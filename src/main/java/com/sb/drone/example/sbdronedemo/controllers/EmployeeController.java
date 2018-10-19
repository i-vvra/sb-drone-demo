package com.sb.drone.example.sbdronedemo.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.sb.drone.example.sbdronedemo.models.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private Map<Integer, Employee> employees = new HashMap<>();
    private AtomicInteger idCounter = new AtomicInteger();

    @GetMapping("/employee/{id}")
    public Employee findEmployee(@PathVariable("id") int id) {
        return employees.get(id);
    }

    @PutMapping("/employee")
    public void saveEmployee(@RequestBody Employee employee) {
        employees.put(idCounter.incrementAndGet(), employee);
    }
}