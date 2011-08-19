package com.automata.cloudcore.service.aws.elb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancing;
import com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingClient;
import com.amazonaws.services.elasticloadbalancing.model.CreateAppCookieStickinessPolicyRequest;
import com.amazonaws.services.elasticloadbalancing.model.CreateAppCookieStickinessPolicyResult;
import com.amazonaws.services.elasticloadbalancing.model.CreateLBCookieStickinessPolicyRequest;
import com.amazonaws.services.elasticloadbalancing.model.CreateLBCookieStickinessPolicyResult;
import com.amazonaws.services.elasticloadbalancing.model.CreateLoadBalancerRequest;
import com.amazonaws.services.elasticloadbalancing.model.CreateLoadBalancerResult;
import com.amazonaws.services.elasticloadbalancing.model.DeleteLoadBalancerRequest;
import com.amazonaws.services.elasticloadbalancing.model.DeregisterInstancesFromLoadBalancerRequest;
import com.amazonaws.services.elasticloadbalancing.model.DeregisterInstancesFromLoadBalancerResult;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancersRequest;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancersResult;
import com.amazonaws.services.elasticloadbalancing.model.DisableAvailabilityZonesForLoadBalancerRequest;
import com.amazonaws.services.elasticloadbalancing.model.DisableAvailabilityZonesForLoadBalancerResult;
import com.amazonaws.services.elasticloadbalancing.model.EnableAvailabilityZonesForLoadBalancerRequest;
import com.amazonaws.services.elasticloadbalancing.model.EnableAvailabilityZonesForLoadBalancerResult;
import com.amazonaws.services.elasticloadbalancing.model.Instance;
import com.amazonaws.services.elasticloadbalancing.model.RegisterInstancesWithLoadBalancerRequest;
import com.amazonaws.services.elasticloadbalancing.model.RegisterInstancesWithLoadBalancerResult;
import com.amazonaws.services.elasticloadbalancing.model.SetLoadBalancerPoliciesOfListenerRequest;
import com.amazonaws.services.elasticloadbalancing.model.SetLoadBalancerPoliciesOfListenerResult;
import com.automata.cloudcore.constants.Constants;
import com.automata.cloudcore.model.ELBModel;
import com.automata.cloudcore.util.RegionInfo;
import com.automata.cloudcore.xmlbindings.CreateAppCookieStickinessPolicyType;
import com.automata.cloudcore.xmlbindings.CreateLBCookieStickinessPolicyType;
import com.automata.cloudcore.xmlbindings.DeleteLoadBalancerType;
import com.automata.cloudcore.xmlbindings.DescribeLoadBalancersType;
@Component
public class LoadBalancerImpl implements ILoadBalancer {

	private AmazonElasticLoadBalancing elb;

	public  LoadBalancerImpl( ) throws Exception {
		init();
	}
	
	public CreateLoadBalancerResult createLoadBalancer(ELBModel request) {

		CreateLoadBalancerRequest createLoadBalancerRequest;
		CreateLoadBalancerResult createLoadBalancerResult;
		
		elb.setEndpoint(request.getEndPoint());
		createLoadBalancerRequest = new CreateLoadBalancerRequest();
		createLoadBalancerRequest.setLoadBalancerName(request.getLoadBalancerName());
		createLoadBalancerRequest.setAvailabilityZones(request.getAvailabilityZones());
		createLoadBalancerRequest.setListeners(request.getListeners());
		createLoadBalancerResult = elb.createLoadBalancer(createLoadBalancerRequest);
		
		return createLoadBalancerResult;
	}
	
	public DescribeLoadBalancersResult describeLoadBalancer(String endPoint,
			List<String> loadBalancerNames)  {

		DescribeLoadBalancersRequest describeLoadBalancersRequest;
		DescribeLoadBalancersResult describeLoadBalancersResult;
		
		elb.setEndpoint(endPoint);
		describeLoadBalancersRequest = new DescribeLoadBalancersRequest();
		describeLoadBalancersRequest.setLoadBalancerNames(loadBalancerNames);
		describeLoadBalancersResult = elb.describeLoadBalancers();
		
		return describeLoadBalancersResult;
	}
	
	public RegisterInstancesWithLoadBalancerResult registerInstanceWithLB(
			String endPoint, String loadBalancerName, List<Instance> instances) {

		RegisterInstancesWithLoadBalancerRequest registerInstancesWithLoadBalancerRequest 	= null;
		RegisterInstancesWithLoadBalancerResult registerInstancesWithLoadBalancerResult 	= null;
		
		elb.setEndpoint(endPoint);
		registerInstancesWithLoadBalancerRequest = new RegisterInstancesWithLoadBalancerRequest();
		registerInstancesWithLoadBalancerRequest.setLoadBalancerName(loadBalancerName);
		registerInstancesWithLoadBalancerRequest.setInstances(instances);
		registerInstancesWithLoadBalancerResult = elb
				.registerInstancesWithLoadBalancer(registerInstancesWithLoadBalancerRequest);

		return registerInstancesWithLoadBalancerResult;
	}
	
	public DeregisterInstancesFromLoadBalancerResult deregisterInstanceWithLB(
			String endPoint, String loadBalancerName, List<Instance> instances) {

		DeregisterInstancesFromLoadBalancerRequest deregisterInstancesFromLoadBalancerRequest;
		DeregisterInstancesFromLoadBalancerResult deregisterInstancesFromLoadBalancerResult;
		
		elb.setEndpoint(endPoint);
		deregisterInstancesFromLoadBalancerRequest = new DeregisterInstancesFromLoadBalancerRequest();
		deregisterInstancesFromLoadBalancerRequest
				.setLoadBalancerName(loadBalancerName);
		deregisterInstancesFromLoadBalancerRequest.setInstances(instances);

		deregisterInstancesFromLoadBalancerResult = elb
				.deregisterInstancesFromLoadBalancer(deregisterInstancesFromLoadBalancerRequest);
		return deregisterInstancesFromLoadBalancerResult;
	}
	
	public DisableAvailabilityZonesForLoadBalancerResult disableAvailabilityZonesForLoadBalancer(
			String endPoint, String loadBalancerName,
			List<String> availabilityZones){

		DisableAvailabilityZonesForLoadBalancerRequest disableAvailabilityZonesForLoadBalancerRequest;
		DisableAvailabilityZonesForLoadBalancerResult disableAvailabilityZonesForLoadBalancerResult;
		
		elb.setEndpoint(endPoint);
		disableAvailabilityZonesForLoadBalancerRequest = new DisableAvailabilityZonesForLoadBalancerRequest();
		disableAvailabilityZonesForLoadBalancerRequest.setLoadBalancerName(loadBalancerName);
		disableAvailabilityZonesForLoadBalancerRequest.setAvailabilityZones(availabilityZones);

		disableAvailabilityZonesForLoadBalancerResult = elb
				.disableAvailabilityZonesForLoadBalancer(disableAvailabilityZonesForLoadBalancerRequest);

		return disableAvailabilityZonesForLoadBalancerResult;
	}
	
	public EnableAvailabilityZonesForLoadBalancerResult enableAvailabilityZonesForLoadBalancer(
			String endPoint, String loadBalancerName,
			List<String> availabilityZones) {

		EnableAvailabilityZonesForLoadBalancerRequest enableAvailabilityZonesForLoadBalancerRequest;
		EnableAvailabilityZonesForLoadBalancerResult enableAvailabilityZonesForLoadBalancerResult;
		
		elb.setEndpoint(endPoint);
		enableAvailabilityZonesForLoadBalancerRequest = new EnableAvailabilityZonesForLoadBalancerRequest();
		enableAvailabilityZonesForLoadBalancerRequest.setLoadBalancerName(loadBalancerName);
		enableAvailabilityZonesForLoadBalancerRequest.setAvailabilityZones(availabilityZones);

		enableAvailabilityZonesForLoadBalancerResult = elb
				.enableAvailabilityZonesForLoadBalancer(enableAvailabilityZonesForLoadBalancerRequest);

		return enableAvailabilityZonesForLoadBalancerResult;
	}

	public CreateLBCookieStickinessPolicyResult createLBCookieStickinessPolicy(
			String endPoint, String loadBalancerName,
			Long cookieExpirationPeriod, String policyName){

		CreateLBCookieStickinessPolicyRequest createLBCookieStickinessPolicyRequest;
		CreateLBCookieStickinessPolicyResult createLBCookieStickinessPolicyResult;
		
		elb.setEndpoint(endPoint);
		createLBCookieStickinessPolicyRequest = new CreateLBCookieStickinessPolicyRequest();
		createLBCookieStickinessPolicyRequest.setLoadBalancerName(loadBalancerName);
		if (cookieExpirationPeriod != null){
			createLBCookieStickinessPolicyRequest.setCookieExpirationPeriod(cookieExpirationPeriod);
		}
		createLBCookieStickinessPolicyRequest.setPolicyName(policyName);
		createLBCookieStickinessPolicyResult = elb
				.createLBCookieStickinessPolicy(createLBCookieStickinessPolicyRequest);

		return createLBCookieStickinessPolicyResult;

	}
	
	public SetLoadBalancerPoliciesOfListenerResult setLoadBalancerPoliciesOfListener(
			String endPoint, String loadBalancerName, Integer loadBalancerPort,
			List<String> policyNames){

		SetLoadBalancerPoliciesOfListenerRequest setLoadBalancerPoliciesOfListenerRequest;
		SetLoadBalancerPoliciesOfListenerResult setLoadBalancerPoliciesOfListenerResult;
		elb.setEndpoint(endPoint);
		setLoadBalancerPoliciesOfListenerRequest = new SetLoadBalancerPoliciesOfListenerRequest();
		setLoadBalancerPoliciesOfListenerRequest.setLoadBalancerName(loadBalancerName);
		setLoadBalancerPoliciesOfListenerRequest.setLoadBalancerPort(loadBalancerPort);
		setLoadBalancerPoliciesOfListenerRequest.setPolicyNames(policyNames);

		setLoadBalancerPoliciesOfListenerResult = elb
				.setLoadBalancerPoliciesOfListener(setLoadBalancerPoliciesOfListenerRequest);
		return setLoadBalancerPoliciesOfListenerResult;
	}
	
	private void init() throws FileNotFoundException, IllegalArgumentException, IOException  {

		AWSCredentials credentials;
		credentials = new PropertiesCredentials(new File("AwsCredentials.properties"));
		elb = new AmazonElasticLoadBalancingClient(credentials);
	}

	public String getLoadBalancerEndPoint(String region) {

		String endPoint = "";
		RegionInfo regionInfo = null;
		regionInfo = new RegionInfo(Constants.ELB, region);
		endPoint = regionInfo.getEndPoint();
		return endPoint;
	}

	@Override
	public void deleteLoadBalancer(DeleteLoadBalancerType loadBalancer) {
		
		DeleteLoadBalancerRequest deleteLoadBalancerRequest;
		
		elb.setEndpoint(getLoadBalancerEndPoint(loadBalancer.getRegion()));
		deleteLoadBalancerRequest = new DeleteLoadBalancerRequest();
		deleteLoadBalancerRequest.setLoadBalancerName(loadBalancer.getLoadBalancerName());
		elb.deleteLoadBalancer(deleteLoadBalancerRequest);
		
	}

	public DescribeLoadBalancersResult describeLoadBalancer(
			DescribeLoadBalancersType describeLoadBalancers) {

		DescribeLoadBalancersRequest request = null;
		DescribeLoadBalancersResult result = null;
		List<String> loadBalancerNames = null;
		String endpoint;
		String region;

		region = describeLoadBalancers.getRegion();
		endpoint = getLoadBalancerEndPoint(region);
		elb.setEndpoint(endpoint);
		request = new DescribeLoadBalancersRequest();
		if ( describeLoadBalancers.getLoadBalancerNames() != null){
			loadBalancerNames = describeLoadBalancers.getLoadBalancerNames()
			.getMember();
			if (loadBalancerNames != null) {
				request.setLoadBalancerNames(loadBalancerNames);
				result = elb.describeLoadBalancers(request);
			}
		}
		return result;
	}
	
	@Override
	public CreateAppCookieStickinessPolicyResult createAppCookieStickinessPolicy(
			CreateAppCookieStickinessPolicyType appCookie) {
		
		CreateAppCookieStickinessPolicyRequest createAppCookieStickinessPolicyRequest;
		CreateAppCookieStickinessPolicyResult createAppCookieStickinessPolicyResult;
		String endPoint = "";
		
		endPoint = getLoadBalancerEndPoint(appCookie.getRegion());
		elb.setEndpoint(endPoint);
		createAppCookieStickinessPolicyRequest = new CreateAppCookieStickinessPolicyRequest();
		createAppCookieStickinessPolicyRequest.setLoadBalancerName(appCookie.getLoadBalancerName());
		createAppCookieStickinessPolicyRequest.setCookieName(appCookie.getCookieName());
		createAppCookieStickinessPolicyRequest.setPolicyName(appCookie.getPolicyName());
		createAppCookieStickinessPolicyResult = elb
				.createAppCookieStickinessPolicy(createAppCookieStickinessPolicyRequest);

		return createAppCookieStickinessPolicyResult;
	}

	@Override
	public CreateLBCookieStickinessPolicyResult createLBCookieStickinessPolicy(
			CreateLBCookieStickinessPolicyType lbCookie ) {
		
		CreateLBCookieStickinessPolicyRequest request;
		CreateLBCookieStickinessPolicyResult result;
		Long cookieExpirationPeriod;
		String endPoint = "";
		
		endPoint = getLoadBalancerEndPoint(lbCookie.getRegion()); 
		cookieExpirationPeriod = lbCookie.getCookieExpirationPeriod();
		elb.setEndpoint(endPoint);
		
		request = new CreateLBCookieStickinessPolicyRequest();
		request.setLoadBalancerName(lbCookie.getLoadBalancerName());
		if (cookieExpirationPeriod  != null){
			request.setCookieExpirationPeriod(cookieExpirationPeriod);
		}
		request.setPolicyName(lbCookie.getPolicyName());
		result = elb.createLBCookieStickinessPolicy(request);

		return result;
	}
	
	private static Logger logger = LoggerFactory.getLogger(LoadBalancerImpl.class.getName());
}
