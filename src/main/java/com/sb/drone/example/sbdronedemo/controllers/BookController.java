package com.sb.drone.example.sbdronedemo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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
        return books.values().stream().filter(b -> b.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    @GetMapping("/books/{isbn}")
    public Book findBooksByIsbn(@PathVariable String isbn) {
        Optional<Book> book = books.values().stream().filter(b -> b.getIsbn().equalsIgnoreCase(isbn)).findFirst();
        return book.get();
    }

    @GetMapping("/books/{author}")
    public List<Book> findBooksByAuthor(@PathVariable String author) {
        return books.values().stream().filter(b->b.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
    }
}