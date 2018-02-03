package base;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoConnect {
	
	private DB db;
	private static DBCollection coll;
	
	public MongoConnect() {
		
		MongoClient roki = new MongoClient();
		db = roki.getDB("projekat");
		coll = db.getCollection("test");
		
	}
	
	public static void insertIntoMongo(int rbr, String title, String desc, String url, int pripadnost, BasicDBList vodiNa) {
		String s;
		
		
		BasicDBObject doc = new BasicDBObject("naslov", title)
				.append("rbr", rbr)
				.append("opis", desc)
				.append("URL", url)
				.append("otkrivenNa", pripadnost)
				.append("vodiNa", vodiNa);
		coll.insert(doc);
	}
	


}
