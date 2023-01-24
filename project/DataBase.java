package project;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import Study.Teacher;

public final class DataBase implements Serializable{
		/**
	 * 
	 */
		private static final long serialVersionUID = 1L;
		private static DataBase singleInstance;
		private Vector<User> users = new Vector<User>();
		private Vector<Course> courses = new Vector<Course>();
		private DataBase() {}
		static {
			if(new File("C:\\Users\\orazg\\eclipse-workspace\\project\\db.txt").exists()) {
				try {
					singleInstance = getDB();
				}
				catch(Exception e) {
				    e.printStackTrace();
				}
			}
		}
		public static DataBase getInstance() {
			if(singleInstance==null) {
				singleInstance = new DataBase();
			}
			return singleInstance;
		}
		public static void loadDB() throws ClassNotFoundException,FileNotFoundException, IOException {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\orazg\\eclipse-workspace\\project\\db.txt");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(DataBase.getInstance());
		    oos.flush();
		    oos.close();
		}
		public static DataBase getDB() throws ClassNotFoundException, IOException {
			FileInputStream fis = new FileInputStream("C:\\Users\\orazg\\eclipse-workspace\\project\\db.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			DataBase db = DataBase.getInstance();
			db = (DataBase) ois.readObject();
			DataBase.singleInstance=db;
			fis.close();
			ois.close();
			return db;
		}
		public void addUser(User u) {
			users.add(u);
		}
		public void addCourse(Course c){
			courses.add(c);
		}
		public User getUser(User user) {
			for(User u :users) {
				if(u.equals(user)){
					return u;
				}
			}
			return null;
		}
		public Vector<User> getUsers(){
			return users;
		}
		public  Vector<Student> getStudents() {
			Vector<Student> students = new Vector<Student>();
			for(User u:users) {
				if(u instanceof Student) {
					students.add((Student) u);
				}
			}
			return students;
		}
		public Vector<Teacher> getTeachers() {
			Vector<Teacher> teachers = new Vector<Teacher>();
			for(User u:users) {
				if(u instanceof Teacher) {
					teachers.add((Teacher) u);
				}
			}
			return teachers;
		}
		public Vector<Employee> getEmployees(){
			Vector<Employee> employees = new Vector<Employee>();
			for(User u:users) {
				if(u instanceof Employee) {
					employees.add((Employee) u);
				}
			}
			return employees;
		}
		public Vector<OR> getOR(){
			Vector<OR> or = new Vector<OR>();
			for(User u:users) {
				if(u instanceof OR) {
					or.add((OR) u);
				}
			}
			return or;
		}
		public Vector<Librarian> getLibrarians(){
			Vector<Librarian> librarians = new Vector<Librarian>();
			for(User u:users) {
				if(u instanceof Librarian) {
					librarians.add((Librarian) u);
				}
			}
			return librarians;
		}
		public Vector<Department> getManagers(){
			Vector<Department> managers = new Vector<Department>();
			for(User u:users) {
				if(u instanceof Department) {
					managers.add((Department) u);
				}
			}
			return managers;
		}
		public Vector<Course> getCourse(){
			return courses;
		}
		
}
