package com.automata.cloudcore.model;

import java.util.List;

import com.amazonaws.services.autoscaling.model.BlockDeviceMapping;
import com.automata.cloudcore.util.TransformObject;
import com.automata.cloudcore.xmlbindings.BlockDeviceMappingsType;
import com.automata.cloudcore.xmlbindings.CreateLaunchConfigurationType;
import com.automata.cloudcore.xmlbindings.SecurityGroups;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateLaunchConfigurationModel.
 */
public class CreateLaunchConfigurationModel {
	
	/** The block device mappings. */
	private List<BlockDeviceMapping> blockDeviceMappings;
	
	/** The image id. */
	private String imageId;
	
	/** The instance type. */
	private String instanceType;
	
	/** The kernel id. */
	private String kernelId;
	
	/** The key name. */
	private String keyName;
	
	/** The launch configuration name. */
	private String launchConfigurationName;
	
	/** The ramdisk id. */
	private String ramdiskId;
	
	/** The security groups. */
	private SecurityGroups securityGroups;
	
	/** The user data. */
	private String userData;
	
	/** The instance monitoring. */
	private boolean instanceMonitoring;

	/** The region. */
	private String region;
	
	
	/**
	 * Instantiates a new creates the launch configuration model.
	 *
	 * @param bdm the bdm
	 * @param imageId the image id
	 * @param instanceType the instance type
	 * @param kernelId the kernel id
	 * @param keyName the key name
	 * @param launchConfigurationName the launch configuration name
	 * @param ramdiskId the ramdisk id
	 * @param securityGroups the security groups
	 * @param userData the user data
	 * @param region the region
	 */
	public CreateLaunchConfigurationModel(
			List<BlockDeviceMapping> bdm, String imageId,
			String instanceType, String kernelId, String keyName,
			String launchConfigurationName, String ramdiskId,
			SecurityGroups securityGroups, String userData, String region) {
		super();
		this.blockDeviceMappings = bdm;
		this.imageId = imageId;
		this.instanceType = instanceType;
		this.kernelId = kernelId;
		this.keyName = keyName;
		this.launchConfigurationName = launchConfigurationName;
		this.ramdiskId = ramdiskId;
		this.securityGroups = securityGroups;
		this.userData = userData;
		this.region = region;
	}
	
	/**
	 * Instantiates a new creates the launch configuration model.
	 *
	 * @param launchConfiguration the launch configuration
	 */
	public CreateLaunchConfigurationModel(
			CreateLaunchConfigurationType launchConfiguration) {
		
		BlockDeviceMappingsType bdm = null;
		bdm = launchConfiguration.getBlockDeviceMappings();
		if (bdm != null)
			this.blockDeviceMappings 	= TransformObject.getBlockDeviceMapping(bdm);
		this.imageId 		= launchConfiguration.getImageId();
		this.instanceType 	= launchConfiguration.getInstanceType();
		this.kernelId 		= launchConfiguration.getKernelId();
		this.keyName 		= launchConfiguration.getKeyName();
		this.launchConfigurationName = launchConfiguration.getLaunchConfigurationName();
		this.ramdiskId 		= launchConfiguration.getRamdiskId();
		this.securityGroups 	= launchConfiguration.getSecurityGroups();
		this.userData 		= launchConfiguration.getUserData();
		this.region			= launchConfiguration.getRegion();
		if(launchConfiguration.getInstanceMonitoring() != null)
			this.instanceMonitoring = launchConfiguration.getInstanceMonitoring().isEnabled();

	}

	/**
	 * Gets the block device mappings.
	 *
	 * @return the block device mappings
	 */
	public List<BlockDeviceMapping> getBlockDeviceMappings() {
		return blockDeviceMappings;
	}
	
	/**
	 * Sets the block device mappings.
	 *
	 * @param blockDeviceMappings the new block device mappings
	 */
	public void setBlockDeviceMappings(
			List<BlockDeviceMapping> blockDeviceMappings) {
		this.blockDeviceMappings = blockDeviceMappings;
	}
	
	/**
	 * Gets the image id.
	 *
	 * @return the image id
	 */
	public String getImageId() {
		return imageId;
	}
	
	/**
	 * Sets the image id.
	 *
	 * @param imageId the new image id
	 */
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	
	/**
	 * Gets the instance type.
	 *
	 * @return the instance type
	 */
	public String getInstanceType() {
		return instanceType;
	}
	
	/**
	 * Sets the instance type.
	 *
	 * @param instanceType the new instance type
	 */
	public void setInstanceType(String instanceType) {
		this.instanceType = instanceType;
	}
	
	/**
	 * Gets the kernel id.
	 *
	 * @return the kernel id
	 */
	public String getKernelId() {
		return kernelId;
	}
	
	/**
	 * Sets the kernel id.
	 *
	 * @param kernelId the new kernel id
	 */
	public void setKernelId(String kernelId) {
		this.kernelId = kernelId;
	}
	
	/**
	 * Gets the key name.
	 *
	 * @return the key name
	 */
	public String getKeyName() {
		return keyName;
	}
	
	/**
	 * Sets the key name.
	 *
	 * @param keyName the new key name
	 */
	public void setKeyName(String keyName) {
		this.keyName = keyName;
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
	 * Gets the ramdisk id.
	 *
	 * @return the ramdisk id
	 */
	public String getRamdiskId() {
		return ramdiskId;
	}
	
	/**
	 * Sets the ramdisk id.
	 *
	 * @param ramdiskId the new ramdisk id
	 */
	public void setRamdiskId(String ramdiskId) {
		this.ramdiskId = ramdiskId;
	}
	
	/**
	 * Gets the security groups.
	 *
	 * @return the security groups
	 */
	public SecurityGroups getSecurityGroups() {
		return securityGroups;
	}
	
	/**
	 * Sets the security groups.
	 *
	 * @param securityGroups the new security groups
	 */
	public void setSecurityGroups(SecurityGroups securityGroups) {
		this.securityGroups = securityGroups;
	}
	
	/**
	 * Gets the user data.
	 *
	 * @return the user data
	 */
	public String getUserData() {
		return userData;
	}
	
	/**
	 * Sets the user data.
	 *
	 * @param userData the new user data
	 */
	public void setUserData(String userData) {
		this.userData = userData;
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

	/**
	 * Gets the instance monitoring.
	 *
	 * @return the instance monitoring
	 */
	public boolean getInstanceMonitoring() {
		return instanceMonitoring;
	}

	/**
	 * Sets the instance monitoring.
	 *
	 * @param instanceMonitoring the new instance monitoring
	 */
	public void setInstanceMonitoring(boolean instanceMonitoring) {
		this.instanceMonitoring = instanceMonitoring;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("CreateLaunchConfigurationModel [blockDeviceMappings=");
		stringBuilder.append(blockDeviceMappings);
		stringBuilder.append(", imageId=");
		stringBuilder.append(imageId);
		stringBuilder.append(", instanceMonitoring=");
		stringBuilder.append(instanceMonitoring);
		stringBuilder.append(", instanceType=");
		stringBuilder.append(instanceType);
		stringBuilder.append(", kernelId=");
		stringBuilder.append(kernelId);
		stringBuilder.append(", keyName=");
		stringBuilder.append(keyName);
		stringBuilder.append(", launchConfigurationName=");
		stringBuilder.append(launchConfigurationName);
		stringBuilder.append(", ramdiskId=");
		stringBuilder.append(ramdiskId);
		stringBuilder.append(", region=");
		stringBuilder.append(region);
		stringBuilder.append(", securityGroups=");
		stringBuilder.append(securityGroups);
		stringBuilder.append(", userData=");
		stringBuilder.append(userData);
		stringBuilder.append(", getBlockDeviceMappings()=");
		stringBuilder.append(getBlockDeviceMappings());
		stringBuilder.append(", getImageId()=");
		stringBuilder.append(getImageId());
		stringBuilder.append(", getInstanceMonitoring()=");
		stringBuilder.append(getInstanceMonitoring());
		stringBuilder.append(", getInstanceType()=");
		stringBuilder.append(getInstanceType());
		stringBuilder.append(", getKernelId()=");
		stringBuilder.append(getKernelId());
		stringBuilder.append(", getKeyName()=");
		stringBuilder.append(getKeyName());
		stringBuilder.append(", getLaunchConfigurationName()=");
		stringBuilder.append(getLaunchConfigurationName());
		stringBuilder.append(", getRamdiskId()=");
		stringBuilder.append(getRamdiskId());
		stringBuilder.append(", getRegion()=");
		stringBuilder.append(getRegion());
		stringBuilder.append(", getSecurityGroups()=");
		stringBuilder.append(getSecurityGroups());
		stringBuilder.append(", getUserData()=");
		stringBuilder.append(getUserData());
		stringBuilder.append(", getClass()=");
		stringBuilder.append(getClass());
		stringBuilder.append(", hashCode()=");
		stringBuilder.append(hashCode());
		stringBuilder.append(", toString()=");
		stringBuilder.append(super.toString());
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
	
	
	
}
