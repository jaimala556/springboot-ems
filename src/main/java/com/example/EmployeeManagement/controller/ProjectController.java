package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.Helpers.ProjectHelper;
import com.example.EmployeeManagement.model.Project;
import com.example.EmployeeManagement.services.ProjectService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping("/project")
    public String addProject(@RequestBody ProjectHelper projectHelper)
    {
        return projectService.addProject(projectHelper);
    }

    @DeleteMapping("/project/{id}")
    public String deleteProject(@PathVariable ObjectId id){
        return projectService.deleteProject(id);
    }

    @PutMapping("/project/{id}")
    public String updateProject(@PathVariable ObjectId id,@RequestBody Project project){
        return projectService.updateProject(id,project);
    }
     @GetMapping("/project/{id}")
    public Optional<Project> getProjectById(@PathVariable ObjectId id){
        return projectService.getProjectById(id);
     }
      @GetMapping("/project")
    public List<Project> getProjects(){
        return projectService.getProjects()     ;}


}
