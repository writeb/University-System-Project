package modes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import project.Course;
import project.DataBase;
import project.Librarian;
import project.Student;
import trivia.Book;

public class LibrarianMode extends Mode{
	private Librarian librarian;
	LibrarianMode(){}
	LibrarianMode(Librarian librarian){
		this.librarian = librarian;
	}
	public void start() throws NumberFormatException, IOException {
		while(true) {
			System.out.println("0->Exit");
			System.out.println("1->View books");
			System.out.println("2->Add book");
			System.out.println("3->View info about Student");
			BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
			int cmd = Integer.parseInt(in.readLine());
			if(cmd==1) {
				this.librarian.viewBooks();
			}
			else if(cmd==2) {
				System.out.println("Write book name:");
				String name = in.readLine();
				System.out.println("Write id: ");
				int id = Integer.parseInt(in.readLine());
				System.out.println("Write description: ");
				String desc = in.readLine();
				System.out.println("Write author: ");
				String author = in.readLine();
				Book b = new Book(name,id,desc,author);
				this.librarian.addBook(b);
				System.out.println("New book "+b.toString()+" succesfully added");
				}
			else if(cmd==3) {
				Vector<Student> students = DataBase.getInstance().getStudents();
				for(Student s:students) {
					System.out.println(s.toString());
				}
			}
			else if(cmd==0) {
				break;
			}else {
				System.out.println("Try again");
			}
		}
	}
}
