package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.automata.cloudcore.service.aws.ec2.IEC2;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.DeleteSecurityGroupResponseType;
import com.automata.cloudcore.xmlbindings.DeleteSecurityGroupType;

public class DeleteSecurityGroupController implements IController {

	@Autowired
	private IEC2 ec2;
	@Override
	public Object execute(Object obj) throws Exception {
		
		Automata automata = null;
		List<DeleteSecurityGroupType> deleteSecurityGroupTypeList = null;
		List<DeleteSecurityGroupResponseType> deleteSecurityGroupResponseList = null;
		DeleteSecurityGroupResponseType deleteSecurityGroupResponse = null;
		
		automata = (Automata) obj;
		deleteSecurityGroupTypeList = automata.getResources().getDeleteSecurityGroupRequest();
		deleteSecurityGroupResponseList = new ArrayList<DeleteSecurityGroupResponseType>();
		
		for(DeleteSecurityGroupType securityGroup : deleteSecurityGroupTypeList ){
			
			try{
				deleteSecurityGroupResponse = new DeleteSecurityGroupResponseType();
				deleteSecurityGroupResponse.setRequest(securityGroup);
				ec2.setEndPoint(securityGroup.getRegion());
				ec2.deleteSecurityGroup(securityGroup);
				deleteSecurityGroupResponse.setStatus("Security group has been deleted");
			}catch (AmazonServiceException ase) {
				deleteSecurityGroupResponse.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while deleting security group ", ase);
			} catch (AmazonClientException ace) {
				deleteSecurityGroupResponse.setStatus(ace.getMessage());
				logger.error("AmazonClientException while updating autoscale group", ace);
			}
			deleteSecurityGroupResponseList.add(deleteSecurityGroupResponse);
		}
		automata.getOutputs().setDeleteSecurityGroupResponse(deleteSecurityGroupResponseList);
		return automata;
	}

	private static Logger logger = LoggerFactory
	.getLogger(DeleteSecurityGroupController.class.getName());
}
