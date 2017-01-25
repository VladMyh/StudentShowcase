package com.studentshowcase.restcontroller.controller;

import com.studentshowcase.model.responce.StringResponse;
import com.studentshowcase.model.user.User;
import com.studentshowcase.model.verificationtoken.VerificationToken;
import com.studentshowcase.service.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class RegistrationConfirmationController {

    private static final Logger LOGGER = Logger.getLogger(RegistrationConfirmationController.class);

    private UserService userService;

    @Autowired
    public RegistrationConfirmationController(UserService userService) {
        LOGGER.info("Initializing RegistrationConfirmationController");

        this.userService = userService;
    }

    @RequestMapping(value = "/confirmRegistration", method = RequestMethod.GET)
    public ResponseEntity<StringResponse> confirmRegistration(@RequestParam("token") String token) {
        LOGGER.info("Confirming registration for token " + token);

        VerificationToken verificationToken = userService.getVerificationToken(token);
        if (verificationToken == null) {
            LOGGER.info("Invalid token");
            return ResponseEntity.badRequest().body(new StringResponse("Invalid token"));
        }

        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpirationDate().getTime() - cal.getTime().getTime()) <= 0) {
            LOGGER.info("Token expired");
            return ResponseEntity.badRequest().body(new StringResponse("Token expired"));
        }

        user.setIsEmailVerified(true);
        user.setIsActivated(true);
        userService.addOrUpdateUser(user);

        return ResponseEntity.ok(new StringResponse("User activated"));
    }
}
