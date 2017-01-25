package com.studentshowcase.restcontroller.registration;

import com.studentshowcase.model.user.User;
import com.studentshowcase.service.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

    private static final Logger LOGGER = Logger.getLogger(RegistrationListener.class);

    private UserService userService;

    @Autowired
    public RegistrationListener(UserService userService) {
        LOGGER.info("Initializing RegistrationListener");

        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent onRegistrationCompleteEvent) {
        User user = onRegistrationCompleteEvent.getUser();
        String token = UUID.randomUUID().toString();
        userService.createVerificationToken(user, token);
    }
}
