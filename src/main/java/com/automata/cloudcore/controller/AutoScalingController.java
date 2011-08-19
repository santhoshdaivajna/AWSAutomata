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
import com.automata.cloudcore.service.aws.as.IAutoScale;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.CreateAutoScalingGroupResponse;
import com.automata.cloudcore.xmlbindings.CreateAutoScalingGroupType;

/**
 * The Class AutoScalingController processes all the create auto scaling 
 * group requests in the input and returns the automata object
 * with updated CreateAutoScalingGroupResponse list.
 * 
 * @author Santhosh Daivajna
 */
@Component
public class AutoScalingController implements IController {

	/** Handle to auto scale APIs */
	@Autowired
	private IAutoScale as;

	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		List<CreateAutoScalingGroupType> autoscalingList = null;
		List<CreateAutoScalingGroupResponse> responseList = null;

		automata = (Automata) obj;
		autoscalingList = automata.getResources().getCreateAutoScalingGroup();
		responseList = new ArrayList<CreateAutoScalingGroupResponse>();

		responseList = processCreateAutoScalingGroupRequests(autoscalingList);
		if( responseList.size() > 0)
			automata.getOutputs().setCreateCreateAutoScalingGroupGroupDetails(responseList);
		return automata;
	}

	
	/**
	 * processes the CreateAutoScalingGroup requests in the input.
	 * @param autoscalingList
	 * @return
	 */
	private List<CreateAutoScalingGroupResponse> processCreateAutoScalingGroupRequests(
			List<CreateAutoScalingGroupType> autoscalingList){
		
		CreateAutoScalingGroupResponse response = null;
		List<CreateAutoScalingGroupResponse> responseList = null;

		responseList = new ArrayList<CreateAutoScalingGroupResponse>();
		for (CreateAutoScalingGroupType autoscaling : autoscalingList) {

			try {
				response = new CreateAutoScalingGroupResponse();
				response.setRequest(autoscaling);
				as.createAutoScalingGroup(autoscaling);
				response.setStatus("Autoscaling group "
						+ autoscaling.getAutoScalingGroupName() + " successfully created");

			} catch (AmazonServiceException ase) {
				response.setStatus(ase.getMessage());
				logger.error(ExceptionConstants.ASE_CREATE_AS, ase);
			} catch (AmazonClientException ace) {
				response.setStatus(ace.getMessage());
				logger.error(ExceptionConstants.ACE_CREATE_AS,	ace);
			}
			responseList.add(response);
		}
		return responseList;
	}

	/**
	 *  the logger.
	 */
	private static Logger logger = LoggerFactory
			.getLogger(AutoScalingController.class.getName());
}