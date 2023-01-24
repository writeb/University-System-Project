package project;

import java.io.Serializable;
import java.util.Vector;

import trivia.Book;
/** 
 * Class Librarian extending Employee class.
*/
public class Librarian extends Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 
     * Constructor - creating a new object with specific values
     * @param name
     * @param login
     * @param password
     * @param salary
     * @see Librarian#Librarian()
     */
	public Librarian(String name, String login, String password, int salary) {
		super(name, login, password, salary);
	}
	public Librarian(String name, String login, String password) {
		super(name, login, password);
	}
	private static Vector<Book>books ;
	public Librarian() {
	}
	static {
		books = new Vector<Book>();
	}
	public void viewInfo(User user) {
		if(user instanceof Student){
			System.out.println(user.toString());
		}else {
			System.out.println("Can not view");
		}
		
	}
	/**
	 * This method is used to view sorted books.
	 */
	public static void viewBooks() {
		QuickSort.quickSort(books, 0, books.size()-1);
		for(Book b:books) {
			System.out.println(b.toString());
		}
	}
	/**
	 * This method is used to add book into Library books.
	 * @param book This is the parameter to choose what book
	 */
	public static void addBook(Book book) {
		Librarian.books.add(book);
	}
	/**
	 * This method is used to remove book from Library books.
	 * @param book This is the parameter to choose what book
	 */
	public static void removeBook(Book book) {
		Librarian.books.remove(book);
	}
	/**
	 * This method is used to get book from Library books.
	 * @param id This is the parameter to choose what book
	 * @return clone of Book
	 */
	public static Book getBook(int id) throws CloneNotSupportedException {
		for(Book b:books) {
			if(b.getId() == id) {
				Book clone = b.clone();
				removeBook(b);
				return clone;
			}
		}
		return null;
	}
}
