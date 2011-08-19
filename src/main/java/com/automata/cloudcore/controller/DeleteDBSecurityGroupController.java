package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.automata.cloudcore.service.aws.rds.IRDS;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.DeleteDBSecurityGroupResponseType;
import com.automata.cloudcore.xmlbindings.DeleteDBSecurityGroupType;

public class DeleteDBSecurityGroupController implements IController {

	/** The as. */
	@Autowired
	private IRDS rds;
	
	@Override
	public Object execute(Object obj) throws Exception {
		
		Automata automata = null;
		List<DeleteDBSecurityGroupType> deleteDBSecurityGroupTypeList = null;
		List<DeleteDBSecurityGroupResponseType> deleteDBSecurityGroupResponseList = null;
		DeleteDBSecurityGroupResponseType deleteDBSecurityGroupResponse = null;
		
		automata = (Automata) obj;
		deleteDBSecurityGroupTypeList = automata.getResources().getDeleteDBSecurityGroupRequest();
		deleteDBSecurityGroupResponseList = new ArrayList<DeleteDBSecurityGroupResponseType>();
		
		for(DeleteDBSecurityGroupType deletedBSecurityGroupType : deleteDBSecurityGroupTypeList ){
			
			try{
				deleteDBSecurityGroupResponse = new DeleteDBSecurityGroupResponseType();
				deleteDBSecurityGroupResponse.setRequest(deletedBSecurityGroupType);
				rds.deleteDBSecurityGroup(deletedBSecurityGroupType);
				deleteDBSecurityGroupResponse.setStatus("DB security group has been deleted");
			}catch (AmazonServiceException ase) {
				deleteDBSecurityGroupResponse.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while deleting DB Security group ", ase);
			} catch (AmazonClientException ace) {
				deleteDBSecurityGroupResponse.setStatus(ace.getMessage());
				logger.error("AmazonClientException while deleting DB Security group",	ace);
			}
			deleteDBSecurityGroupResponseList.add(deleteDBSecurityGroupResponse);
		}
		automata.getOutputs().setDeleteDBSecurityGroupResponse(deleteDBSecurityGroupResponseList);
		return automata;
	}

	private static Logger logger = LoggerFactory
	.getLogger(DeleteDBSecurityGroupController.class.getName());
}
