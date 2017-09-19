package pl.bj.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * Contains attributes of a book.
 * 
 * @author bjaroszewicz
 */
@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "title")
	private String title;

	@ManyToOne
	@JoinColumn(name = "authorId")
	private Author author;

	@Transient
	private Type type;

	// @Column(name = "publishing_house")
	private String publishingHouse;

	private Double price;

	private Integer numberPages;

	private Boolean hardCover;

	private Boolean withPictures;

	public Book() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNumberPages() {
		return numberPages;
	}

	public void setNumberPages(Integer numberPages) {
		this.numberPages = numberPages;
	}

	public Boolean getHardCover() {
		return hardCover;
	}

	public void setHardCover(Boolean hardCover) {
		this.hardCover = hardCover;
	}

	public Boolean getWithPictures() {
		return withPictures;
	}

	public void setWithPictures(Boolean withPictures) {
		this.withPictures = withPictures;
	}

}
