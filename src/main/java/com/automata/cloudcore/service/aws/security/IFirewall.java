package com.automata.cloudcore.service.aws.security;

public interface IFirewall {

	public abstract void createSecurityGroup(String groupName, String endPoint,
			String description);

	public abstract void addSecurityGroupRule(String endPoint,
			String securityGroupName, Integer fromPort, Integer toPort,
			String protocol, String cidrIp) throws Exception;

	public abstract void revokeSecurityGroupRule(String endPoint,
			String securityGroupName, Integer fromPort, Integer toPort,
			String protocol, String cidrIp);

}