package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.rds.model.DBSecurityGroup;
import com.automata.cloudcore.constants.ExceptionConstants;
import com.automata.cloudcore.service.aws.rds.IRDS;
import com.automata.cloudcore.xmlbindings.AuthorizeDBSecurityGroupIngressResponse;
import com.automata.cloudcore.xmlbindings.AuthorizeDBSecurityGroupIngressType;
import com.automata.cloudcore.xmlbindings.Automata;

/**
 * The Class AuthorizeDBSecurityGroupController authorizes adds firewall rules to 
 * the DB security group defined in the automata instance.  Returns a  automata 
 * object with updated AuthorizeDBSecurityGroupResponse list.
 * 
 * @author Santhosh Daivajna
 */
@Component
public class AuthorizeDBSecurityGroupController implements IController {

	/** Handle to RDS APIs. */
	@Autowired
	private IRDS rds;


	/* (non-Javadoc)
	 * @see com.automata.cloudcore.controller.IController#execute(java.lang.Object)
	 */
	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		List<AuthorizeDBSecurityGroupIngressResponse> responseList = null;
		List<AuthorizeDBSecurityGroupIngressType> authorizeDBSecurityGroupIngressList = null;
		
		automata = (Automata) obj;
		authorizeDBSecurityGroupIngressList = automata.getResources().getAuthorizeDBSecurityGroupIngress();
		responseList = processAuthorizeDBSecurityGroupIngress(
				authorizeDBSecurityGroupIngressList);

		automata.getOutputs().setAuthorizeDBSecurityGroupIngressDetails(
				responseList);
		return automata;
	}

	/**
	 * Processes and authorizes db security group ingress.
	 *
	 * @param authorizeDBSecurityGroupIngressList the authorize db security group ingress list
	 * @return the list
	 */
	private List<AuthorizeDBSecurityGroupIngressResponse> processAuthorizeDBSecurityGroupIngress(
			List<AuthorizeDBSecurityGroupIngressType> authorizeDBSecurityGroupIngressList) {
		
		DBSecurityGroup dBSecurityGroup;
		AuthorizeDBSecurityGroupIngressResponse response = null;
		List<AuthorizeDBSecurityGroupIngressResponse> responseList;
		responseList = new ArrayList<AuthorizeDBSecurityGroupIngressResponse>();

		for (AuthorizeDBSecurityGroupIngressType authorizeIngress : authorizeDBSecurityGroupIngressList) {

			try {
				response = new AuthorizeDBSecurityGroupIngressResponse(authorizeIngress);
				dBSecurityGroup = rds
						.authorizeDBSecurityGroupIngress(authorizeIngress);
				response.setStatus("successfully authorized");
				responseList.add(response);
			} catch (AmazonServiceException ase) {
				response.setStatus(ase.getMessage());
				logger.error( ExceptionConstants.AUTH_DBSECGRP_ASE , ase);
			} catch (AmazonClientException ace) {
				response.setStatus(ace.getMessage());
				logger.error( ExceptionConstants.AUTH_DBSECGRP_ACE ,ace);
			}
		}
		return responseList;
	}

	/** The logger. */
	private static Logger logger = LoggerFactory
			.getLogger(AutoScalingController.class.getName());

}
