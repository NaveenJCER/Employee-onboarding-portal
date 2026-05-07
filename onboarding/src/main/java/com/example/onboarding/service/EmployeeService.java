package com.example.onboarding.service;

import com.example.onboarding.model.Employee;
import com.example.onboarding.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    // Create a new employee
    public Employee save(Employee emp) {
        return repo.save(Objects.requireNonNull(emp));
    }

    // Retrieve all employees
    public List<Employee> getAll() {
        return repo.findAll();
    }

    // Retrieve a single employee by ID
    public Employee getById(Long id) {
        return repo.findById(Objects.requireNonNull(id))
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    // Update onboarding status fields (and name/email) for an existing employee
    public Employee update(Long id, Employee updatedEmp) {
        Employee emp = repo.findById(Objects.requireNonNull(id))
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        emp.setName(updatedEmp.getName());
        emp.setEmail(updatedEmp.getEmail());
        emp.setDocumentSubmitted(updatedEmp.isDocumentSubmitted());
        emp.setItSetupDone(updatedEmp.isItSetupDone());
        emp.setTrainingCompleted(updatedEmp.isTrainingCompleted());

        return repo.save(emp);
    }

    // Delete an employee by ID
    public void delete(Long id) {
        Long nonNullId = Objects.requireNonNull(id);
        if (!repo.existsById(nonNullId)) {
            throw new RuntimeException("Employee not found with id: " + nonNullId);
        }
        repo.deleteById(nonNullId);
    }
}