package pl.bj.library.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Contains attributes of a Person.
 * 
 * @author bjaroszewicz
 */
@MappedSuperclass
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String surname;

	public Person() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return name == null ? "" : surname == null ? "" : name + " " + surname;
	}
}
