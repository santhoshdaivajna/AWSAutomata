package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsResult;
import com.automata.cloudcore.service.aws.ec2.IEC2;
import com.automata.cloudcore.util.TransformObject;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.DescribeSecurityGroupsResponseType;
import com.automata.cloudcore.xmlbindings.DescribeSecurityGroupsType;
import com.automata.cloudcore.xmlbindings.SecurityGroupSetType;

public class DescribeSecurityGroupsController implements IController {

	/** The ec2. */
	@Autowired
	private IEC2 ec2;

	
	@Override
	public Object execute(Object obj) throws Exception {
		
		Automata automata = null;
		List<DescribeSecurityGroupsType> describeSecurityGroupsTypeList = null;
		List<DescribeSecurityGroupsResponseType> responseList = null;
		DescribeSecurityGroupsResponseType response = null;
		DescribeSecurityGroupsResult result = null;
		SecurityGroupSetType securityGroupSetType = null;
		
		automata = (Automata) obj;
		describeSecurityGroupsTypeList = automata.getResources().getDescribeSecurityGroups();
		responseList = new ArrayList<DescribeSecurityGroupsResponseType>();
		
		for(DescribeSecurityGroupsType securityGroup : describeSecurityGroupsTypeList ){
			
			try{
				response = new DescribeSecurityGroupsResponseType();
				response.setRequest(securityGroup);
				response.setRegion(securityGroup.getRegion());
				ec2.setEndPoint(securityGroup.getRegion());
				result = ec2.describeSecurityGroups(securityGroup);
				securityGroupSetType = TransformObject.getSecurityGroupSet(result);
				response.setSecurityGroupInfo(securityGroupSetType);
				response.setStatus("security groups  have been successfully described for region :"+securityGroup.getRegion());
			}catch (AmazonServiceException ase) {
				response.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while describing security groups for region :"+securityGroup.getRegion(), ase);
			} catch (AmazonClientException ace) {
				response.setStatus(ace.getMessage());
				logger.error("AmazonClientException while while describing security groups for region :"+securityGroup.getRegion(),	ace);
			}
			responseList.add(response);
		}
		automata.getOutputs().setDescribeSecurityGroupsResponse(responseList);
		return automata;
	}

	private static Logger logger = LoggerFactory
	.getLogger(DescribeSecurityGroupsController.class.getName());
}
