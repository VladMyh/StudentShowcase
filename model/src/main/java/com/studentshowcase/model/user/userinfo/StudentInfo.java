package com.studentshowcase.model.user.userinfo;

import com.studentshowcase.model.track.Track;

import java.util.Set;

public class StudentInfo {
	private String faculty;
	private String cathedra;
	private String github;
	private String about;
	private Set<Track> tracks;

	public StudentInfo() {}

	public StudentInfo(String faculty, String cathedra, String github,
					   String about, Set<Track> tracks) {
		this.faculty = faculty;
		this.cathedra = cathedra;
		this.github = github;
		this.about = about;
		this.tracks = tracks;
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

	public Set<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		StudentInfo student = (StudentInfo) o;

		if (!faculty.equals(student.faculty)) return false;
		if (!cathedra.equals(student.cathedra)) return false;
		if (!github.equals(student.github)) return false;
		if (about != null ? !about.equals(student.about) : student.about != null) return false;
		return tracks != null ? tracks.equals(student.tracks) : student.tracks == null;

	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + faculty.hashCode();
		result = 31 * result + cathedra.hashCode();
		result = 31 * result + github.hashCode();
		result = 31 * result + (about != null ? about.hashCode() : 0);
		result = 31 * result + (tracks != null ? tracks.hashCode() : 0);
		return result;
	}
}
