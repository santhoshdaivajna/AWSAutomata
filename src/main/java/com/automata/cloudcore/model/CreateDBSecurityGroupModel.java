package com.automata.cloudcore.model;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateDBSecurityGroupModel.
 */
public class CreateDBSecurityGroupModel {

	/** The d b security group name. */
	private String dBSecurityGroupName;
    
    /** The d b security group description. */
    private String dBSecurityGroupDescription;
    
    /** The region. */
    private String region;
    
	/**
	 * Instantiates a new creates the db security group model.
	 *
	 * @param dBSecurityGroupName the d b security group name
	 * @param dBSecurityGroupDescription the d b security group description
	 * @param region the region
	 */
	public CreateDBSecurityGroupModel(String dBSecurityGroupName,
			String dBSecurityGroupDescription, String region) {
		super();
		this.dBSecurityGroupName = dBSecurityGroupName;
		this.dBSecurityGroupDescription = dBSecurityGroupDescription;
		this.region = region;
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
	 * Sets the d b security group name.
	 *
	 * @param dBSecurityGroupName the new d b security group name
	 */
	public void setdBSecurityGroupName(String dBSecurityGroupName) {
		this.dBSecurityGroupName = dBSecurityGroupName;
	}
	
	/**
	 * Gets the d b security group description.
	 *
	 * @return the d b security group description
	 */
	public String getdBSecurityGroupDescription() {
		return dBSecurityGroupDescription;
	}
	
	/**
	 * Sets the d b security group description.
	 *
	 * @param dBSecurityGroupDescription the new d b security group description
	 */
	public void setdBSecurityGroupDescription(String dBSecurityGroupDescription) {
		this.dBSecurityGroupDescription = dBSecurityGroupDescription;
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
		stringBuilder.append("CreateDBSecurityGroupModel [dBSecurityGroupDescription=");
		stringBuilder.append(dBSecurityGroupDescription);
		stringBuilder.append(", dBSecurityGroupName=");
		stringBuilder.append(dBSecurityGroupName);
		stringBuilder.append(", region=");
		stringBuilder.append(region);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
	
	
	
}
