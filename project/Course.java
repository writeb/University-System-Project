package project;

import java.io.File;
import java.io.Serializable;
import java.util.Vector;

import trivia.Lesson;

public class Course implements Serializable,Comparable<Object>{
	private static final long serialVersionUID = 1L;
	private String name;
	private Course prereq;
	private int credits;
	private Semester semester;
	private Vector <Lesson> lessons;
	private Course prereqOfCourse;
	private File files;
	private Faculty faculty;
	{
		lessons = new Vector<Lesson>();
		DataBase.getInstance().addCourse(this);
	}
	public Course() {};
	public Course(String name, Faculty Faculty) {
		this.name=name;
	}
	public Course(String name, Course prereq, int credits, Semester semester, Vector<Lesson> lessons,
			Course prereqOfCourse, File files, Faculty faculty) {
		super();
		this.name=name;
		this.prereq = prereq;
		this.credits = credits;
		this.semester = semester;
		this.lessons = lessons;
		this.prereqOfCourse = prereqOfCourse;
		this.files = files;
		this.faculty = faculty;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getPrereq() {
		return prereq;
	}

	public void setPrereq(Course prereq) {
		this.prereq = prereq;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Vector<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(Vector<Lesson> lessons) {
		this.lessons = lessons;
	}
	
	public Course getPrereqOfCourse() {
		return prereqOfCourse;
	}

	public void setPrereqOfCourse(Course prereqOfCourse) {
		this.prereqOfCourse = prereqOfCourse;
	}

	public File getFiles() {
		return files;
	}

	public void setFiles(File files) {
		this.files = files;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public void addLesson(Lesson l) {
		lessons.add(l);
	}
	public void viewLessons(){
		QuickSort.quickSort(lessons, 0, lessons.size()-1);
		for (Lesson lesson : lessons) {
			System.out.println(lesson.toString());
		}
	}
	public Lesson getLesson(int position) {
		return lessons.elementAt(position);
	}
	public File getFile() {
		return this.files;
	}
	public int compareName(Course o) {
		return this.name.compareTo(o.name);
	}
	@Override
	public int compareTo(Object o) {
		Course c = (Course)o;
		if (this.credits > c.credits) return 1;
		if (this.credits < c.credits) return -1;
		if (this.lessons.size() > c.lessons.size()) return 1;
		if (this.lessons.size() < c.lessons.size()) return -1;
		if(this.compareName(c)!=0) return compareName(c);
		return 0;
	}
	public void sortLessons() {
		QuickSort.quickSort(lessons, 0, lessons.size()-1);
	}
	public String toString() {
		return name+" course, "+faculty+" faculty.";
	}
}

