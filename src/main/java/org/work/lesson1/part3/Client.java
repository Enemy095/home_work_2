package org.work.lesson1.part3;

import lombok.Getter;

import java.util.List;

@Getter

public class Client {
    private int id;
    private String name;
    private int age;
    private List<Phone> phones;
}
