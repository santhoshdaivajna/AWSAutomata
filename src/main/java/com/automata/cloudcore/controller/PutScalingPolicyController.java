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
import com.automata.cloudcore.xmlbindings.PutScalingPolicyResponse;
import com.automata.cloudcore.xmlbindings.PutScalingPolicyType;

/**
 * The Class PutScalingPolicyController processes all the PutScalingPolicy
 * requests in the input and returns the automata object with updated 
 * PutScalingPolicyResponse list.
 * 
 * @author Santhosh Daivajna
 */
@Component
public class PutScalingPolicyController implements IController {

	/** Handle to auto scaling APIs. */
	@Autowired
	private IAutoScale as;
	
	@Override
	public Object execute(Object obj) throws Exception {
		
		Automata automata = null;
		PutScalingPolicyResponse response = null;
		List<PutScalingPolicyResponse> responseList = null;
		List<PutScalingPolicyType> scalingPolicyList = null;
		automata = (Automata) obj;
		scalingPolicyList = automata.getResources().getPutScalingPolicy();
		
		responseList = processPutScalingPolicyResponse(scalingPolicyList);
		automata.getOutputs().setPutScalingPolicyDetails(responseList);
		return automata;
	}

	/**
	 * @param scalingPolicyList
	 * @return
	 */
	private List<PutScalingPolicyResponse> processPutScalingPolicyResponse(
			List<PutScalingPolicyType> scalingPolicyList) {
		
		PutScalingPolicyResponse response = null;
		List<PutScalingPolicyResponse> responseList;
		
		responseList = new ArrayList<PutScalingPolicyResponse>();
		for (PutScalingPolicyType policy : scalingPolicyList) {
			try{
				response = new PutScalingPolicyResponse();
				response.setRequest(policy);
				as.putScalingPolicy(policy);
				response.setStatus("Scaling policy "+policy.getPolicyName()+" successully created");
			} catch (AmazonServiceException ase) {
				response.setStatus(ase.getMessage());
				logger.error(ExceptionConstants.ASE_CREATE_ASPOLICY, ase);
			} catch (AmazonClientException ace) {
				response.setStatus(ace.getMessage());
				logger.error(ExceptionConstants.ACE_CREATE_ASPOLICY,ace);
			}
			responseList.add(response);
		}
		return responseList;
	}
	
	
	/**
	 * The logger.
	 */
	private static Logger logger = LoggerFactory
	.getLogger(PutScalingPolicyController.class.getName());

}
