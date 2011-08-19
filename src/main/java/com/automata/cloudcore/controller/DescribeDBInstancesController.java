package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.rds.model.DescribeDBInstancesResult;
import com.automata.cloudcore.constants.Constants;
import com.automata.cloudcore.constants.ExceptionConstants;
import com.automata.cloudcore.service.aws.rds.IRDS;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.DescribeDBInstancesResponseType;
import com.automata.cloudcore.xmlbindings.DescribeDBInstancesResultType;
import com.automata.cloudcore.xmlbindings.DescribeDBInstancesType;

/**
 * The Class DescribeDBInstancesController.
 * describes the RDS instances specified in the DescribeDBInstances 
 * element in the input xml file. 
 */
public class DescribeDBInstancesController implements IController {

	
	/** The rds. */
	@Autowired
	private IRDS rds;
	
	/* execute (Object obj) - input obj is of type Automata.
	 *  execute iterates over all the DescribeDBInstance elements specified in the 
	 * input file and sets the responses in the output element. 
	 *
	 */
	@Override
	public Object execute(Object obj) throws Exception {
		
		Automata automata = null;
		List<DescribeDBInstancesType> descDBInstancesTypeList = null;
		List<DescribeDBInstancesResponseType> responseList = null;
		DescribeDBInstancesResponseType response = null;
		DescribeDBInstancesResultType resultType = null;
		DescribeDBInstancesResult  result = null;
		
		automata = (Automata) obj;
		descDBInstancesTypeList = automata.getResources().getDescribeDBInstances();
		responseList = new ArrayList<DescribeDBInstancesResponseType>();
		
		for(DescribeDBInstancesType dbInstance : descDBInstancesTypeList ){
			
			try{
				logger.debug("DB Instance identifier "+dbInstance.getDBInstanceIdentifier());
				response = new DescribeDBInstancesResponseType();
				result = rds.describeDBInstance(dbInstance);
				resultType = new DescribeDBInstancesResultType(result);
				response.setDescribeDBInstancesResult(resultType);
				response.setRegion(dbInstance.getRegion());
				response.setStatus(Constants.RDS_DESC_SUCCESS);
			}catch (AmazonServiceException ase) {
				response.setStatus(ase.getMessage());
				logger.error(ExceptionConstants.ASE_DESCRIBING_RDS_INSTANCE, ase);
			} catch (AmazonClientException ace) {
				response.setStatus(ace.getMessage());
				logger.error(ExceptionConstants.ACE_DESCRIBING_RDS_INSTANCE, ace);
			}
			responseList.add(response);
		}
		automata.getOutputs().setDescribeDBInstancesResponse(responseList);
		return automata;
	}

	/** The logger. */
	private static Logger logger = LoggerFactory
	.getLogger(DescribeDBInstancesController.class.getName());
}
