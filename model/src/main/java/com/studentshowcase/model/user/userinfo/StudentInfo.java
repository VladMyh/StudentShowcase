package com.studentshowcase.model.user.userinfo;

import java.util.Set;

public class StudentInfo {
	private String faculty;
	private String department;
	private String group;
	private String github;
	private String about;
	private Set<String> tracks;

	public StudentInfo() {}

	public StudentInfo(String faculty, String department, String group,
					   String github, String about, Set<String> tracks) {
		this.faculty = faculty;
		this.department = department;
		this.group = group;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public Set<String> getTracks() {
		return tracks;
	}

	public void setTracks(Set<String> tracks) {
		this.tracks = tracks;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		StudentInfo info = (StudentInfo) o;

		if (faculty != null ? !faculty.equals(info.faculty) : info.faculty != null) return false;
		if (department != null ? !department.equals(info.department) : info.department != null) return false;
		if (group != null ? !group.equals(info.group) : info.group != null) return false;
		if (github != null ? !github.equals(info.github) : info.github != null) return false;
		if (about != null ? !about.equals(info.about) : info.about != null) return false;
		return tracks != null ? tracks.equals(info.tracks) : info.tracks == null;

	}

	@Override
	public int hashCode() {
		int result = faculty != null ? faculty.hashCode() : 0;
		result = 31 * result + (department != null ? department.hashCode() : 0);
		result = 31 * result + (group != null ? group.hashCode() : 0);
		result = 31 * result + (github != null ? github.hashCode() : 0);
		result = 31 * result + (about != null ? about.hashCode() : 0);
		result = 31 * result + (tracks != null ? tracks.hashCode() : 0);
		return result;
	}
}
