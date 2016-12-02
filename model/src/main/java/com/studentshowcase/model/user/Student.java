package com.studentshowcase.model.user;

import com.studentshowcase.model.specialization.Specialization;

import java.util.Set;

public class Student extends AbstractUser{
	private String faculty;
	private String cathedra;
	private String github;
	private Set<Specialization> specializations;

	public Student() {}

	public Student(String id, String firstName, String lastName, String email, String linkedin,
				   String faculty, String cathedra, String github, Set<Specialization> specializations) {
		super(id, firstName, lastName, email, linkedin);
		this.faculty = faculty;
		this.cathedra = cathedra;
		this.github = github;
		this.specializations = specializations;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getCathedra() {
		return cathedra;
	}

	public void setCathedra(String cathedra) {
		this.cathedra = cathedra;
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

		if (!faculty.equals(student.faculty)) return false;
		if (!cathedra.equals(student.cathedra)) return false;
		if (!github.equals(student.github)) return false;
		return specializations.equals(student.specializations);

	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + faculty.hashCode();
		result = 31 * result + cathedra.hashCode();
		result = 31 * result + github.hashCode();
		result = 31 * result + specializations.hashCode();
		return result;
	}
}
