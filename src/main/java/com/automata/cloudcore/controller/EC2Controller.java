package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.automata.cloudcore.model.EC2Model;
import com.automata.cloudcore.service.aws.ec2.IEC2;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.Ec2InstanceResponse;
import com.automata.cloudcore.xmlbindings.Ec2InstanceType;

/**
 * The Class EC2Controller. EC2Controller launches the EC2 instances and updates
 * the Automata object with the instance details.
 */

@Component
public class EC2Controller implements IController {

	/** The ec2. */
	@Autowired
	private IEC2 ec2;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.automata.cloudcore.controller.IController#execute(java.lang.Object)
	 */
	public Object execute(Object obj) throws Exception {

		obj = launchEc2Instances(obj);
		return obj;
	}

	/**
	 * Launch ec2 instances and update the automata object with the instance
	 * details
	 * 
	 * @param obj
	 *            the obj
	 * @return the automata object
	 */

	private Object launchEc2Instances(Object obj) {

		Automata automata = null;
		List<Ec2InstanceType> ec2Instances = null;
		EC2Model ec2Model = null;
		RunInstancesResult runInstancesResult = null;
		List<Instance> instanceList = null;
		List<Ec2InstanceResponse> instanceDetailsList = null;
		Ec2InstanceResponse instanceDetails = null;

		automata = (Automata) obj;
		ec2Instances = automata.getResources().getEc2Instance();
		instanceDetailsList = new ArrayList<Ec2InstanceResponse>();

		for (Ec2InstanceType ec2Instance : ec2Instances) {
			
			try {
				ec2Model = new EC2Model(ec2Instance);
				ec2.setEndPoint(ec2Instance.getRegion());
				runInstancesResult = ec2.launchServer(ec2Model);
				instanceList = runInstancesResult.getReservation().getInstances();

				for (Instance instance : instanceList) {
					instanceDetails = new Ec2InstanceResponse();
					copyInstanceDetails(instanceDetails, ec2Instance, instance);
					instanceDetailsList.add(instanceDetails);
				}
			} catch (AmazonServiceException ase) {
				instanceDetails = setStatusOnException(ec2Instance, ase);
				instanceDetailsList.add(instanceDetails);
				logger.error("AmazonServiceException while launching the server "
						+ ase.getMessage(), ase);
			} catch (AmazonClientException ace) {
				instanceDetails = setStatusOnException(ec2Instance, ace);
				instanceDetailsList.add(instanceDetails);
				logger.error("AmazonClientException thrown while calling launchInstance",ace);
			} catch (Exception e) {
				instanceDetails = setStatusOnException(ec2Instance, e);
				instanceDetailsList.add(instanceDetails);
				logger.error("Exception thrown while calling launchInstance", e);
			}
		}
		automata.getOutputs().setInstanceDetails(instanceDetailsList);
		return automata;
	}

	private Ec2InstanceResponse setStatusOnException(
			Ec2InstanceType ec2Instance, Exception e) {
	
		Ec2InstanceResponse instanceDetails;
		instanceDetails = new Ec2InstanceResponse();
		
		if (e instanceof AmazonServiceException) {
			AmazonServiceException ase = (AmazonServiceException) e;
			instanceDetails.setStatus(ase.getMessage());
		} else if (e instanceof AmazonClientException) {
			AmazonClientException ace = (AmazonClientException) e;
			instanceDetails.setStatus(ace.getMessage());
		} else {
			instanceDetails.setStatus(e.getMessage());
		}
		instanceDetails.setImageId(ec2Instance.getAMI());
		instanceDetails.setInstanceType(ec2Instance.getInstanceType());
		instanceDetails.setAvailabilityZone(ec2Instance.getAvailabilityZone());
		
		return instanceDetails;
	}

	private Ec2InstanceResponse copyInstanceDetails(Ec2InstanceResponse instanceDetails,
			Ec2InstanceType ec2Instance, Instance instance) {
		
		instanceDetails.setImageId(instance.getImageId());
		instanceDetails.setInstanceId(instance.getInstanceId());
		instanceDetails.setInstanceType(instance.getInstanceType());
		instanceDetails.setKeyName(instance.getKeyName());
		instanceDetails.setState(instance.getState().getName());
		instanceDetails.setLaunchTime(instance.getLaunchTime().toString());
		instanceDetails.setMonitoring(instance.getMonitoring().getState());
		instanceDetails.setAvailabilityZone(instance.getPlacement().getAvailabilityZone());
		instanceDetails.setPublicDnsName(instance.getPublicDnsName());
		instanceDetails.setPrivateDnsName(instance.getPrivateDnsName());
		instanceDetails.setPrivateIpAddress(instance.getPrivateIpAddress());
		instanceDetails.setPublicIpAddress(instance.getPublicIpAddress());
		instanceDetails.setArchitecture(instance.getArchitecture());
		instanceDetails.setKernelId(instance.getKernelId());
		instanceDetails.setRootDeviceName(instance.getRootDeviceName());
		instanceDetails.setRootDeviceType(instance.getRootDeviceType());
		instanceDetails.setVirtualizationType(instance.getVirtualizationType());
		instanceDetails.setLoadBalancerName(ec2Instance.getLBName());
		instanceDetails.setRegion(ec2Instance.getRegion());
		instanceDetails.setStatus("Instance successfully launched");
		return instanceDetails;
	}

	private static final Logger logger = LoggerFactory.getLogger(EC2Controller.class.getName());

}
