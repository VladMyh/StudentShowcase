package com.studentshowcase.model.faculty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "faculty")
public class Faculty {

    @Id
    private String id;
    private String title;
    private List<String> departments;

    public Faculty() {}

    public Faculty(String id, String title, List<String> departments) {
        this.id = id;
        this.title = title;
        this.departments = departments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }
}
