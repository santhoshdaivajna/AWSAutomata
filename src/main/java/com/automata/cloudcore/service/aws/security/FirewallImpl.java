package com.automata.cloudcore.service.aws.security;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.AuthorizeSecurityGroupIngressRequest;
import com.amazonaws.services.ec2.model.CreateSecurityGroupRequest;
import com.amazonaws.services.ec2.model.RevokeSecurityGroupIngressRequest;
@Component
public class FirewallImpl implements IFirewall {
	
	private static AmazonEC2Client ec2;
	
	public  FirewallImpl() throws Exception {
		init();
	}
	
	public void createSecurityGroup(  String groupName, String endPoint, String description) {
		
		CreateSecurityGroupRequest createSecurityGroupRequest;
			ec2.setEndpoint(endPoint);
			createSecurityGroupRequest = new CreateSecurityGroupRequest();
			createSecurityGroupRequest.setGroupName(groupName);
			createSecurityGroupRequest.setDescription(description);
			ec2.createSecurityGroup(createSecurityGroupRequest);
	}
	
	public void addSecurityGroupRule( String endPoint, String securityGroupName,  Integer fromPort, Integer toPort,
			String protocol, String cidrIp) throws Exception {
		
			ec2.setEndpoint(endPoint);
			AuthorizeSecurityGroupIngressRequest rule = new AuthorizeSecurityGroupIngressRequest();
			rule.setGroupName(securityGroupName);
			rule.setFromPort(fromPort);
			rule.setToPort(toPort);
			rule.setIpProtocol(protocol);
			rule.setCidrIp(cidrIp);
			ec2.authorizeSecurityGroupIngress(rule);
	}
	
	public void revokeSecurityGroupRule( String endPoint, String securityGroupName, Integer fromPort, Integer toPort,
			String protocol, String cidrIp) {
		
			ec2.setEndpoint(endPoint);
			RevokeSecurityGroupIngressRequest rule = new RevokeSecurityGroupIngressRequest();
			rule.setGroupName(securityGroupName);
			rule.setFromPort(fromPort);
			rule.setToPort(toPort);
			rule.setIpProtocol(protocol);
			rule.setCidrIp(cidrIp);
			ec2.revokeSecurityGroupIngress(rule);
	}
	
	private void init() throws FileNotFoundException, IllegalArgumentException, IOException  {
		AWSCredentials credentials;
		credentials = new PropertiesCredentials(new File("AwsCredentials.properties"));
		ec2 = new AmazonEC2Client(credentials);
	}
	
	private static Logger logger = LoggerFactory.getLogger(FirewallImpl.class.getName());

}
