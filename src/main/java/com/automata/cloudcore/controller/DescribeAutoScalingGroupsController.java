package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.autoscaling.model.DescribeAutoScalingGroupsResult;
import com.automata.cloudcore.constants.ExceptionConstants;
import com.automata.cloudcore.service.aws.as.IAutoScale;
import com.automata.cloudcore.util.TransformObject;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.DescribeAutoScalingGroupsResponseType;
import com.automata.cloudcore.xmlbindings.DescribeAutoScalingGroupsResultType;
import com.automata.cloudcore.xmlbindings.DescribeAutoScalingGroupsType;

/**
 * DescribeAutoScalingGroupsController processes all the DescribeAutoScalingGroups 
 * requests in the input and returns the automata object with updated 
 * DescribeAutoScalingGroupResponse list.
 * 
 * @author Santhosh Daivajna
 */
public class DescribeAutoScalingGroupsController implements IController {

	/** The handle to AutoScaling APIs  */
	@Autowired
	private IAutoScale as;
	
	@Override
	public Object execute(Object obj) throws Exception {
		
		Automata automata = null;
		List<DescribeAutoScalingGroupsType> descAutoScalingGrpsList = null;
		List<DescribeAutoScalingGroupsResponseType> responseList = null;
		
		automata = (Automata) obj;
		if( automata.getResources() != null ){
			descAutoScalingGrpsList = automata.getResources().getDescribeAutoScalingGroups();
		}
		responseList = processDescAutoScalingGroups(
				descAutoScalingGrpsList);
		
		automata.getOutputs().setDescribeAutoScalingGroupsResponse(responseList);
		return automata;
	}

	/**
	 * @param descAutoScalingGrpsList
	 * @return
	 */
	private List<DescribeAutoScalingGroupsResponseType> processDescAutoScalingGroups(
			List<DescribeAutoScalingGroupsType> descAutoScalingGrpsList
			) {
		
		DescribeAutoScalingGroupsResponseType response = null;
		List<DescribeAutoScalingGroupsResponseType> responseList;
		DescribeAutoScalingGroupsResult result;
		DescribeAutoScalingGroupsResultType resultType;
		responseList = new ArrayList<DescribeAutoScalingGroupsResponseType>();
		for (DescribeAutoScalingGroupsType autoscaleGroup : descAutoScalingGrpsList ){
			
			try {
				response = new DescribeAutoScalingGroupsResponseType();
				result = as.describeAutoScalingGroups(autoscaleGroup);
				resultType = TransformObject.getDescribeAutoScalingGroupsResultType(result);
				response.setDescribeAutoScalingGroupsResult(resultType);
				response.setStatus("AutoScaling group described successfully");
			}catch (AmazonServiceException ase) {
				response.setStatus(ase.getMessage());
				logger.error(ExceptionConstants.ASE_DESC_AS, ase);
			} catch (AmazonClientException ace) {
				response.setStatus(ace.getMessage());
				logger.error(ExceptionConstants.ACE_DESC_AS ,ace);
			}
			responseList.add(response);
		}
		return responseList;
	}
	
	private static Logger logger = LoggerFactory
	.getLogger(DescribeAutoScalingGroupsController.class.getName());

}
