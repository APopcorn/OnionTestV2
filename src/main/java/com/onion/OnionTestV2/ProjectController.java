package com.onion.OnionTestV2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectRepository repository;

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        List<Project> list = new ArrayList<Project>();
        repository.findAll().forEach(list::add);
        return list;
    }

    @DeleteMapping("/projects")
    public String delAllEmployees() {
        repository.deleteAll();
        return "Successful delete";
    }


    @PostMapping("/projects")
    public ResponseEntity<Project> addUser(@RequestBody Project project) {
        System.out.println("AddUser");
        repository.save(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }

}
