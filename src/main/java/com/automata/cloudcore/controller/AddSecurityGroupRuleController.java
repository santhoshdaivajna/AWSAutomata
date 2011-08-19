package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.automata.cloudcore.constants.Constants;
import com.automata.cloudcore.constants.ExceptionConstants;
import com.automata.cloudcore.service.aws.ec2.IEC2;
import com.automata.cloudcore.xmlbindings.AddSecurityGroupRuleResponse;
import com.automata.cloudcore.xmlbindings.AddSecurityGroupRuleType;
import com.automata.cloudcore.xmlbindings.Automata;

/**
 * The Class AddSecurityGroupRuleController adds security rules defined in
 * the automata instance to the security groups. Returns a updated
 * automata object with created security groups status.
 */
@Component
public class AddSecurityGroupRuleController implements IController {

	/** The ec2. */
	@Autowired
	private IEC2 ec2;

	/**
	 *  adds security rules defined in the automata instance to the security groups. 
	 * Returns a updated automata object with created security groups status.
	 */
	
	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		List<AddSecurityGroupRuleType> requestList = null;
		List<AddSecurityGroupRuleResponse> responseList = null;

		automata = (Automata) obj;
		requestList = automata.getResources().getAddSecurityGroupRule();
		responseList = processAddSecurityGroupRuleRequests(requestList);
		if(responseList.size() > 0)
			automata.getOutputs().setAddSecurityGroupRuleDetails(responseList);
		return automata;
	}

	/**
	 * @param requestList
	 * @return the AddSecurityGroupRuleDetailsType list
	 */
	private List<AddSecurityGroupRuleResponse> processAddSecurityGroupRuleRequests(
			List<AddSecurityGroupRuleType> requestList) {

		String region;
		AddSecurityGroupRuleResponse response = null;
		List<AddSecurityGroupRuleResponse> responseList = null;

		responseList = new ArrayList<AddSecurityGroupRuleResponse>();
		for (AddSecurityGroupRuleType securityGroupRule : requestList) {

			try {
				region = securityGroupRule.getRegion();
				response = new AddSecurityGroupRuleResponse();
				response.setRequest(securityGroupRule);

				ec2.setEndPoint(region);
				ec2.addSecurityGroupRule(securityGroupRule);
				response.setStatus(Constants.RULE_ADDED);
			} catch (AmazonServiceException ase) {
				response.setStatus(ase.getMessage());
				logger.error(ExceptionConstants.ASE_ADD_SECURITY_GROUP_RULE, ase);
			} catch (AmazonClientException ace) {
				response.setStatus(ace.getMessage());
				logger.error(ExceptionConstants.ACE_ADD_SECURITY_GROUP_RULE, ace);
			}
			responseList.add(response);
		}
		return responseList;
	}

	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(CreateSecurityGroupController.class.getName());
}
