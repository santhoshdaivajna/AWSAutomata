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
import com.automata.cloudcore.constants.Constants;
import com.automata.cloudcore.constants.ExceptionConstants;
import com.automata.cloudcore.model.CreateDBInstanceModel;
import com.automata.cloudcore.service.aws.rds.IRDS;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.CreateDBInstanceResponse;
import com.automata.cloudcore.xmlbindings.CreateDBInstanceResultType;
import com.automata.cloudcore.xmlbindings.CreateDBInstanceType;
import com.automata.cloudcore.xmlbindings.DBInstanceType;

/**
 * The Class RDSController processes all the launch RDS instance requests
 * in the input object and sets an updated list of CreateDBInstanceResponse
 * object in the output.
 * 
 * @author Santhosh Daivajna
 */
@Component
public class RDSController implements IController {

	/**
	 * Handle to RDS APIs
	 */
	@Autowired
	private IRDS rds;

	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		List<CreateDBInstanceType> createDBInstanceList = null;
		List<CreateDBInstanceResponse> responseList = null;
		
		automata = (Automata) obj;
		createDBInstanceList = automata.getResources().getLaunchRDSInstance();
		responseList = processCreateDBInstance(createDBInstanceList);
		automata.getOutputs().setLaunchRDSInstanceDetails(responseList);
		return automata;
	}

	
	/**
	 * processes all the CreateDBInstanceRequests and returns a response list.
	 * @param createDBInstanceList
	 * @return
	 */
	private List<CreateDBInstanceResponse> processCreateDBInstance(
			List<CreateDBInstanceType> createDBInstanceList) {
		
		DBInstance dbInstance;
		CreateDBInstanceResponse response = null;
		CreateDBInstanceResultType createDBInstanceResultType;
		CreateDBInstanceModel createDBInstanceModel;
		List<CreateDBInstanceResponse> responseList = null;
		
		responseList = new ArrayList<CreateDBInstanceResponse>();
		for (CreateDBInstanceType launchRDSInstance : createDBInstanceList) {

			try {
				createDBInstanceModel = new CreateDBInstanceModel(launchRDSInstance);
				response = new CreateDBInstanceResponse();
				dbInstance = rds.createDBInstance(createDBInstanceModel);
				createDBInstanceResultType = new CreateDBInstanceResultType();
				createDBInstanceResultType.setDBInstance(new DBInstanceType(dbInstance));
				response.setCreateDBInstanceResult(createDBInstanceResultType);
				response.setStatus(Constants.RDS_SUCCESS);
				response.setRegion(launchRDSInstance.getRegion());

			} catch (AmazonServiceException ase) {
				response.setStatus(ase.getMessage());
				logger.error(ExceptionConstants.ASE_RDS_LAUNCH, ase);
			} catch (AmazonClientException ace) {
				response.setStatus(ace.getMessage());
				logger.error(ExceptionConstants.ASE_RDS_LAUNCH,ace);
			}
			responseList.add(response);
		}
		return responseList;
	}

	private static Logger logger = LoggerFactory.getLogger(RDSController.class.getName());
}
