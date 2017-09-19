package pl.bj.library.model;

import javax.persistence.Entity;

/**
 * Contains attributes of a Customer.
 * 
 * @author bjaroszewicz
 */
@Entity
public class Customer extends Person {

	private String email;

	private String phone;

	public Customer() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
