package project;

import Study.StudentMarks;
import Study.Teacher;
import trivia.Book;
import trivia.Lesson;
import trivia.Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;

/** 
 * Class Student extending User class.
*/
public class Student extends User implements Serializable,Comparable<Student>{
	private static final long serialVersionUID = 1L;
	/** Field faculty */
	private Faculty faculty;
	/** Field organization in which the student */
	private String studentOrganization;
	/** Field student courses */
	private Vector<Course> courses = new Vector<Course>();
	/** Field student's schedule */
	private Vector<Lesson> schedule = new Vector<Lesson>();
	/** Field student's degree*/
	public Degree degree;
	/** Field student's project diploma*/
	private Project diploma;
	/** Field student's marks*/
	private StudentMarks studMarks = new StudentMarks();
	/** Field student's books*/
	private Book book;
	public Student() {}
	public Student(String name, String login, String password) {
		super(name, login, password);
	}
	/** 
     * Constructor - creating a new object with specific values
     * @param name
     * @param login
     * @param password
     * @param faculty
     * @param studentOrganization
     * @param degree
     * @param diploma
     * @see Student#Student()
     */
	public Student(String name, String login, String password, Faculty faculty, String studentOrganization, Degree degree, Project diploma) {
		super(name, login, password);
		this.faculty = faculty;
		this.degree = degree;
		this.studentOrganization = studentOrganization;
		this.diploma = diploma;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public String getStudentOrganization() {
		return studentOrganization;
	}
	public void setStudentOrganization(String studentOrganization) {
		this.studentOrganization = studentOrganization;
	}
	public Project getDiploma() {
		return diploma;
	}
	public void setDiploma(Project diploma) {
		this.diploma = diploma;
	}
	public StudentMarks getLog() {
		return studMarks;
	}
	public Book getBook() {
		return book;
	}
	/**
	 * This method is used to return book to Library.
	 */
	public void returnBook() {
		Librarian.addBook(book);
	}
	public boolean finishedCourse(Course c) {
		if(c == null) {
			return true;
		}
		return courses.contains(c);
	}
	/**
	 * This method is used to see the journal of Student.
	 * @param course This is the parameter to choose what course
	 */
	public void seeLog(Course course) {
		for(Course oth : courses) {
			studMarks.seeLog(oth);
		}
	}
	public void viewTranscript() {
		studMarks.viewTranscript();
	}
	public String getTrascript() {
		return studMarks.getTranscript();
	}
	/**
	   * This method is used to get Average Point of Student.
	   * @return double.
	   */
	public double getAveragePoints() {
		return studMarks.averagePoints();
	}
	/**
	   * This method is used to register for a course, 
	   * If OR manager approve registration then student is successfully registered.  
	   * @param course This is the parameter to choose what course
	   */
	public void registerCourse(Course course) {
		if(OR.approveRegistration(this, course)) {
			System.out.println("Successfully registered");
			courses.add(course);
		}
	}
	/**
	   * This method is used to rate Teacher.  
	   * @param t This is the first parameter to choose what Teacher
	   * @param rate This is the second parameter to rate
	   */
	public void rateTeacher(Teacher t, double rate) {
		User to = DataBase.getInstance().getUser(t);
		((Teacher) to).avgRating.add(rate);
	}
	public void viewInfo(User user) {
		User to = DataBase.getInstance().getUser(user);
		if (to instanceof Teacher) {
			Teacher t = (Teacher) to;
			System.out.println(t.toString());
		}else {
			System.out.println("can not view");
		}
		
	}
	@Override
	public String toString() {
		return super.toString()+" " + ", faculty = " + faculty + ", studentOrganization = " + studentOrganization
				+ ", courses = " + courses + ", schedule = " + schedule;
	}
	public void viewSchedule() {
		QuickSort.quickSort(schedule, 0, schedule.size()-1);
		for (Lesson i : schedule) {
			System.out.println(i.toString());
		}
	}
	/**
	   * This method is used to pick a lesson and add lesson into student's schedule. 
	   * @param course This is the parameter to choose what course
	   */
	public void pickLesson(Course course) throws IOException {
		course.viewLessons();
		System.out.print("Enter position: ");
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		this.schedule.add(course.getLesson(Integer.parseInt(in.readLine())));
		System.out.println("Succesfully added");
	}
	@Override
	public int compareTo(Student o) {
		if(this.getName().compareTo(o.getName())!=0) return this.getName().compareTo(o.getName());
		if (this.courses.size() > o.courses.size()) return 1;
		if (this.courses.size() < o.courses.size()) return -1;
		if (this.schedule.size() > o.schedule.size()) return 1;
		if (this.schedule.size() < o.schedule.size()) return -1;
		return 0;
	}
	/**
	   * This method is used to pick a book from library. 
	   * @param id This is the parameter to choose what book by id
	   */
	public void pickBook(int id) throws CloneNotSupportedException {
		book = Librarian.getBook(id);
	}
	public Vector<Course> getCourses(){
		return this.courses;
	}
	
	
}
