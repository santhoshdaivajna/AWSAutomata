package com.automata.cloudcore.service.aws.sqs;

import java.util.List;
import java.util.Map;

import com.amazonaws.services.sqs.model.CreateQueueResult;

public class SQSUtilityTester {
	
	public static void main(String args[]) throws Exception {
	
	SQSUtilityTester squ = new SQSUtilityTester();
	squ.testCreateQueue("harishQ209");
	squ.testCreateQueue("harishQ2090");
	squ.testCreateQueue("harishQ2009");
	Thread.sleep(25000);
	List<String> list 	= 	squ.testListQueues();
	//list = squ.testListQueuesWithInputFilter("https://queue.amazonaws.com/841764865526/harishQ2000");
	list = squ.testListQueuesWithInputFilter("har");
	if(list!=null){
		for(int count =0 ; count<list.size();count++){
			squ.testGetQueueAttributes(list.get(count));
			//squ.testDeleteQueue(list.get(count));
		}
	}
	Thread.sleep(25000);	
	list	=	null;
	list 	= 	squ.testListQueues();	
	}
	
	public void testCreateQueue(String queuename) throws Exception{
		try{
			ISQS sqsu = new SQSImpl();
			CreateQueueResult result 	= sqsu.createQueue(queuename);
			System.out.println("SQSUtilityTester queue creation status :"+result);
		}catch(Exception e){
			System.out.println("SQSUtilityTester testCreateQueue Exception :" + e.getMessage());
			throw new Exception();
		}
	}
	
	public List<String> testListQueues() throws Exception{
		List<String> qlist = null;
		try{
			ISQS sqsu = new SQSImpl();
			qlist 	= sqsu.listQueues();
			System.out.println("SQSUtilityTester queue list status :"+qlist);
		}catch(Exception e){
			System.out.println("SQSUtilityTester testListQueues Exception :" + e.getMessage());
			throw new Exception();
		}
		return qlist;
	}
	
	public List<String> testListQueuesWithInputFilter(String filterStr) throws Exception{
		List<String> qlist = null;
		try{
			ISQS sqsu = new SQSImpl();
			qlist 	= sqsu.listQueuesWithInputFilters(filterStr);
			System.out.println("SQSUtilityTester queue list status with filter:"+qlist);
		}catch(Exception e){
			System.out.println("SQSUtilityTester testListQueuesWithInputFilter Exception :" + e.getMessage());
			throw new Exception();
		}
		return qlist;
	}
	
	public void testDeleteQueue(String queuename) throws Exception{
		try{
			ISQS sqsu = new SQSImpl();
			String result =	sqsu.deleteQueue(queuename);
			System.out.println("SQSUtilityTester queue delete status :"+result);
		}catch(Exception e){
			System.out.println("SQSUtilityTester testDeleteQueues Exception :" + e.getMessage());
			throw new Exception();
		}
	}
	
	
	public void testGetQueueAttributes(String queuename) throws Exception{
		try{
			ISQS sqsu = new SQSImpl();
			Map<String,String> result=	sqsu.getQueueAttributes(queuename);
			System.out.println("SQSUtilityTester queue attributes :"+result);
		}catch(Exception e){
			System.out.println("SQSUtilityTester testGetQueueAttributes Exception :" + e.getMessage());
			throw new Exception();
		}
	}
	
}