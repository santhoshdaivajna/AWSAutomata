package com.automata.cloudcore.model;

// TODO: Auto-generated Javadoc
/**
 * The Class SQSSendMessage.
 */
public class SQSSendMessage {

	/** The queue url. */
	private String queueUrl;
	
	/** The message body. */
	private String messageBody;

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
	 * Gets the message body.
	 *
	 * @return the message body
	 */
	public String getMessageBody() {
		return messageBody;
	}

	/**
	 * Sets the message body.
	 *
	 * @param messageBody the new message body
	 */
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SQSSendMessage [messageBody=");
		stringBuilder.append(messageBody);
		stringBuilder.append(", queueUrl=");
		stringBuilder.append(queueUrl);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
