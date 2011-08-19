package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.automata.cloudcore.service.aws.as.IAutoScale;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.DeleteAutoScalingGroupResponseType;
import com.automata.cloudcore.xmlbindings.DeleteAutoScalingGroupType;

public class DeleteAutoScalingGroupController implements IController {

	/** The as. */
	@Autowired
	private IAutoScale as;
	
	@Override
	public Object execute(Object obj) throws Exception {
		
		Automata automata = null;
		List<DeleteAutoScalingGroupType> deleteAutoScalingGroupTypeList = null;
		List<DeleteAutoScalingGroupResponseType> deleteAutoScalingGroupResponseList = null;
		DeleteAutoScalingGroupResponseType deleteAutoScalingGroupResponse = null;
		
		automata = (Automata) obj;
		deleteAutoScalingGroupTypeList = automata.getResources().getDeleteAutoScalingGroupRequest();
		deleteAutoScalingGroupResponseList = new ArrayList<DeleteAutoScalingGroupResponseType>();
		
		for( DeleteAutoScalingGroupType autoScalingGroup : deleteAutoScalingGroupTypeList ){
			
			try{
				deleteAutoScalingGroupResponse = new DeleteAutoScalingGroupResponseType();
				deleteAutoScalingGroupResponse.setRequest(autoScalingGroup);
				as.deleteAutoScalingGroup(autoScalingGroup);
				deleteAutoScalingGroupResponse.setStatus("Auto Scaling group has been deleted");
			}catch (AmazonServiceException ase) {
				deleteAutoScalingGroupResponse.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while updating autoscale group "
								+ ase.getMessage() , ase);
			} catch (AmazonClientException ace) {
				deleteAutoScalingGroupResponse.setStatus(ace.getMessage());
				logger.error("AmazonClientException while updating autoscale group",ace);
			}
			deleteAutoScalingGroupResponseList.add(deleteAutoScalingGroupResponse);
		}
		automata.getOutputs().setDeleteAutoScalingGroupResponse(deleteAutoScalingGroupResponseList);
		return automata;
	}

	private static Logger logger = LoggerFactory
	.getLogger(DeleteAutoScalingGroupController.class.getName());
}
