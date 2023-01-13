package com.onion.OnionTestV2;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Iterable<Employee> findAll() {
        return repository.findAll();
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public Employee updateEmployeeById(Employee employee, Long id) {
        Employee updateEmployee = new Employee();
        updateEmployee.setId(id);
        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setLastName(employee.getLastName());
        return repository.save(updateEmployee);
    }

    public boolean deleteById(Long id) {
        repository.deleteById(id);
        // wiard ????
        return true;
    }

    public String deleteAll() {
        repository.deleteAll();
        return "All records deleted";
    }

}
