package com.example.other.repository;

public class MongoDemo {
    public void demo() {
        testMongo();
        testInMemory();
    }

    public void testMongo() {
        String connectionURL = "mongodb://localhost:27017";
        UserRepository userRepositoryMongoDB = new UserRepositoryMongoDB(connectionURL);
        // userRepositoryMongoDB.test();

        insertData(userRepositoryMongoDB);
    }

    public void testInMemory() {
        UserRepository userRepositoryInMemory = new UserRepositoryInMemory();

        insertData(userRepositoryInMemory);
    }

    public static void insertData(UserRepository userRepositoryInMemory) {
        Film titanic = new Film("titanic", 105);
        User peter = new User("peter@gmail.com", "peter", "1234");

        userRepositoryInMemory.addFilm(titanic);
        userRepositoryInMemory.buyTicket(peter, titanic);

        Film film = userRepositoryInMemory.getFilm(titanic.getTitle());
        System.out.println(film.toString());
    }
}
