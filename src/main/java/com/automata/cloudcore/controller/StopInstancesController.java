package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.ec2.model.InstanceStateChange;
import com.amazonaws.services.ec2.model.StopInstancesResult;
import com.automata.cloudcore.model.StopInstancesModel;
import com.automata.cloudcore.service.aws.ec2.IEC2;
import com.automata.cloudcore.util.TransformObject;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.InstanceStateChangeSetType;
import com.automata.cloudcore.xmlbindings.InstanceStateChangeType;
import com.automata.cloudcore.xmlbindings.StopInstancesResponseType;
import com.automata.cloudcore.xmlbindings.StopInstancesType;

@Component
public class StopInstancesController implements IController {

	/** The ec2. */
	@Autowired
	private IEC2 ec2;

	@Override
	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		StopInstancesResponseType stopInstancesResponse = null;
		StopInstancesModel stopInstanceModel = null;
		StopInstancesResult stopInstancesResult = null;
		List<StopInstancesType> stopInstances = null; 
		List<StopInstancesResponseType> stopInstancesResponses = null;
		List<InstanceStateChange> instanceStateChangeList = null;
		List<InstanceStateChangeType> instanceStateChangeTypeList = null;
		InstanceStateChangeSetType instanceStateChangeSetType = null;

		automata = (Automata) obj;
		stopInstances = automata.getResources().getStopInstances();
		stopInstancesResponses = new ArrayList<StopInstancesResponseType>();

		for (StopInstancesType stopInstancesType : stopInstances) {

			try {
				stopInstanceModel 			= new StopInstancesModel(stopInstancesType);
				stopInstancesResponse 		= new StopInstancesResponseType();
				instanceStateChangeSetType 	= new InstanceStateChangeSetType();

				ec2.setEndPoint(stopInstanceModel.getRegion());
				stopInstancesResult = ec2.stopServer(stopInstanceModel.getInstanceIds());
				// stopInstancesResponse.setRequestId(StopInstancesResult.);
				instanceStateChangeList 	= stopInstancesResult.getStoppingInstances();
				instanceStateChangeTypeList = TransformObject.transform(instanceStateChangeList);
				instanceStateChangeSetType.setItem(instanceStateChangeTypeList);
				
				stopInstancesResponse.setInstancesSet(instanceStateChangeSetType);
				stopInstancesResponse.setRegion(stopInstancesType.getRegion());
				stopInstancesResponse.setStatus("Instances successfully Stopped in "+ stopInstancesType.getRegion());
			} catch (AmazonServiceException ase) {
				stopInstancesResponse.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while Stopping the servers :" 
						+ ase.getMessage(),ase);
			} catch (AmazonClientException ace) {
				stopInstancesResponse.setStatus(ace.getMessage());
				logger.error("AmazonClientException while Stopping the servers", ace);
			}
			stopInstancesResponses.add(stopInstancesResponse);
		}
		automata.getOutputs().setStopInstancesResponse(stopInstancesResponses);
		return automata;
	}

	private static final Logger logger = LoggerFactory
			.getLogger(StopInstancesController.class.getName());
}
