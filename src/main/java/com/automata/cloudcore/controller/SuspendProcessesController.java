package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.automata.cloudcore.model.SuspendProcessesModel;
import com.automata.cloudcore.service.aws.as.IAutoScale;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.SuspendProcessesResponseType;
import com.automata.cloudcore.xmlbindings.SuspendProcessesType;

@Component
public class SuspendProcessesController implements IController {

	@Autowired
	private IAutoScale as;
	
	@Override
	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		List<SuspendProcessesType> suspendProcessesList;
		SuspendProcessesResponseType suspendProcessResponse = null;
		List<SuspendProcessesResponseType> suspendProcessesResponseList;
		SuspendProcessesModel suspendProcessesModel = null;
		
		automata = (Automata) obj;
		suspendProcessesList = automata.getResources().getSuspendProcesses();
		suspendProcessesResponseList = new ArrayList<SuspendProcessesResponseType>();
		
		for (SuspendProcessesType suspendProcess : suspendProcessesList){
			
			try{
				suspendProcessesModel  = new SuspendProcessesModel(suspendProcess);
				suspendProcessResponse = new SuspendProcessesResponseType();
				as.suspendProcesses(suspendProcessesModel);
				suspendProcessResponse.setRequest(suspendProcess);
				//suspendProcessResponse.setResponseMetadata(value);
				suspendProcessResponse.setStatus("Scaling processes have been suspended");
			} catch (AmazonServiceException ase) {
				suspendProcessResponse.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while suspending autoscale processes :"
								+ ase.getMessage() , ase);
			} catch (AmazonClientException ace) {
				suspendProcessResponse.setStatus(ace.getMessage());
				logger.error("AmazonClientException while suspending autoscale processes",ace);
			}
			suspendProcessesResponseList.add(suspendProcessResponse);
		}
		automata.getOutputs().setSuspendProcessesResponse(suspendProcessesResponseList);
		return automata;
	}
	
	private static final Logger logger = LoggerFactory
	.getLogger(SuspendProcessesController.class.getName());

}
