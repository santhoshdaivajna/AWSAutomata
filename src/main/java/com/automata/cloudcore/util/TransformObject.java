package com.automata.cloudcore.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.amazonaws.services.autoscaling.model.BlockDeviceMapping;
import com.amazonaws.services.autoscaling.model.DescribeAutoScalingGroupsResult;
import com.amazonaws.services.autoscaling.model.DescribeLaunchConfigurationsResult;
import com.amazonaws.services.autoscaling.model.EnabledMetric;
import com.amazonaws.services.autoscaling.model.SuspendedProcess;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.DescribeKeyPairsResult;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.InstanceState;
import com.amazonaws.services.ec2.model.InstanceStateChange;
import com.amazonaws.services.ec2.model.IpPermission;
import com.amazonaws.services.ec2.model.KeyPairInfo;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.SecurityGroup;
import com.amazonaws.services.ec2.model.UserIdGroupPair;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancersResult;
import com.amazonaws.services.elasticloadbalancing.model.HealthCheck;
import com.amazonaws.services.elasticloadbalancing.model.Listener;
import com.amazonaws.services.elasticloadbalancing.model.ListenerDescription;
import com.amazonaws.services.elasticloadbalancing.model.LoadBalancerDescription;
import com.amazonaws.services.elasticloadbalancing.model.Policies;
import com.amazonaws.services.rds.model.DBParameterGroupStatus;
import com.amazonaws.services.rds.model.DBSecurityGroupMembership;
import com.amazonaws.services.rds.model.IPRange;
import com.amazonaws.services.rds.model.PendingModifiedValues;
import com.automata.cloudcore.xmlbindings.AutoScalingGroupType;
import com.automata.cloudcore.xmlbindings.AutoScalingGroupsType;
import com.automata.cloudcore.xmlbindings.AvailabilityZonesType;
import com.automata.cloudcore.xmlbindings.BlockDeviceMappingType;
import com.automata.cloudcore.xmlbindings.BlockDeviceMappingsType;
import com.automata.cloudcore.xmlbindings.DBParameterGroupStatusListType;
import com.automata.cloudcore.xmlbindings.DBParameterGroupStatusType;
import com.automata.cloudcore.xmlbindings.DBSecurityGroupMembershipListType;
import com.automata.cloudcore.xmlbindings.DBSecurityGroupMembershipType;
import com.automata.cloudcore.xmlbindings.DescribeAutoScalingGroupsResultType;
import com.automata.cloudcore.xmlbindings.DescribeInstancesInfoType;
import com.automata.cloudcore.xmlbindings.DescribeInstancesItemType;
import com.automata.cloudcore.xmlbindings.DescribeInstancesType;
import com.automata.cloudcore.xmlbindings.DescribeKeyPairsResponseInfoType;
import com.automata.cloudcore.xmlbindings.DescribeKeyPairsResponseItemType;
import com.automata.cloudcore.xmlbindings.DescribeLaunchConfigurationsResultType;
import com.automata.cloudcore.xmlbindings.DescribeLoadBalancersResultType;
import com.automata.cloudcore.xmlbindings.EC2SecurityGroup;
import com.automata.cloudcore.xmlbindings.EC2SecurityGroupList;
import com.automata.cloudcore.xmlbindings.EbsType;
import com.automata.cloudcore.xmlbindings.EnabledMetricType;
import com.automata.cloudcore.xmlbindings.EnabledMetricsType;
import com.automata.cloudcore.xmlbindings.GroupItemType;
import com.automata.cloudcore.xmlbindings.GroupSetType;
import com.automata.cloudcore.xmlbindings.HealthCheckType;
import com.automata.cloudcore.xmlbindings.IPRangeList;
import com.automata.cloudcore.xmlbindings.InstanceStateChangeType;
import com.automata.cloudcore.xmlbindings.InstanceStateType;
import com.automata.cloudcore.xmlbindings.InstanceType;
import com.automata.cloudcore.xmlbindings.InstancesType;
import com.automata.cloudcore.xmlbindings.IpPermissionSetType;
import com.automata.cloudcore.xmlbindings.IpPermissionType;
import com.automata.cloudcore.xmlbindings.LaunchConfigurationType;
import com.automata.cloudcore.xmlbindings.LaunchConfigurationsType;
import com.automata.cloudcore.xmlbindings.ListenerDescriptionType;
import com.automata.cloudcore.xmlbindings.ListenerDescriptionsType;
import com.automata.cloudcore.xmlbindings.ListenerType;
import com.automata.cloudcore.xmlbindings.LoadBalancerDescriptionType;
import com.automata.cloudcore.xmlbindings.LoadBalancerDescriptionsType;
import com.automata.cloudcore.xmlbindings.PendingModifiedValuesType;
import com.automata.cloudcore.xmlbindings.PoliciesType;
import com.automata.cloudcore.xmlbindings.PolicyNamesType;
import com.automata.cloudcore.xmlbindings.ReadReplicaDBInstanceIdentifierListType;
import com.automata.cloudcore.xmlbindings.ReservationInfoType;
import com.automata.cloudcore.xmlbindings.ReservationSetType;
import com.automata.cloudcore.xmlbindings.RunningInstancesItemType;
import com.automata.cloudcore.xmlbindings.RunningInstancesSetType;
import com.automata.cloudcore.xmlbindings.SecurityGroupItemType;
import com.automata.cloudcore.xmlbindings.SecurityGroupSetType;
import com.automata.cloudcore.xmlbindings.SecurityGroups;
import com.automata.cloudcore.xmlbindings.SuspendedProcessType;
import com.automata.cloudcore.xmlbindings.SuspendedProcessesType;
import com.automata.cloudcore.xmlbindings.UserIdGroupPairSetType;
import com.automata.cloudcore.xmlbindings.UserIdGroupPairType;

public class TransformObject {

	private static List<LoadBalancerDescription> loadBalancerDescriptions;

	public static List<InstanceStateChangeType> transform(
			List<InstanceStateChange> instanceStateChangeList) {

		InstanceStateChangeType instanceStateChangeType;
		List<InstanceStateChangeType> instanceStateChangeTypeList;
		InstanceStateType previousState, currentState;

		instanceStateChangeTypeList = new ArrayList<InstanceStateChangeType>();

		for (InstanceStateChange instanceStateChange : instanceStateChangeList) {
			previousState = TransformObject
				.getInstanceStateType(instanceStateChange.getPreviousState());
			currentState = TransformObject
				.getInstanceStateType(instanceStateChange.getCurrentState());
			instanceStateChangeType = new InstanceStateChangeType();
			instanceStateChangeType.setPreviousState(previousState);
			instanceStateChangeType.setCurrentState(currentState);
			instanceStateChangeType.setInstanceId(instanceStateChange.getInstanceId());
			instanceStateChangeTypeList.add(instanceStateChangeType);
		}

		return instanceStateChangeTypeList;
	}

	public static InstanceStateType getInstanceStateType(
			InstanceState instanceState) {

		InstanceStateType instanceStateType;
		instanceStateType = new InstanceStateType();
		instanceStateType.setCode(instanceState.getCode());
		instanceStateType.setName(instanceState.getName());
		return instanceStateType;
	}
	
	public static ReadReplicaDBInstanceIdentifierListType transform(
			List<String> readReplicaDBInstanceIdentifiers) {
		ReadReplicaDBInstanceIdentifierListType readReplicaDBInstanceIdentifierListType;
		readReplicaDBInstanceIdentifierListType = new ReadReplicaDBInstanceIdentifierListType();
		readReplicaDBInstanceIdentifierListType.setReadReplicaDBInstanceIdentifier(readReplicaDBInstanceIdentifiers);	
		return readReplicaDBInstanceIdentifierListType;
	}

	public static DBSecurityGroupMembershipListType transform(
			List<DBSecurityGroupMembership> dBSecurityGroupMembershipList) {
		
		DBSecurityGroupMembershipListType  dBSecurityGroupMembershipListType = null;
		List<DBSecurityGroupMembershipType> dbSecurityGroupMembershipTypeList = null;
		DBSecurityGroupMembershipType dbSecurityGroupMembershipType = null;
		String dBSecGrpName ="";
		String status = "";
		
		dBSecurityGroupMembershipListType = new DBSecurityGroupMembershipListType();
		dbSecurityGroupMembershipTypeList = new ArrayList<DBSecurityGroupMembershipType>();
		dbSecurityGroupMembershipType = new DBSecurityGroupMembershipType();
		
		for (DBSecurityGroupMembership dBSecurityGroupMembership : dBSecurityGroupMembershipList){
			
			dBSecGrpName = dBSecurityGroupMembership.getDBSecurityGroupName();
			status = dBSecurityGroupMembership.getStatus();
			dbSecurityGroupMembershipType.setDBSecurityGroupName(dBSecGrpName);
			dbSecurityGroupMembershipType.setStatus(status);
			dbSecurityGroupMembershipTypeList.add(dbSecurityGroupMembershipType);
		}
		dBSecurityGroupMembershipListType.setDbSecurityGroup(dbSecurityGroupMembershipTypeList);
		return dBSecurityGroupMembershipListType;
	}

	public static DBParameterGroupStatusListType transform(List<DBParameterGroupStatus> dbParameterGroupStatus) {
		
		DBParameterGroupStatusListType dBParameterGroupStatusListType;
		List<DBParameterGroupStatusType> dBParameterGroupStatusTypeList;
		DBParameterGroupStatusType dBParameterGroupStatusType;
		String dbParameterGroupName = "";
		String parameterApplyStatus = "";
		
		dBParameterGroupStatusListType = new DBParameterGroupStatusListType();
		dBParameterGroupStatusType = new DBParameterGroupStatusType();
		dBParameterGroupStatusTypeList = new ArrayList<DBParameterGroupStatusType>();
		
		for(DBParameterGroupStatus  dBParameterGroupStatus : dbParameterGroupStatus){
			
			dbParameterGroupName = dBParameterGroupStatus.getDBParameterGroupName();
			parameterApplyStatus = dBParameterGroupStatus.getParameterApplyStatus();
			dBParameterGroupStatusType.setDBParameterGroupName(dbParameterGroupName);
			dBParameterGroupStatusType.setParameterApplyStatus(parameterApplyStatus);
			dBParameterGroupStatusTypeList.add(dBParameterGroupStatusType);
		}
		dBParameterGroupStatusListType.setDbParameterGroup(dBParameterGroupStatusTypeList);
		return dBParameterGroupStatusListType;
	}
	
	public static PendingModifiedValuesType transform(PendingModifiedValues values) {
		
		PendingModifiedValuesType pendingModifiedValuesType;
		pendingModifiedValuesType = new PendingModifiedValuesType();
		pendingModifiedValuesType.setAllocatedStorage(values.getAllocatedStorage());
		pendingModifiedValuesType.setBackupRetentionPeriod(values.getBackupRetentionPeriod());
		pendingModifiedValuesType.setDBInstanceClass(values.getDBInstanceClass());
		pendingModifiedValuesType.setEngineVersion(values.getEngineVersion());
		pendingModifiedValuesType.setMasterUserPassword(values.getMasterUserPassword());
		pendingModifiedValuesType.setMultiAZ(values.getMultiAZ());
		pendingModifiedValuesType.setPort(values.getPort());
		
		return pendingModifiedValuesType;
	}
	
	public static List<BlockDeviceMapping> getBlockDeviceMapping(
			BlockDeviceMappingsType bdm) {

		List<com.amazonaws.services.autoscaling.model.BlockDeviceMapping> blockDeviceMappingList = null;
		List<BlockDeviceMappingType> inputBlockDeviceMappingList = null;
		String deviceName = "";
		String virtualName = "";
		EbsType ebs = null;
		com.amazonaws.services.autoscaling.model.Ebs ebsModel = null;
		BlockDeviceMapping blockDeviceMapping = null;

		inputBlockDeviceMappingList = bdm.getMember();
		if (inputBlockDeviceMappingList.size() > 0) {
			blockDeviceMappingList = new ArrayList<BlockDeviceMapping>();
			for (BlockDeviceMappingType bd : inputBlockDeviceMappingList) {
				deviceName = bd.getDeviceName();
				virtualName = bd.getVirtualName();
				ebs = bd.getEbs();

				blockDeviceMapping = new BlockDeviceMapping();
				blockDeviceMapping.setDeviceName(deviceName);
				if(StringUtils.hasLength(virtualName))
					blockDeviceMapping.setVirtualName(virtualName);
				if (ebs != null) {
					ebsModel = new com.amazonaws.services.autoscaling.model.Ebs();
					ebsModel.setSnapshotId(ebs.getSnapshotId());
					ebsModel.setVolumeSize(ebs.getVolumeSize());
					blockDeviceMapping.setEbs(ebsModel);
				}
				blockDeviceMappingList.add(blockDeviceMapping);
			}
		}
		return blockDeviceMappingList;
	}
	
	public static DescribeKeyPairsResponseInfoType getKeySet(
			DescribeKeyPairsResult describeKeyPairsResult) {
		
		DescribeKeyPairsResponseInfoType keyPairsResponseInfo = null;
		DescribeKeyPairsResponseItemType keyPairsResponseItem = null;
		List<DescribeKeyPairsResponseItemType> describeKeyPairsResponseItemList;
		
		keyPairsResponseInfo = new DescribeKeyPairsResponseInfoType();
		describeKeyPairsResponseItemList = new ArrayList<DescribeKeyPairsResponseItemType>();
		for ( KeyPairInfo keyPairInfo : describeKeyPairsResult.getKeyPairs()){
			keyPairsResponseItem = new DescribeKeyPairsResponseItemType();
			keyPairsResponseItem.setKeyName(keyPairInfo.getKeyName());
			keyPairsResponseItem.setKeyFingerprint(keyPairInfo.getKeyFingerprint());
			describeKeyPairsResponseItemList.add(keyPairsResponseItem);
		}
		keyPairsResponseInfo.setItem(describeKeyPairsResponseItemList);
		return keyPairsResponseInfo;
	}

	public static SecurityGroupSetType getSecurityGroupSet(
			DescribeSecurityGroupsResult describeSecurityGroupsResult) {
		
		SecurityGroupSetType securityGroupSetType = null;
		List<SecurityGroupItemType> securityGroupItemTypeList;
		SecurityGroupItemType securityGroupItemType = null;
		IpPermissionSetType ipPermissionSet = null;
		List<IpPermissionType> ipPermissionTypeList = null;
		IpPermissionType ipPermissionType = null;
		UserIdGroupPairSetType userIdGroupPairSet = null;
		List<UserIdGroupPairType> userIdGroupPairTypeList;
		UserIdGroupPairType userIdGroupPairType;
		
		securityGroupSetType = new SecurityGroupSetType();
		securityGroupItemTypeList = new ArrayList<SecurityGroupItemType>();
		
		for (SecurityGroup secGrp : describeSecurityGroupsResult.getSecurityGroups()){
			
			securityGroupItemType = new SecurityGroupItemType();
			securityGroupItemType.setGroupName(secGrp.getGroupName());
			securityGroupItemType.setGroupId(secGrp.getGroupId());
			securityGroupItemType.setGroupDescription(secGrp.getDescription());
			
			ipPermissionSet = new IpPermissionSetType();
			
			for (IpPermission permission : secGrp.getIpPermissions()){
				ipPermissionType = new IpPermissionType();
				
				ipPermissionType.setFromPort(permission.getFromPort());
				ipPermissionType.setToPort(permission.getToPort());
				ipPermissionType.setIpProtocol(permission.getIpProtocol());
				//ipPermissionType.setIpRanges();
				
				userIdGroupPairTypeList = new ArrayList<UserIdGroupPairType>();
				for (UserIdGroupPair userIdGroupPair : permission.getUserIdGroupPairs()){
					userIdGroupPairType = new UserIdGroupPairType();
					userIdGroupPairType.setGroupId(userIdGroupPair.getGroupId());
					userIdGroupPairType.setGroupName(userIdGroupPair.getGroupName());
					userIdGroupPairType.setUserId(userIdGroupPair.getUserId());
					userIdGroupPairTypeList.add(userIdGroupPairType);
				}
				userIdGroupPairSet = new UserIdGroupPairSetType();
				userIdGroupPairSet.setItem(userIdGroupPairTypeList);
				ipPermissionType.setGroups(userIdGroupPairSet);
				
			}
			ipPermissionSet.setItem(ipPermissionTypeList);
			securityGroupItemType.setIpPermissions(ipPermissionSet);
			//securityGroupItemType.setIpPermissionsEgress(value);
			securityGroupItemType.setOwnerId(secGrp.getOwnerId());
			//securityGroupItemType.setTagSet(secGrp.getTags());
			securityGroupItemType.setVpcId(secGrp.getVpcId());
			securityGroupItemTypeList.add(securityGroupItemType);
		}
		securityGroupSetType.setItem(securityGroupItemTypeList);
		return securityGroupSetType;
	}

	public static List<String> getInstanceIds(DescribeInstancesType describeInstancesType) {
		
		DescribeInstancesInfoType describeInstancesInfoType = null;
		List<DescribeInstancesItemType>  describeInstancesItemTypeList;
		List<String> instanceIds = null;
		String instanceId ;
		
		describeInstancesInfoType = describeInstancesType.getInstancesSet();
		describeInstancesItemTypeList = describeInstancesInfoType.getItem();
		instanceIds = new ArrayList<String>();
		
		for (DescribeInstancesItemType describeInstancesItemType : describeInstancesItemTypeList ){
			instanceId = describeInstancesItemType.getInstanceId();
			instanceIds.add(instanceId);
		}
		return instanceIds;
	}

	public static ReservationSetType getReservationSet(
			DescribeInstancesResult describeInstancesResult) {
		
		ReservationSetType reservationSetType = null;
		ReservationInfoType reservationInfoType = null;
		List<Reservation> reservationList = null;
		GroupSetType groupSetType = null;
		List<ReservationInfoType> reservationInfoTypeList = null;
		RunningInstancesSetType runningInstancesSetType = null;
		
		reservationInfoTypeList = new ArrayList<ReservationInfoType>();
		reservationSetType = new ReservationSetType();
		reservationList = describeInstancesResult.getReservations();
		for ( Reservation reservation : reservationList ){
			
			reservationInfoType = new ReservationInfoType();
			groupSetType = TransformObject.getGroupSetType(reservation);
			reservationInfoType.setGroupSet(groupSetType);
			runningInstancesSetType = TransformObject.getRunningInstancesSetType(reservation);
			reservationInfoType.setInstancesSet(runningInstancesSetType);
			reservationInfoType.setOwnerId(reservation.getOwnerId());
			reservationInfoType.setRequesterId(reservation.getRequesterId());
			reservationInfoType.setReservationId(reservation.getReservationId());
			
			reservationInfoTypeList.add(reservationInfoType);
		}
		
		reservationSetType.setItem(reservationInfoTypeList);
		return reservationSetType;
	}

	private static RunningInstancesSetType getRunningInstancesSetType(
			Reservation reservation) {
		
		RunningInstancesSetType runningInstancesSetType = null;
		List<RunningInstancesItemType> runningInstancesItemTypeList = null;
		RunningInstancesItemType runningInstancesItemType = null;
		List<Instance> instances = null;
		
		runningInstancesSetType = new RunningInstancesSetType();
		runningInstancesItemTypeList = new ArrayList<RunningInstancesItemType>();
		instances = reservation.getInstances();
		for (Instance instance : instances ){
			runningInstancesItemType = new RunningInstancesItemType(instance);
			runningInstancesItemTypeList.add(runningInstancesItemType);
		}
		runningInstancesSetType.setItem(runningInstancesItemTypeList);
		return runningInstancesSetType;
	}

	private static GroupSetType getGroupSetType(Reservation reservation) {

		GroupSetType groupSetType = null;
		List<GroupItemType> groupItemTypeList = null;
		GroupItemType groupItemType = null;
		
		groupSetType = new GroupSetType();
		groupItemTypeList = new ArrayList<GroupItemType>();
		
		for (String groupName : reservation.getGroupNames()){
			groupItemType = new GroupItemType();
			groupItemType.setGroupName(groupName);
			groupItemTypeList.add(groupItemType);
		}
		groupSetType.setItem(groupItemTypeList);
		return groupSetType;
	}

	public static DescribeAutoScalingGroupsResultType getDescribeAutoScalingGroupsResultType(
			DescribeAutoScalingGroupsResult descAutoScalingGrpResult) {
		
		DescribeAutoScalingGroupsResultType descASGrpResultType;
		String nextToken = null;
		AutoScalingGroupType asg = null;
		AutoScalingGroupsType asgroups = null;
		List<AutoScalingGroupType> asgroupsList = null;
		List<com.amazonaws.services.autoscaling.model.AutoScalingGroup> autoscalingGroupsList;
		
		descASGrpResultType = new DescribeAutoScalingGroupsResultType();
		asgroups = new AutoScalingGroupsType();
		asgroupsList = new ArrayList<AutoScalingGroupType>();
		
		nextToken = descAutoScalingGrpResult.getNextToken();
		if (nextToken != null)
			descASGrpResultType.setNextToken(descAutoScalingGrpResult.getNextToken());
		autoscalingGroupsList =  descAutoScalingGrpResult.getAutoScalingGroups();
		for (com.amazonaws.services.autoscaling.model.AutoScalingGroup autoScalingGrp : autoscalingGroupsList ){
			asg = new AutoScalingGroupType(autoScalingGrp);
			asgroupsList.add(asg);
		}
		
		asgroups.setMember(asgroupsList);
		descASGrpResultType.setAutoScalingGroups(asgroups);
		return descASGrpResultType;
	}

	public static DescribeLoadBalancersResultType getDescribeLoadBalancersResultType(
			DescribeLoadBalancersResult describeLoadBalancersResult) {
		
		DescribeLoadBalancersResultType resultType;
		LoadBalancerDescriptionsType loadBalancerDescriptions;
		LoadBalancerDescriptionType  loadBalancerDescType;
		List<LoadBalancerDescriptionType> loadBalancerDescTypeList;
		List<LoadBalancerDescription> loadBalancerDescList;
		AvailabilityZonesType az =  null;
		HealthCheckType healthCheckType = null;
		InstancesType instances = null;
		ListenerDescriptionsType listenerDescriptions = null;
		
		resultType = new DescribeLoadBalancersResultType();
		loadBalancerDescriptions = new LoadBalancerDescriptionsType();
		loadBalancerDescTypeList = new ArrayList<LoadBalancerDescriptionType>();
		loadBalancerDescList = describeLoadBalancersResult.getLoadBalancerDescriptions();
		
		for (LoadBalancerDescription loadbalancerDesc : loadBalancerDescList ){
			loadBalancerDescType = new LoadBalancerDescriptionType();
			loadBalancerDescType.setDNSName(loadbalancerDesc.getDNSName());
			loadBalancerDescType.setLoadBalancerName(loadbalancerDesc.getLoadBalancerName());

			az =  new AvailabilityZonesType();
			az.setMember(loadbalancerDesc.getAvailabilityZones());
			loadBalancerDescType.setAvailabilityZones(az);
			
			healthCheckType = getHealthCheckType(loadbalancerDesc.getHealthCheck());
			loadBalancerDescType.setHealthCheckType(healthCheckType);
			
			instances = getInstancesType(loadbalancerDesc.getInstances());
			loadBalancerDescType.setInstancesType(instances);
			
			listenerDescriptions = getListenerDescriptionsType(loadbalancerDesc.getListenerDescriptions());
			loadBalancerDescType.setListenerDescriptions(listenerDescriptions);
			PoliciesType policies = getPoliciesType(loadbalancerDesc.getPolicies());
			loadBalancerDescType.setPolicies(policies);
			
			loadBalancerDescTypeList.add(loadBalancerDescType);
		}
		loadBalancerDescriptions.setMember(loadBalancerDescTypeList);
		resultType.setLoadBalancerDescriptions(loadBalancerDescriptions);
		return resultType;
	}

	private static PoliciesType getPoliciesType(Policies policies) {
		
		PoliciesType policiesType = new PoliciesType();
		//TODO : complete this
		return null;
	}

	private static ListenerDescriptionsType getListenerDescriptionsType(
			List<ListenerDescription> listenerDescriptions) {
		ListenerDescriptionsType listenerDescriptionsType;
		List<ListenerDescriptionType> listenerDescriptionList;
		ListenerDescriptionType listenerDescriptionType;
		
		listenerDescriptionsType = new ListenerDescriptionsType();
		listenerDescriptionList = new ArrayList<ListenerDescriptionType>();
		for (ListenerDescription listenerDescription : listenerDescriptions){
			listenerDescriptionType = new ListenerDescriptionType();
			
			ListenerType listener =getListenerType(listenerDescription.getListener());
			listenerDescriptionType.setListener(listener);
			PolicyNamesType policyNames = getPolicyNamesType(listenerDescription.getPolicyNames());
			listenerDescriptionType.setPolicyNames(policyNames);
			listenerDescriptionList.add(listenerDescriptionType);
		}
		listenerDescriptionsType.setMember(listenerDescriptionList);
		
		return listenerDescriptionsType;
	}

	private static PolicyNamesType getPolicyNamesType(List<String> policyNames) {
		
		PolicyNamesType policyNamesType = new PolicyNamesType();
		policyNamesType.setMember(policyNames);
	
		return policyNamesType;
	}

	private static ListenerType getListenerType(
			Listener listener) {
		ListenerType listenerType = new ListenerType();
		if (listener != null){
			listenerType.setInstancePort(listener.getInstancePort());
			listenerType.setLoadBalancerPort(listener.getLoadBalancerPort());
			listenerType.setProtocol(listener.getProtocol());
			listenerType.setSSLCertificateId(listener.getSSLCertificateId());
		}
		return listenerType;
	}

	private static InstancesType getInstancesType(
			List<com.amazonaws.services.elasticloadbalancing.model.Instance> lbInstances) {
		InstancesType instances = new InstancesType(); 
		List<InstanceType> instanceList = new ArrayList<InstanceType>();
		InstanceType instance = null;
		for ( com.amazonaws.services.elasticloadbalancing.model.Instance lbinstance : lbInstances){
			instance = new InstanceType();
			instance.setInstanceId(lbinstance.getInstanceId());
			instanceList.add(instance);
		}
		instances.setMember(instanceList);
		return instances;
	}

	private static HealthCheckType getHealthCheckType(HealthCheck hc) {
		HealthCheckType healthCheckType = new HealthCheckType();
		if (hc != null) {
			healthCheckType.setHealthyThreshold(hc.getHealthyThreshold());
			healthCheckType.setUnhealthyThreshold(hc.getUnhealthyThreshold());
			healthCheckType.setInterval(hc.getInterval());
			healthCheckType.setTarget(hc.getTarget());
			healthCheckType.setTimeout(hc.getTimeout());
		}
		return healthCheckType;
	}

	public static DescribeLaunchConfigurationsResultType getDescribeLaunchConfigurationsResultType(
			DescribeLaunchConfigurationsResult result) {
		
		DescribeLaunchConfigurationsResultType resultType;
		resultType = new DescribeLaunchConfigurationsResultType();
		
		LaunchConfigurationsType launchConfigurations;
		LaunchConfigurationType launchConfigurationType;
		List<LaunchConfigurationType> launchConfigurationList;
		launchConfigurations = new LaunchConfigurationsType();
		launchConfigurationList = new ArrayList<LaunchConfigurationType>();
		
		for(com.amazonaws.services.autoscaling.model.LaunchConfiguration lc : result.getLaunchConfigurations() ){
			launchConfigurationType = new LaunchConfigurationType();
			launchConfigurationType.setLaunchConfigurationName(lc.getLaunchConfigurationName());
			launchConfigurationType.setLaunchConfigurationARN(lc.getLaunchConfigurationARN());
			launchConfigurationType.setImageId(lc.getImageId());
			launchConfigurationType.setKeyName(lc.getKeyName());
			
			SecurityGroups sg = new SecurityGroups();
			sg.setMember(lc.getSecurityGroups());
			launchConfigurationType.setSecurityGroups(sg);
			
			launchConfigurationType.setUserData(lc.getUserData());
			launchConfigurationType.setInstanceType(lc.getInstanceType());
			launchConfigurationType.setKernelId(lc.getKernelId());
			launchConfigurationType.setRamdiskId(lc.getRamdiskId());
			
			/*BlockDeviceMappingsType bdm = new BlockDeviceMappingsType();
			bdm.
			launchConfigurationType.setBlockDeviceMappings(bdm);*/
			//TODO: Complete it
			launchConfigurationList.add(launchConfigurationType);
		}
		
		launchConfigurations.setMember(launchConfigurationList);
		resultType.setLaunchConfigurations(launchConfigurations);
		resultType.setNextToken(result.getNextToken());
		return resultType;
	}

	public static InstancesType getASInstancesType(
			List<com.amazonaws.services.autoscaling.model.Instance> instances) {
		
		InstancesType instancesType;
		InstanceType instanceType;
		List<InstanceType> instanceTypeList;
		
		instancesType = new InstancesType();
		instanceTypeList = new ArrayList<InstanceType>();
		for(com.amazonaws.services.autoscaling.model.Instance instance : instances ){
			instanceType = new InstanceType();
			instanceType.setInstanceId(instance.getInstanceId());
			instanceTypeList.add(instanceType);
		}
		instancesType.setMember(instanceTypeList);
		return instancesType;
	}

	public static EnabledMetricsType getEnabledMetricsType(
			List<EnabledMetric> enabledMetrics) {
		EnabledMetricsType enabledMetricsType = new EnabledMetricsType();
		List<EnabledMetricType> enabledMetricTypeList = new ArrayList<EnabledMetricType>();
		EnabledMetricType enabledMetricType;
		for(EnabledMetric enabledMetric : enabledMetrics ){
			enabledMetricType = new EnabledMetricType();
			enabledMetricType.setGranularity(enabledMetric.getGranularity());
			enabledMetricType.setMetric(enabledMetric.getMetric());
			enabledMetricTypeList.add(enabledMetricType);
		}
		enabledMetricsType.setMember(enabledMetricTypeList);
		return enabledMetricsType;
	}

	public static SuspendedProcessesType getSuspendedProcessesType(
			List<SuspendedProcess> enabledMetrics) {
		SuspendedProcessesType SuspendedProcessesType = new SuspendedProcessesType();
		List<SuspendedProcessType> suspendedProcessTypeList = new ArrayList<SuspendedProcessType>();
		SuspendedProcessType suspendedProcessType;
		for(SuspendedProcess suspendedProcess : enabledMetrics ){
			suspendedProcessType = new SuspendedProcessType();
			suspendedProcessType.setProcessName(suspendedProcess.getProcessName());
			suspendedProcessType.setSuspensionReason(suspendedProcess.getSuspensionReason());
			suspendedProcessTypeList.add(suspendedProcessType);
		}
		SuspendedProcessesType.setMember(suspendedProcessTypeList);
		return SuspendedProcessesType;
	}
	
	
	public static EC2SecurityGroupList getEC2SecurityGroupList(
			List<com.amazonaws.services.rds.model.EC2SecurityGroup> ec2SecGrpList) {
		EC2SecurityGroupList ec2SecurityGroups = new EC2SecurityGroupList();
    	List<EC2SecurityGroup> ec2SecurityGroupTypeList;
    	EC2SecurityGroup ec2SecurityGroupType;
    	ec2SecurityGroupTypeList = new ArrayList<EC2SecurityGroup>();
    	for (com.amazonaws.services.rds.model.EC2SecurityGroup ec2secGrp : ec2SecGrpList){
    		ec2SecurityGroupType = new EC2SecurityGroup();
    		ec2SecurityGroupType.setEC2SecurityGroupName(ec2secGrp.getEC2SecurityGroupName());
    		ec2SecurityGroupType.setEC2SecurityGroupOwnerId(ec2secGrp.getEC2SecurityGroupOwnerId());
    		ec2SecurityGroupType.setStatus(ec2secGrp.getStatus());
    		ec2SecurityGroupTypeList.add(ec2SecurityGroupType);
    	}
    	ec2SecurityGroups.setEc2SecurityGroup(ec2SecurityGroupTypeList);
		return ec2SecurityGroups;
	}

	public static IPRangeList getIPRangeList(
			List<com.amazonaws.services.rds.model.IPRange> ipRangeList) {
		
		IPRangeList ipRanges = new IPRangeList();
    	List<IPRange> ipRangeTypeList;
    	IPRange ipRangeType;
    	ipRangeTypeList = new ArrayList<IPRange>();
    	for (com.amazonaws.services.rds.model.IPRange ipRange : ipRangeList){
    		ipRangeType = new IPRange();
    		ipRangeType.setCIDRIP(ipRange.getCIDRIP());
    		ipRangeType.setStatus(ipRange.getStatus());
    		ipRangeTypeList.add(ipRangeType);
    	}
    	ipRanges.setIpRange(ipRangeTypeList);
		return ipRanges;
	}
}
