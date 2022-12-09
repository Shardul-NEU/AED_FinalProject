/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author priyankakhimyani
 */
public class DatabaseConnection {
    
    public MongoDatabase connectToDatabase(){
        
        ConnectionString connectionString = new ConnectionString("mongodb+srv://suraj:7021072380@cluster0.ehrr7jd.mongodb.net/?retryWrites=true&w=majority");
        
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                                             pojoCodecRegistry);
        
        
        MongoClientSettings clientSettings;
        clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();
        
        MongoClient client = (MongoClient) MongoClients.create(clientSettings);
        MongoDatabase database = client.getDatabase("SportsManagement");
       
        
        return database;
    }
    
}
