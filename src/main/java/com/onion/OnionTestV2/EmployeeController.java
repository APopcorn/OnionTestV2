package com.onion.OnionTestV2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployess() {
        List<Employee> list = new ArrayList<Employee>();
        repository.findAll().forEach(list::add);
        return list;
    }


    @GetMapping(path = "/employees/{id}")
    public Employee getEmployessById(@PathVariable("id") Long id) {
        Optional<Employee> employee = repository.findById(id);
        if (!employee.isPresent()) {
            return new Employee();
        }

        return employee.get();
    }

    @DeleteMapping("/employees")
    public String delAllEmployees() {
        repository.deleteAll();
        return "Successful delete";
    }

    // Add Student
    // http://localhost:8080/students ResponseEntity<Employee>
    @PostMapping("/employees")
    public ResponseEntity<Employee> addUser(@RequestBody Employee employee) {
        System.out.println("AddUser");
        repository.save(employee);
        new TestingJavaCodeAction().outputTest();
        //return "Success";
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
        // return new ResponseEntity<Employee>(newStudent, HttpStatus.CREATED);
    }




}
