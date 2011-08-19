package com.automata.cloudcore.service.aws.eip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.AllocateAddressRequest;
import com.amazonaws.services.ec2.model.AllocateAddressResult;
import com.amazonaws.services.ec2.model.AssociateAddressRequest;
import com.amazonaws.services.ec2.model.DescribeAddressesRequest;
import com.amazonaws.services.ec2.model.DescribeAddressesResult;
import com.amazonaws.services.ec2.model.DisassociateAddressRequest;
import com.amazonaws.services.ec2.model.ReleaseAddressRequest;
@Component
public class ElasticIPImpl implements IElasticIP {

	private static AmazonEC2Client ec2;

	public ElasticIPImpl() throws Exception {
		init();
	}

	public AllocateAddressResult allocateElasticIp(String endPoint) {

		AllocateAddressRequest allocateAddressRequest;
		AllocateAddressResult allocateAddressResult;
		ec2.setEndpoint(endPoint);
		allocateAddressRequest = new AllocateAddressRequest();
		// TODO :
		allocateAddressResult = ec2.allocateAddress();

		return allocateAddressResult;
	}

	public void associateAddress(String endPoint, String elasticIp,
			String instanceId) throws Exception {

		AssociateAddressRequest associateAddressRequest;
		ec2.setEndpoint(endPoint);
		associateAddressRequest = new AssociateAddressRequest();
		associateAddressRequest.setInstanceId(instanceId);
		associateAddressRequest.setPublicIp(elasticIp);
		ec2.associateAddress(associateAddressRequest);

	}

	public void disAssociateAddress(String endPoint, String elasticIp,
			String instanceId) throws Exception {

		DisassociateAddressRequest disAssociateAddressRequest;
		ec2.setEndpoint(endPoint);
		disAssociateAddressRequest = new DisassociateAddressRequest();
		disAssociateAddressRequest.setPublicIp(elasticIp);
		ec2.disassociateAddress(disAssociateAddressRequest);

	}

	public DescribeAddressesResult describeAddresses(String endPoint,
			List<String> elasticIps) throws Exception {

		DescribeAddressesRequest describeAddressesRequest;
		DescribeAddressesResult describeAddressesResult;
		ec2.setEndpoint(endPoint);
		describeAddressesRequest = new DescribeAddressesRequest();
		describeAddressesRequest.setPublicIps(elasticIps);
		describeAddressesResult = ec2
				.describeAddresses(describeAddressesRequest);

		return describeAddressesResult;

	}

	public void releaseAddress(String endPoint, String elasticIp) {

		ReleaseAddressRequest releaseAddressRequest;
		ec2.setEndpoint(endPoint);
		releaseAddressRequest = new ReleaseAddressRequest();
		releaseAddressRequest.setPublicIp(elasticIp);
		ec2.releaseAddress(releaseAddressRequest);

	}

	private void init() throws FileNotFoundException, IllegalArgumentException,
			IOException {
		AWSCredentials credentials;
		credentials = new PropertiesCredentials(new File(
				"AwsCredentials.properties"));
		ec2 = new AmazonEC2Client(credentials);
	}

	private static Logger logger = LoggerFactory.getLogger(ElasticIPImpl.class
			.getName());
}
