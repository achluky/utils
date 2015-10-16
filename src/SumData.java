import java.io.IOException;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * 	@author ahmadluky
 */
public class SumData {
		
		private static final Logger LOG = LoggerFactory.getLogger(SumData.class);
		
		public static void main(String[] args) throws IOException, ParseException
		{	
			// Connecting MongoDB Database dataTwitter
	        MongoClient mongo 		= new MongoClient("localhost", 27017);
	        DB db					= mongo.getDB("dataTwitterTagging");
	        
	        // Get collection list from database
	        Set<String> collections 		= db.getCollectionNames();
	        for (String collectionName : collections) 
	        {
	        	DBCollection coll = db.getCollection(collectionName);
	         	LOG.info("Collection : "+collectionName+" Count:"+ coll.count()+"");
	        }
	        
			mongo.close();
	     }
}
