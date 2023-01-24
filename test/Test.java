package test;
import Study.*;
import trivia.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import project.*;
public class Test {

	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
		UserFactory uf = new UserFactory();
		Student s = (Student) uf.register("Student","almas", "a_orazgaliev", "alma45884");
		s.setFaculty(Faculty.FIT);
		Course oop = new Course();
		oop.setFaculty(Faculty.FIT);
		oop.setName("OOP");
		
		Lesson l = new Lesson("L", Days.TUE, new Time(14,2), Format.OFFLINE, DurationFormat.LECTURE, new Room(461,100,4));
		Lesson a = new Lesson("A", Days.WED, new Time(13,1), Format.ONLINE, DurationFormat.PRACTICE, new Room(424,55,4));
		Lesson d = new Lesson("D", Days.SAT, new Time(15,2), Format.OFFLINE,DurationFormat.LECTURE, new Room(444,120,4));
		Lesson m = new Lesson("M", Days.MON, new Time(19,1));
		
		oop.addLesson(l);
		oop.addLesson(a);
		oop.addLesson(d);
		oop.addLesson(m);
		
		
		OR or = (OR) uf.register("or", "new", "new_kz", "12345");
		OR.openRegister();
		
		Lector t = (Lector) uf.register("Lector", "Bobur", "b_bobur", "89746");
		OR.assignCourseToTeacher(t, oop);
		s.registerCourse(oop);
		s.pickLesson(oop);
		s.pickLesson(oop);
		s.viewSchedule();
		
		withResearcher s1 = new withResearcher(s);
		System.out.println(s1.toString());
		Vector<User> users = DataBase.getInstance().getUsers();
		System.out.println(users.toString());
		DataBase.loadDB();
	}

}
