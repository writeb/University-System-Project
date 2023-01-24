package project;

import java.io.Serializable;
import Study.Teacher;

/** 
 * Class OR extending Employee class.
*/
public class OR extends Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	/** Field isRegisterTime for registration course */
	private static boolean isRegisterTime = false;;
	public OR() {
		
	}
	/** 
     * Constructor - creating a new object with specific values
     * @param name
     * @param login
     * @param password
     * @param salary
     * @see OR#OR()
     */
	public OR(String name, String login, String password, int salary) {
		super(name, login, password, salary);
	}
	public OR(String name, String login, String password) {
		super(name, login, password);
	}
	/**
	 * This method is used to approve Student's registration for Course if it's register time.
	 * @param student This is the first parameter to choose what student
	 * @param course This is the second parameter to choose what course
	 */
	public static boolean approveRegistration(Student student, Course course) {
		return isRegisterTime==true ;
	}
	/**
	 * This method is used to close registration.
	 */
	public static void closeRegister() {
		isRegisterTime=false;
	}
	/**
	 * This method is used to open registration.
	 */
	public static void openRegister() {
		isRegisterTime=true;
	}
	/**
	 * This method is used to assign some course to teacher.
	 * @param teacher This is the first parameter to choose what teacher
	 * @param course This is the second parameter to choose what course
	 */
	public static void assignCourseToTeacher(Teacher teacher, Course course) {
		User to = DataBase.getInstance().getUser(teacher);
		if(to instanceof Teacher) {
			((Teacher) to).addCourse(course);
		}
	}
	/**
	 * This method is used to view information of some user.
	 * @param user This is the first parameter to choose what user
	 */
	public void viewInfo(User user) {
		User to = DataBase.getInstance().getUser(user);
		System.out.println(to.toString());
	}
}