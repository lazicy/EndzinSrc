package base;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoConnect {
	
	private DB db;
	private DBCollection coll;
	
	public MongoConnect() {
		
		MongoClient milan = new MongoClient();
		db = milan.getDB("projekat");
		coll = db.getCollection("test");
		
	}

}
