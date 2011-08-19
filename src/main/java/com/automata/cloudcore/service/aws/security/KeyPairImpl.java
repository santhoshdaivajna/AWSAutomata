package com.automata.cloudcore.service.aws.security;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.CreateKeyPairRequest;
import com.amazonaws.services.ec2.model.CreateKeyPairResult;
import com.amazonaws.services.ec2.model.DeleteKeyPairRequest;

public class KeyPairImpl implements IKeyPair {

	private static AmazonEC2Client ec2;

	public KeyPairImpl() throws Exception {
		init();
	}

	public CreateKeyPairResult createKeyPair(String endPoint, String keyName) {

		CreateKeyPairRequest createKeyPairRequest;
		CreateKeyPairResult createKeyPairResult;
		ec2.setEndpoint(endPoint);
		createKeyPairRequest = new CreateKeyPairRequest();
		createKeyPairRequest.setKeyName(keyName);
		createKeyPairResult = ec2.createKeyPair(createKeyPairRequest);

		return createKeyPairResult;
	}

	public void deleteKeyPair(String endPoint, String keyName) {

		DeleteKeyPairRequest deleteKeyPairRequest;
		ec2.setEndpoint(endPoint);
		deleteKeyPairRequest = new DeleteKeyPairRequest();
		deleteKeyPairRequest.setKeyName(keyName);
		ec2.deleteKeyPair(deleteKeyPairRequest);

	}

	private void init() throws FileNotFoundException, IllegalArgumentException,
			IOException {
		AWSCredentials credentials;
		credentials = new PropertiesCredentials(new File(
				"AwsCredentials.properties"));
		ec2 = new AmazonEC2Client(credentials);
	}

	private static Logger logger = LoggerFactory.getLogger(KeyPairImpl.class
			.getName());
}
