package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.automata.cloudcore.constants.ExceptionConstants;
import com.automata.cloudcore.service.aws.ec2.IEC2;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.CreateSecurityGroupResponse;
import com.automata.cloudcore.xmlbindings.CreateSecurityGroupType;

/**
 * The Class CreateSecurityGroupController creates security groups defined in
 * the automata instance and adds the security rules to it. Returns a updated
 * automata object with created security groups status.
 * 
 * @author Santhosh Daivajna
 */
@Component
public class CreateSecurityGroupController implements IController {

	/** The ec2. */
	@Autowired
	private IEC2 ec2;

	/** execute (Object obj) 
	 * execute iterates and processes all the  CreateSecurityGroup elements 
	 * specified in the input file and sets the responses in the output element. 
	 *
	 */
	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		List<CreateSecurityGroupType> requestList = null;
		List<CreateSecurityGroupResponse> responseList = null;
		
		automata = (Automata) obj;
		requestList = automata.getResources().getCreateSecurityGroup();
		responseList = processSecurityGroupRequests(requestList);
		if (responseList.size() > 0)
			automata.getOutputs().setCreateSecurityGroupDetails(responseList);
		
		return automata;
	}


	/**
	 * Processes create security group requests.
	 *
	 * @param createSecurityGroupRequestList the create security group request list
	 * @return the CreateSecurityGroupDetailsType list
	 */
	private List<CreateSecurityGroupResponse> processSecurityGroupRequests(
			List<CreateSecurityGroupType> createSecurityGroupRequestList) {

		List<CreateSecurityGroupResponse> responseList;
		String region;
		String groupName;
		String message;
		boolean secGroupExists;
		CreateSecurityGroupResponse response = null;
		responseList = new ArrayList<CreateSecurityGroupResponse>();

		for (CreateSecurityGroupType createSecurityGroup : createSecurityGroupRequestList) {

			secGroupExists = false;
			try {
				groupName = createSecurityGroup.getSecurityGroupName();
				region = createSecurityGroup.getRegion();
				response = new CreateSecurityGroupResponse();
				response.setRequest(createSecurityGroup);
				ec2.setEndPoint(region);

				secGroupExists = ec2.createSecurityGroup(createSecurityGroup);
				message = (secGroupExists == false) ? "was created": "already exists";
				response.setStatus("Security Group " + groupName + " "+ message);
			} catch (AmazonServiceException ase) {
				response.setStatus(ase.getMessage());
				logger.error(ExceptionConstants.ASE_CREATE_SECURITY_GROUP_API, ase);
			} catch (AmazonClientException ace) {
				response.setStatus(ace.getMessage());
				logger.error(ExceptionConstants.ACE_CREATE_SECURITY_GROUP_API, ace);
			}
			responseList.add(response);
		}
		return responseList;
	}

	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(CreateSecurityGroupController.class.getName());

}
