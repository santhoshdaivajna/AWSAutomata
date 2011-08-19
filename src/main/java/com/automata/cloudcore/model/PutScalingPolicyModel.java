package com.automata.cloudcore.model;

import com.automata.cloudcore.xmlbindings.PutScalingPolicyType;

// TODO: Auto-generated Javadoc
/**
 * The Class PutScalingPolicyModel.
 */
public class PutScalingPolicyModel {

	/** The auto scaling group name. */
	private String autoScalingGroupName;
	
	/** The policy name. */
	private String policyName;
	
	/** The scaling adjustment. */
	private Integer scalingAdjustment;
	
	/** The adjustment type. */
	private String adjustmentType;
	
	/** The cooldown. */
	private Integer cooldown;
	
	/** The region. */
	private String region;

	/**
	 * Instantiates a new put scaling policy model.
	 */
	public PutScalingPolicyModel() {
	}

	/**
	 * Instantiates a new put scaling policy model.
	 *
	 * @param putScalingPolicy the put scaling policy
	 */
	public PutScalingPolicyModel(PutScalingPolicyType putScalingPolicy) {

		this.autoScalingGroupName = putScalingPolicy.getAutoScalingGroupName();
		this.policyName = putScalingPolicy.getPolicyName();
		this.scalingAdjustment = putScalingPolicy.getScalingAdjustment();
		this.adjustmentType = putScalingPolicy.getAdjustmentType();
		this.cooldown = putScalingPolicy.getCooldown();
		this.region = putScalingPolicy.getRegion();
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
	 * Gets the policy name.
	 *
	 * @return the policy name
	 */
	public String getPolicyName() {
		return policyName;
	}

	/**
	 * Sets the policy name.
	 *
	 * @param policyName the new policy name
	 */
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	/**
	 * Gets the scaling adjustment.
	 *
	 * @return the scaling adjustment
	 */
	public Integer getScalingAdjustment() {
		return scalingAdjustment;
	}

	/**
	 * Sets the scaling adjustment.
	 *
	 * @param scalingAdjustment the new scaling adjustment
	 */
	public void setScalingAdjustment(Integer scalingAdjustment) {
		this.scalingAdjustment = scalingAdjustment;
	}

	/**
	 * Gets the adjustment type.
	 *
	 * @return the adjustment type
	 */
	public String getAdjustmentType() {
		return adjustmentType;
	}

	/**
	 * Sets the adjustment type.
	 *
	 * @param adjustmentType the new adjustment type
	 */
	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

	/**
	 * Gets the cooldown.
	 *
	 * @return the cooldown
	 */
	public Integer getCooldown() {
		return cooldown;
	}

	/**
	 * Sets the cooldown.
	 *
	 * @param cooldown the new cooldown
	 */
	public void setCooldown(Integer cooldown) {
		this.cooldown = cooldown;
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
		stringBuilder.append("PutScalingPolicyModel [adjustmentType=");
		stringBuilder.append(adjustmentType);
		stringBuilder.append(", autoScalingGroupName=");
		stringBuilder.append(autoScalingGroupName);
		stringBuilder.append(", cooldown=");
		stringBuilder.append(cooldown);
		stringBuilder.append(", policyName=");
		stringBuilder.append(policyName);
		stringBuilder.append(", region=");
		stringBuilder.append(region);
		stringBuilder.append(", scalingAdjustment=");
		stringBuilder.append(scalingAdjustment);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
