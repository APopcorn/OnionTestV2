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
public class ProjectDetailsController {
    @Autowired
    private ProjectDetailsRepository repository;

    @GetMapping("/projectDetails")
    public List<ProjectDetails> getAllProjects() {
        List<ProjectDetails> list = new ArrayList<ProjectDetails>();
        repository.findAll().forEach(list::add);
        return list;
    }
}


