package com.automata.cloudcore.constants;

public interface Constants {

	public static final String EC2 = "ec2";
	public static final String ELB = "elasticloadbalancing";
	public static final String AS = "autoscaling";
	public static final String RDS = "rds";

	public static final String URL_EU_WEST = "eu-west-1.amazonaws.com";
	public static final String URL_US_EAST = "us-east-1.amazonaws.com";
	public static final String URL_US_WEST = "us-west-1.amazonaws.com";
	public static final String URL_AP_SOUTHEAST = "ap-southeast-1.amazonaws.com";
	public static final String URL_AP_NORTHEAST = "ap-northeast-1.amazonaws.com";
	public static final String US_EAST_1 = "US-EAST-1";
	public static final String US_WEST_1 = "us-west-1";
	public static final String EU_WEST_1 = "eu-west-1";
	public static final String AP_SOUTHEAST_1 = "ap-southeast-1";
	public static final String AP_NORTHEAST_1 = "ap-northeast-1";

	public static final String CREATE = "create";
	public static final String STOP = "stop";
	public static final String RESUME = "resume";
	public static final String TERMINATE = "terminate";
	public static final String DESCRIBE = "describe";

	public static final long EC2_DESCRIBE = 30;
	public static final long RDS_DESCRIBE = 30;
	public static final String XML_BINDINGS_PACKAGENAME = "com.automata.cloudcore.xmlbindings";
	public static final String MESSAGE_QUEUE = "";

	public static final String RDS_DESC_SUCCESS = "RDS Instance described successfully";

	public static final String RULE_ADDED = "Rule successfully added to security group";

	public static final String LB_SUCCESSFULLY_CREATED = "LoadBalancer successfully created ";

	public static final String SUCCESS_CREATED = "successfully created";

	public static final String RDS_SUCCESS = "RDS instance successfully launched";
	public static final String RDS_STATE_AVAILABLE = "available";
	public static final String AUTOMATA_SUCCESS = "input elements have been processed successfully";

}
