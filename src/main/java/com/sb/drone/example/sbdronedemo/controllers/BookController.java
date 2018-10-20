package com.sb.drone.example.sbdronedemo.controllers;

import java.util.HashMap;
import java.util.Map;

import com.sb.drone.example.sbdronedemo.models.Book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private Map<Integer, Book> books = new HashMap<>();

    public BookController() {

    }

    @GetMapping("/books/{id}")
    public Book findBookById(@PathVariable int id) {
        return books.get(id);
    }

}