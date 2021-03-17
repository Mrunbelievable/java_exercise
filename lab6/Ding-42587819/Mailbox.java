package labs.lab6;
import java.util.ArrayList;
/**
 * An email mailbox.
 */
public class Mailbox {
	// ADD YOUR INSTANCE VARIABLES HERE
	private String user;
	private ArrayList<Message> list = new ArrayList<Message>();
	/**
	 * Constructs a Mailbox object.
	 * 
	 * @param u the user
	 */
	public Mailbox(String u) {
		user = u;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user of this mailbox
	 */
	public String getUser() {
		
		return user;
	}

	/**
	 * Adds a message to the list.
	 * 
	 * @param m the message to add
	 */
	public void addMessage(Message m) {
		list.add(m);
	}

	/**
	 * Retrieves all of the messages, 
	 * with a line of 5 dashes (-----) between each message
	 */
	public String getAllMessages() {
		String str = "";
		for(int i=0; i<list.size(); i++) {
			str += " -----\n";
			str += list.get(i).toString();
		}
		return str;
	}
}
