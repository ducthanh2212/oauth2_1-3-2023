package com.example.user;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data // lombok
@Document(collection = "user")
public class User {
	@Id
    private ObjectId _id;

    private String username;
    private String password;
    
    private String role;
}
