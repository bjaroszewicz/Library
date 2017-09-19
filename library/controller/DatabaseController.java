package pl.bj.library.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.bj.library.model.Author;
import pl.bj.library.model.Book;
import pl.bj.library.model.Type;

public class DatabaseController implements BookControllerIf {

	private final SessionFactory sessionFactory;

	public DatabaseController(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addBook(String title, Author author, Type type, String publishingHouse, Double price,
			Integer numberPages, Boolean hardCover, Boolean withPictures) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addBook(String title, String authorName, String authorSurname, Type type,
			String publishingHouse, Double price, Integer numberPages, Boolean hardCover,
			Boolean withPictures) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeBook(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public ObservableList<Book> getBooks() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Book> books = session.createQuery("from Book").list();
		session.getTransaction().commit();
		session.close();
		return FXCollections.observableArrayList(books);
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		sessionFactory.close();
	}
}
