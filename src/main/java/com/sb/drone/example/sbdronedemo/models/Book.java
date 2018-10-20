package com.sb.drone.example.sbdronedemo.models;

import lombok.Data;

@Data
public class Book {
    private int id;
    private String name;
    private String isbn;
    private Author author;
}