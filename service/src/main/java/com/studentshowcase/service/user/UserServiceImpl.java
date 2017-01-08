package com.studentshowcase.service.user;

import com.studentshowcase.model.user.User;
import com.studentshowcase.repository.user.MongoUserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	private MongoUserRepository repository;

	@Autowired
	public UserServiceImpl(MongoUserRepository repository) {
		LOGGER.info("Initializing UserServiceImpl");
		this.repository = repository;
	}


	@Override
	public User getUserById(String id) {
		LOGGER.info("Getting user with id = " + id);
		return repository.findOne(id);
	}

	@Override
	public User getUserByEmail(String email) {
		LOGGER.info("Getting user by email");
		return repository.findByEmail(email).get(0);
	}

	@Override
	public void addOrUpdateUser(User user) {

	}
}
