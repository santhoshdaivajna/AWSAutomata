package com.automata.cloudcore.model;

import java.util.ArrayList;
import java.util.List;

import com.automata.cloudcore.xmlbindings.Ec2InstanceType;

// TODO: Auto-generated Javadoc
/**
 * The Class EC2Model.
 */
public class EC2Model extends CloudInstanceModel {

	/** The instance type. */
	private String instanceType;
	
	/** The min count. */
	private Integer minCount;
	
	/** The max count. */
	private Integer maxCount;
	
	/** The image id. */
	private String imageId;
	
	/** The key name. */
	private String keyName;
	
	/** The availability zone. */
	private String availabilityZone;
	
	/** The monitoring. */
	private boolean monitoring;
	
	/** The security groups. */
	private List<String> securityGroups;

	/**
	 * Instantiates a new e c2 model.
	 *
	 * @param ec2Instance the ec2 instance
	 */
	public EC2Model(Ec2InstanceType ec2Instance) {
		this.availabilityZone = ec2Instance.getAvailabilityZone();
		this.imageId = ec2Instance.getAMI();
		this.instanceType = ec2Instance.getInstanceType();
		this.keyName = ec2Instance.getKeyPair();
		this.maxCount = ec2Instance.getMaxInstances();
		this.minCount = ec2Instance.getMinInstances();
		this.monitoring = ec2Instance.isMonitoring();
		
		List<String> secGroups = new ArrayList<String>();
		for (String secGroup : ec2Instance.getSecurityGroupName())
			secGroups.add(secGroup);
		this.securityGroups = secGroups;
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
	 * Gets the min count.
	 *
	 * @return the min count
	 */
	public Integer getMinCount() {
		return minCount;
	}

	/**
	 * Sets the min count.
	 *
	 * @param minCount the new min count
	 */
	public void setMinCount(Integer minCount) {
		this.minCount = minCount;
	}

	/**
	 * Gets the max count.
	 *
	 * @return the max count
	 */
	public Integer getMaxCount() {
		return maxCount;
	}

	/**
	 * Sets the max count.
	 *
	 * @param maxCount the new max count
	 */
	public void setMaxCount(Integer maxCount) {
		this.maxCount = maxCount;
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
	 * Gets the key pair name.
	 *
	 * @return the key pair name
	 */
	public String getKeyPairName() {
		return keyName;
	}


	/**
	 * Sets the key pair name.
	 *
	 * @param keyPairName the new key pair name
	 */
	public void setKeyPairName(String keyPairName) {
		this.keyName = keyPairName;
	}

	/**
	 * Gets the availability zone.
	 *
	 * @return the availability zone
	 */
	public String getAvailabilityZone() {
		return availabilityZone;
	}

	/**
	 * Sets the availability zone.
	 *
	 * @param availabilityZone the new availability zone
	 */
	public void setAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
	}

	/**
	 * Checks if is monitoring.
	 *
	 * @return true, if is monitoring
	 */
	public boolean isMonitoring() {
		return monitoring;
	}

	/**
	 * Sets the monitoring.
	 *
	 * @param monitoring the new monitoring
	 */
	public void setMonitoring(boolean monitoring) {
		this.monitoring = monitoring;
	}

	/**
	 * Gets the security groups.
	 *
	 * @return the security groups
	 */
	public List<String> getSecurityGroups() {
		return securityGroups;
	}

	/**
	 * Sets the security groups.
	 *
	 * @param securityGroups the new security groups
	 */
	public void setSecurityGroups(List<String> securityGroups) {
		this.securityGroups = securityGroups;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("LaunchRequest [instanceType=");
		stringBuilder.append(instanceType);
		stringBuilder.append(", minCount=");
		stringBuilder.append(minCount);
		stringBuilder.append(", maxCount=");
		stringBuilder.append(maxCount);
		stringBuilder.append(", imageId=");
		stringBuilder.append(imageId);
		stringBuilder.append(", keyName=");
		stringBuilder.append(keyName);
		stringBuilder.append(", availabilityZone=");
		stringBuilder.append(availabilityZone);
		stringBuilder.append(", monitoring=");
		stringBuilder.append(monitoring);
		stringBuilder.append(", securityGroups=");
		stringBuilder.append(securityGroups);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
