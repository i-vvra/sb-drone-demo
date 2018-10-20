package com.sb.drone.example.sbdronedemo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.sb.drone.example.sbdronedemo.models.Book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private Map<Integer, Book> books = new HashMap<>();
    private AtomicInteger sequence = new AtomicInteger();

    public BookController() {
    }

    @PostMapping("/books")
    public void newBook(@RequestBody Book book) {
        books.put(sequence.incrementAndGet(), book);
    }

    @GetMapping("/books/{name}")
    public List<Book> findBooksByName(@PathVariable String name) {
        return books.values().stream().filter(b->b.getName().equalsIgnoreCase(name)).collect(Collectors.toList())
    }
}