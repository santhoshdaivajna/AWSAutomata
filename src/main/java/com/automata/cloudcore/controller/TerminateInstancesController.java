package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.ec2.model.InstanceStateChange;
import com.amazonaws.services.ec2.model.TerminateInstancesResult;
import com.automata.cloudcore.model.TerminateInstancesModel;
import com.automata.cloudcore.service.aws.ec2.IEC2;
import com.automata.cloudcore.util.TransformObject;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.InstanceStateChangeSetType;
import com.automata.cloudcore.xmlbindings.InstanceStateChangeType;
import com.automata.cloudcore.xmlbindings.TerminateInstancesResponseType;
import com.automata.cloudcore.xmlbindings.TerminateInstancesType;

public class TerminateInstancesController implements IController {

	/** The ec2. */
	@Autowired
	private IEC2 ec2;

	@Override
	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		TerminateInstancesResponseType terminateInstancesResponse = null;
		TerminateInstancesModel terminateInstanceModel = null;
		TerminateInstancesResult terminateInstancesResult = null;
		List<TerminateInstancesType> terminateInstances = null;
		List<TerminateInstancesResponseType> terminateInstancesResponses = null;
		List<InstanceStateChange> instanceStateChangeList = null;
		List<InstanceStateChangeType> instanceStateChangeTypeList = null;
		InstanceStateChangeSetType instanceStateChangeSetType = null;

		automata = (Automata) obj;
		terminateInstances = automata.getResources().getTerminateInstancesRequest();
		terminateInstancesResponses = new ArrayList<TerminateInstancesResponseType>();

		for (TerminateInstancesType terminateInstancesType : terminateInstances){

			try{
				terminateInstanceModel 		= new TerminateInstancesModel(terminateInstancesType);
				terminateInstancesResponse  = new TerminateInstancesResponseType();
				instanceStateChangeSetType  = new InstanceStateChangeSetType();

				ec2.setEndPoint(terminateInstanceModel.getRegion());
				terminateInstancesResult = ec2.terminateServer(terminateInstanceModel.getInstanceIds());
				//terminateInstancesResponse.setRequestId(terminateInstancesResult.);
				instanceStateChangeList = terminateInstancesResult.getTerminatingInstances();
				instanceStateChangeTypeList = TransformObject.transform(instanceStateChangeList);
				instanceStateChangeSetType.setItem(instanceStateChangeTypeList);
				terminateInstancesResponse.setInstancesSet(instanceStateChangeSetType);
				terminateInstancesResponse.setRegion(terminateInstancesType.getRegion());
				terminateInstancesResponse.setStatus("Instances successfully terminated in "+terminateInstancesType.getRegion());
			} catch (AmazonServiceException ase) {
				terminateInstancesResponse.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while terminating the servers :" 
						+ ase.getMessage(), ase);
			} catch (AmazonClientException ace) {
				terminateInstancesResponse.setStatus(ace.getMessage());
				logger.error("AmazonClientException while terminating the servers",	ace);
			}
			terminateInstancesResponses.add(terminateInstancesResponse);
		}
		automata.getOutputs().setTerminateInstancesResponse(terminateInstancesResponses);
		return automata;
	}


	private static final Logger logger = LoggerFactory.getLogger(TerminateInstancesController.class.getName());
}
