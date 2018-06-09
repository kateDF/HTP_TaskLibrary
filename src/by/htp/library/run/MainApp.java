package by.htp.library.run;

import by.htp.library.entity.Author;
import by.htp.library.entity.Book;
import by.htp.library.entity.Library;
import by.htp.library.logic.Librarian;

public class MainApp {

	public static void main(String[] args) {

		Library library = new Library();

		Author author1 = new Author("Vladimir", "Vladimirovich", "Gtest", 1955);
		Author author2 = new Author("Dmitry", "Dmitrievich", "Btest", 1980);
		Book newBook = new Book("NewBook", 1997, author1, author2);

		library.addBook(newBook);
		System.out.println("All list of books: ");
		Librarian.printBooks(library);

		Book[] booksByAuthor = Librarian.searchByAuthor(library, author2);
		System.out.println("Search book by author: " + author2);
		Librarian.printBooks(booksByAuthor);

		Book resultBook = Librarian.searchByAuthorTitleYear(library, author2, "Abook", 1997);
		System.out.println("Search book by autor, title and year:");
		Librarian.printBook(resultBook);
		System.out.println();

	}

}
