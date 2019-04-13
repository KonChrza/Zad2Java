package zad2;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class UserContext {
	
	public DBCollection dbContext; 
	public UserContext() throws UnknownHostException{
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			DB dbUser = mongo.getDB("Users");
			dbContext = dbUser.getCollection("User");
	}
	
}
