package com.automata.cloudcore.service.aws.security;

import com.amazonaws.services.ec2.model.CreateKeyPairResult;

public interface IKeyPair {

	public abstract CreateKeyPairResult createKeyPair(String endPoint,
			String keyName);

	public abstract void deleteKeyPair(String endPoint, String keyName);

}