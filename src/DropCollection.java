import java.io.IOException;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class DropCollection {
	
	private static final Logger LOG = LoggerFactory.getLogger(DropCollection.class);
	
	public static void main(String[] args) throws IOException, ParseException
	{	
        MongoClient mongo 		= new MongoClient("localhost", 27017);
        // define database
        DB db					= mongo.getDB("dataTwitterSubjectifFilter"); 
        //dataTwitterPraproses dataTwitterTagging dataTwitterSubjectifFilter
        
        Set<String> collections 		= db.getCollectionNames();
        for (String collectionName : collections) 
        {
        	DBCollection coll = db.getCollection(collectionName);
        	if (!collectionName.equals("system.indexes")) {
            	coll.drop();
             	LOG.info("Collection : "+collectionName+" DROPED");	
			}
        }
        
		mongo.close();
     }
}
