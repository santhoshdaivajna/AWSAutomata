package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.CreateAppCookieStickinessPolicyResult;
import com.automata.cloudcore.constants.ExceptionConstants;
import com.automata.cloudcore.service.aws.elb.ILoadBalancer;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.CreateAppCookieStickinessPolicyResponse;
import com.automata.cloudcore.xmlbindings.CreateAppCookieStickinessPolicyType;

/**
 * The Class CreateAppCookieStickinessPolicyController creates app cookie stickiness 
 * policies defined in the automata instance and associates the policy with the 
 * load balancer. 
 * Returns a updated automata object with status of policy creation.
 */
@Component
public class CreateAppCookieStickinessPolicyController implements IController {

	@Autowired
	private ILoadBalancer lb;

	@Override
	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		List<CreateAppCookieStickinessPolicyType> appCookieStickinessList = null;
		List<CreateAppCookieStickinessPolicyResponse> responseList = null;

		automata = (Automata) obj;
		appCookieStickinessList = automata.getResources().getCreateAppCookieStickinessPolicy();
		responseList = processCreateAppCookieStickynessPolicy(appCookieStickinessList);
		automata.getOutputs().setCreateAppCookieStickinessPolicyDetails(responseList);
		return automata;
	}

	/**
	 * processes CreateAppCookieStickynessPolicy requests
	 * @param appCookieStickinessList
	 * @return
	 */
	private List<CreateAppCookieStickinessPolicyResponse> processCreateAppCookieStickynessPolicy(
			List<CreateAppCookieStickinessPolicyType> appCookieStickinessList) {
		
		CreateAppCookieStickinessPolicyResponse response = null;
		List<CreateAppCookieStickinessPolicyResponse> responseList = null;
		CreateAppCookieStickinessPolicyResult result = null;
		String loadBalancerName;
		String policyName;
		responseList = new ArrayList<CreateAppCookieStickinessPolicyResponse>();
		
		for (CreateAppCookieStickinessPolicyType appCookie : appCookieStickinessList) {

			try{
				response = new CreateAppCookieStickinessPolicyResponse();
				response.setRequest(appCookie);
				loadBalancerName 	= appCookie.getLoadBalancerName();
				policyName 			= appCookie.getPolicyName();
				
				result =  lb.createAppCookieStickinessPolicy(appCookie);
				response.setStatus( policyName +" successfully associated with "+loadBalancerName);
			} catch (AmazonServiceException ase) {
				response.setStatus(ase.getMessage());
				logger.error(ExceptionConstants.ASE_CREATING_APP_COOKIE , ase);
			} catch (AmazonClientException ace) {
				response.setStatus(ace.getMessage());
				logger.error(ExceptionConstants.ACE_CREATING_APP_COOKIE, ace);
			}
			responseList.add(response);
		}
		return responseList;
	}

	private static final Logger logger = LoggerFactory.getLogger(CreateAppCookieStickinessPolicyController.class.getName());

}
