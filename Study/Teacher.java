package Study;

import java.io.Serializable;
import java.util.Vector;

import project.User;
import project.Faculty;
import project.Course;
import project.DataBase;
import project.Employee;
import project.Student;


public class Teacher extends Employee implements Serializable{
	public Teacher(String name, String login, String password, int salary) {
		super(name, login, password, salary);
	}
	public Teacher(String name, String login, String password) {
		super(name, login, password);
	}
	public Teacher(String name, String login, String password, int salary, Faculty faculty) {
		super(name, login, password, salary);
		this.faculty = faculty;
	}
	private static final long serialVersionUID = 1L;
	private String name;
	private Faculty faculty;
	private Vector<Course> course = new Vector<Course>();
	public Vector<Double> avgRating = new Vector<Double>();
	
	public Teacher() {}
	public void addCourse(Course c) {
		this.course.add(c);
	}
	public void viewCourse() {
		for(Course c:course) {
			System.out.println(c.toString());
		}
	}	
	public void viewInfo(User user) {
		User to = DataBase.getInstance().getUser(user);
		if (to instanceof Student) {
			Student s = (Student) to;
			System.out.println(s.toString());
		}else {
			System.out.println("can not view");
		}
	}
	public void getRated(double rate) {
		this.avgRating.add(rate);
	}
	public Course getCourse(int position) {
		return course.get(position);
	}
	@Override
	public String toString() {
		return "Teacher name=" + name + ", faculty=" + faculty+", rating="+this.getRating();
	}
	public double getRating() {
		double cnt=0, sum=0;
		for (double i=0; i<avgRating.size(); i++) {
			cnt+=1;
			sum+=i;
		}
		return sum/cnt;
	}
	public void seeLog(Student s, Course c) {
		s.seeLog(c);
	}
	
}
