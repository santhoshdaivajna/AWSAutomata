package com.automata.cloudcore.model;

// TODO: Auto-generated Javadoc
/**
 * The Class DeleteDBSecurityGroupModel.
 */
public class DeleteDBSecurityGroupModel {

	/** The d b security group name. */
	private String dBSecurityGroupName;
	
	/** The region. */
	private String region;

	/**
	 * Sets the d b security group name.
	 *
	 * @param dBSecurityGroupName the new d b security group name
	 */
	public void setdBSecurityGroupName(String dBSecurityGroupName) {
		this.dBSecurityGroupName = dBSecurityGroupName;
	}

	/**
	 * Gets the d b security group name.
	 *
	 * @return the d b security group name
	 */
	public String getdBSecurityGroupName() {
		return dBSecurityGroupName;
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
	 * Gets the region.
	 *
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("DeleteDBSecurityGroupModel [dBSecurityGroupName=");
		stringBuilder.append(dBSecurityGroupName);
		stringBuilder.append(", region=");
		stringBuilder.append(region);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
