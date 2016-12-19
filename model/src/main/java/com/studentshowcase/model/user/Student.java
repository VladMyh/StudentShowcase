package com.studentshowcase.model.user;

import com.studentshowcase.model.specialization.Specialization;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "student")
public class Student extends AbstractUser{
	private boolean activated;
	private String faculty;
	private String cathedra;
	private String github;
	private String about;
	private Set<Specialization> specializations;

	public Student() {}

	public Student(String id, String firstName, String lastName, String email, String linkedin, String password,
				   boolean activated, String faculty, String cathedra, String github, String about,
				   Set<Specialization> specializations) {
		super(id, firstName, lastName, email, linkedin, password);
		this.activated = activated;
		this.faculty = faculty;
		this.cathedra = cathedra;
		this.github = github;
		this.about = about;
		this.specializations = specializations;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
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

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
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

		if (activated != student.activated) return false;
		if (!faculty.equals(student.faculty)) return false;
		if (!cathedra.equals(student.cathedra)) return false;
		if (!github.equals(student.github)) return false;
		if (about != null ? !about.equals(student.about) : student.about != null) return false;
		return specializations != null ? specializations.equals(student.specializations) : student.specializations == null;

	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (activated ? 1 : 0);
		result = 31 * result + faculty.hashCode();
		result = 31 * result + cathedra.hashCode();
		result = 31 * result + github.hashCode();
		result = 31 * result + (about != null ? about.hashCode() : 0);
		result = 31 * result + (specializations != null ? specializations.hashCode() : 0);
		return result;
	}
}
