package com.automata.cloudcore.service.aws.as;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.autoscaling.AmazonAutoScalingClient;
import com.amazonaws.services.autoscaling.model.CreateAutoScalingGroupRequest;
import com.amazonaws.services.autoscaling.model.CreateLaunchConfigurationRequest;
import com.amazonaws.services.autoscaling.model.DeleteAutoScalingGroupRequest;
import com.amazonaws.services.autoscaling.model.DeleteLaunchConfigurationRequest;
import com.amazonaws.services.autoscaling.model.DescribeAutoScalingGroupsRequest;
import com.amazonaws.services.autoscaling.model.DescribeAutoScalingGroupsResult;
import com.amazonaws.services.autoscaling.model.DescribeLaunchConfigurationsRequest;
import com.amazonaws.services.autoscaling.model.DescribeLaunchConfigurationsResult;
import com.amazonaws.services.autoscaling.model.DescribeScalingActivitiesRequest;
import com.amazonaws.services.autoscaling.model.DescribeScalingActivitiesResult;
import com.amazonaws.services.autoscaling.model.InstanceMonitoring;
import com.amazonaws.services.autoscaling.model.PutScalingPolicyRequest;
import com.amazonaws.services.autoscaling.model.PutScalingPolicyResult;
import com.amazonaws.services.autoscaling.model.ResumeProcessesRequest;
import com.amazonaws.services.autoscaling.model.SuspendProcessesRequest;
import com.amazonaws.services.autoscaling.model.UpdateAutoScalingGroupRequest;
import com.automata.cloudcore.constants.Constants;
import com.automata.cloudcore.model.CreateLaunchConfigurationModel;
import com.automata.cloudcore.model.ResumeProcessesModel;
import com.automata.cloudcore.model.SuspendProcessesModel;
import com.automata.cloudcore.util.RegionInfo;
import com.automata.cloudcore.xmlbindings.AvailabilityZonesType;
import com.automata.cloudcore.xmlbindings.CreateAutoScalingGroupType;
import com.automata.cloudcore.xmlbindings.DeleteAutoScalingGroupType;
import com.automata.cloudcore.xmlbindings.DeleteLaunchConfigurationType;
import com.automata.cloudcore.xmlbindings.DescribeAutoScalingGroupsType;
import com.automata.cloudcore.xmlbindings.DescribeLaunchConfigurationsType;
import com.automata.cloudcore.xmlbindings.LaunchConfigurationNamesType;
import com.automata.cloudcore.xmlbindings.LoadBalancerNamesType;
import com.automata.cloudcore.xmlbindings.PutScalingPolicyType;
import com.automata.cloudcore.xmlbindings.UpdateAutoScalingGroupType;
@Component
public class AutoScaleImpl implements IAutoScale {

	private AmazonAutoScalingClient as;
	
	public  AutoScaleImpl() throws Exception {
		init();
	}
	
	public void createAutoScalingGroup(CreateAutoScalingGroupType autoscaleGroup){

		CreateAutoScalingGroupRequest createAutoScalingGroupRequest;
		
		String autoScalingGroupName 		= autoscaleGroup.getAutoScalingGroupName();
		String launchConfigurationName		= autoscaleGroup.getLaunchConfigurationName();
		Integer minSize 					= autoscaleGroup.getMinSize();
		Integer maxSize 					= autoscaleGroup.getMaxSize();
		Integer desiredCapacity				= autoscaleGroup.getDesiredCapacity();
		Integer defaultCooldown 			= autoscaleGroup.getDefaultCooldown();
		AvailabilityZonesType availabilityZones = autoscaleGroup.getAvailabilityZones();
		LoadBalancerNamesType loadBalancerNames = autoscaleGroup.getLoadBalancerNames();
		String healthCheckType 				= autoscaleGroup.getHealthCheckType();
		Integer healthCheckGracePeriod 		= autoscaleGroup.getHealthCheckGracePeriod();
		String placementGroup 				= autoscaleGroup.getPlacementGroup();
		String vpcZoneIdentifier 			= autoscaleGroup.getVPCZoneIdentifier();
		String region 						= autoscaleGroup.getRegion();

		createAutoScalingGroupRequest = new CreateAutoScalingGroupRequest();
		createAutoScalingGroupRequest.withAutoScalingGroupName(
				autoScalingGroupName)
				.withLaunchConfigurationName(launchConfigurationName)
				.withMinSize(minSize)
				.withMaxSize(maxSize)
				.withAvailabilityZones(availabilityZones.getMember());
		
		if ( loadBalancerNames != null && loadBalancerNames.getMember() != null && loadBalancerNames.getMember().size() > 0  )
			createAutoScalingGroupRequest.withLoadBalancerNames(loadBalancerNames.getMember());
		
		if( desiredCapacity != null)
			createAutoScalingGroupRequest.withDesiredCapacity(desiredCapacity);
		
		if (defaultCooldown != null)
			createAutoScalingGroupRequest.withDefaultCooldown(defaultCooldown);
		
		if(StringUtils.hasLength(healthCheckType))
			createAutoScalingGroupRequest.withHealthCheckType(healthCheckType);
		
		if( healthCheckGracePeriod != null)
			createAutoScalingGroupRequest.withHealthCheckGracePeriod(healthCheckGracePeriod);
		
		if(StringUtils.hasLength(placementGroup))
			createAutoScalingGroupRequest.withPlacementGroup(placementGroup);
		
		if(StringUtils.hasLength(vpcZoneIdentifier))
			createAutoScalingGroupRequest.withVPCZoneIdentifier(vpcZoneIdentifier);
		
		as.setEndpoint(getEndPoint(region));
		as.createAutoScalingGroup(createAutoScalingGroupRequest);
	}
	
	public void deleteAutoScalingGroup ( DeleteAutoScalingGroupType deleteASGroup ){
		
		DeleteAutoScalingGroupRequest deleteAutoScalingGroupRequest;
			deleteAutoScalingGroupRequest = new DeleteAutoScalingGroupRequest();
			deleteAutoScalingGroupRequest
			.withAutoScalingGroupName(deleteASGroup.getAutoScalingGroupName())
			.withForceDelete(deleteASGroup.isForceDelete());
			as.setEndpoint(getEndPoint(deleteASGroup.getRegion()));
			as.deleteAutoScalingGroup(deleteAutoScalingGroupRequest);
		
	}

	public void createLaunchConfiguration ( CreateLaunchConfigurationModel launchConfigurationModel) {

		CreateLaunchConfigurationRequest launchConfigRequest;

		launchConfigRequest = new CreateLaunchConfigurationRequest();
		launchConfigRequest.setLaunchConfigurationName( launchConfigurationModel.getLaunchConfigurationName());
		launchConfigRequest.setImageId( launchConfigurationModel.getImageId());			
		launchConfigRequest.setInstanceType( launchConfigurationModel.getInstanceType());
		InstanceMonitoring instanceMonitoring = new InstanceMonitoring();
		instanceMonitoring.setEnabled(launchConfigurationModel.getInstanceMonitoring());
		launchConfigRequest.setInstanceMonitoring(instanceMonitoring);
		if( launchConfigurationModel.getBlockDeviceMappings() != null)		
			launchConfigRequest.setBlockDeviceMappings( launchConfigurationModel.getBlockDeviceMappings());		
		
		if( launchConfigurationModel.getKernelId() != null)	
			launchConfigRequest.setKernelId( launchConfigurationModel.getKernelId());
		
		if( launchConfigurationModel.getKeyName() != null)
			launchConfigRequest.setKeyName( launchConfigurationModel.getKeyName());

		if( launchConfigurationModel.getRamdiskId() != null)
			launchConfigRequest.setRamdiskId( launchConfigurationModel.getRamdiskId());
		
		if( launchConfigurationModel.getSecurityGroups() != null)
			launchConfigRequest.setSecurityGroups( launchConfigurationModel.getSecurityGroups().getMember());
		
		if( launchConfigurationModel.getUserData() != null)
			launchConfigRequest.setUserData( launchConfigurationModel.getUserData());
		as.setEndpoint(getEndPoint(launchConfigurationModel.getRegion()));
		as.createLaunchConfiguration( launchConfigRequest);

	} 
	
	public PutScalingPolicyResult putScalingPolicy(PutScalingPolicyType policy){

		PutScalingPolicyRequest request;
		PutScalingPolicyResult result;
		Integer cooldown;
		
		request = new PutScalingPolicyRequest();
		request
			.withAutoScalingGroupName(policy.getAutoScalingGroupName())
			.withPolicyName(policy.getPolicyName())
			.withScalingAdjustment(policy.getScalingAdjustment())
			.withAdjustmentType(policy.getAdjustmentType());
		
		cooldown = policy.getCooldown();
		if (cooldown != null)
			request.withCooldown(cooldown);

		result = as.putScalingPolicy(request);
		return result;
	}
	
	
	public void deleteLaunchConfiguration( DeleteLaunchConfigurationType launchConfiguration) {
		
		DeleteLaunchConfigurationRequest deleteLaunchConfigurationRequest;
	
		deleteLaunchConfigurationRequest = new DeleteLaunchConfigurationRequest();
		as.setEndpoint(getEndPoint(launchConfiguration.getRegion()));
		deleteLaunchConfigurationRequest
			.setLaunchConfigurationName(launchConfiguration.getLaunchConfigurationName());
		as.deleteLaunchConfiguration(deleteLaunchConfigurationRequest);
	}
	
	/*public void putScheduledUpdateAction(PutScheduledUpdateGroupActionType putScheduledUpdateGroupAction)
			throws AmazonServiceException, AmazonClientException {

		PutScheduledUpdateGroupActionRequest putScheduledUpdateGroupActionRequest;

		putScheduledUpdateGroupActionRequest = new PutScheduledUpdateGroupActionRequest();
		String autoScalingGroupName = "";
		Integer desiredCapacity = null;
		Integer minSize = null;
		Integer maxSize = null;
		String scheduledActionName = "";
		Date time = null;

		putScheduledUpdateGroupActionRequest
		.withAutoScalingGroupName(autoScalingGroupName)
		.withDesiredCapacity(desiredCapacity)
		.withMinSize(minSize).withMaxSize(maxSize)
		.withScheduledActionName(scheduledActionName)
		.withTime(time);

		as.putScheduledUpdateGroupAction(putScheduledUpdateGroupActionRequest);

	}*/
		
/*	public void createOrUpdateScalingTrigger ( CreateOrUpdateScalingTriggerModel createOrUpdateScalingTriggerModel ) 
		throws AmazonServiceException, AmazonClientException {

		CreateOrUpdateScalingTriggerRequest createOrUpdateScalingTriggerRequest;

		createOrUpdateScalingTriggerRequest = new CreateOrUpdateScalingTriggerRequest();
		createOrUpdateScalingTriggerRequest
		.withAutoScalingGroupName(createOrUpdateScalingTriggerModel.getAutoScalingGroupName())
		.withBreachDuration(createOrUpdateScalingTriggerModel.getBreachDuration())
		.withCustomUnit(createOrUpdateScalingTriggerModel.getCustomUnit())
		.withDimensions(createOrUpdateScalingTriggerModel.getDimensions())
		.withLowerBreachScaleIncrement(createOrUpdateScalingTriggerModel.getLowerBreachScaleIncrement())
		.withLowerThreshold(createOrUpdateScalingTriggerModel.getLowerThreshold())
		.withMeasureName(createOrUpdateScalingTriggerModel.getMeasureName())
		.withNamespace(createOrUpdateScalingTriggerModel.getNamespace())
		.withPeriod(createOrUpdateScalingTriggerModel.getPeriod())
		.withStatistic(createOrUpdateScalingTriggerModel.getStatistic())
		.withTriggerName(createOrUpdateScalingTriggerModel.getTriggerName())
		.withUnit(createOrUpdateScalingTriggerModel.getUnit())
		.withUpperBreachScaleIncrement(createOrUpdateScalingTriggerModel.getUpperBreachScaleIncrement())
		.withUpperThreshold(createOrUpdateScalingTriggerModel.getUpperThreshold());

		as.setEndpoint(createOrUpdateScalingTriggerModel.getEndPoint());
		as.createOrUpdateScalingTrigger(createOrUpdateScalingTriggerRequest);
	} 
	

	public void deleteTrigger ( String endPoint, String triggerName ) throws Exception {
		
		String methodName = "deleteTrigger";
		DeleteTriggerRequest deleteTriggerRequest;
		try{
			deleteTriggerRequest = new DeleteTriggerRequest();
			deleteTriggerRequest.setTriggerName(triggerName);
			as.setEndpoint(endPoint);
			as.deleteTrigger(deleteTriggerRequest);
			
		}catch (AmazonServiceException ase) {
			logger.error("Caught Exception: " + ase.getMessage() + "Response Status Code: " + ase.getStatusCode()
					+ "Error Code: " + ase.getErrorCode() + "Request ID: " 	+ ase.getRequestId());
			logger.error("Exception in "+ this.getClass().getName() + "method: " + methodName, ase );
			throw new Exception("AmazonServiceException while deleting trigger", ase);
		} catch (AmazonClientException ace) {
			logger.error("Exception in "+ this.getClass().getName() + "method: " + methodName, ace);
			throw new Exception( "AmazonClientException while deleting trigger", ace);
		}
	}
*/	
	
	public void updateAutoScalingGroup(UpdateAutoScalingGroupType request){
		
		String region ="";
		UpdateAutoScalingGroupRequest updateAutoScalingGroupRequest;

			updateAutoScalingGroupRequest= new UpdateAutoScalingGroupRequest();
			updateAutoScalingGroupRequest.withAutoScalingGroupName(request.getAutoScalingGroupName())
			.withAvailabilityZones()
			.withDefaultCooldown(request.getDefaultCooldown())
			.withDesiredCapacity(request.getDesiredCapacity())
			.withHealthCheckGracePeriod(request.getHealthCheckGracePeriod())
			.withLaunchConfigurationName(request.getLaunchConfigurationName())
			.withMaxSize(request.getMaxSize())
			.withMinSize(request.getMinSize())
			.withPlacementGroup(request.getPlacementGroup())
			.withVPCZoneIdentifier(request.getVPCZoneIdentifier());
			
			if (request.getAvailabilityZones() != null)
				updateAutoScalingGroupRequest.withAvailabilityZones(request.getAvailabilityZones().getMember());
			region = request.getRegion();
			as.setEndpoint(getEndPoint(region));
			as.updateAutoScalingGroup(updateAutoScalingGroupRequest);
			
	}
	
	public void suspendProcesses(SuspendProcessesModel suspendProcessesModel){
		
		SuspendProcessesRequest suspendProcessesRequest;
		suspendProcessesRequest = new SuspendProcessesRequest();
		
		suspendProcessesRequest
			.withAutoScalingGroupName(suspendProcessesModel.getAutoScalingGroupName())
			.withScalingProcesses(suspendProcessesModel.getScalingProcesses());
		as.setEndpoint(getEndPoint(suspendProcessesModel.getRegion()));
		as.suspendProcesses(suspendProcessesRequest);
	}
	
	public void resumeProcesses(ResumeProcessesModel resumeProcessesModel){
		
		ResumeProcessesRequest resumeProcessesRequest;
		resumeProcessesRequest = new ResumeProcessesRequest();
		resumeProcessesRequest
			.withAutoScalingGroupName(resumeProcessesModel.getAutoScalingGroupName())
			.withScalingProcesses(resumeProcessesModel.getScalingProcesses());
		as.resumeProcesses(resumeProcessesRequest);
	}
	
	public DescribeAutoScalingGroupsResult describeAutoScalingGroups(
			DescribeAutoScalingGroupsType autoscaleGroup) {
		DescribeAutoScalingGroupsRequest describeAutoScalingGroupsRequest;
		DescribeAutoScalingGroupsResult describeAutoScalingGroupsResult;
		List<String> autoScalingGroupNames = null;

		describeAutoScalingGroupsRequest = new DescribeAutoScalingGroupsRequest();
		if (autoscaleGroup.getAutoScalingGroupNames() != null)
			autoScalingGroupNames = autoscaleGroup.getAutoScalingGroupNames()
					.getMember();

		describeAutoScalingGroupsRequest
				.withAutoScalingGroupNames(autoScalingGroupNames);
		describeAutoScalingGroupsResult = as
				.describeAutoScalingGroups(describeAutoScalingGroupsRequest);

		return describeAutoScalingGroupsResult;
	}
	
	public String getEndPoint(String region) {
		
		String endPoint = "";
		RegionInfo regionInfo = null;
		regionInfo = new RegionInfo(Constants.AS, region);
		endPoint = regionInfo.getEndPoint();
		return endPoint;
	}
	

	public DescribeLaunchConfigurationsResult describeLaunchConfiguration(
			DescribeLaunchConfigurationsType descLaunchConfigurationsType) {

		DescribeLaunchConfigurationsRequest request = null;
		DescribeLaunchConfigurationsResult  result = null;
		
		Integer maxRecords = null;
		String nextToken = null;
		LaunchConfigurationNamesType launchConfigurationNamesType;
		List<String> configNames;
		launchConfigurationNamesType = descLaunchConfigurationsType.getLaunchConfigurationNames();
		maxRecords = descLaunchConfigurationsType.getMaxRecords();
		nextToken = descLaunchConfigurationsType.getNextToken();
		configNames = launchConfigurationNamesType.getMember();
		if (configNames != null){
			request = new DescribeLaunchConfigurationsRequest();
			request.setLaunchConfigurationNames(configNames);
			if(maxRecords != null)
				request.setMaxRecords(maxRecords);
			if(nextToken != null)
				request.setNextToken(nextToken);
			result = as.describeLaunchConfigurations(request);
		}
		
		return result;
	}
	
	public DescribeScalingActivitiesResult describeActivities(
			String autoScalingGroupName, String region) {
		
		DescribeScalingActivitiesRequest describeScalingActivitiesRequest;
		DescribeScalingActivitiesResult describeScalingActivities;
		
		describeScalingActivitiesRequest = new DescribeScalingActivitiesRequest();
		describeScalingActivitiesRequest.setAutoScalingGroupName(autoScalingGroupName);
		as.setEndpoint(getEndPoint(region));
		describeScalingActivities = as.describeScalingActivities(describeScalingActivitiesRequest);
		return describeScalingActivities;
	}

	
	private void init() throws FileNotFoundException, IllegalArgumentException, IOException {
		AWSCredentials credentials;
		credentials = new PropertiesCredentials(new File("AwsCredentials.properties"));
		as = new AmazonAutoScalingClient(credentials);
	}
	
	private static Logger logger = LoggerFactory.getLogger(AutoScaleImpl.class.getName());
	
}
