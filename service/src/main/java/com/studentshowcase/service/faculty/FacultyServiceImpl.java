package com.studentshowcase.service.faculty;

import com.studentshowcase.model.faculty.Faculty;
import com.studentshowcase.repository.faculty.MongoFacultyRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    private static final Logger LOGGER = Logger.getLogger(FacultyServiceImpl.class);
    private MongoFacultyRepository repository;

    @Autowired
    public void setRepository(MongoFacultyRepository repository) {
        LOGGER.info("Initializing FacultyServiceImpl");
        this.repository = repository;
    }

    @Override
    public List<Faculty> getAllFaculties() {
        LOGGER.info("Getting all faculties");
        return (List<Faculty>) repository.findAll();
    }
}
