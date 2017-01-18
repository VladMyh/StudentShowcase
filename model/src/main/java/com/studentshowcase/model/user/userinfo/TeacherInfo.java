package com.studentshowcase.model.user.userinfo;

import java.util.Set;

public class TeacherInfo {
    private String about;
    private Set<String> tracks;

    public TeacherInfo() {}

    public TeacherInfo(String about, Set<String> tracks) {
        this.about = about;
        this.tracks = tracks;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherInfo that = (TeacherInfo) o;

        if (about != null ? !about.equals(that.about) : that.about != null) return false;
        return tracks != null ? tracks.equals(that.tracks) : that.tracks == null;
    }

    @Override
    public int hashCode() {
        int result = about != null ? about.hashCode() : 0;
        result = 31 * result + (tracks != null ? tracks.hashCode() : 0);
        return result;
    }
}
