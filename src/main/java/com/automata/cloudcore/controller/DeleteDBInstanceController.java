package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.automata.cloudcore.service.aws.rds.IRDS;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.DeleteDBInstanceResponseType;
import com.automata.cloudcore.xmlbindings.DeleteDBInstanceType;
@Component
public class DeleteDBInstanceController implements IController {

	/** The as. */
	@Autowired
	private IRDS rds;
	
	@Override
	public Object execute(Object obj) throws Exception {
		
		Automata automata = null;
		List<DeleteDBInstanceType> deleteDBInstanceTypeList = null;
		List<DeleteDBInstanceResponseType> deleteDBInstanceResponseList = null;
		DeleteDBInstanceResponseType deleteDBInstanceResponse = null;
		
		automata = (Automata) obj;
		deleteDBInstanceTypeList = automata.getResources().getDeleteDBInstanceRequest();
		deleteDBInstanceResponseList = new ArrayList<DeleteDBInstanceResponseType>();
		
		for(DeleteDBInstanceType dBInstanceType : deleteDBInstanceTypeList ){
			
			try{
				deleteDBInstanceResponse = new DeleteDBInstanceResponseType();
				deleteDBInstanceResponse.setRequest(dBInstanceType);
				rds.deleteDBInstance(dBInstanceType);
				deleteDBInstanceResponse.setStatus("RDS Instance has been successfully deleted");
			}catch (AmazonServiceException ase) {
				deleteDBInstanceResponse.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while deleting the RDS instance ", ase);
			} catch (AmazonClientException ace) {
				deleteDBInstanceResponse.setStatus(ace.getMessage());
				logger.error("AmazonClientException while deleting the RDS instance", ace);
			}
			deleteDBInstanceResponseList.add(deleteDBInstanceResponse);
		}
		automata.getOutputs().setDeleteDBInstanceResponse(deleteDBInstanceResponseList);
		return automata;
	}

	private static Logger logger = LoggerFactory
	.getLogger(DeleteDBInstanceController.class.getName());
}
