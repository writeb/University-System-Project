package trivia;

import java.io.Serializable;
import java.util.Vector;


public class File implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vector <String> books;
	private String syllabus;
	
	public File() {};
	public File(String syllabus) {
		this.syllabus = syllabus;
	}
	
	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}
	public void addBook(String book) {
		this.books.add(book);
	}
	public void deleteBook(String book) {
		this.books.remove(book);
	}
	public void changeSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}
	public void viewSyllabus() {
		System.out.println(syllabus);
	}
	public String getSyllabus() {
		return syllabus;
	}
}
