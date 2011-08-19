package com.automata.cloudcore.service.aws.rds;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.rds.model.DBInstance;
import com.amazonaws.services.rds.model.DBSecurityGroup;
import com.amazonaws.services.rds.model.DBSnapshot;
import com.amazonaws.services.rds.model.DescribeDBInstancesResult;
import com.amazonaws.services.rds.model.DescribeDBSecurityGroupsResult;
import com.automata.cloudcore.model.CreateDBInstanceModel;
import com.automata.cloudcore.model.DeleteDBSecurityGroupModel;
import com.automata.cloudcore.xmlbindings.AuthorizeDBSecurityGroupIngressType;
import com.automata.cloudcore.xmlbindings.CreateDBInstanceReadReplicaType;
import com.automata.cloudcore.xmlbindings.CreateDBSecurityGroupType;
import com.automata.cloudcore.xmlbindings.CreateDBSnapshotType;
import com.automata.cloudcore.xmlbindings.DeleteDBInstanceType;
import com.automata.cloudcore.xmlbindings.DeleteDBSecurityGroupType;
import com.automata.cloudcore.xmlbindings.DescribeDBInstancesType;
import com.automata.cloudcore.xmlbindings.DescribeDBSecurityGroupsType;
import com.automata.cloudcore.xmlbindings.RestoreDBInstanceFromDBSnapshotType;

public interface IRDS {

	/**
	 * <p>
	 * Creates a new DB instance.
	 * </p>
	 *
	 * @param createDBInstance Container for the necessary parameters
	 *           to execute the CreateDBInstance service method on AmazonRDS.
	 * 
	 * @return The response from the CreateDBInstance service method, as
	 *         returned by AmazonRDS.
	 *
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client while
	 *             attempting to make the request or handle the response.  For example
	 *             if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonRDS indicating
	 *             either a problem with the data in the request, or a server side issue.
	 */
	public DBInstance createDBInstance(CreateDBInstanceModel createDBInstance)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * Creates a new database security group. Database Security groups
	 * control access to a database instance.
	 * </p>
	 *
	 * @param createDBSecGroup Container for the necessary
	 *           parameters to execute the CreateDBSecurityGroup service method on
	 *           AmazonRDS.
	 * 
	 * @return The response from the CreateDBSecurityGroup service method, as
	 *         returned by AmazonRDS.
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client while
	 *             attempting to make the request or handle the response.  For example
	 *             if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonRDS indicating
	 *             either a problem with the data in the request, or a server side issue.
	 */

	public DBSecurityGroup createDBSecurityGroup(
			CreateDBSecurityGroupType createDBSecGroup)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * Deletes a database security group.
	 * </p>
	 * <p>
	 * <b>NOTE:</b>The specified database security group must not be
	 * associated with any DB instances.
	 * </p>
	 *
	 * @param DeleteDBSecurityGroupModel Container for the necessary
	 *           parameters to execute the DeleteDBSecurityGroup service method on
	 *           AmazonRDS.
	 *
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client while
	 *             attempting to make the request or handle the response.  For example
	 *             if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonRDS indicating
	 *             either a problem with the data in the request, or a server side issue.
	 */

	public void deleteDBSecurityGroup(
			DeleteDBSecurityGroupModel deleteDBSecGroup)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * Enables ingress to a DBSecurityGroup using one of two forms of
	 * authorization. First, EC2 Security Groups can be added to the
	 * DBSecurityGroup if the application using the database is running on
	 * EC2 instances. Second, IP ranges are available if the application
	 * accessing your database is running on the Internet. Required
	 * parameters for this API are one of CIDR range or (EC2SecurityGroupName
	 * AND EC2SecurityGroupOwnerId).
	 * </p>
	 * <p>
	 * <b>NOTE:</b> You cannot authorize ingress from an EC2 security group
	 * in one Region to an Amazon RDS DB Instance in another.
	 * </p>
	 * <p>
	 * For an overview of CIDR ranges, go to the <a
	 * href="http://en.wikipedia.org/wiki/Classless_Inter-Domain_Routing">
	 * Wikipedia Tutorial </a> .
	 * </p>
	 *
	 * @param authorizeDBSecurityGroupIngressRequest Container for the
	 *           necessary parameters to execute the AuthorizeDBSecurityGroupIngress
	 *           service method on AmazonRDS.
	 * 
	 * @return The response from the AuthorizeDBSecurityGroupIngress service
	 *         method, as returned by AmazonRDS.
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client while
	 *             attempting to make the request or handle the response.  For example
	 *             if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonRDS indicating
	 *             either a problem with the data in the request, or a server side issue.
	 */
	public DBSecurityGroup authorizeDBSecurityGroupIngress(
			AuthorizeDBSecurityGroupIngressType authorizedBSecGrp)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * Creates a DBSnapshot. The source DBInstance must be in "available"
	 * state.
	 * </p>
	 *
	 * @param CreateDBSnapshotType Container for the necessary parameters
	 *           to execute the CreateDBSnapshot service method on AmazonRDS.
	 * 
	 * @return The response from the CreateDBSnapshot service method, as
	 *         returned by AmazonRDS.
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client while
	 *             attempting to make the request or handle the response.  For example
	 *             if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonRDS indicating
	 *             either a problem with the data in the request, or a server side issue.
	 */
	public DBSnapshot createDBSnapshot(CreateDBSnapshotType dbSnapshot)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * Creates a DB Instance that acts as a Read Replica of a source DB
	 * Instance.
	 * </p>
	 * <p>
	 * All Read Replica DB Instances are created as Single-AZ deployments
	 * with backups disabled. All other DB Instance attributes (including DB
	 * Security Groups and DB Parameter Groups) are inherited from the source
	 * DB Instance, except as specified below.
	 * </p>
	 * <p>
	 * <b>IMPORTANT:</b> The source DB Instance must have backup retention
	 * enabled.
	 * </p>
	 *
	 * @param CreateDBInstanceReadReplicaType Container for the necessary
	 *           parameters to execute the CreateDBInstanceReadReplica service method
	 *           on AmazonRDS.
	 * 
	 * @return The response from the CreateDBInstanceReadReplica service
	 *         method, as returned by AmazonRDS.
	 *
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client while
	 *             attempting to make the request or handle the response.  For example
	 *             if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonRDS indicating
	 *             either a problem with the data in the request, or a server side issue.
	 */
	public DBInstance createReadReplica(
			CreateDBInstanceReadReplicaType readReplica)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * Restores a DB Instance to an arbitrary point-in-time. Users can
	 * restore to any point in time before the latestRestorableTime for up to
	 * backupRetentionPeriod days. The target database is created from the
	 * source database with the same configuration as the original database
	 * except that the DB instance is created with the default DB security
	 * group.
	 * </p>
	 *
	 * @param RestoreDBInstanceFromDBSnapshotType Container for the
	 *           necessary parameters to execute the RestoreDBInstanceFromDBSnapshot
	 *           service method on AmazonRDS.
	 * 
	 * @return The response from the RestoreDBInstanceFromDBSnapshot service
	 *         method, as returned by AmazonRDS.
	 *
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client while
	 *             attempting to make the request or handle the response.  For example
	 *             if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonRDS indicating
	 *             either a problem with the data in the request, or a server side issue.
	 */

	public DBInstance restoreDBInstanceFromDBSnapshot(
			RestoreDBInstanceFromDBSnapshotType restoreDBInstanceFromDBSnapshot)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * The DeleteDBInstance API deletes a previously provisioned RDS
	 * instance. A successful response from the web service indicates the
	 * request was received correctly. If a final DBSnapshot is requested the
	 * status of the RDS instance will be "deleting" until the DBSnapshot is
	 * created. DescribeDBInstance is used to monitor the status of this
	 * operation. This cannot be canceled or reverted once submitted.
	 * </p>
	 *
	 * @param deleteDBInstanceRequest Container for the necessary parameters
	 *           to execute the DeleteDBInstance service method on AmazonRDS.
	 * 
	 * @return The response from the DeleteDBInstance service method, as
	 *         returned by AmazonRDS.
	 * 
	 *
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client while
	 *             attempting to make the request or handle the response.  For example
	 *             if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonRDS indicating
	 *             either a problem with the data in the request, or a server side issue.
	 */
	public DBInstance deleteDBInstance(DeleteDBInstanceType deleteDBInstance)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * Returns information about provisioned RDS instances. This API
	 * supports pagination.
	 * </p>
	 *
	 * @param dBInstanceIdentifier 
	 * @param region
	 * 
	 * @return The response from the DescribeDBInstances service method, as
	 *         returned by AmazonRDS.
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client while
	 *             attempting to make the request or handle the response.  For example
	 *             if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonRDS indicating
	 *             either a problem with the data in the request, or a server side issue.
	 */
	public DescribeDBInstancesResult describeRDSInstance(
			String dBInstanceIdentifier, String region)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * Deletes a database security group.
	 * </p>
	 * <p>
	 * <b>NOTE:</b>The specified database security group must not be
	 * associated with any DB instances.
	 * </p>
	 *
	 * @param deleteDBSecurityGroup Container for the necessary
	 *           parameters to execute the DeleteDBSecurityGroup service method on
	 *           AmazonRDS.
	 * 
	 *
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client while
	 *             attempting to make the request or handle the response.  For example
	 *             if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonRDS indicating
	 *             either a problem with the data in the request, or a server side issue.
	 */
	public void deleteDBSecurityGroup(
			DeleteDBSecurityGroupType deleteDBSecurityGroup)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * Returns a list of DBSecurityGroup descriptions. If a
	 * DBSecurityGroupName is specified, the list will contain only the
	 * descriptions of the specified DBSecurityGroup.
	 * </p>
	 * <p>
	 * For an overview of CIDR ranges, go to the <a
	 * href="http://en.wikipedia.org/wiki/Classless_Inter-Domain_Routing">
	 * Wikipedia Tutorial </a> .
	 * </p>
	 *
	 * @param describeDBSecurityGroups Container for the necessary
	 *           parameters to execute the DescribeDBSecurityGroups service method on
	 *           AmazonRDS.
	 * 
	 * @return The response from the DescribeDBSecurityGroups service method,
	 *         as returned by AmazonRDS.
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client while
	 *             attempting to make the request or handle the response.  For example
	 *             if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonRDS indicating
	 *             either a problem with the data in the request, or a server side issue.
	 */
	public DescribeDBSecurityGroupsResult describeDBSecurityGroup(
			DescribeDBSecurityGroupsType describeDBSecurityGroups)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * Returns a list of DBSecurityGroup descriptions. If a
	 * DBSecurityGroupName is specified, the list will contain only the
	 * descriptions of the specified DBSecurityGroup.
	 * </p>
	 * <p>
	 * For an overview of CIDR ranges, go to the <a
	 * href="http://en.wikipedia.org/wiki/Classless_Inter-Domain_Routing">
	 * Wikipedia Tutorial </a> .
	 * </p>
	 *
	 * @param describeDBInstances Container for the necessary
	 *           parameters to execute the DescribeDBSecurityGroups service method on
	 *           AmazonRDS.
	 * 
	 * @return The response from the DescribeDBSecurityGroups service method,
	 *         as returned by AmazonRDS.
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client while
	 *             attempting to make the request or handle the response.  For example
	 *             if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonRDS indicating
	 *             either a problem with the data in the request, or a server side issue.
	 */
	public DescribeDBInstancesResult describeDBInstance(
			DescribeDBInstancesType describeDBInstances)
			throws AmazonServiceException, AmazonClientException;

	public String getEndPoint(String region);

}