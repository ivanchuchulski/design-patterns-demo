package com.example.other.repository;

public interface UserRepository {
    void addFilm(Film film);

    Film getFilm(String title);

    void buyTicket(User user, Film film);
}
