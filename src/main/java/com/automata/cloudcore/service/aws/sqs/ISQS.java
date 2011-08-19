package com.automata.cloudcore.service.aws.sqs;

import java.util.List;
import java.util.Map;

import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.automata.cloudcore.model.SQSReceiveMessage;
import com.automata.cloudcore.model.SQSSendMessage;

public interface ISQS {

	public abstract CreateQueueResult createQueue(String queueName)
			throws Exception;

	public abstract String deleteQueue(String queueName) throws Exception;

	public abstract List<String> listQueues() throws Exception;

	public abstract List<String> listQueuesWithInputFilters(String filterStr)
			throws Exception;

	public abstract ReceiveMessageResult recieveMessage(
			SQSReceiveMessage message) throws Exception;

	public abstract SendMessageResult sendMessage(SQSSendMessage message)
			throws Exception;

	public abstract Map<String, String> getQueueAttributes(String queueName)
			throws Exception;

}