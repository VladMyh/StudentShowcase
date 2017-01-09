package com.studentshowcase.service.faculty;

import com.studentshowcase.model.faculty.Faculty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FacultyService {
    List<Faculty> getAllFaculties();
}
