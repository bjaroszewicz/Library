package pl.bj.library.controller;

import javafx.collections.ObservableList;
import pl.bj.library.model.Author;
import pl.bj.library.model.Book;
import pl.bj.library.model.Type;

public interface BookControllerIf {

	void addBook(String title, Author author, Type type, String publishingHouse,
			Double price, Integer numberPages, Boolean hardCover,
			Boolean withPictures);

	void addBook(String title, String authorName, String authorSurname,
			Type type, String publishingHouse, Double price,
			Integer numberPages, Boolean hardCover, Boolean withPictures);

	void removeBook(Book book);

	ObservableList<Book> getBooks();

}