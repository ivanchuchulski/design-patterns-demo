package com.example.other.repository;

import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Objects;

public class Film {

    private final String title;


    private final int duration;

    public Film(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Film film = (Film) o;
        return duration == film.duration && Objects.equals(title, film.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, duration);
    }
}
