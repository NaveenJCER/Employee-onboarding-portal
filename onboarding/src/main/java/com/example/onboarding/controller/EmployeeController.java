package com.example.onboarding.controller;

import com.example.onboarding.model.Employee;
import com.example.onboarding.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // POST /employees — Add a new employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee emp) {
        return service.save(emp);
    }

    // GET /employees — Retrieve all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAll();
    }

    // GET /employees/{id} — Retrieve a single employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // PUT /employees/{id} — Update an employee's details and onboarding status
    @PutMapping("/{id}")
    public Employee updateStatus(@PathVariable Long id, @RequestBody Employee emp) {
        return service.update(id, emp);
    }

    // DELETE /employees/{id} — Remove an employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}