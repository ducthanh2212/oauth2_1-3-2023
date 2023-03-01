package com.example.dao;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.example.user.User;
import com.mongodb.client.MongoCollection;
@Repository
public class UserDao {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	private MongoCollection<Document> getCollection(){
		return mongoTemplate.getCollection("user");
	}
	
	public User getUser(String userName) {
		Document filter = new Document ("username", userName);
		Document userDoc = this.getCollection().find(filter).first();
		User user = mongoTemplate.getConverter().read(User.class, userDoc);
		return user;
	}
	
	public User getUserById(String id) {
		Document filter = new Document("_id", new ObjectId(id));
		Document userDoc = this.getCollection().find(filter).first();
		User user = mongoTemplate.getConverter().read(User.class, userDoc);
		return user;
	}
}
