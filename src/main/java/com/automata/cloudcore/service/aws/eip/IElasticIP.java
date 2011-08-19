package com.automata.cloudcore.service.aws.eip;

import java.util.List;

import com.amazonaws.services.ec2.model.AllocateAddressResult;
import com.amazonaws.services.ec2.model.DescribeAddressesResult;

public interface IElasticIP {

	public abstract AllocateAddressResult allocateElasticIp(String endPoint);

	public abstract void associateAddress(String endPoint, String elasticIp,
			String instanceId) throws Exception;

	public abstract void disAssociateAddress(String endPoint, String elasticIp,
			String instanceId) throws Exception;

	public abstract DescribeAddressesResult describeAddresses(String endPoint,
			List<String> elasticIps) throws Exception;

	public abstract void releaseAddress(String endPoint, String elasticIp);

}