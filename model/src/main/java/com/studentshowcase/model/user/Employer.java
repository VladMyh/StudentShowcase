package com.studentshowcase.model.user;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employer")
public class Employer extends AbstractUser {
}
