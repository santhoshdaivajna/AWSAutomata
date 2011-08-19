package com.automata.cloudcore.service.aws.ec2;

import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.ec2.model.AllocateAddressResult;
import com.amazonaws.services.ec2.model.CreateKeyPairResult;
import com.amazonaws.services.ec2.model.DescribeAddressesResult;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.DescribeKeyPairsResult;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsResult;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.amazonaws.services.ec2.model.StartInstancesResult;
import com.amazonaws.services.ec2.model.StopInstancesResult;
import com.amazonaws.services.ec2.model.TerminateInstancesResult;
import com.automata.cloudcore.model.EC2Model;
import com.automata.cloudcore.xmlbindings.AddSecurityGroupRuleType;
import com.automata.cloudcore.xmlbindings.CreateSecurityGroupType;
import com.automata.cloudcore.xmlbindings.DeleteKeyPairType;
import com.automata.cloudcore.xmlbindings.DeleteSecurityGroupRuleType;
import com.automata.cloudcore.xmlbindings.DeleteSecurityGroupType;
import com.automata.cloudcore.xmlbindings.DescribeKeyPairsType;
import com.automata.cloudcore.xmlbindings.DescribeSecurityGroupsType;

public interface IEC2 {

	/**
	 * <p>
	 * The launchServer operation launches a specified number of instances.
	 * </p>
	 * <p>
	 * If Amazon EC2 cannot launch the minimum number AMIs you request, no
	 * instances launch. If there is insufficient capacity to launch the maximum
	 * number of AMIs you request, Amazon EC2 launches as many as possible to
	 * satisfy the requested maximum values.
	 * </p>
	 * <p>
	 * Every instance is launched in a security group. If you do not specify a
	 * security group at launch, the instances start in your default security
	 * group. For more information on creating security groups, see
	 * CreateSecurityGroup.
	 * </p>
	 * <p>
	 * An optional instance type can be specified. For information about
	 * instance types, see Instance Types.
	 * </p>
	 * <p>
	 * You can provide an optional key pair ID for each image in the launch
	 * request (for more information, see CreateKeyPair). All instances that are
	 * created from images that use this key pair will have access to the
	 * associated public key at boot. You can use this key to provide secure
	 * access to an instance of an image on a per-instance basis. Amazon EC2
	 * public images use this feature to provide secure access without
	 * passwords.
	 * </p>
	 * <p>
	 * <b>IMPORTANT:</b> Launching public images without a key pair ID will
	 * leave them inaccessible. The public key material is made available to the
	 * instance at boot time by placing it in the openssh_id.pub file on a
	 * logical device that is exposed to the instance as /dev/sda2 (the
	 * ephemeral store). The format of this file is suitable for use as an entry
	 * within ~/.ssh/authorized_keys (the OpenSSH format). This can be done at
	 * boot (e.g., as part of rc.local) allowing for secure access without
	 * passwords. Optional user data can be provided in the launch request. All
	 * instances that collectively comprise the launch request have access to
	 * this data For more information, see Instance Metadata.
	 * </p>
	 * <p>
	 * <b>NOTE:</b> If any of the AMIs have a product code attached for which
	 * the user has not subscribed, the RunInstances call will fail.
	 * </p>
	 * <p>
	 * <b>IMPORTANT:</b> We strongly recommend using the 2.6.18 Xen stock kernel
	 * with the c1.medium and c1.xlarge instances. Although the default Amazon
	 * EC2 kernels will work, the new kernels provide greater stability and
	 * performance for these instance types. For more information about kernels,
	 * see Kernels, RAM Disks, and Block Device Mappings.
	 * </p>
	 * 
	 * @param ec2model
	 *            Container for the necessary parameters to execute the
	 *            RunInstances service method on AmazonEC2.
	 * 
	 * @return The response from the RunInstances service method, as returned by
	 *         AmazonEC2.
	 * 
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client
	 *             while attempting to make the request or handle the response.
	 *             For example if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonEC2 indicating
	 *             either a problem with the data in the request, or a server
	 *             side issue.
	 */
	public RunInstancesResult launchServer(EC2Model ec2model)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * Starts an instance that uses an Amazon EBS volume as its root device.
	 * Instances that use Amazon EBS volumes as their root devices can be
	 * quickly stopped and started. When an instance is stopped, the compute
	 * resources are released and you are not billed for hourly instance usage.
	 * However, your root partition Amazon EBS volume remains, continues to
	 * persist your data, and you are charged for Amazon EBS volume usage. You
	 * can restart your instance at any time.
	 * </p>
	 * <p>
	 * <b>NOTE:</b> Performing this operation on an instance that uses an
	 * instance store as its root device returns an error.
	 * </p>
	 * 
	 * @param instanceIds
	 *            list of instances
	 * 
	 * @return The response from the StartInstances service method, as returned
	 *         by AmazonEC2.
	 * 
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client
	 *             while attempting to make the request or handle the response.
	 *             For example if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonEC2 indicating
	 *             either a problem with the data in the request, or a server
	 *             side issue.
	 */
	public StartInstancesResult startServer(List<String> instanceIds)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * Starts an instance that uses an Amazon EBS volume as its root device.
	 * Instances that use Amazon EBS volumes as their root devices can be
	 * quickly stopped and started. When an instance is stopped, the compute
	 * resources are released and you are not billed for hourly instance usage.
	 * However, your root partition Amazon EBS volume remains, continues to
	 * persist your data, and you are charged for Amazon EBS volume usage. You
	 * can restart your instance at any time.
	 * </p>
	 * <p>
	 * <b>NOTE:</b> Performing this operation on an instance that uses an
	 * instance store as its root device returns an error.
	 * </p>
	 * 
	 * @param instanceIds
	 *            list of instances
	 * 
	 * @return The response from the StartInstances service method, as returned
	 *         by AmazonEC2.
	 * 
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client
	 *             while attempting to make the request or handle the response.
	 *             For example if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonEC2 indicating
	 *             either a problem with the data in the request, or a server
	 *             side issue.
	 */
	public StopInstancesResult stopServer(List<String> instanceIds)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * The TerminateInstances operation shuts down one or more instances. This
	 * operation is idempotent; if you terminate an instance more than once,
	 * each call will succeed.
	 * </p>
	 * <p>
	 * Terminated instances will remain visible after termination (approximately
	 * one hour).
	 * </p>
	 * 
	 * @param instanceIds
	 *            list of instances
	 * 
	 * @return The response from the TerminateInstances service method, as
	 *         returned by AmazonEC2.
	 * 
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client
	 *             while attempting to make the request or handle the response.
	 *             For example if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonEC2 indicating
	 *             either a problem with the data in the request, or a server
	 *             side issue.
	 */
	public TerminateInstancesResult terminateServer(List<String> instanceIds)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * The DescribeInstances operation returns information about instances that
	 * you own.
	 * </p>
	 * <p>
	 * If you specify one or more instance IDs, Amazon EC2 returns information
	 * for those instances. If you do not specify instance IDs, Amazon EC2
	 * returns information for all relevant instances. If you specify an invalid
	 * instance ID, a fault is returned. If you specify an instance that you do
	 * not own, it will not be included in the returned results.
	 * </p>
	 * <p>
	 * Recently terminated instances might appear in the returned results. This
	 * interval is usually less than one hour.
	 * </p>
	 * 
	 * @param instanceIds
	 *            list of instances
	 * 
	 * @return The response from the DescribeInstances service method, as
	 *         returned by AmazonEC2.
	 * 
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client
	 *             while attempting to make the request or handle the response.
	 *             For example if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonEC2 indicating
	 *             either a problem with the data in the request, or a server
	 *             side issue.
	 */
	public DescribeInstancesResult describeServer(List<String> instanceIds)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * The CreateKeyPair operation creates a new 2048 bit RSA key pair and
	 * returns a unique ID that can be used to reference this key pair when
	 * launching new instances. For more information, see RunInstances.
	 * </p>
	 * 
	 * @param keyName
	 *            name of the key to be created
	 * 
	 * @return The response from the CreateKeyPair service method, as returned
	 *         by AmazonEC2.
	 * 
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client
	 *             while attempting to make the request or handle the response.
	 *             For example if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonEC2 indicating
	 *             either a problem with the data in the request, or a server
	 *             side issue.
	 */
	public CreateKeyPairResult createKeyPair(String keyName)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * The DeleteKeyPair operation deletes a key pair.
	 * </p>
	 * 
	 * @param keyPair
	 * 
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client
	 *             while attempting to make the request or handle the response.
	 *             For example if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonEC2 indicating
	 *             either a problem with the data in the request, or a server
	 *             side issue.
	 */
	public void deleteKeyPair(DeleteKeyPairType keyPair)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * The DescribeKeyPairs operation returns information about key pairs
	 * available to you. If you specify key pairs, information about those key
	 * pairs is returned. Otherwise, information for all registered key pairs is
	 * returned.
	 * </p>
	 * 
	 * @param describeKeyPair
	 *            Container for the necessary parameters to execute the
	 *            DescribeKeyPairs service method on AmazonEC2.
	 * 
	 * @return The response from the DescribeKeyPairs service method, as
	 *         returned by AmazonEC2.
	 * 
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client
	 *             while attempting to make the request or handle the response.
	 *             For example if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonEC2 indicating
	 *             either a problem with the data in the request, or a server
	 *             side issue.
	 */
	public DescribeKeyPairsResult describeKeyPairs(
			DescribeKeyPairsType describeKeyPair)
			throws AmazonServiceException, AmazonClientException;

	public DescribeSecurityGroupsResult describeSecurityGroups(
			DescribeSecurityGroupsType descDBSecGroup)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * The AllocateElasticIp operation acquires an elastic IP address for use
	 * with your account.
	 * </p>
	 * 
	 * @return The response from the AllocateElasticIp service method, as
	 *         returned by AmazonEC2.
	 * 
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client
	 *             while attempting to make the request or handle the response.
	 *             For example if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonEC2 indicating
	 *             either a problem with the data in the request, or a server
	 *             side issue.
	 */
	public AllocateAddressResult allocateElasticIp(String accessKey,
			String secretAccessKey) throws AmazonServiceException,
			AmazonClientException;

	/**
	 * <p>
	 * The AssociateAddress operation associates an elastic IP address with an
	 * instance.
	 * </p>
	 * <p>
	 * If the IP address is currently assigned to another instance, the IP
	 * address is assigned to the new instance. This is an idempotent operation.
	 * If you enter it more than once, Amazon EC2 does not return an error.
	 * </p>
	 * 
	 * @param elasticIp
	 * @param instanceId
	 * 
	 * @return The response from the AssociateAddress service method, as
	 *         returned by AmazonEC2.
	 * 
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client
	 *             while attempting to make the request or handle the response.
	 *             For example if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonEC2 indicating
	 *             either a problem with the data in the request, or a server
	 *             side issue.
	 */
	public void associateAddress(String elasticIp, String instanceId)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * The DisassociateAddress operation disassociates the specified elastic IP
	 * address from the instance to which it is assigned. This is an idempotent
	 * operation. If you enter it more than once, Amazon EC2 does not return an
	 * error.
	 * </p>
	 * 
	 * @param elasticIp
	 * @param instanceId
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client
	 *             while attempting to make the request or handle the response.
	 *             For example if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonEC2 indicating
	 *             either a problem with the data in the request, or a server
	 *             side issue.
	 */
	public void disAssociateAddress(String elasticIp, String instanceId)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * The DescribeAddresses operation lists elastic IP addresses assigned to
	 * your account.
	 * </p>
	 * 
	 * @param elasticIps
	 *            list of elastic ips
	 * 
	 * @return The response from the DescribeAddresses service method, as
	 *         returned by AmazonEC2.
	 * 
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client
	 *             while attempting to make the request or handle the response.
	 *             For example if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonEC2 indicating
	 *             either a problem with the data in the request, or a server
	 *             side issue.
	 */
	public DescribeAddressesResult describeAddresses(List<String> elasticIps)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * The ReleaseAddress operation releases an elastic IP address associated
	 * with your account.
	 * </p>
	 * <p>
	 * <b>NOTE:</b> Releasing an IP address automatically disassociates it from
	 * any instance with which it is associated. For more information, see
	 * DisassociateAddress.
	 * </p>
	 * <p>
	 * <b>IMPORTANT:</b> After releasing an elastic IP address, it is released
	 * to the IP address pool and might no longer be available to your account.
	 * Make sure to update your DNS records and any servers or devices that
	 * communicate with the address. If you run this operation on an elastic IP
	 * address that is already released, the address might be assigned to
	 * another account which will cause Amazon EC2 to return an error.
	 * </p>
	 * 
	 * @param elasticIp
	 *            - to be released.
	 * 
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client
	 *             while attempting to make the request or handle the response.
	 *             For example if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonEC2 indicating
	 *             either a problem with the data in the request, or a server
	 *             side issue.
	 */
	public void releaseAddress(String elasticIp) throws AmazonServiceException,
			AmazonClientException;

	/**
	 * <p>
	 * The AuthorizeSecurityGroupIngress operation adds permissions to a
	 * security group.
	 * </p>
	 * <p>
	 * Permissions are specified by the IP protocol (TCP, UDP or ICMP), the
	 * source of the request (by IP range or an Amazon EC2 user-group pair), the
	 * source and destination port ranges (for TCP and UDP), and the ICMP codes
	 * and types (for ICMP). When authorizing ICMP, <code>-1</code> can be used
	 * as a wildcard in the type and code fields.
	 * </p>
	 * <p>
	 * Permission changes are propagated to instances within the security group
	 * as quickly as possible. However, depending on the number of instances, a
	 * small delay might occur.
	 * </p>
	 * 
	 * @param addSecurityGroupRule
	 *            Container for the necessary parameters to execute the
	 *            AuthorizeSecurityGroupIngress service method on AmazonEC2.
	 * 
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client
	 *             while attempting to make the request or handle the response.
	 *             For example if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonEC2 indicating
	 *             either a problem with the data in the request, or a server
	 *             side issue.
	 */
	public void addSecurityGroupRule(
			AddSecurityGroupRuleType addSecurityGroupRule);

	/**
	 * <p>
	 * The CreateSecurityGroup operation creates a new security group.
	 * </p>
	 * <p>
	 * Every instance is launched in a security group. If no security group is
	 * specified during launch, the instances are launched in the default
	 * security group. Instances within the same security group have
	 * unrestricted network access to each other. Instances will reject network
	 * access attempts from other instances in a different security group. As
	 * the owner of instances you can grant or revoke specific permissions using
	 * the AuthorizeSecurityGroupIngress and RevokeSecurityGroupIngress
	 * operations.
	 * </p>
	 * 
	 * @param createSecGrp
	 *            Container for the necessary parameters to execute the
	 *            CreateSecurityGroup service method on AmazonEC2.
	 * 
	 * @return The boolean response from the CreateSecurityGroup service method.
	 *         true - security group already exists. false - security group was
	 *         created.
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client
	 *             while attempting to make the request or handle the response.
	 *             For example if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonEC2 indicating
	 *             either a problem with the data in the request, or a server
	 *             side issue.
	 */
	public boolean createSecurityGroup(CreateSecurityGroupType createSecGrp)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * The DeleteSecurityGroup operation deletes a security group.
	 * </p>
	 * <p>
	 * <b>NOTE:</b> If you attempt to delete a security group that contains
	 * instances, a fault is returned. If you attempt to delete a security group
	 * that is referenced by another security group, a fault is returned. For
	 * example, if security group B has a rule that allows access from security
	 * group A, security group A cannot be deleted until the allow rule is
	 * removed.
	 * </p>
	 * 
	 * @param deleteSecurityGroup
	 *            Container for the necessary parameters to execute the
	 *            DeleteSecurityGroup service method on AmazonEC2.
	 * 
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client
	 *             while attempting to make the request or handle the response.
	 *             For example if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonEC2 indicating
	 *             either a problem with the data in the request, or a server
	 *             side issue.
	 */
	public void deleteSecurityGroup(DeleteSecurityGroupType deleteSecurityGroup)
			throws AmazonServiceException, AmazonClientException;

	/**
	 * <p>
	 * The revokeSecurityGroupRule operation revokes permissions from a security
	 * group. The permissions used to revoke must be specified using the same
	 * values used to grant the permissions.
	 * </p>
	 * <p>
	 * Permissions are specified by IP protocol (TCP, UDP, or ICMP), the source
	 * of the request (by IP range or an Amazon EC2 user-group pair), the source
	 * and destination port ranges (for TCP and UDP), and the ICMP codes and
	 * types (for ICMP).
	 * </p>
	 * <p>
	 * Permission changes are quickly propagated to instances within the
	 * security group. However, depending on the number of instances in the
	 * group, a small delay might occur.
	 * </p>
	 * 
	 * @param deleteSecurityGroupRule
	 *            Container for the necessary parameters to execute the
	 *            RevokeSecurityGroupIngress service method on AmazonEC2.
	 * 
	 * 
	 * @throws AmazonClientException
	 *             If any internal errors are encountered inside the client
	 *             while attempting to make the request or handle the response.
	 *             For example if a network connection is not available.
	 * @throws AmazonServiceException
	 *             If an error response is returned by AmazonEC2 indicating
	 *             either a problem with the data in the request, or a server
	 *             side issue.
	 */
	public void revokeSecurityGroupRule(
			DeleteSecurityGroupRuleType deleteSecurityGroupRule);

	/**
	 * sets the ec2 endpoint.
	 * 
	 * @param region
	 * @return
	 */
	public void setEndPoint(String region) throws AmazonServiceException,
			AmazonClientException;

}