package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.ec2.model.InstanceStateChange;
import com.amazonaws.services.ec2.model.StartInstancesResult;
import com.automata.cloudcore.model.StartInstancesModel;
import com.automata.cloudcore.service.aws.ec2.IEC2;
import com.automata.cloudcore.util.TransformObject;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.InstanceStateChangeSetType;
import com.automata.cloudcore.xmlbindings.InstanceStateChangeType;
import com.automata.cloudcore.xmlbindings.StartInstancesResponseType;
import com.automata.cloudcore.xmlbindings.StartInstancesType;

public class StartInstancesController implements IController {

	/** The ec2. */
	@Autowired
	private IEC2 ec2;

	@Override
	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		StartInstancesResponseType startInstancesResponse = null;
		StartInstancesModel startInstanceModel = null;
		StartInstancesResult startInstancesResult = null;
		List<StartInstancesType> startInstances = null;
		List<StartInstancesResponseType> startInstancesResponses = null;
		List<InstanceStateChange> instanceStateChangeList = null;
		List<InstanceStateChangeType> instanceStateChangeTypeList = null;
		InstanceStateChangeSetType instanceStateChangeSetType = null;

		automata = (Automata) obj;
		startInstances = automata.getResources().getStartInstances();
		startInstancesResponses = new ArrayList<StartInstancesResponseType>();

		for (StartInstancesType instances : startInstances) {

			try {
				startInstanceModel 			= new StartInstancesModel(instances);
				startInstancesResponse 		= new StartInstancesResponseType();
				instanceStateChangeSetType = new InstanceStateChangeSetType();

				ec2.setEndPoint(startInstanceModel.getRegion());
				startInstancesResult = ec2.startServer(startInstanceModel.getInstanceIds());
				// startInstancesResponse.setRequestId(startInstancesResult.);
				instanceStateChangeList = startInstancesResult.getStartingInstances();
				instanceStateChangeTypeList = TransformObject.transform(instanceStateChangeList);
				instanceStateChangeSetType.setItem(instanceStateChangeTypeList);
				
				startInstancesResponse.setInstancesSet(instanceStateChangeSetType);
				startInstancesResponse.setRegion(instances.getRegion());
				startInstancesResponse.setStatus("Instances successfully started in "
								+ instances.getRegion());
			} catch (AmazonServiceException ase) {
				startInstancesResponse.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while starting the servers :"
								+ ase.getMessage(), ase);
			} catch (AmazonClientException ace) {
				startInstancesResponse.setStatus(ace.getMessage());
				logger.error("AmazonClientException while starting the servers",ace);
			}
			startInstancesResponses.add(startInstancesResponse);
		}
		automata.getOutputs().setStartInstancesResponse(startInstancesResponses);
		return automata;
	}

	private static final Logger logger = LoggerFactory
			.getLogger(EC2Controller.class.getName());
}
