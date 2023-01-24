package Study;

import project.Student;

import java.io.Serializable;

import project.Course;
import project.Faculty;
public class Lector extends Teacher implements Serializable{
	
	public Lector(String name, String login, String password, int salary, Faculty faculty) {
		super(name, login, password, salary, faculty);
	}

	public Lector(String name, String login, String password, int salary) {
		super(name, login, password, salary);
	}

	public Lector(String name, String login, String password) {
		super(name, login, password);
	}
	private static final long serialVersionUID = 1L;
	public Lector() {}
	
	public void putMarks(Student s,Course c, int mark) {
		 StudentMarks sm = s.getLog();
		 sm.addMark(c, mark);
	}
	public void courseFiles(Course c) {
		c.getFile();
	}
}
