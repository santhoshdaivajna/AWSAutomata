package com.automata.cloudcore.model;

import com.automata.cloudcore.xmlbindings.AvailabilityZonesType;
import com.automata.cloudcore.xmlbindings.CreateAutoScalingGroupType;
import com.automata.cloudcore.xmlbindings.LoadBalancerNamesType;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateAutoScaleGroupModel.
 */
public class CreateAutoScaleGroupModel {

	/** The auto scaling group name. */
	private String autoScalingGroupName;
	
	/** The launch configuration name. */
	private String launchConfigurationName;
	
	/** The min size. */
	private Integer minSize;
	
	/** The max size. */
	private Integer maxSize;
	
	/** The desired capacity. */
	private Integer desiredCapacity;
	
	/** The default cooldown. */
	private Integer defaultCooldown;
	
	/** The availability zones. */
	private AvailabilityZonesType availabilityZones;
	
	/** The load balancer names. */
	private LoadBalancerNamesType loadBalancerNames;
	
	/** The health check type. */
	private String healthCheckType;
	
	/** The health check grace period. */
	private Integer healthCheckGracePeriod;
	
	/** The placement group. */
	private String placementGroup;
	
	/** The vpc zone identifier. */
	private String vpcZoneIdentifier;
	
	/** The region. */
	private String region;

	/**
	 * Instantiates a new creates the auto scale group model.
	 */
	public CreateAutoScaleGroupModel() {
	}

	/**
	 * Instantiates a new creates the auto scale group model.
	 *
	 * @param autoScalingGroupName the auto scaling group name
	 * @param launchConfigurationName the launch configuration name
	 * @param minSize the min size
	 * @param maxSize the max size
	 * @param desiredCapacity the desired capacity
	 * @param defaultCooldown the default cooldown
	 * @param availabilityZones the availability zones
	 * @param loadBalancerNames the load balancer names
	 * @param healthCheckType the health check type
	 * @param healthCheckGracePeriod the health check grace period
	 * @param placementGroup the placement group
	 * @param vpcZoneIdentifier the vpc zone identifier
	 * @param region the region
	 */
	public CreateAutoScaleGroupModel(String autoScalingGroupName,
			String launchConfigurationName, Integer minSize, Integer maxSize,
			Integer desiredCapacity, Integer defaultCooldown,
			AvailabilityZonesType availabilityZones,
			LoadBalancerNamesType loadBalancerNames, String healthCheckType,
			Integer healthCheckGracePeriod, String placementGroup,
			String vpcZoneIdentifier, String region) {
		super();
		this.autoScalingGroupName = autoScalingGroupName;
		this.launchConfigurationName = launchConfigurationName;
		this.minSize = minSize;
		this.maxSize = maxSize;
		this.desiredCapacity = desiredCapacity;
		this.defaultCooldown = defaultCooldown;
		this.availabilityZones = availabilityZones;
		this.loadBalancerNames = loadBalancerNames;
		this.healthCheckType = healthCheckType;
		this.healthCheckGracePeriod = healthCheckGracePeriod;
		this.placementGroup = placementGroup;
		this.vpcZoneIdentifier = vpcZoneIdentifier;
		this.region = region;
	}

	/**
	 * Instantiates a new creates the auto scale group model.
	 *
	 * @param autoscaling the autoscaling
	 */
	public CreateAutoScaleGroupModel(CreateAutoScalingGroupType autoscaling) {
		this.autoScalingGroupName = autoscaling.getAutoScalingGroupName();
		this.launchConfigurationName = autoscaling.getLaunchConfigurationName();
		this.minSize = autoscaling.getMinSize();
		this.maxSize = autoscaling.getMaxSize();
		this.desiredCapacity = autoscaling.getDesiredCapacity();
		this.defaultCooldown = autoscaling.getDefaultCooldown();
		this.availabilityZones = autoscaling.getAvailabilityZones();
		this.loadBalancerNames = autoscaling.getLoadBalancerNames();
		this.healthCheckType = autoscaling.getHealthCheckType();
		this.healthCheckGracePeriod = autoscaling.getHealthCheckGracePeriod();
		this.placementGroup = autoscaling.getPlacementGroup();
		this.vpcZoneIdentifier = autoscaling.getVPCZoneIdentifier();
		this.region = autoscaling.getRegion();
	}

	/**
	 * Gets the auto scaling group name.
	 *
	 * @return the auto scaling group name
	 */
	public String getAutoScalingGroupName() {
		return autoScalingGroupName;
	}

	/**
	 * Sets the auto scaling group name.
	 *
	 * @param autoScalingGroupName the new auto scaling group name
	 */
	public void setAutoScalingGroupName(String autoScalingGroupName) {
		this.autoScalingGroupName = autoScalingGroupName;
	}

	/**
	 * Gets the launch configuration name.
	 *
	 * @return the launch configuration name
	 */
	public String getLaunchConfigurationName() {
		return launchConfigurationName;
	}

	/**
	 * Sets the launch configuration name.
	 *
	 * @param launchConfigurationName the new launch configuration name
	 */
	public void setLaunchConfigurationName(String launchConfigurationName) {
		this.launchConfigurationName = launchConfigurationName;
	}

	/**
	 * Gets the min size.
	 *
	 * @return the min size
	 */
	public Integer getMinSize() {
		return minSize;
	}

	/**
	 * Sets the min size.
	 *
	 * @param minSize the new min size
	 */
	public void setMinSize(Integer minSize) {
		this.minSize = minSize;
	}

	/**
	 * Gets the max size.
	 *
	 * @return the max size
	 */
	public Integer getMaxSize() {
		return maxSize;
	}

	/**
	 * Sets the max size.
	 *
	 * @param maxSize the new max size
	 */
	public void setMaxSize(Integer maxSize) {
		this.maxSize = maxSize;
	}

	/**
	 * Gets the desired capacity.
	 *
	 * @return the desired capacity
	 */
	public Integer getDesiredCapacity() {
		return desiredCapacity;
	}

	/**
	 * Sets the desired capacity.
	 *
	 * @param desiredCapacity the new desired capacity
	 */
	public void setDesiredCapacity(Integer desiredCapacity) {
		this.desiredCapacity = desiredCapacity;
	}

	/**
	 * Gets the default cooldown.
	 *
	 * @return the default cooldown
	 */
	public Integer getDefaultCooldown() {
		return defaultCooldown;
	}

	/**
	 * Sets the default cooldown.
	 *
	 * @param defaultCooldown the new default cooldown
	 */
	public void setDefaultCooldown(Integer defaultCooldown) {
		this.defaultCooldown = defaultCooldown;
	}

	/**
	 * Gets the availability zones.
	 *
	 * @return the availability zones
	 */
	public AvailabilityZonesType getAvailabilityZones() {
		return availabilityZones;
	}

	/**
	 * Sets the availability zones.
	 *
	 * @param availabilityZones the new availability zones
	 */
	public void setAvailabilityZones(AvailabilityZonesType availabilityZones) {
		this.availabilityZones = availabilityZones;
	}

	/**
	 * Gets the load balancer names.
	 *
	 * @return the load balancer names
	 */
	public LoadBalancerNamesType getLoadBalancerNames() {
		return loadBalancerNames;
	}

	/**
	 * Sets the load balancer names.
	 *
	 * @param loadBalancerNames the new load balancer names
	 */
	public void setLoadBalancerNames(LoadBalancerNamesType loadBalancerNames) {
		this.loadBalancerNames = loadBalancerNames;
	}

	/**
	 * Gets the health check type.
	 *
	 * @return the health check type
	 */
	public String getHealthCheckType() {
		return healthCheckType;
	}

	/**
	 * Sets the health check type.
	 *
	 * @param healthCheckType the new health check type
	 */
	public void setHealthCheckType(String healthCheckType) {
		this.healthCheckType = healthCheckType;
	}

	/**
	 * Gets the health check grace period.
	 *
	 * @return the health check grace period
	 */
	public Integer getHealthCheckGracePeriod() {
		return healthCheckGracePeriod;
	}

	/**
	 * Sets the health check grace period.
	 *
	 * @param healthCheckGracePeriod the new health check grace period
	 */
	public void setHealthCheckGracePeriod(Integer healthCheckGracePeriod) {
		this.healthCheckGracePeriod = healthCheckGracePeriod;
	}

	/**
	 * Gets the placement group.
	 *
	 * @return the placement group
	 */
	public String getPlacementGroup() {
		return placementGroup;
	}

	/**
	 * Sets the placement group.
	 *
	 * @param placementGroup the new placement group
	 */
	public void setPlacementGroup(String placementGroup) {
		this.placementGroup = placementGroup;
	}

	/**
	 * Gets the vpc zone identifier.
	 *
	 * @return the vpc zone identifier
	 */
	public String getVpcZoneIdentifier() {
		return vpcZoneIdentifier;
	}

	/**
	 * Sets the vpc zone identifier.
	 *
	 * @param vpcZoneIdentifier the new vpc zone identifier
	 */
	public void setVpcZoneIdentifier(String vpcZoneIdentifier) {
		this.vpcZoneIdentifier = vpcZoneIdentifier;
	}

	/**
	 * Gets the region.
	 *
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Sets the region.
	 *
	 * @param region the new region
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("CreateAutoScaleGroupModel [autoScalingGroupName=");
		stringBuilder.append(autoScalingGroupName);
		stringBuilder.append(", availabilityZones=");
		stringBuilder.append(availabilityZones);
		stringBuilder.append(", defaultCooldown=");
		stringBuilder.append(defaultCooldown);
		stringBuilder.append(", desiredCapacity=");
		stringBuilder.append(desiredCapacity);
		stringBuilder.append(", region=");
		stringBuilder.append(region);
		stringBuilder.append(", healthCheckGracePeriod=");
		stringBuilder.append(healthCheckGracePeriod);
		stringBuilder.append(", healthCheckType=");
		stringBuilder.append(healthCheckType);
		stringBuilder.append(", launchConfigurationName=");
		stringBuilder.append(launchConfigurationName);
		stringBuilder.append(", loadBalancerNames=");
		stringBuilder.append(loadBalancerNames);
		stringBuilder.append(", maxSize=");
		stringBuilder.append(maxSize);
		stringBuilder.append(", minSize=");
		stringBuilder.append(minSize);
		stringBuilder.append(", placementGroup=");
		stringBuilder.append(placementGroup);
		stringBuilder.append(", vpcZoneIdentifier=");
		stringBuilder.append(vpcZoneIdentifier);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
