package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.automata.cloudcore.constants.ExceptionConstants;
import com.automata.cloudcore.model.CreateLaunchConfigurationModel;
import com.automata.cloudcore.service.aws.as.IAutoScale;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.CreateLaunchConfigurationResponse;
import com.automata.cloudcore.xmlbindings.CreateLaunchConfigurationType;

/**
  The Class LaunchConfigurationController creates launch configurations 
  defined in the automata. Returns a updated automata object with 
  created launch configuration status.
 *
 * @author Santhosh Daivajna
 */
@Component
public class LaunchConfigurationController implements IController {

	/** The as. */
	@Autowired
	private IAutoScale as;

	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		List<CreateLaunchConfigurationType> launchConfigurationList = null;
		List<CreateLaunchConfigurationResponse> responseList = null;

		automata = (Automata) obj;
		launchConfigurationList = automata.getResources().getCreateLaunchConfiguration();
		responseList = processCreateLaunchConfigurationRequests( launchConfigurationList );

		automata.getOutputs().setCreateLaunchConfigurationDetails(responseList);
		return automata;
	}

	
	/**
	 * Processes create launch configuration requests.
	 *
	 * @param launchConfigurationList the launch configuration list
	 * @return the list
	 */
	private List<CreateLaunchConfigurationResponse> processCreateLaunchConfigurationRequests(
			List<CreateLaunchConfigurationType> launchConfigurationList ) {
		
		CreateLaunchConfigurationResponse response = null;
		List<CreateLaunchConfigurationResponse> responseList = null;
		CreateLaunchConfigurationModel launchConfigurationModel = null;
		
		responseList = new ArrayList<CreateLaunchConfigurationResponse>();
		for (CreateLaunchConfigurationType launchConfiguration : launchConfigurationList) {

			try {
				launchConfigurationModel = new CreateLaunchConfigurationModel(launchConfiguration);
				response = new CreateLaunchConfigurationResponse();
				response.setRequest(launchConfiguration);
				as.createLaunchConfiguration(launchConfigurationModel);
				response.setStatus("Launch Configuration "+launchConfiguration.getLaunchConfigurationName()+" successfully created");
			} catch (AmazonServiceException ase) {
				logger.error(ExceptionConstants.ASE_CREATE_LC,ase);
				response.setStatus(ase.getMessage());
			} catch (AmazonClientException ace) {
				logger.error(ExceptionConstants.ACE_CREATE_LC, ace);
				response.setStatus(ace.getMessage());
			}
			responseList.add(response);
		}
		return responseList;
	}

	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(LaunchConfigurationController.class.getName());

}
