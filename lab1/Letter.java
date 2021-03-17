package labs.lab1;

/**
 * This class models a simple letter.
 */
public class Letter {
	private String sender;
	private String recipient;
	private String body="";

	/**
	 * Constructs a letter with a given sender and recipient.
	 * 
	 * @param from the sender
	 * @param to   the recipient
	 */
	public Letter(String from, String to) {
		sender = from;
		recipient = to;
	}

	/**
	 * Adds a line to the body of this letter.
	 */
	public void addLine(String line) {
		body += line;
		body +='\n';
	}

	/**
	 * Gets the body of this letter.
	 */
	public String getText() {
		String str1 = "Dear " + recipient +":";
		str1 += '\n';
		str1 += '\n';
		str1 += body;
		str1 += '\n';
		String str2 = "Sincerely,";
		str2 += '\n';
		str2 += '\n';
		str1 = str1 + str2 + sender;
		return str1;
	}
}
