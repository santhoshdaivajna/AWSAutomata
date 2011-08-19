package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.InstanceStateName;
import com.amazonaws.services.ec2.model.Reservation;
import com.automata.cloudcore.constants.Constants;
import com.automata.cloudcore.constants.ExceptionConstants;
import com.automata.cloudcore.service.aws.ec2.IEC2;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.Ec2InstanceResponse;

/**
 * The Class DescribeEC2Controller describes the instances launched previously in the flow
 * and updates the status of the instances.
 * 
 * @author Santhosh Daivajna
 */
@Component
public class DescribeEC2Controller implements IController {

	/** Handle to EC2 APIs */
	@Autowired
	private IEC2 ec2;

	/* (non-Javadoc)
	 * @see com.automata.cloudcore.controller.IController#execute(java.lang.Object)
	 */
	@Override
	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		List<Ec2InstanceResponse> ec2InstanceResponses = null;

		automata = (Automata) obj;
		ec2InstanceResponses = automata.getOutputs().getInstanceDetails();
		describeEC2Instances(ec2InstanceResponses);

		if (!ec2InstanceResponses.isEmpty() ){
			automata.getOutputs().setInstanceDetails(ec2InstanceResponses);
		}
		return automata;
	}

	/**
	 * describes all the instances until all the instances are running.
	 * @param ec2InstanceResponses
	 * @param instanceIds
	 * @throws InterruptedException
	 */
	private void describeEC2Instances( List<Ec2InstanceResponse> ec2InstanceResponses)
		throws InterruptedException {
		
		List<String> instanceIds;
		DescribeInstancesResult describeInstanceResult;
		Instance instance;
		String instanceState;
		boolean notOperational;
		Ec2InstanceResponse ec2Response = null;
		
		instanceIds = new ArrayList<String>();
		for (int index = 0; index < ec2InstanceResponses.size(); index++) {
			
			notOperational = true;
			while (notOperational) {
				
				try {
					ec2Response = ec2InstanceResponses.get(index);
					instanceIds.add(ec2Response.getInstanceId());
					ec2.setEndPoint(ec2Response.getRegion());
					describeInstanceResult = ec2.describeServer(instanceIds);
					
					instance = getInstance(describeInstanceResult);
					instanceState = instance.getState().getName();
					if (instanceState.equalsIgnoreCase(InstanceStateName.Running.toString())) {
						notOperational = false;
						setEC2Response(instance, ec2Response);
					} else {
						Thread.sleep(TimeUnit.SECONDS.toSeconds(Constants.EC2_DESCRIBE));
					}
					instanceIds.removeAll(instanceIds);
				} catch (AmazonServiceException ase) {
					notOperational = false;
					ec2Response.setStatus(ase.getMessage());
					logger.error(ExceptionConstants.ASE_DESC_EC2, ase);
				} catch (AmazonClientException ace) {
					notOperational = false;
					ec2Response.setStatus(ace.getMessage());
					logger.error(ExceptionConstants.ASE_DESC_EC2, ace);
				}
			}
		}
	}

	private Instance getInstance(DescribeInstancesResult describeInstanceResult) {
		
		Instance instance;
		List<Instance> instances;
		List<Reservation> reservations;
		Reservation reservation;
		
		reservations =  describeInstanceResult.getReservations();
		reservation = reservations.get(0);
		instances = reservation.getInstances();
		instance = instances.get(0);
		
		return instance;
	}

	/**
	 * @param instance
	 * @param ec2Response
	 */
	private void setEC2Response(Instance instance,
			Ec2InstanceResponse ec2Response) {
		
		ec2Response.setState(InstanceStateName.Running.toString());
		ec2Response.setLaunchTime(instance.getLaunchTime().toString());
		ec2Response.setPublicDnsName(instance.getPublicDnsName());
		ec2Response.setPrivateDnsName(instance.getPrivateDnsName());
	}

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(DescribeEC2Controller.class.getName());

}
