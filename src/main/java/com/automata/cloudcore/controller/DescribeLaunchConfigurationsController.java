package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.autoscaling.model.DescribeLaunchConfigurationsResult;
import com.automata.cloudcore.service.aws.as.IAutoScale;
import com.automata.cloudcore.util.TransformObject;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.DescribeLaunchConfigurationsResponseType;
import com.automata.cloudcore.xmlbindings.DescribeLaunchConfigurationsResultType;
import com.automata.cloudcore.xmlbindings.DescribeLaunchConfigurationsType;

public class DescribeLaunchConfigurationsController implements IController {

	/** The as. */
	@Autowired
	private IAutoScale as;

	
	@Override
	public Object execute(Object obj) throws Exception {
		
		Automata automata = null;
		List<DescribeLaunchConfigurationsType> describeLaunchConfigurationsTypeList = null;
		List<DescribeLaunchConfigurationsResponseType> responseTypeList = null;
		DescribeLaunchConfigurationsResponseType response = null;
		DescribeLaunchConfigurationsResult result = null;
		DescribeLaunchConfigurationsResultType resultType = null;
		
		automata = (Automata) obj;
		describeLaunchConfigurationsTypeList = automata.getResources().getDescribeLaunchConfigurations();
		responseTypeList = new ArrayList<DescribeLaunchConfigurationsResponseType>();
		
		for(DescribeLaunchConfigurationsType descLaunchConfigurationsType : describeLaunchConfigurationsTypeList ){
			
			try{
				response = new DescribeLaunchConfigurationsResponseType();
				response.setRegion(descLaunchConfigurationsType.getRegion());
				
				result = as.describeLaunchConfiguration(descLaunchConfigurationsType);
				resultType = TransformObject.getDescribeLaunchConfigurationsResultType(result);
				response.setDescribeLaunchConfigurationsResult(resultType);
				response.setRegion(descLaunchConfigurationsType.getRegion());
				response.setStatus("LaunchConfiguration has been successfully described");
			}catch (AmazonServiceException ase) {
				response.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while describing launch configuration", ase);
			} catch (AmazonClientException ace) {
				response.setStatus(ace.getMessage());
				logger.error("AmazonClientException while while describing launch configuration",	ace);
			}
			responseTypeList.add(response);
		}
		automata.getOutputs().setDescribeLaunchConfigurationsResponse(responseTypeList);
		
		return automata;
	}

	private static Logger logger = LoggerFactory
	.getLogger(DescribeLaunchConfigurationsController.class.getName());
}
