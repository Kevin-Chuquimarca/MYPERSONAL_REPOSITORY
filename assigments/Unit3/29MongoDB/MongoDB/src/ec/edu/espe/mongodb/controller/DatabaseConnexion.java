package ec.edu.espe.mongodb.controller;

import ec.edu.espe.mongodb.model.Customer;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class DatabaseConnexion {
    private MongoClient customerMongoDB;
    private DB dataBase;
    private DBCollection dBCollection;
    
    public DatabaseConnexion() {
        customerMongoDB=new MongoClient("127.0.0.1",27017);
        dataBase=customerMongoDB.getDB("Cinema");
        dBCollection=dataBase.getCollection("Customer");
    }
    
    public void recordUser(Customer user){
        BasicDBObject file = new BasicDBObject();
        file.put("lastName", user.getLastName());
        file.put("name", user.getName());
        file.put("direction", user.getDirection());
        dBCollection.insert(file);
    }
        
    public void deleteUser(Customer user){
        BasicDBObject deleteQuery = new BasicDBObject();
        deleteQuery.put("lastName", user.getLastName());
        deleteQuery.put("name", user.getName());
        DBCursor cursor = dBCollection.find(deleteQuery);
        while (cursor.hasNext()) {
            DBObject item = cursor.next();
            dBCollection.remove(item);
        }
    }
}
