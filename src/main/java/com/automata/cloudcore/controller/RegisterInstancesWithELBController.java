/**
 * 
 */
package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.Instance;
import com.amazonaws.services.elasticloadbalancing.model.RegisterInstancesWithLoadBalancerResult;
import com.automata.cloudcore.constants.Constants;
import com.automata.cloudcore.constants.ExceptionConstants;
import com.automata.cloudcore.service.aws.elb.ILoadBalancer;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.Ec2InstanceResponse;
import com.automata.cloudcore.xmlbindings.LoadBalancerResponse;
import com.automata.cloudcore.xmlbindings.LoadBalancerType;

@Component
public class RegisterInstancesWithELBController implements IController {

	@Autowired
	private ILoadBalancer lb;

	@Override
	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		List<LoadBalancerResponse> responseList;

		automata = (Automata) obj;
		responseList = automata.getOutputs().getLoadBalancerDetails();
		registerInstancesWithLB(automata, responseList);
		return automata;
	}

	/**
	 * @param automata
	 * @param responseList
	 */
	private void registerInstancesWithLB(Automata automata,
			List<LoadBalancerResponse> responseList) {
		
		RegisterInstancesWithLoadBalancerResult registerInstancesWithLBResult;
		Instance instance;
		String loadBalancerName;
		String region;
		String endPoint;
		List<Instance> elbInstances;
		LoadBalancerType loadBalancerType;
		
		List<Ec2InstanceResponse> ec2ResponseList = automata.getOutputs().getInstanceDetails();
		for ( LoadBalancerResponse loadbalancerResponse : responseList ) {
			
			try{
				elbInstances = new ArrayList<Instance>();
				loadBalancerType = loadbalancerResponse.getRequest();
				region = loadBalancerType.getRegion();
				endPoint = lb.getLoadBalancerEndPoint(region);
				
					if (loadbalancerResponse.getStatus().contains(Constants.SUCCESS_CREATED)){
						for (Ec2InstanceResponse instanceDetails : ec2ResponseList) {
							loadBalancerName = instanceDetails.getLoadBalancerName();
							if (loadBalancerName != null && loadBalancerName.equalsIgnoreCase(loadBalancerType.getLoadBalancerName())) {
								instance = new Instance();
								instance.setInstanceId(instanceDetails.getInstanceId());
								elbInstances.add(instance);
							}
						}
						if (elbInstances.size() > 0){
							registerInstancesWithLBResult = lb.registerInstanceWithLB(endPoint, 
									loadBalancerType.getLoadBalancerName(), elbInstances);
						}
					}
					
			}catch(AmazonServiceException ase){
				logger.error(ExceptionConstants.ASE_REG_INSTANCES_LB, ase);
				// TODO : Set the status of registration failure
			}catch(AmazonClientException ace){
				logger.error(ExceptionConstants.ACE_REG_INSTANCES_LB, ace);
				// TODO : Set the status of registration failure
			}
		}
	}
	
	private static Logger logger = LoggerFactory.getLogger(RegisterInstancesWithELBController.class.getName());

}
