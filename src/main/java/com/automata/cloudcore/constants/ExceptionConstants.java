package com.automata.cloudcore.constants;

public interface ExceptionConstants {
	
	public final static String AUTH_DBSECGRP_ASE = "AmazonServiceException while authorizing db security group ingress: ";
	public final static String AUTH_DBSECGRP_ACE = "AmazonClientException while authorizing db security group ingress";
	public static final String ASE_CREATE_AS = "AmazonServiceException while creating the autoscale group ";
	public static final String ACE_CREATE_AS = "AmazonClientException while creating the autoscale group ";
	
	public static final String ASE_CREATE_ASPOLICY = "AmazonServiceException while creating scaling policy ";
	public static final String ACE_CREATE_ASPOLICY = "AmazonClientException while creating scaling policy";
	
	public static final String ASE_CREATE_DBGRP = "AmazonServiceException while creating db security group";
	public static final String ACE_CREATE_DBGRP = "AmazonClientException while creating db security group";
	public static final String ASE_RDS_LAUNCH = "AmazonServiceException while launching RDS instance ";
	public static final String ACE_RDS_LAUNCH = "AmazonClientException while launching RDS instance ";
	
	public static final String ASE_CREATE_READREPLICA = "AmazonServiceException while launching RDS instance ";
	public static final String ACE_CREATE_READREPLICA = "AmazonClientException while launching the RDS instance";
	
	public static final String ASE_DESC_EC2 = "AmazonServiceException while describing the EC2 instance " ;
	public static final String ACE_DESC_EC2 = "AmazonClientException while describing the EC2 instance " ;
	public static final String ASE_DESC_RDS = "AmazonServiceException while describing the rds instance ";
	public static final String ACE_DESC_RDS = "AmazonClientException while describing the rds instance ";
	
	public static final String ASE_DESC_AS = "AmazonServiceException while describing auto scaling group ";
	public static final String ACE_DESC_AS = "AmazonClientException while describing auto scaling group ";
	
	public static final String ACE_DESCRIBING_RDS_INSTANCE = "AmazonClientException while describing rds instance";
	public static final String ASE_DESCRIBING_RDS_INSTANCE = "AmazonServiceException while describing rds instance ";
	
	public static final String ACE_CREATE_SECURITY_GROUP_API = "AmazonClientException thrown while calling CreateSecurityGroup API";
	public static final String ASE_CREATE_SECURITY_GROUP_API = "AmazonServiceException thrown while calling CreateSecurityGroup API";
	
	public static final String ACE_ADD_SECURITY_GROUP_RULE = "AmazonClientException thrown while calling addSecurityGroupRule";
	public static final String ASE_ADD_SECURITY_GROUP_RULE = "AmazonServiceException thrown while calling addSecurityGroupRule";
	
	public static final String ASE_CREATE_KEYPAIR = "AmazonServiceException while creating key pair ";
	public static final String ACE_CREATE_KEYPAIR = "AmazonClientException while creating key pair ";
	
	public static final String ASE_CREATE_LB = "AmazonServiceException while creating load balancer";
	public static final String ACE_CREATE_LB = "AmazonClientException while creating load balancer";
	
	public static final String ASE_REG_INSTANCES_LB = "AmazonServiceException while registering instances with loadbalancer";
	public static final String ACE_REG_INSTANCES_LB = "AmazonClientException while registering instances with loadbalancer";
	
	public static final String ACE_CREATING_APP_COOKIE = "";
	public static final String ASE_CREATING_APP_COOKIE = "";
	public static final String ASE_CREATE_LB_COOKIE = "AmazonServiceException while creating the loadbalancer cookie stickiness policy ";
	public static final String ACE_CREATE_LB_COOKIE = "AmazonClientException while creating the loadbalancer cookie stickiness policy ";
	
	public static final String ASE_CREATE_LC = "AmazonServiceException while creating launch configuration: ";
	public static final String ACE_CREATE_LC = "AmazonClientException while creating launch configuration: ";
	
}
