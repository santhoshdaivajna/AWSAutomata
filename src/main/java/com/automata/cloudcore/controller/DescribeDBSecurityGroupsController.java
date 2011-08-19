package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.rds.model.DescribeDBSecurityGroupsResult;
import com.automata.cloudcore.service.aws.rds.IRDS;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.DescribeDBSecurityGroupsResponseType;
import com.automata.cloudcore.xmlbindings.DescribeDBSecurityGroupsResultType;
import com.automata.cloudcore.xmlbindings.DescribeDBSecurityGroupsType;

public class DescribeDBSecurityGroupsController implements IController {

	@Autowired
	private IRDS rds;
	
	@Override
	public Object execute(Object obj) throws Exception {
		
		Automata automata = null;
		List<DescribeDBSecurityGroupsType> describeDBSecurityGroupsTypeList = null;
		List<DescribeDBSecurityGroupsResponseType> responseList = null;
		DescribeDBSecurityGroupsResponseType response = null;
		DescribeDBSecurityGroupsResultType resultType;
		DescribeDBSecurityGroupsResult  result;
		
		automata = (Automata) obj;
		describeDBSecurityGroupsTypeList = automata.getResources().getDescribeDBSecurityGroups();
		responseList = new ArrayList<DescribeDBSecurityGroupsResponseType>();
		
		for(DescribeDBSecurityGroupsType dbSecurityGroup : describeDBSecurityGroupsTypeList ){
			
			try{
				response = new DescribeDBSecurityGroupsResponseType();
				result = rds.describeDBSecurityGroup(dbSecurityGroup);
				resultType = new DescribeDBSecurityGroupsResultType(result);
				response.setDescribeDBSecurityGroupsResult(resultType);
				response.setRegion(dbSecurityGroup.getRegion());
				response.setStatus("Security group has been deleted");
			}catch (AmazonServiceException ase) {
				response.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while deleting security group ", ase);
			} catch (AmazonClientException ace) {
				response.setStatus(ace.getMessage());
				logger.error("AmazonClientException while updating autoscale group", ace);
			}
			responseList.add(response);
		}
		automata.getOutputs().setDescribeDBSecurityGroupsResponse(responseList);
		return automata;
	}

	private static Logger logger = LoggerFactory
	.getLogger(DescribeDBSecurityGroupsController.class.getName());
}
