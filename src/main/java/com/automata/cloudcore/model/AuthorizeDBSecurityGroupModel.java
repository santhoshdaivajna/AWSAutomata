package com.automata.cloudcore.model;

import com.automata.cloudcore.xmlbindings.AuthorizeDBSecurityGroupIngressType;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorizeDBSecurityGroupModel.
 */
public class AuthorizeDBSecurityGroupModel {
	
	/** The database security group name. */
	private String dBSecurityGroupName;
	
	/** The ec2 security group name. */
	private String ec2SecurityGroupName;
	
	/** The ec2 security group owner id. */
	private String ec2SecurityGroupOwnerId;
	
	/** The cidr ip. */
	private String cidrIp ;
	
	/** One of the Amazon AWS Region. */
	private String region;

	
	/**
	 * Instantiates a new AuthorizeDBSecurityGroupModel.
	 *
	 * @param dBSecurityGroupName the d b security group name
	 * @param ec2SecurityGroupName the ec2 security group name
	 * @param ec2SecurityGroupOwnerId the ec2 security group owner id
	 * @param cidrIp the cidr ip
	 * @param region the region
	 */
	public AuthorizeDBSecurityGroupModel(String dBSecurityGroupName,
			String ec2SecurityGroupName, String ec2SecurityGroupOwnerId,
			String cidrIp, String region) {
		super();
		this.dBSecurityGroupName = dBSecurityGroupName;
		this.ec2SecurityGroupName = ec2SecurityGroupName;
		this.ec2SecurityGroupOwnerId = ec2SecurityGroupOwnerId;
		this.cidrIp = cidrIp;
		this.region = region;
	}
	
	public AuthorizeDBSecurityGroupModel(
			AuthorizeDBSecurityGroupIngressType authorizeIngress) {
		this.dBSecurityGroupName = authorizeIngress.getDBSecurityGroupName();
		this.ec2SecurityGroupName = authorizeIngress.getEc2SecurityGroupName();
		this.ec2SecurityGroupOwnerId = authorizeIngress.getEc2SecurityGroupOwnerId();
		this.cidrIp = authorizeIngress.getCidrIp();
		this.region = authorizeIngress.getRegion();
	}

	/**
	 * Gets the db security group name.
	 *
	 * @return the db security group name
	 */
	public String getdBSecurityGroupName() {
		return dBSecurityGroupName;
	}
	
	/**
	 * Sets the db security group name.
	 *
	 * @param dBSecurityGroupName the new db security group name
	 */
	public void setdBSecurityGroupName(String dBSecurityGroupName) {
		this.dBSecurityGroupName = dBSecurityGroupName;
	}
	
	/**
	 * Gets the ec2 security group name.
	 *
	 * @return the ec2 security group name
	 */
	public String getEc2SecurityGroupName() {
		return ec2SecurityGroupName;
	}
	
	/**
	 * Sets the ec2 security group name.
	 *
	 * @param ec2SecurityGroupName the new ec2 security group name
	 */
	public void setEc2SecurityGroupName(String ec2SecurityGroupName) {
		this.ec2SecurityGroupName = ec2SecurityGroupName;
	}
	
	/**
	 * Gets the cidr ip.
	 *
	 * @return the cidr ip
	 */
	public String getCidrIp() {
		return cidrIp;
	}
	
	/**
	 * Sets the cidr ip.
	 *
	 * @param cidrIp the new cidr ip
	 */
	public void setCidrIp(String cidrIp) {
		this.cidrIp = cidrIp;
	}
	
	/**
	 * Gets the ec2 security group owner id.
	 *
	 * @return the ec2 security group owner id
	 */
	public String getEc2SecurityGroupOwnerId() {
		return ec2SecurityGroupOwnerId;
	}
	
	/**
	 * Sets the ec2 security group owner id.
	 *
	 * @param ec2SecurityGroupOwnerId the new ec2 security group owner id
	 */
	public void setEc2SecurityGroupOwnerId(String ec2SecurityGroupOwnerId) {
		this.ec2SecurityGroupOwnerId = ec2SecurityGroupOwnerId;
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
		stringBuilder.append("AuthorizeDBSecurityGroupModel [cidrIp=");
		stringBuilder.append(cidrIp);
		stringBuilder.append(", dBSecurityGroupName=");
		stringBuilder.append(dBSecurityGroupName);
		stringBuilder.append(", ec2SecurityGroupName=");
		stringBuilder.append(ec2SecurityGroupName);
		stringBuilder.append(", ec2SecurityGroupOwnerId=");
		stringBuilder.append(ec2SecurityGroupOwnerId);
		stringBuilder.append(", region=");
		stringBuilder.append(region);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
	
	
}
