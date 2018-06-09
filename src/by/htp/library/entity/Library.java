package by.htp.library.entity;

public class Library {

	private Book[] books;
	private Author[] authors;

	public Library() {
		init();
	}

	public Book[] getBooks() {
		return books;
	}

	public Author[] getAuthors() {
		return authors;
	}

	private void init() {
		Author au1 = new Author("Alex", "Alexandrovich", "Atest", 1977);
		Author au2 = new Author("Dmitry", "Dmitrievich", "Btest", 1980);
		Author au3 = new Author("Veronika", "Alexandrovna", "Ctest", 1966);

		authors = new Author[] { au1, au2, au3 };

		Book b1 = new Book("Abook", 1997, au1, au2);
		Book b2 = new Book("Abook another", 1988, au2);
		Book b3 = new Book("Nbook", 1997, au1);
		Book b4 = new Book("Ibook", 1999, au2, au3);
		Book b5 = new Book("Sbook", 1980, au3);
		Book b6 = new Book("Lbook", 1970, au1, au3);
		Book b7 = new Book("Rbook", 1969, au3);

		books = new Book[] { b1, b2, b3, b4, b5, b6, b7 };
	}

	public void addBook(Book addedBook) {
		Book[] books = new Book[this.books.length + 1];
		for (int i = 0; i < this.books.length; i++) {
			books[i] = this.books[i];
		}
		books[books.length - 1] = addedBook;

		this.books = books;
	}

}
