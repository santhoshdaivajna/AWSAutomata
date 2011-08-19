package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.rds.model.DBSecurityGroup;
import com.automata.cloudcore.constants.ExceptionConstants;
import com.automata.cloudcore.service.aws.rds.IRDS;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.CreateDBSecurityGroupResponse;
import com.automata.cloudcore.xmlbindings.CreateDBSecurityGroupType;

/**
 * The Class CreateDBSecurityGroupController creates DB Security Groups 
 * defined in the automata instance and returns a updated automata 
 * object with created security groups status.
 * 
 * @author Santhosh Daivajna
 */
@Component
public class CreateDBSecurityGroupController implements IController {

	@Autowired
	private IRDS rds;
	
	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		List<CreateDBSecurityGroupResponse> responseList;
		List<CreateDBSecurityGroupType> createDBSecurityGroupList;

		automata = (Automata) obj;
		createDBSecurityGroupList = automata.getResources().getCreateDBSecurityGroup();
		responseList = processCreateDBSecGroup(createDBSecurityGroupList);
		automata.getOutputs().setCreateDBSecurityGroupDetails(responseList);

		return automata;
	}

	/**
	 * @param createDBSecurityGroupList
	 * @param response
	 * @return
	 */
	private List<CreateDBSecurityGroupResponse> processCreateDBSecGroup(
			List<CreateDBSecurityGroupType> createDBSecurityGroupList) {
		
		CreateDBSecurityGroupResponse  response = null;
		List<CreateDBSecurityGroupResponse> responseList;
		DBSecurityGroup dBSecurityGroup;
		responseList = new ArrayList<CreateDBSecurityGroupResponse>();
		
		for (CreateDBSecurityGroupType createDBSecGroup : createDBSecurityGroupList ) {
			
			try{
				response = new CreateDBSecurityGroupResponse();
				response.setRequest(createDBSecGroup);
				dBSecurityGroup = rds.createDBSecurityGroup(createDBSecGroup);
				response.setStatus("DB Security Group "+createDBSecGroup.getDBSecurityGroupName()+" successfully created");
			} catch (AmazonServiceException ase) {
				logger.error(ExceptionConstants.ASE_CREATE_DBGRP, ase);
				response.setStatus(ase.getMessage());
			} catch (AmazonClientException ace) {
				logger.error(ExceptionConstants.ASE_CREATE_DBGRP, ace);
				response.setStatus(ace.getMessage());
			}
			responseList.add(response);
		}
		return responseList;
	}
	
	private static Logger logger = LoggerFactory.getLogger(CreateDBSecurityGroupController.class.getName());

}
