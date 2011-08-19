package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.automata.cloudcore.service.aws.ec2.IEC2;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.DeleteKeyPairResponseType;
import com.automata.cloudcore.xmlbindings.DeleteKeyPairType;

public class DeleteKeyPairController implements IController {

	/** The as. */
	@Autowired
	private IEC2 ec2;
	
	@Override
	public Object execute(Object obj) throws Exception {
		
		Automata automata = null;
		List<DeleteKeyPairType> deleteKeyPairTypeList = null;
		List<DeleteKeyPairResponseType> deleteKeyPairResponseList = null;
		DeleteKeyPairResponseType deleteKeyPairResponse = null;
		
		automata = (Automata) obj;
		deleteKeyPairTypeList = automata.getResources().getDeleteKeyPairRequest();
		deleteKeyPairResponseList = new ArrayList<DeleteKeyPairResponseType>();
		
		for(DeleteKeyPairType deleteKeyPairType : deleteKeyPairTypeList ){
			
			try{
				deleteKeyPairResponse = new DeleteKeyPairResponseType();
				deleteKeyPairResponse.setRequest(deleteKeyPairType);
				ec2.deleteKeyPair(deleteKeyPairType);
				deleteKeyPairResponse.setStatus("Keypair has been deleted");
			}catch (AmazonServiceException ase) {
				deleteKeyPairResponse.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while deleting the keypair ", ase);
			} catch (AmazonClientException ace) {
				deleteKeyPairResponse.setStatus(ace.getMessage());
				logger.error("AmazonClientException while deleting the keypair",ace);
			}
			deleteKeyPairResponseList.add(deleteKeyPairResponse);
		}
		automata.getOutputs().setDeleteKeyPairResponse(deleteKeyPairResponseList);
		return automata;
	}

	private static Logger logger = LoggerFactory
	.getLogger(DeleteKeyPairController.class.getName());
}
