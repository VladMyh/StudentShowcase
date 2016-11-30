package com.studentshowcase.model.user;

import com.studentshowcase.model.specialization.Specialization;

import java.util.Set;

public class Student extends AbstractUser{
	private String github;
	private Set<Specialization> specializations;

	public Student() {}

	public Student(String id, String firstName, String lastName, String linkedin,
				   String github, Set<Specialization> specializations) {
		super(id, firstName, lastName, linkedin);
		this.github = github;
		this.specializations = specializations;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public Set<Specialization> getSpecializations() {
		return specializations;
	}

	public void setSpecializations(Set<Specialization> specializations) {
		this.specializations = specializations;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Student student = (Student) o;

		if (!github.equals(student.github)) return false;
		return specializations.equals(student.specializations);

	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + github.hashCode();
		result = 31 * result + specializations.hashCode();
		return result;
	}
}
