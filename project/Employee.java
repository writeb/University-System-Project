package project;

import java.io.Serializable;

import trivia.Message;
import trivia.Request;
/** 
 * Class Employee extending User class.
*/
public class Employee extends User implements Serializable{
	private static final long serialVersionUID = 1L;
	/** Field salary of employee */
	private int salary;
	/** Field messages */
	private Message messages;
	/** Field request */
	private Request request;
	public Employee() {
		super();
	}
	public Employee( String name , String login, String password) {
		super( password, password, password);
	}
	/** 
     * Constructor - creating a new object with specific values
     * @param name
     * @param login
     * @param password
     * @param salary
     * @see Employee#Employee()
     */
	public Employee( String name , String login, String password, int salary) {
		super(password, password, password);
		this.salary = salary;
	}
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		super.notifyAdmin("setting salary");
		this.salary = salary;
	}
	public String toString() {
		return super.toString()+" salary:"+salary;
	}
	/**
	 * This method is used to send message to other employee, and it notifies admin about 
	 * user action - send message.
	 * @param e This is the first parameter to choose what employee
	 * @param header This is the second parameter
	 * @param body This is the third parameter
	 */
	public void sendMessage(Employee e, String header, String body) {
		super.notifyAdmin("sending message, ");
		User to = DataBase.getInstance().getUser((User) e);
		if(to instanceof Employee){
			Employee emp = (Employee) to;
			emp.getMessage(this,header,body);
		}
		
	}
	private void getMessage(Employee e, String header, String body) {
		super.notifyAdmin("geting message, ");
		this.messages.addMessage(e, header, body);
	}
	/**
	 * This method is used to send request, if Department manager approves the request, it also notifies admin about 
	 * user action - send request.
	 */
	public void sendRequest() {
		super.notifyAdmin("sending request, ");
		if(Department.approveRequest(request)) {
			System.out.println("Request approved");
		}else {
			System.out.println("Requesr not approved");
		}
	}

}
