package com.studentshowcase.restcontroller.controller;

import com.studentshowcase.service.faculty.FacultyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculties")
public class FacultyController {

    private static final Logger LOGGER = Logger.getLogger(FacultyController.class);

    private FacultyService facultyService;

    @Autowired
    public void setFacultyService(FacultyService facultyService) {
        LOGGER.info("Initializing FacultyController");
        this.facultyService = facultyService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getAdd() {
        return ResponseEntity.ok(facultyService.getAllFaculties());
    }
}
