package project;
import java.io.Serializable;
import java.util.Vector ; 
/** 
 * Class Admin extending Employee class.
*/
public class Admin extends Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	/** Field vector of users */
	private static Vector<User> users;
	{
		new Vector<User>();
	}
	
	public Admin (){} 
	/** 
     * Constructor - creating a new object with specific values
     * @param name
     * @param login
     * @param password
     * @param salary
     * @see Admin#Admin()
     */
	public Admin(String name, String login, String password, int salary) {
		super(name, login, password, salary);
	}
	public Admin(String name, String login, String password) {
		super(name, login, password);
	}
	/**
	 * This method is used to add user to users vector.
	 * @param user This is the parameter to choose what user
	 */
	public static void addUser(User user) {
		users.add(user) ; 		
	}
	/**
	 * This method is used to remove user from users vector.
	 * @param user This is the parameter to choose what user
	 */
	public static void removeUser(User user) {
		users.remove(user) ;
	}
	/**
	 * This method is used to see actions which user made.
	 * @param user This is the parameter to choose what user
	 */
	public static void seeUserActions(User user) {
		User to = DataBase.getInstance().getUser(user);
		System.out.println(to.getActions());
	}

	
}
