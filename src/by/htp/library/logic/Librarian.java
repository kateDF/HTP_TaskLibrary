package by.htp.library.logic;

import by.htp.library.entity.Author;
import by.htp.library.entity.Book;
import by.htp.library.entity.Library;

public class Librarian {

	private Librarian() {

	}

	public static void printBooks(Library library) {
		Book[] books = library.getBooks();
		printBooks(books);
	}

	public static void printBooks(Book[] books) {
		if (books != null) {
			for (int i = 0; i < books.length; i++) {
				System.out.print(1 + i + ". Book title: " + books[i].getTitle() + " ");
				ptintAuthors(books[i].getAuthors());
			}
		} else {
			System.out.println("There are no book for showing");
		}
		System.out.println();
	}

	public static void ptintAuthors(Author... authors) {
		if (authors != null) {
			if (authors.length > 1) {
				for (int i = 0; i < authors.length - 1; i++) {
					System.out.print("Authors: " + authors[i] + ", ");
				}
				System.out.print(authors[authors.length - 1] + ".");
			} else if (authors.length == 1) {
				System.out.print("Author: " + authors[0] + ".");
			} else {
				System.out.print("No information about authors");
			}
			System.out.println();
		}
	}

	public static void printBook(Book book) {
		if (book != null) {
			System.out.println("Book title: " + book.getTitle() + ", " + book.getYear());
			ptintAuthors(book.getAuthors());
		} else {
			System.out.println("There are no book for showing");
		}
	}

	public static int calculateBooksByAuthor(Book[] books, Author author) {
		int counter = 0;
		for (int i = 0; i < books.length; i++) {
			for (int j = 0; j < books[i].getAuthors().length; j++) {
				if (author.equals(books[i].getAuthors()[j])) {
					counter++;
				}
			}
		}
		return counter;
	}

	public static Book[] searchByAuthor(Library library, Author author) {
		Book[] books = library.getBooks();
		int booksNumber = calculateBooksByAuthor(books, author);
		Book[] booksByAuthor = new Book[booksNumber];

		int k = 0;
		for (int i = 0; i < books.length; i++) {
			for (int j = 0; j < books[i].getAuthors().length; j++) {
				if (author.equals(books[i].getAuthors()[j])) {
					booksByAuthor[k] = books[i];
					k++;
				}
			}
		}
		return booksByAuthor;
	}

	public static Book searchByAuthorTitleYear(Library library, Author author, String title, int year) {
		Book[] books = library.getBooks();
		Book resultBook = null;

		for (int i = 0; i < books.length; i++) {
			if (books[i].getTitle().equals(title) && books[i].getYear() == year) {
				for (int j = 0; j < books[i].getAuthors().length; j++) {
					if (author.equals(books[i].getAuthors()[j])) {
						resultBook = books[i];
						break;
					}
				}
			}
		}
		return resultBook;
	}

}
