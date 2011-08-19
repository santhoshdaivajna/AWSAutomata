package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.automata.cloudcore.service.aws.as.IAutoScale;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.DeleteLaunchConfigurationResponseType;
import com.automata.cloudcore.xmlbindings.DeleteLaunchConfigurationType;

public class DeleteLaunchConfigurationController implements IController {


	/** The as. */
	@Autowired
	private IAutoScale as;
	
	@Override
	public Object execute(Object obj) throws Exception {
	
		Automata automata = null;
		List<DeleteLaunchConfigurationType> deleteLaunchConfigurationList = null;
		DeleteLaunchConfigurationResponseType deleteLaunchConfigurationResponse = null;
		List<DeleteLaunchConfigurationResponseType> deleteLaunchConfigurationResponseList = null;
		
		automata = (Automata) obj;
		deleteLaunchConfigurationList = automata.getResources().getDeleteLaunchConfigurationRequest();
		deleteLaunchConfigurationResponseList = new ArrayList<DeleteLaunchConfigurationResponseType>();
		
		for(DeleteLaunchConfigurationType launchConfiguration : deleteLaunchConfigurationList){
			try{
				deleteLaunchConfigurationResponse = new DeleteLaunchConfigurationResponseType();
				deleteLaunchConfigurationResponse.setRequest(launchConfiguration);
				as.deleteLaunchConfiguration(launchConfiguration);
				deleteLaunchConfigurationResponse.setStatus("Launch configuration successfully deleted");
			}catch (AmazonServiceException ase) {
				deleteLaunchConfigurationResponse.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while deleting launch configuration "
								+ ase.getMessage() , ase);
			} catch (AmazonClientException ace) {
				deleteLaunchConfigurationResponse.setStatus(ace.getMessage());
				logger.error("AmazonClientException while deleting launch configuration",	ace);
			}
			deleteLaunchConfigurationResponseList.add(deleteLaunchConfigurationResponse);
		}
		automata.getOutputs().setDeleteLaunchConfigurationResponse(deleteLaunchConfigurationResponseList);
		return automata;
	}
	
	private static Logger logger = LoggerFactory
	.getLogger(DeleteLaunchConfigurationController.class.getName());

}
