package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.automata.cloudcore.service.aws.ec2.IEC2;
import com.automata.cloudcore.util.TransformObject;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.DescribeInstancesResponseType;
import com.automata.cloudcore.xmlbindings.DescribeInstancesType;
import com.automata.cloudcore.xmlbindings.ReservationSetType;

public class DescribeInstancesController implements IController {

	/** The ec2. */
	@Autowired
	private IEC2 ec2;

	
	@Override
	public Object execute(Object obj) throws Exception {
		
		Automata automata = null;
		List<DescribeInstancesType> describeInstancesTypeList = null;
		List<DescribeInstancesResponseType> responseList = null;
		DescribeInstancesResponseType response = null;
		DescribeInstancesResult describeInstancesResult = null;
		ReservationSetType reservationSetType = null;
		List<String> instanceIds = null;
		
		automata = (Automata) obj;
		describeInstancesTypeList = automata.getResources().getDescribeInstances();
		responseList = new ArrayList<DescribeInstancesResponseType>();
		
		for(DescribeInstancesType instance : describeInstancesTypeList ){
			
			try{
				response = new DescribeInstancesResponseType();
				response.setRegion(instance.getRegion());
				
				instanceIds = TransformObject.getInstanceIds(instance);
				describeInstancesResult = ec2.describeServer(instanceIds);
				reservationSetType = TransformObject.getReservationSet(describeInstancesResult);
				response.setReservationSet(reservationSetType);
				response.setStatus("Instance"+ instanceIds +" successfully described ");
			}catch (AmazonServiceException ase) {
				response.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while describing instances :"+instanceIds, ase);
			} catch (AmazonClientException ace) {
				response.setStatus(ace.getMessage());
				logger.error("AmazonClientException while describing instances :"+instanceIds,	ace);
			}
			responseList.add(response);
		}
		automata.getOutputs().setDescribeInstancesResponse(responseList);
		return automata;
	}

	private static Logger logger = LoggerFactory
		.getLogger(DescribeInstancesController.class.getName());
}
