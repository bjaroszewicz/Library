package pl.bj.library.model;

/**
 * Contains attributes of a Author.
 * 
 * @author bjaroszewicz
 */
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Author extends Person {

	@OneToMany
	@JoinColumn(name = "id")
	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Author() {
	}

}
