package com.automata.cloudcore.service.aws.elb;

import java.util.List;

import com.amazonaws.services.elasticloadbalancing.model.CreateAppCookieStickinessPolicyResult;
import com.amazonaws.services.elasticloadbalancing.model.CreateLBCookieStickinessPolicyResult;
import com.amazonaws.services.elasticloadbalancing.model.CreateLoadBalancerResult;
import com.amazonaws.services.elasticloadbalancing.model.DeregisterInstancesFromLoadBalancerResult;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancersResult;
import com.amazonaws.services.elasticloadbalancing.model.DisableAvailabilityZonesForLoadBalancerResult;
import com.amazonaws.services.elasticloadbalancing.model.EnableAvailabilityZonesForLoadBalancerResult;
import com.amazonaws.services.elasticloadbalancing.model.Instance;
import com.amazonaws.services.elasticloadbalancing.model.RegisterInstancesWithLoadBalancerResult;
import com.amazonaws.services.elasticloadbalancing.model.SetLoadBalancerPoliciesOfListenerResult;
import com.automata.cloudcore.model.ELBModel;
import com.automata.cloudcore.xmlbindings.CreateAppCookieStickinessPolicyType;
import com.automata.cloudcore.xmlbindings.CreateLBCookieStickinessPolicyType;
import com.automata.cloudcore.xmlbindings.DeleteLoadBalancerType;
import com.automata.cloudcore.xmlbindings.DescribeLoadBalancersType;

public interface ILoadBalancer {

	public  CreateLoadBalancerResult createLoadBalancer(ELBModel request);

	public  DescribeLoadBalancersResult describeLoadBalancer(
			String endPoint, List<String> loadBalancerNames);

	public  RegisterInstancesWithLoadBalancerResult registerInstanceWithLB(
			String endPoint, String loadBalancerName, List<Instance> instances);

	public  DeregisterInstancesFromLoadBalancerResult deregisterInstanceWithLB(
			String endPoint, String loadBalancerName, List<Instance> instances);

	public  DisableAvailabilityZonesForLoadBalancerResult disableAvailabilityZonesForLoadBalancer(
			String endPoint, String loadBalancerName,
			List<String> availabilityZones);

	public  EnableAvailabilityZonesForLoadBalancerResult enableAvailabilityZonesForLoadBalancer(
			String endPoint, String loadBalancerName,
			List<String> availabilityZones);

	public  CreateLBCookieStickinessPolicyResult createLBCookieStickinessPolicy(
			String endPoint, String loadBalancerName,
			Long cookieExpirationPeriod, String policyName);

	public  SetLoadBalancerPoliciesOfListenerResult setLoadBalancerPoliciesOfListener(
			String endPoint, String loadBalancerName, Integer loadBalancerPort,
			List<String> policyNames);

	public  String getLoadBalancerEndPoint(String region);

	public  void deleteLoadBalancer(DeleteLoadBalancerType loadBalancer);

	public  DescribeLoadBalancersResult describeLoadBalancer(
			DescribeLoadBalancersType describeLoadBalancersType);

	public CreateAppCookieStickinessPolicyResult createAppCookieStickinessPolicy(
			CreateAppCookieStickinessPolicyType appCookie);

	public CreateLBCookieStickinessPolicyResult createLBCookieStickinessPolicy(
			CreateLBCookieStickinessPolicyType lbCookie);

}