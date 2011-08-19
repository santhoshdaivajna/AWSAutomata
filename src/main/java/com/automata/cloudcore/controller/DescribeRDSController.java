package com.automata.cloudcore.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.rds.model.DescribeDBInstancesResult;
import com.automata.cloudcore.constants.Constants;
import com.automata.cloudcore.constants.ExceptionConstants;
import com.automata.cloudcore.service.aws.rds.IRDS;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.CreateDBInstanceResponse;
import com.automata.cloudcore.xmlbindings.CreateDBInstanceResultType;
import com.automata.cloudcore.xmlbindings.DBInstanceType;

/**
 * The Class DescribeRDSController describes the RDS instances launched previously
 * in the flow and updates the status of the instances in the output object.
 * 
 * @author Santhosh Daivajna
 */
@Component
public class DescribeRDSController implements IController {

	/** The handle to RDS APIs. */
	@Autowired
	private IRDS rds;
	
	@Override
	public Object execute(Object obj) throws Exception {
		
		Automata automata = null;
		String dBInstanceIdentifier = null;
		String region = null;
		String dbInstanceState = null;
		boolean notOperational = true;
		DBInstanceType dbInstance = null;
		CreateDBInstanceResponse response = null;
		List<CreateDBInstanceResponse> responseList = null;
		DescribeDBInstancesResult describeDBInstanceResult = null;
		CreateDBInstanceResultType createDBInstanceResult = null;
		
		
		automata = (Automata) obj;
		responseList = automata.getOutputs().getLaunchRDSInstanceDetails();
		
		for (int index = 0; index < responseList.size(); index++) {
			notOperational = true;
			while (notOperational) {
				
				try {
					response = responseList.get(index);
					createDBInstanceResult = response.getCreateDBInstanceResult();
					dbInstance = createDBInstanceResult.getDBInstance();
					dBInstanceIdentifier = dbInstance.getDBInstanceIdentifier();
					region = response.getRegion();
					logger.debug("dBInstanceIdentifier "+dBInstanceIdentifier+ "region "+region);
					describeDBInstanceResult = rds.describeRDSInstance(dBInstanceIdentifier, region);
					dbInstance = new DBInstanceType(describeDBInstanceResult.getDBInstances().get(0));
					dbInstanceState = dbInstance.getDBInstanceStatus();
					logger.debug("db instance state :"+dbInstanceState);
					
					if (dbInstanceState.equalsIgnoreCase(Constants.RDS_STATE_AVAILABLE)) {
						notOperational = false;
						createDBInstanceResult = new CreateDBInstanceResultType();
						createDBInstanceResult.setDBInstance(dbInstance);
						response.setCreateDBInstanceResult(createDBInstanceResult);
					} else {
						Thread.sleep(TimeUnit.SECONDS.toSeconds(Constants.RDS_DESCRIBE));
					}
					
				}catch (AmazonServiceException ase) {
					notOperational = false;
					response.setStatus(ase.getMessage());
					logger.error(ExceptionConstants.ASE_DESC_RDS , ase);
				} catch (AmazonClientException ace) {
					notOperational = false;
					response.setStatus(ace.getMessage());
					logger.error(ExceptionConstants.ASE_DESC_RDS, ace);
				}
			}
		}
		
		return automata;
	}

		/** The Constant logger. */
		private static final Logger logger = LoggerFactory
				.getLogger(DescribeRDSController.class.getName());
}
