package trivia;

import java.io.Serializable;
import java.time.Instant;
import java.util.Vector;

import project.Employee;

public class Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Vector<String> messages = new Vector<String>();
	Message(){}
	public Vector<String> getHistory(){
		return this.messages;
	}
	public void showHistory() {
		for(String m: messages) {
			System.out.println(m+"\n");
		}
	}
	public void addMessage(Employee e, String header, String body) {
		messages.add(e.getName()+" "+Instant.now()+"\n"+header+"\n"+body);	
	}
}
