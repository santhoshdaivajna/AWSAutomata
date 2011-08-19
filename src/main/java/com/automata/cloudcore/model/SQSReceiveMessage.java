package com.automata.cloudcore.model;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class SQSReceiveMessage.
 */
public class SQSReceiveMessage {

	/** The queue url. */
	private String queueUrl;
	
	/** The attribute names. */
	private List<String> attributeNames;
	
	/** The max number of messages. */
	private Integer maxNumberOfMessages;
	
	/** The visibility timeout. */
	private Integer visibilityTimeout;

	/**
	 * Gets the queue url.
	 *
	 * @return the queue url
	 */
	public String getQueueUrl() {
		return queueUrl;
	}

	/**
	 * Sets the queue url.
	 *
	 * @param queueUrl the new queue url
	 */
	public void setQueueUrl(String queueUrl) {
		this.queueUrl = queueUrl;
	}

	/**
	 * Gets the attribute names.
	 *
	 * @return the attribute names
	 */
	public List<String> getAttributeNames() {
		return attributeNames;
	}

	/**
	 * Sets the attribute names.
	 *
	 * @param attributeNames the new attribute names
	 */
	public void setAttributeNames(List<String> attributeNames) {
		this.attributeNames = attributeNames;
	}

	/**
	 * Gets the max number of messages.
	 *
	 * @return the max number of messages
	 */
	public Integer getMaxNumberOfMessages() {
		return maxNumberOfMessages;
	}

	/**
	 * Sets the max number of messages.
	 *
	 * @param maxNumberOfMessages the new max number of messages
	 */
	public void setMaxNumberOfMessages(Integer maxNumberOfMessages) {
		this.maxNumberOfMessages = maxNumberOfMessages;
	}

	/**
	 * Gets the visibility timeout.
	 *
	 * @return the visibility timeout
	 */
	public Integer getVisibilityTimeout() {
		return visibilityTimeout;
	}

	/**
	 * Sets the visibility timeout.
	 *
	 * @param visibilityTimeout the new visibility timeout
	 */
	public void setVisibilityTimeout(Integer visibilityTimeout) {
		this.visibilityTimeout = visibilityTimeout;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SQSReceiveMessage [attributeNames=");
		stringBuilder.append(attributeNames);
		stringBuilder.append(", maxNumberOfMessages=");
		stringBuilder.append(maxNumberOfMessages);
		stringBuilder.append(", queueUrl=");
		stringBuilder.append(queueUrl);
		stringBuilder.append(", visibilityTimeout=");
		stringBuilder.append(visibilityTimeout);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
