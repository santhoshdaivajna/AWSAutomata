package com.automata.cloudcore.service.aws.sqs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.DeleteQueueRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesResult;
import com.amazonaws.services.sqs.model.ListQueuesRequest;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.automata.cloudcore.model.SQSReceiveMessage;
import com.automata.cloudcore.model.SQSSendMessage;

@Component
public class SQSImpl implements ISQS {

	private static AmazonSQS sqs;

	public SQSImpl() throws Exception {
		init();
	}

	public CreateQueueResult createQueue(String queueName) {

		CreateQueueResult result = null;
		CreateQueueRequest request = null;
		request = new CreateQueueRequest(queueName);
		result = sqs.createQueue(request);
		logger.info("SQSImpl.createQueue Queue :" + queueName + " result :"
				+ result.toString() + " Successfully created");
		return result;
	}

	public String deleteQueue(String queueName) {

		DeleteQueueRequest dqrequest = null;
		String result = "F";
		dqrequest = new DeleteQueueRequest(queueName);
		sqs.deleteQueue(dqrequest);
		logger.info("SQSImpl.deleteQueue Queue :" + queueName
				+ " Successfully deleted");
		result = "S";
		return result;
	}

	public List<String> listQueues() {

		ListQueuesResult lqresult = null;
		lqresult = sqs.listQueues();
		logger.info("SQSImpl.listQueues QueueList :" + lqresult);
		if (lqresult != null) {
			return lqresult.getQueueUrls();
		} else {
			return null;
		}
	}

	public List<String> listQueuesWithInputFilters(String filterStr) {

		ListQueuesRequest lqrequest = null;
		ListQueuesResult lqresult = null;
		lqrequest = new ListQueuesRequest(filterStr);
		lqresult = sqs.listQueues(lqrequest);
		logger
				.info("SQSImpl.listQueuesWithInputFilters QueueList :"
						+ lqresult);
		if (lqresult != null) {
			return lqresult.getQueueUrls();
		} else {
			return null;
		}
	}

	public ReceiveMessageResult recieveMessage(SQSReceiveMessage message) {
		ReceiveMessageRequest request = null;
		ReceiveMessageResult result = null;
		request = new ReceiveMessageRequest();

		request.withQueueUrl(message.getQueueUrl()).withAttributeNames(
				message.getAttributeNames()).withMaxNumberOfMessages(
				message.getMaxNumberOfMessages()).withVisibilityTimeout(
				message.getVisibilityTimeout());
		result = sqs.receiveMessage(request);
		return result;
	}

	public SendMessageResult sendMessage(SQSSendMessage message) {
		SendMessageRequest request;
		SendMessageResult result;
		request = new SendMessageRequest();
		request.withQueueUrl(message.getQueueUrl()).withMessageBody(
				message.getMessageBody());

		result = sqs.sendMessage(request);
		return result;
	}

	public Map<String, String> getQueueAttributes(String queueName)
			throws Exception {

		GetQueueAttributesRequest gqarequest = null;
		GetQueueAttributesResult gqaresult = null;

		gqarequest = new GetQueueAttributesRequest(queueName);
		gqaresult = sqs.getQueueAttributes(gqarequest);
		logger.info("SQSImpl.getQueueAttributes Queue :" + queueName
				+ " Attributes	:" + gqaresult + " Successfully executed");

		if (gqaresult != null) {
			return gqaresult.getAttributes();
		} else {
			return null;
		}
	}

	private void init() throws FileNotFoundException, IllegalArgumentException,
			IOException {
		AWSCredentials credentials;
		credentials = new PropertiesCredentials(new File(
				"AwsCredentials.properties"));
		sqs = new AmazonSQSClient(credentials);
	}

	private Logger logger = LoggerFactory.getLogger(SQSImpl.class.getName());

}
