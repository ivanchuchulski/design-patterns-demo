package com.example.other.repository;

import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

public class UserRepositoryMongoDB implements UserRepository {

    private final MongoClient mongoClient;

    public UserRepositoryMongoDB(String connectionURL) {
        mongoClient = MongoClients.create(connectionURL);
    }

    @Override
    public void addFilm(Film film) {
        MongoDatabase database = mongoClient.getDatabase("testdb");
        MongoCollection<Document> films = database.getCollection("films");

        Document filmDocument = new Document("title", film.getTitle()).append("duration", film.getDuration());

        if (films.find(filmDocument).first() == null) {
            films.insertOne(filmDocument);
        } else {
            System.out.println("mongo: film is already added!");
        }
    }

    @Override
    public Film getFilm(String title) {
        MongoDatabase database = mongoClient.getDatabase("testdb");
        MongoCollection<Document> films = database.getCollection("films");

        Document filmDocument = new Document("title", title);

        String s = films.find(filmDocument).first().toJson();
        return new Gson().fromJson(s, Film.class);
    }

    @Override
    public void buyTicket(User user, Film film) {
        MongoDatabase database = mongoClient.getDatabase("testdb");
        MongoCollection<Document> films = database.getCollection("films");

        Document ticketDocument = new Document("title", film.getTitle()).append("user", user.getUsername());

        if (films.find(ticketDocument).first() == null) {
            films.insertOne(ticketDocument);
        } else {
            System.out.println("mongo: ticket already bought!");
        }
    }

    public void test() {
        MongoDatabase database = mongoClient.getDatabase("testdb");
        MongoCollection<Document> toysCollection = database.getCollection("toys");

        // Document toy = new Document("name", "yoyo").append("ages", new Document("min", 5));
        // toysCollection.insertOne(toy);
        //
        // Document film = new Document("title", "titanic");
        // toysCollection.insertOne(film);

        // Document yoyo = toysCollection.find(new Document("name", "yoyo")).first();

        for (Document document : toysCollection.find()) {
            if (document.containsKey("ages")) {
                System.out.println(document);
            }
        }
    }
}
