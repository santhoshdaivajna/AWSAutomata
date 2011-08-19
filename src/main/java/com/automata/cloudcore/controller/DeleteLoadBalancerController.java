package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.automata.cloudcore.service.aws.elb.ILoadBalancer;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.DeleteLoadBalancerResponseType;
import com.automata.cloudcore.xmlbindings.DeleteLoadBalancerType;

public class DeleteLoadBalancerController implements IController {

	/** The as. */
	@Autowired
	private ILoadBalancer elb;
	
	@Override
	public Object execute(Object obj) throws Exception {
		
		Automata automata = null;
		List<DeleteLoadBalancerType> deleteLoadBalancerTypeList = null;
		List<DeleteLoadBalancerResponseType> deleteLoadBalancerResponseList = null;
		DeleteLoadBalancerResponseType deleteLoadBalancerResponse = null;
		
		automata = (Automata) obj;
		deleteLoadBalancerTypeList = automata.getResources().getDeleteLoadBalancerRequest();
		deleteLoadBalancerResponseList = new ArrayList<DeleteLoadBalancerResponseType>();
		
		for(DeleteLoadBalancerType loadBalancer : deleteLoadBalancerTypeList ){
			
			try{
				deleteLoadBalancerResponse = new DeleteLoadBalancerResponseType();
				deleteLoadBalancerResponse.setRequest(loadBalancer);
				elb.deleteLoadBalancer(loadBalancer);
				deleteLoadBalancerResponse.setStatus("Elastic Load Balancer has been deleted");
			}catch (AmazonServiceException ase) {
				deleteLoadBalancerResponse.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while deleting load balancer "
								+ ase.getMessage(), ase);
			} catch (AmazonClientException ace) {
				deleteLoadBalancerResponse.setStatus(ace.getMessage());
				logger.error("AmazonClientException while deleting load balancer",	ace);
			}
			deleteLoadBalancerResponseList.add(deleteLoadBalancerResponse);
		}
		automata.getOutputs().setDeleteLoadBalancerResponse(deleteLoadBalancerResponseList);
		return automata;
	}

	private static Logger logger = LoggerFactory
	.getLogger(DeleteLoadBalancerController.class.getName());
}
