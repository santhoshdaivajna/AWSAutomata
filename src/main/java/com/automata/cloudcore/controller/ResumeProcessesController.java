package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.automata.cloudcore.model.ResumeProcessesModel;
import com.automata.cloudcore.service.aws.as.IAutoScale;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.ResumeProcessesResponseType;
import com.automata.cloudcore.xmlbindings.ResumeProcessesType;

public class ResumeProcessesController implements IController {

	@Autowired
	private IAutoScale as;
	
	@Override
	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		List<ResumeProcessesType> resumeProcessesList;
		ResumeProcessesResponseType resumeProcessResponse = null;
		List<ResumeProcessesResponseType> resumeProcessesResponseList;
		ResumeProcessesModel resumeProcessesModel = null;
		
		automata = (Automata) obj;
		resumeProcessesList = automata.getResources().getResumeProcesses();
		resumeProcessesResponseList = new ArrayList<ResumeProcessesResponseType>();
		
		for (ResumeProcessesType resumeProcess : resumeProcessesList){
			
			try{
				resumeProcessesModel  = new ResumeProcessesModel(resumeProcess);
				resumeProcessResponse = new ResumeProcessesResponseType();
				as.resumeProcesses(resumeProcessesModel);
				resumeProcessResponse.setRequest(resumeProcess);
				//resumeProcessResponse.setResponseMetadata(value);
				resumeProcessResponse.setStatus("Scaling processes have been resumed");
			} catch (AmazonServiceException ase) {
				resumeProcessResponse.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while resuming autoscale processes :"
								+ ase.getMessage(), ase);
			} catch (AmazonClientException ace) {
				resumeProcessResponse.setStatus(ace.getMessage());
				logger.error("AmazonClientException while resuming autoscale processes",ace);
			}
			resumeProcessesResponseList.add(resumeProcessResponse);
		}
		automata.getOutputs().setResumeProcessesResponse(resumeProcessesResponseList);
		return automata;
	}
	
	private static final Logger logger = LoggerFactory
	.getLogger(ResumeProcessesController.class.getName());

}
