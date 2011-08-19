package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.ec2.model.DescribeKeyPairsResult;
import com.automata.cloudcore.service.aws.ec2.IEC2;
import com.automata.cloudcore.util.TransformObject;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.DescribeKeyPairsResponseInfoType;
import com.automata.cloudcore.xmlbindings.DescribeKeyPairsResponseType;
import com.automata.cloudcore.xmlbindings.DescribeKeyPairsType;

public class DescribeKeyPairController implements IController {

	/** The ec2. */
	@Autowired
	private IEC2 ec2;

	
	@Override
	public Object execute(Object obj) throws Exception {
		
		Automata automata = null;
		List<DescribeKeyPairsType> describeKeyPairsTypeList = null;
		List<DescribeKeyPairsResponseType> describeKeyPairsResponseList = null;
		DescribeKeyPairsResponseType response = null;
		DescribeKeyPairsResult result = null;
		DescribeKeyPairsResponseInfoType keyPairsResponseInfo = null;
		
		automata = (Automata) obj;
		describeKeyPairsTypeList = automata.getResources().getDescribeKeyPairs();
		describeKeyPairsResponseList = new ArrayList<DescribeKeyPairsResponseType>();
		
		for(DescribeKeyPairsType keypair : describeKeyPairsTypeList ){
			
			try{
				response = new DescribeKeyPairsResponseType();
				response.setRegion(keypair.getRegion());
				ec2.setEndPoint(keypair.getRegion());
				result = ec2.describeKeyPairs(keypair);
				
				keyPairsResponseInfo = TransformObject.getKeySet(result);
				response.setKeySet(keyPairsResponseInfo);
				response.setStatus("keypairs have been successfully described ");
			}catch (AmazonServiceException ase) {
				response.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while describing keypair ", ase);
			} catch (AmazonClientException ace) {
				response.setStatus(ace.getMessage());
				logger.error("AmazonClientException while describing keypairs ",ace);
			}
			describeKeyPairsResponseList.add(response);
		}
		automata.getOutputs().setDescribeKeyPairsResponse(describeKeyPairsResponseList);
		return automata;
	}

	private static Logger logger = LoggerFactory
	.getLogger(DescribeKeyPairController.class.getName());
}
