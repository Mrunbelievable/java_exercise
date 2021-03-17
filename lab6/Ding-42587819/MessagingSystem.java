package labs.lab6;

import java.util.ArrayList;

/**
 * An email messaging system.
 */
public class MessagingSystem {
	// ADD YOUR INSTANCE VARIABLES HERE
	private ArrayList<Mailbox> list;
	/**
	 * Constructs a MessagingSystem object
	 */
	public MessagingSystem() {
		list = new ArrayList<Mailbox>();
	}

	/**
	 * Delivers a message to the recipient.
	 * 
	 * @param sender 		the sender's username
	 * @param recipient 	the recipient's username
	 * @param text			the text of the message
	 */
	public void deliver(String sender, String recipient, String text) {
		Message m = new Message(sender, recipient, text);
		boolean exit = false;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getUser().equals(recipient)) {
				exit = true;
			}
		}
		if(exit == false) {
			Mailbox mailbox = new Mailbox(recipient);
			list.add(mailbox);
		}
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getUser().equals(recipient)) {
				list.get(i).addMessage(m);
			}
		}
	}

	/**
	 * Retrieves the messages for a user
	 * (by calling Mailbox.getAllMessages())
	 * 
	 * @param user the user
	 */
	public String getMessages(String user) {
		String str = "";
		for(int i=0; i<list.size(); i++) {
			if(user.equals(list.get(i).getUser())) {
				str += list.get(i).getAllMessages();
			}
		}
		return str;
	}
}
