package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.rds.model.DBInstance;
import com.automata.cloudcore.model.RestoreDBInstanceFromDBSnapshotModel;
import com.automata.cloudcore.service.aws.rds.IRDS;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.DBInstanceType;
import com.automata.cloudcore.xmlbindings.RestoreDBInstanceFromDBSnapshotResponseType;
import com.automata.cloudcore.xmlbindings.RestoreDBInstanceFromDBSnapshotResultType;
import com.automata.cloudcore.xmlbindings.RestoreDBInstanceFromDBSnapshotType;

@Component
public class RestoreDBInstanceFromDBSnapshotController implements IController {

	@Autowired
	private IRDS rds;
	
	@Override
	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		RestoreDBInstanceFromDBSnapshotResponseType restoreDBInstanceFromDBSnapshotResponse = null;
		List<RestoreDBInstanceFromDBSnapshotType> restoreDBInstanceFromDBSnapshotList = null;
		List<RestoreDBInstanceFromDBSnapshotResponseType> restoreDBInstanceFromDBSnapshotResponseList = null;
		RestoreDBInstanceFromDBSnapshotModel restoreDBInstanceFromDBSnapshotModel = null;
		DBInstance dBInstance = null;
		DBInstanceType dBInstanceType = null;
		RestoreDBInstanceFromDBSnapshotResultType restoreDBInstanceFromDBSnapshotResult;
		
		automata = (Automata) obj;
		restoreDBInstanceFromDBSnapshotList = automata.getResources().getRestoreDBInstanceFromDBSnapshot();
		restoreDBInstanceFromDBSnapshotResponseList = new ArrayList<RestoreDBInstanceFromDBSnapshotResponseType>();
		
		for (RestoreDBInstanceFromDBSnapshotType restoreDBInstance : restoreDBInstanceFromDBSnapshotList){
			
			try{
				restoreDBInstanceFromDBSnapshotResponse = new RestoreDBInstanceFromDBSnapshotResponseType();
				restoreDBInstanceFromDBSnapshotModel = new RestoreDBInstanceFromDBSnapshotModel(restoreDBInstance);
				restoreDBInstanceFromDBSnapshotResponse.setRequest(restoreDBInstance);
				
				dBInstance = rds.restoreDBInstanceFromDBSnapshot(restoreDBInstance);
				dBInstanceType = new DBInstanceType(dBInstance);
				restoreDBInstanceFromDBSnapshotResult = new RestoreDBInstanceFromDBSnapshotResultType();
				restoreDBInstanceFromDBSnapshotResult.setDBInstance(dBInstanceType);
				restoreDBInstanceFromDBSnapshotResponse
					.setRestoreDBInstanceFromDBSnapshotResult(restoreDBInstanceFromDBSnapshotResult);
				restoreDBInstanceFromDBSnapshotResponse.setStatus("DB Instance successfully restored from DB snapshot");
			}catch (AmazonServiceException ase) {
				restoreDBInstanceFromDBSnapshotResponse.setStatus(ase.getMessage());
				logger.error("Amazon Service Exception while restoring instance from snapshot: " 
						+ ase.getMessage(), ase);
			} catch (AmazonClientException ace) {
				restoreDBInstanceFromDBSnapshotResponse.setStatus(ace.getMessage());
				logger.error("Amazon Service Exception while restoring instance from snapshot: ",ace);
			}
			restoreDBInstanceFromDBSnapshotResponseList.add(restoreDBInstanceFromDBSnapshotResponse);
		}
		automata.getOutputs().setRestoreDBInstanceFromDBSnapshotResponse(restoreDBInstanceFromDBSnapshotResponseList);
		return automata;
	}

	private static Logger logger = LoggerFactory.getLogger(RestoreDBInstanceFromDBSnapshotController.class.getName());
}
