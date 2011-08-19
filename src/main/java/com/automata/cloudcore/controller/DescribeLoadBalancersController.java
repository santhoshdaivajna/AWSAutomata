package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancersResult;
import com.automata.cloudcore.service.aws.elb.ILoadBalancer;
import com.automata.cloudcore.util.TransformObject;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.DescribeLoadBalancersResponseType;
import com.automata.cloudcore.xmlbindings.DescribeLoadBalancersResultType;
import com.automata.cloudcore.xmlbindings.DescribeLoadBalancersType;

public class DescribeLoadBalancersController implements IController {

	/** The ec2. */
	@Autowired
	private ILoadBalancer elb;

	
	@Override
	public Object execute(Object obj) throws Exception {
		
		Automata automata = null;
		List<DescribeLoadBalancersType> describeLoadBalancersTypeList = null;
		List<DescribeLoadBalancersResponseType> responseTypeList = null;
		DescribeLoadBalancersResponseType response = null;
		DescribeLoadBalancersResult result = null;
		DescribeLoadBalancersResultType resultType = null;
		
		automata = (Automata) obj;
		describeLoadBalancersTypeList = automata.getResources().getDescribeLoadBalancers();
		responseTypeList = new ArrayList<DescribeLoadBalancersResponseType>();
		
		for(DescribeLoadBalancersType descLoadBalancersType : describeLoadBalancersTypeList ){
			
			try{
				response = new DescribeLoadBalancersResponseType();
				response.setRegion(descLoadBalancersType.getRegion());
				
				result = elb.describeLoadBalancer(descLoadBalancersType);
				resultType = TransformObject.getDescribeLoadBalancersResultType(result);
				response.setDescribeLoadBalancersResult(resultType);
				response.setRegion(descLoadBalancersType.getRegion());
				response.setStatus("LoadBalancer has been successfully described ");
			}catch (AmazonServiceException ase) {
				response.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while describing load balancers", ase);
			} catch (AmazonClientException ace) {
				response.setStatus(ace.getMessage());
				logger.error("AmazonClientException while while describing loadbalancer",	ace);
			}
			responseTypeList.add(response);
		}
		automata.getOutputs().setDescribeLoadBalancersResponse(responseTypeList);
		
		return automata;
	}

	private static Logger logger = LoggerFactory
	.getLogger(DescribeLoadBalancersController.class.getName());
}
