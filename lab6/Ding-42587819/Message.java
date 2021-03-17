package labs.lab6;

/**
 * An email message.
 */
public class Message {
	// ADD YOUR INSTANCE VARIABLES HERE
	private String sender;
	private String recipient;
	private String text;
	/**
	 * Constructs a Message object.
	 * 
	 * @param from the sender of the message
	 */
	public Message(String from, String to, String text) {
		// FILL IN
		sender = from;
		recipient = to;
		this.text = text;
	}

	/**
	 * Gets the recipient.
	 * 
	 * @return the recipient
	 */
	public String getRecipient() {
		return recipient;
	}

	/**
	 * Formats the email message as follows (see assignment example):
	 * From: [sender]
	 * To: [recipient]
	 * [Message text]
	 */
	public String toString() {
		String str = "";
		str += "From: " + sender + '\n';
		str += "To: " + recipient + '\n';
		str += text;
		return str; 
	}
}
