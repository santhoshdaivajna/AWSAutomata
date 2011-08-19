package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.automata.cloudcore.service.aws.as.IAutoScale;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.UpdateAutoScalingGroupResponseType;
import com.automata.cloudcore.xmlbindings.UpdateAutoScalingGroupType;
@Component
public class UpdateAutoScalingGroupController implements IController {

	/** The as. */
	@Autowired
	private IAutoScale as;
	
	@Override
	public Object execute(Object obj) throws Exception {
		
		Automata automata = null;
		List<UpdateAutoScalingGroupType> updateAutoScalingGroupTypeList = null;
		List<UpdateAutoScalingGroupResponseType> updateAutoScalingGroupResponseList = null;
		UpdateAutoScalingGroupResponseType updateAutoScalingGroupResponse = null;
		
		automata = (Automata) obj;
		updateAutoScalingGroupTypeList = automata.getResources().getUpdateAutoScalingGroupRequest();
		updateAutoScalingGroupResponseList = new ArrayList<UpdateAutoScalingGroupResponseType>();
		
		for(UpdateAutoScalingGroupType updateAutoScalingGroupType : updateAutoScalingGroupTypeList ){
			
			try{
				updateAutoScalingGroupResponse = new UpdateAutoScalingGroupResponseType();
				updateAutoScalingGroupResponse.setRequest(updateAutoScalingGroupType);
				as.updateAutoScalingGroup(updateAutoScalingGroupType);
				updateAutoScalingGroupResponse.setStatus("Auto Scaling group has been updated");
			}catch (AmazonServiceException ase) {
				updateAutoScalingGroupResponse.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while updating autoscale group "
								+ ase.getMessage(), ase);
			} catch (AmazonClientException ace) {
				updateAutoScalingGroupResponse.setStatus(ace.getMessage());
				logger.error("AmazonClientException while updating autoscale group",	ace);
			}
			updateAutoScalingGroupResponseList.add(updateAutoScalingGroupResponse);
		}
		automata.getOutputs().setUpdateAutoScalingGroupResponse(updateAutoScalingGroupResponseList);
		return automata;
	}

	private static Logger logger = LoggerFactory
	.getLogger(UpdateAutoScalingGroupController.class.getName());
}
