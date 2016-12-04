package com.studentshowcase.model.user;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teacher")
public class Teacher extends AbstractUser{
}
