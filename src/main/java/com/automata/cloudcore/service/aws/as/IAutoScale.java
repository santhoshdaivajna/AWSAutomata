package com.automata.cloudcore.service.aws.as;

import com.amazonaws.services.autoscaling.model.DescribeAutoScalingGroupsResult;
import com.amazonaws.services.autoscaling.model.DescribeLaunchConfigurationsResult;
import com.amazonaws.services.autoscaling.model.DescribeScalingActivitiesResult;
import com.amazonaws.services.autoscaling.model.PutScalingPolicyResult;
import com.automata.cloudcore.model.CreateLaunchConfigurationModel;
import com.automata.cloudcore.model.ResumeProcessesModel;
import com.automata.cloudcore.model.SuspendProcessesModel;
import com.automata.cloudcore.xmlbindings.CreateAutoScalingGroupType;
import com.automata.cloudcore.xmlbindings.DeleteAutoScalingGroupType;
import com.automata.cloudcore.xmlbindings.DeleteLaunchConfigurationType;
import com.automata.cloudcore.xmlbindings.DescribeAutoScalingGroupsType;
import com.automata.cloudcore.xmlbindings.DescribeLaunchConfigurationsType;
import com.automata.cloudcore.xmlbindings.PutScalingPolicyType;
import com.automata.cloudcore.xmlbindings.UpdateAutoScalingGroupType;

public interface IAutoScale {

	public void createAutoScalingGroup(CreateAutoScalingGroupType autoscaleGroup);

	public void deleteAutoScalingGroup(DeleteAutoScalingGroupType deleteASGroup);

	public void createLaunchConfiguration(
			CreateLaunchConfigurationModel launchConfigurationModel);

	public PutScalingPolicyResult putScalingPolicy(PutScalingPolicyType policy);

	public void deleteLaunchConfiguration(
			DeleteLaunchConfigurationType launchConfiguration);

	public void updateAutoScalingGroup(UpdateAutoScalingGroupType request);

	public void suspendProcesses(SuspendProcessesModel suspendProcessesModel);

	public void resumeProcesses(ResumeProcessesModel resumeProcessesModel);

	public DescribeAutoScalingGroupsResult describeAutoScalingGroups(
			DescribeAutoScalingGroupsType autoscaleGroup);

	public String getEndPoint(String region);

	public DescribeLaunchConfigurationsResult describeLaunchConfiguration(
			DescribeLaunchConfigurationsType descLaunchConfigurationsType);

	public DescribeScalingActivitiesResult describeActivities(
			String autoScalingGroupName, String region);

}