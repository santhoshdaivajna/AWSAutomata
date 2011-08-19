package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.CreateLBCookieStickinessPolicyResult;
import com.automata.cloudcore.constants.ExceptionConstants;
import com.automata.cloudcore.service.aws.elb.ILoadBalancer;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.CreateLBCookieStickinessPolicyResponse;
import com.automata.cloudcore.xmlbindings.CreateLBCookieStickinessPolicyType;

/**
 * The Class CreateLBCookieStickinessPolicyController creates load balancer cookie
 * stickiness policies defined in the automata instance and associates the policy 
 * with the load balancer. 
 * Returns a updated automata object with status of policy creation.
 */
@Component
public class CreateLBCookieStickinessPolicyController implements IController {

	@Autowired
	private ILoadBalancer lb;

	@Override
	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		List<CreateLBCookieStickinessPolicyType> lbCookieStickinessList = null;
		List<CreateLBCookieStickinessPolicyResponse> responseList = null;

		automata = (Automata) obj;
		lbCookieStickinessList = automata.getResources().getCreateLBCookieStickinessPolicy();
		responseList = processCreateLBCookieStickinessPolicyReq( lbCookieStickinessList );
		
		automata.getOutputs().setCreateLBCookieStickinessPolicyDetails(responseList);
		return automata;
	}

	/**
	 * @param lbCookieStickinessList
	 * @return responseList
	 */
	private List<CreateLBCookieStickinessPolicyResponse> processCreateLBCookieStickinessPolicyReq(
			List<CreateLBCookieStickinessPolicyType> lbCookieStickinessList) {
		
		CreateLBCookieStickinessPolicyResponse response = null;
		List<CreateLBCookieStickinessPolicyResponse> responseList;
		CreateLBCookieStickinessPolicyResult result;
		String loadBalancerName;
		String policyName;
		
		responseList = new ArrayList<CreateLBCookieStickinessPolicyResponse>();
		for (CreateLBCookieStickinessPolicyType lbCookie : lbCookieStickinessList) {

			try{
				loadBalancerName = lbCookie.getLoadBalancerName();
				policyName 	= lbCookie.getPolicyName();
				response = new CreateLBCookieStickinessPolicyResponse();
				response.setRequest(lbCookie);
				result =  lb.createLBCookieStickinessPolicy(lbCookie);
				response.setStatus( policyName +" successfully associated with "+loadBalancerName );
			} catch (AmazonServiceException ase) {
				response.setStatus(ase.getMessage());
				logger.error(ExceptionConstants.ASE_CREATE_LB_COOKIE, ase);
			} catch (AmazonClientException ace) {
				response.setStatus(ace.getMessage());
				logger.error(ExceptionConstants.ASE_CREATE_LB_COOKIE, ace);
			}
			responseList.add(response);
		}
		return responseList;
	}

	private static final Logger logger = LoggerFactory.getLogger(CreateLBCookieStickinessPolicyController.class.getName());

}
