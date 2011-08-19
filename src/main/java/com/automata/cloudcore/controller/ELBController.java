package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.CreateLoadBalancerResult;
import com.amazonaws.services.elasticloadbalancing.model.Listener;
import com.automata.cloudcore.constants.Constants;
import com.automata.cloudcore.constants.ExceptionConstants;
import com.automata.cloudcore.model.ELBModel;
import com.automata.cloudcore.service.aws.elb.ILoadBalancer;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.ListenerType;
import com.automata.cloudcore.xmlbindings.LoadBalancerResponse;
import com.automata.cloudcore.xmlbindings.LoadBalancerType;

/*  ELBController creates the load balancers and registers the instances
 *  with the load balancers.
 */

@Component
public class ELBController implements IController {

	@Autowired
	private ILoadBalancer lb;

	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		List<LoadBalancerType> loadbalancerList = null;
		List<LoadBalancerResponse> responseList = null;

		automata = (Automata) obj;
		loadbalancerList = automata.getResources().getLoadBalancer();
		responseList = processLoadBalancerRequest(loadbalancerList);

		if (responseList.size() > 0)
			automata.getOutputs().setLoadBalancerDetails(responseList);
		return automata;
	}

	/**
	 * @param loadbalancerList
	 * @return responseList
	 */
	private List<LoadBalancerResponse> processLoadBalancerRequest(
			List<LoadBalancerType> loadbalancerList ) {
		
		String endPoint;
		String loadbalancerName;
		List<String> availabilityZones;
		ELBModel elbModel;
		List<Listener> listenerList;
		List<LoadBalancerResponse> responseList;
		CreateLoadBalancerResult createLoadBalancerResult;
		LoadBalancerResponse response = null;
		
		responseList = new ArrayList<LoadBalancerResponse>();
		
		for (LoadBalancerType loadbalancer : loadbalancerList) {
			try {
				response = new LoadBalancerResponse();
				response.setRequest(loadbalancer);
				
				loadbalancerName = loadbalancer.getLoadBalancerName();
				availabilityZones = loadbalancer.getAvailabilityZones();
				listenerList = getListenerList(loadbalancer.getListener());
				endPoint = lb.getLoadBalancerEndPoint(loadbalancer.getRegion());
				elbModel = new ELBModel(availabilityZones, loadbalancerName, endPoint, listenerList);
				createLoadBalancerResult = lb.createLoadBalancer(elbModel);
				
				response.setLoadBalancerDNSName(createLoadBalancerResult.getDNSName());
				response.setStatus(Constants.LB_SUCCESSFULLY_CREATED +":"+loadbalancerName);
			} catch (AmazonServiceException ase) {
				logger.error(ExceptionConstants.ASE_CREATE_LB, ase);
				response.setStatus(ase.getMessage());
			} catch (AmazonClientException ace) {
				logger.error(ExceptionConstants.ASE_CREATE_LB, ace);
				response.setStatus(ace.getMessage());
			}
			responseList.add(response);
		}
		return responseList;
	}

	/**
	 * @param listenerList
	 * @param loadbalancer
	 */
	private List<Listener> getListenerList(List<ListenerType> listenerTypeList ) {
		Listener loadbalancerListener;
		List<Listener> listenerList;
		
		listenerList = new ArrayList<Listener>();
		for (ListenerType listener : listenerTypeList ) {
			loadbalancerListener = new Listener();
			loadbalancerListener.withProtocol(listener.getProtocol())
					.withLoadBalancerPort(listener.getLoadBalancerPort())
					.withInstancePort(listener.getInstancePort());
			listenerList.add(loadbalancerListener);
		}
		return listenerList;
	}

	private static Logger logger = LoggerFactory.getLogger(ELBController.class.getName());
}
