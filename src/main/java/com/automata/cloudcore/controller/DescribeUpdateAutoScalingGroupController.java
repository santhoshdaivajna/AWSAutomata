/*package com.automata.cloudcore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.autoscaling.model.Activity;
import com.amazonaws.services.autoscaling.model.DescribeScalingActivitiesResult;
import com.automata.cloudcore.service.aws.as.IAutoScale;
import com.automata.cloudcore.xmlbindings.AutomataType;
import com.automata.cloudcore.xmlbindings.UpdateAutoScalingGroupType;

public class DescribeUpdateAutoScalingGroupController implements IController {

	*//** The as. *//*
	@Autowired
	private IAutoScale as;
	private List<Activity> activities;

	
	@Override
	public Object execute(Object obj) throws Exception {
		
		AutomataType automata = null;
		String autoScalingGroupName;
		String region;
		
		automata = (AutomataType) obj;
		
		List<UpdateAutoScalingGroupType> updateAutoScalingGroupTypeList = null;
		DescribeScalingActivitiesResult describeActivities = null;
		updateAutoScalingGroupTypeList = automata.getResources().getUpdateAutoScalingGroupRequest();
		
		for(UpdateAutoScalingGroupType updateAutoScalingGroupType : updateAutoScalingGroupTypeList ){
			
			try{
				autoScalingGroupName = updateAutoScalingGroupType.getAutoScalingGroupName();
				region = updateAutoScalingGroupType.getRegion();
				describeActivities = as.describeActivities(autoScalingGroupName, region);
				activities = describeActivities.getActivities();
				for (Activity activity : activities){
					int progress = activity.getProgress();
					if (progres)
				}
			}catch(){
				
			}
		return automata;
	}

	private static Logger logger = LoggerFactory
	.getLogger(DescribeUpdateAutoScalingGroupController.class.getName());
}
*/