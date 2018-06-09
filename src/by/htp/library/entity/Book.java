package by.htp.library.entity;

public class Book {
	public static final Author UNKNOWN_AUTHOR = new Author("unknown", "unknown", "unknown", 0);

	private String title;
	private int year;
	private Author[] authors;

	public Book() {

	}

	public Book(String title, int year, Author... listAuthors) {
		this.title = title;
		this.year = year;
		this.authors = createAuthorsList(listAuthors);

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Author[] getAuthors() {
		return authors;
	}

	public void setAuthor(Author... authors) {
		this.authors = createAuthorsList(authors);
	}

	@Override
	public String toString() {
		return "Book title: " + title + ", year: " + year + ", author: " + authors;
	}

	private static Author[] createAuthorsList(Author... listAuthors) {
		Author[] authorArr = listAuthors;
		if (authorArr == null || authorArr.length == 0) {
			authorArr = new Author[] { UNKNOWN_AUTHOR };
		}
		return authorArr;
	}

}
