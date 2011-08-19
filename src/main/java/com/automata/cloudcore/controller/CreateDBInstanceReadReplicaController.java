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
import com.automata.cloudcore.constants.ExceptionConstants;
import com.automata.cloudcore.service.aws.rds.IRDS;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.CreateDBInstanceReadReplicaResponse;
import com.automata.cloudcore.xmlbindings.CreateDBInstanceReadReplicaType;
import com.automata.cloudcore.xmlbindings.DBInstanceType;


/**
 * The Class CreateDBInstanceReadReplicaController processes all the CreateDBInstanceReadReplica requests
 * in the input object and sets an updated list of CreateDBInstanceReadReplicaResponse in the output.
 * 
 * @author Santhosh Daivajna
 *
 */
@Component
public class CreateDBInstanceReadReplicaController implements IController {

	@Autowired
	private IRDS rds;

	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		List<CreateDBInstanceReadReplicaType> createDBInstanceReadReplicaList = null;
		List<CreateDBInstanceReadReplicaResponse> responseList = null;

		automata = (Automata) obj;
		createDBInstanceReadReplicaList = automata.getResources().getCreateDBInstanceReadReplica();
		responseList = processCreateDBInstanceReadReplica(createDBInstanceReadReplicaList);
		automata.getOutputs().setCreateDBInstanceReadReplicaDetails(responseList);
		return automata;
	}

	
	/**
	 * processes all the CreateDBInstanceReadReplica requests
	 * @param createDBInstanceReadReplicaList
	 * @return
	 */
	private List<CreateDBInstanceReadReplicaResponse> processCreateDBInstanceReadReplica(
			List<CreateDBInstanceReadReplicaType> createDBInstanceReadReplicaList ) {
		
		CreateDBInstanceReadReplicaResponse response = null;
		List<CreateDBInstanceReadReplicaResponse> responseList;
		DBInstance dbInstance;
		DBInstanceType dbInstanceType;
		
		responseList = new ArrayList<CreateDBInstanceReadReplicaResponse>();
		for ( CreateDBInstanceReadReplicaType dbReadReplica : createDBInstanceReadReplicaList) {

			try {
				response = new CreateDBInstanceReadReplicaResponse();
				dbInstance = rds.createReadReplica(dbReadReplica);
				dbInstanceType = new DBInstanceType(dbInstance);
				response.setDBInstance(dbInstanceType);
				response.setRegion(dbReadReplica.getRegion());
				response.setStatus("RDS Read Replica instance "+ dbReadReplica.getDBInstanceIdentifier() +" successfully launched");

			} catch (AmazonServiceException ase) {
				response.setStatus(ase.getMessage());
				logger.error(ExceptionConstants.ASE_CREATE_READREPLICA, ase);
			} catch (AmazonClientException ace) {
				response.setStatus(ace.getMessage());
				logger.error(ExceptionConstants.ASE_CREATE_READREPLICA,ace);
			}
			responseList.add(response);
		}
		return responseList;
	}

	/**
	 * The logger. 
	 */
	private static Logger logger = LoggerFactory.getLogger(CreateDBInstanceReadReplicaController.class.getName());
}
