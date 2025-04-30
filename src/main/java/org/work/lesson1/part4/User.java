package org.work.lesson1.part4;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;


@Getter
public class User {
    private Long id;
    private String name;
    @Setter
    private List<User> friends;

    public User(String name) {
        this.name = name;
        this.id = new Random().nextLong();
    }

    @Override
    public String toString() {
        return this.id + " " + this.name;
    }
}
