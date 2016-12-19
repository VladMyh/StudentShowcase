package com.studentshowcase.model.user;

import org.springframework.data.annotation.Id;

public abstract class AbstractUser {
	@Id
	protected String id;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String linkedin;
	protected String password;

	public AbstractUser() {}

	public AbstractUser(String id, String firstName, String lastName, String email, String linkedin, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.linkedin = linkedin;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		AbstractUser that = (AbstractUser) o;

		if (!id.equals(that.id)) return false;
		if (!firstName.equals(that.firstName)) return false;
		if (!lastName.equals(that.lastName)) return false;
		if (!email.equals(that.email)) return false;
		if (!linkedin.equals(that.linkedin)) return false;
		return password.equals(that.password);

	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		result = 31 * result + email.hashCode();
		result = 31 * result + linkedin.hashCode();
		result = 31 * result + password.hashCode();
		return result;
	}
}
