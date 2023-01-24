package project;

import java.util.Vector;

import Study.Lector;
import Study.Teacher;

public class UserFactory {
		 
		public User logIn(String login, String password){
			Vector<User> users = DataBase.getInstance().getUsers();
			for(User u:users) {
				if(u.getLogin().equals(login) && u.getPassword().equals(password)) {
					return u;
				}
			}
			return null;
		}
		public User register(String userType, String name, String login, String password){
			if(userType == null){
				return null;
			}
			User u = null ;
			if(userType.equalsIgnoreCase("STUDENT")){
				u = new Student(name,login,password);
	         
			} else if(userType.equalsIgnoreCase("TEACHER")){
				u = new Teacher(name,login,password);
	         
			} else if(userType.equalsIgnoreCase("LECTOR")){
				u = new Lector(name,login,password);
	         
			} else if(userType.equalsIgnoreCase("ADMIN")) {
				u = new Admin(name,login,password);
	    	  
			} else if(userType.equalsIgnoreCase("OR")) {
				u = new OR(name,login,password);
	    	  
			} else if(userType.equalsIgnoreCase("DEPARTMENT")) {
				u = new Department(name,login,password);
				
	    	  
			} else if(userType.equalsIgnoreCase("LIBRARIAN")) {
				u = new Librarian(name,login,password);
	    	  
			}
			if(u != null) {
				DataBase.getInstance().addUser(u);
			}
			return u;
	   }
	}