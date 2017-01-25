package com.studentshowcase.restcontroller.controller;

import com.studentshowcase.model.user.User;
import com.studentshowcase.service.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private static final Logger LOGGER = Logger.getLogger(TeacherController.class);

    private UserService userService;

    @Autowired
    public TeacherController(UserService userService) {
        LOGGER.info("Initializing TeacherController");

        this.userService = userService;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public void register(@RequestBody User teacher, WebRequest request) {
        LOGGER.info("Registering new student");

        userService.registerUser(teacher, request);
    }
}
