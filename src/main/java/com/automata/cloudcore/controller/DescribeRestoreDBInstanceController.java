package com.automata.cloudcore.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.rds.model.DescribeDBInstancesResult;
import com.automata.cloudcore.constants.Constants;
import com.automata.cloudcore.service.aws.rds.IRDS;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.DBInstanceType;
import com.automata.cloudcore.xmlbindings.RestoreDBInstanceFromDBSnapshotResponseType;
import com.automata.cloudcore.xmlbindings.RestoreDBInstanceFromDBSnapshotResultType;

public class DescribeRestoreDBInstanceController implements IController {

	/** The rds. */
	@Autowired
	private IRDS rds;
	
	@Override
	public Object execute(Object obj) throws Exception {
		
		Automata automata = null;
		DBInstanceType dbInstanceType = null;
		 List<RestoreDBInstanceFromDBSnapshotResponseType> rdsInstanceDetailsList = null;
		 RestoreDBInstanceFromDBSnapshotResponseType restoreDBInstance = null;
		 
		DescribeDBInstancesResult describeDBInstanceResult = null;
		RestoreDBInstanceFromDBSnapshotResultType restoreDBInstanceResult = null;
		String dBInstanceIdentifier = null;
		String region = null;
		String dbInstanceState = null;
		boolean notOperational = true;
		
		automata = (Automata) obj;
		rdsInstanceDetailsList = automata.getOutputs().getRestoreDBInstanceFromDBSnapshotResponse();
		
		for (int index = 0; index < rdsInstanceDetailsList.size(); index++) {
			notOperational = true;
			while (notOperational) {
				
				try {
					restoreDBInstance = rdsInstanceDetailsList.get(index);
					if(restoreDBInstance != null)
						restoreDBInstanceResult = restoreDBInstance.getRestoreDBInstanceFromDBSnapshotResult();
					if (restoreDBInstanceResult != null){
						dbInstanceType = restoreDBInstanceResult.getDBInstance();
						dBInstanceIdentifier = dbInstanceType.getDBInstanceIdentifier();
					}
					region = restoreDBInstance.getRequest().getRegion();
					
					describeDBInstanceResult = rds.describeRDSInstance(dBInstanceIdentifier, region);
					dbInstanceType = new DBInstanceType(describeDBInstanceResult.getDBInstances().get(0));
					dbInstanceState = dbInstanceType.getDBInstanceStatus();
					logger.debug("dbInstanceState :"+dbInstanceState);
					if (dbInstanceState.equalsIgnoreCase("available")) {
						notOperational = false;
						restoreDBInstanceResult = new RestoreDBInstanceFromDBSnapshotResultType();
						restoreDBInstanceResult.setDBInstance(dbInstanceType);
						restoreDBInstance.setRestoreDBInstanceFromDBSnapshotResult(restoreDBInstanceResult);
					} else {
						logger.debug("Thread sleep  :"+Constants.RDS_DESCRIBE+" seconds");
						Thread.sleep(TimeUnit.SECONDS.toSeconds(Constants.RDS_DESCRIBE));
					}
				}catch (AmazonServiceException ase) {
					notOperational = false;
					restoreDBInstance.setStatus(ase.getMessage());
					logger.error("Amazon Service Exception while describing the rds instance " 
							+ ase.getMessage(), ase);
				} catch (AmazonClientException ace) {
					notOperational = false;
					restoreDBInstance.setStatus(ace.getMessage());
					logger.error("AmazonClientException while describing rds instance", ace);
				}
			
			}
		}
		
		return automata;
	}

		/** The Constant logger. */
		private static final Logger logger = LoggerFactory
				.getLogger(DescribeRestoreDBInstanceController.class.getName());
}
