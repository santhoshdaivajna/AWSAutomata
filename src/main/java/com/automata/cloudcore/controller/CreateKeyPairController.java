package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.ec2.model.CreateKeyPairResult;
import com.amazonaws.services.ec2.model.KeyPair;
import com.automata.cloudcore.constants.ExceptionConstants;
import com.automata.cloudcore.service.aws.ec2.IEC2;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.CreateKeyPairResponse;
import com.automata.cloudcore.xmlbindings.CreateKeyPairType;

@Component
public class CreateKeyPairController implements IController {

	/** The ec2. */
	@Autowired
	private IEC2 ec2;

	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		List<CreateKeyPairType> createKeyPairList = null;
		List<CreateKeyPairResponse> responseList = null;

		automata = (Automata) obj;
		createKeyPairList = automata.getResources().getCreateKeyPair();
		responseList = processCreateKeyPairRequests(createKeyPairList);
		if (responseList.size() > 0)
			automata.getOutputs().setCreateKeyPairDetails(responseList);
		return automata;
	}

	/**
	 * @param keyName
	 * @param createKeyPairList
	 * @param response
	 * @return responseList
	 */
	private List<CreateKeyPairResponse> processCreateKeyPairRequests(
			List<CreateKeyPairType> createKeyPairList) {
		
		String region;
		String status;
		String keyName = "";
		KeyPair keyPair = null;
		CreateKeyPairResult createKeyPairResult;
		CreateKeyPairResponse response = null;
		List<CreateKeyPairResponse> responseList;
		responseList = new ArrayList<CreateKeyPairResponse>();

		for (CreateKeyPairType createKeyPair : createKeyPairList) {

			try {
				keyName = createKeyPair.getKeyPairName();
				region = createKeyPair.getRegion();
				response = new CreateKeyPairResponse();
				response.setRequest(createKeyPair);
				ec2.setEndPoint(region);
				createKeyPairResult = ec2.createKeyPair(keyName);

				keyPair = createKeyPairResult.getKeyPair();
				response.setKeyFingerprint(keyPair.getKeyFingerprint());
				response.setKeyMaterial(keyPair.getKeyMaterial());
				status = "Keypair " + keyName + " created";
				response.setStatus(status);
				logger.debug(status);
			} catch (AmazonServiceException ase) {
				response.setStatus(ase.getMessage());
				logger.error(ExceptionConstants.ASE_CREATE_KEYPAIR + keyName, ase);
			} catch (AmazonClientException ace) {
				response.setStatus(ace.getMessage());
				logger.error(ExceptionConstants.ACE_CREATE_KEYPAIR + keyName, ace);
			}
			responseList.add(response);
		}
		return responseList;
	}

	private static Logger logger = LoggerFactory
			.getLogger(CreateKeyPairController.class.getName());

}
