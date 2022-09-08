package com.example.other.repository;

import java.util.HashSet;
import java.util.Set;

public class UserRepositoryInMemory implements UserRepository {

    private final Set<Film> films;
    private final Set<Ticket> tickets;

    public UserRepositoryInMemory() {
        films = new HashSet<>();
        tickets = new HashSet<>();
    }

    @Override
    public void addFilm(Film film) {
        if (!films.add(film)) {
            System.out.println("film is already added");
        }
    }

    @Override
    public Film getFilm(String title) {
        for (var it = films.iterator(); it.hasNext();) {
            Film film = it.next();
            if (film.getTitle().equals(title)) {
                return film;
            }
        }

        return null;
    }

    @Override
    public void buyTicket(User user, Film film) {
        Ticket ticket = new Ticket(user, film);

        if (!tickets.add(ticket)) {
            System.out.println("ticket is already bought");
        }
    }

    private record Ticket(User user, Film film) {
    }
}
