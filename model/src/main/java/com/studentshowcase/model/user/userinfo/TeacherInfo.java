package com.studentshowcase.model.user.userinfo;

import java.util.Set;

public class TeacherInfo {
    private String faculty;
    private String department;
    private String about;
    private Set<String> tracks;

    public TeacherInfo() {}

    public TeacherInfo(String about, Set<String> tracks, String faculty, String department) {
        this.about = about;
        this.tracks = tracks;
        this.faculty = faculty;
        this.department = department;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherInfo that = (TeacherInfo) o;

        if (!faculty.equals(that.faculty)) return false;
        if (!department.equals(that.department)) return false;
        if (about != null ? !about.equals(that.about) : that.about != null) return false;
        return tracks != null ? tracks.equals(that.tracks) : that.tracks == null;
    }

    @Override
    public int hashCode() {
        int result = faculty.hashCode();
        result = 31 * result + department.hashCode();
        result = 31 * result + (about != null ? about.hashCode() : 0);
        result = 31 * result + (tracks != null ? tracks.hashCode() : 0);
        return result;
    }
}
