package pl.bj.library.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.bj.library.model.Author;
import pl.bj.library.model.Book;
import pl.bj.library.model.Type;

public class InMemoryController implements BookControllerIf {

	private ObservableList<Book> books;

	public InMemoryController() {
		books = FXCollections.observableArrayList();// new ArrayList<Book>();

		initializeBooks();
	}

	private void initializeBooks() {
		// tytu³, Imiê autora, nazwisko autora, ksi¹¿ki autora, gatunek,
		// wydawnictwo, cena, liczba stron, czy twarda ok³adka, czy s¹ zdjêcia
		addBook("Harry Potter", createAuthor("Katrin", "Rowling"), Type.FANTASY,
				"wydawnictwo1", (double) 50, 350, true, false);
		addBook("Wiedzmin", createAuthor("Andrzej", "Sapkowski"), Type.FANTASY,
				"wydawnictwo2", (double) 30, null, false, true);
		addBook("Ogniem i Mieczem", createAuthor("Henryk", "Sienkiewicz"),
				Type.HISTORY, "wydawnictwo3", (double) 25, null, true, false);
		addBook("Igrzyska Œmierci", createAuthor(null, null), Type.FANTASY,
				"wydawnictwo2", (double) 61, 834, true, false);
		addBook("Gra o Tron", createAuthor("George", "Martin"), Type.FANTASY,
				"wydawnictwo1", (double) 49, 473, true, true);

	}

	@Override
	public void addBook(String title, Author author, Type type,
			String publishingHouse, Double price, Integer numberPages,
			Boolean hardCover, Boolean withPictures) {
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setType(type);
		book.setPublishingHouse(publishingHouse);
		book.setPrice(price);
		book.setNumberPages(numberPages);
		book.setHardCover(hardCover);
		book.setWithPictures(withPictures);

		books.add(book);
	}

	@Override
	public void addBook(String title, String authorName, String authorSurname,
			Type type, String publishingHouse, Double price,
			Integer numberPages, Boolean hardCover, Boolean withPictures) {
		addBook(title, createAuthor(authorName, authorSurname), type,
				publishingHouse, price, numberPages, hardCover, withPictures);
	}

	@Override
	public void removeBook(Book book) {
		books.remove(book);
	}

	private Author createAuthor(String name, String surname) {
		Author author = new Author();
		author.setName(name);
		author.setSurname(surname);

		return author;
	}

	@Override
	public ObservableList<Book> getBooks() {
		return books;
	}
}
