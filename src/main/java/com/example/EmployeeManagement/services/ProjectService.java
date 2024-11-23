package com.example.EmployeeManagement.services;

import com.example.EmployeeManagement.Helpers.ProjectHelper;
import com.example.EmployeeManagement.model.Project;
import com.example.EmployeeManagement.repository.ProjectRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    EmployeeService employeeService;

    //    add project
    public String addProject(ProjectHelper projectHelper) {
        Project project = new Project();


//        verify employee id
        boolean isVerify = true;
        List<ObjectId> employeesId = projectHelper.getEmployees();
        for (ObjectId id : employeesId) {
            isVerify = employeeService.verifyEmployeeById(id);
            if (!isVerify) {
                return "Employee id is not match : " + id;
            }

        }


        project.setProjectName(projectHelper.getProjectName());
        project.setDescription(projectHelper.getDescription());
        project.setTechStack(projectHelper.getTechStack());
        project.setClientName(projectHelper.getClientName());
        project.setBudget(projectHelper.getBudget());
        project.setEmployees(projectHelper.getEmployees());
        project.setLastUpdate(LocalDateTime.now());


        projectRepo.save(project);
        return "Project is saved......";
    }

    //    update project
    public String updateProject(ObjectId id, Project project) {
        Project oldProject = projectRepo.findById(id).orElse(new Project());
        if (oldProject.getId() == null) return "Project not available";

        if (project.getProjectName() != null && !project.getProjectName().equals(oldProject.getProjectName())) {
            oldProject.setProjectName(project.getProjectName());
        }
        if (project.getDescription() != null && !project.getDescription().equals(oldProject.getDescription())) {
            oldProject.setDescription(project.getDescription());
        }
        if (project.getTechStack() != null && !project.getTechStack().equals(oldProject.getTechStack())) {
            oldProject.setTechStack(project.getTechStack());
        }
        if (project.getBudget() != null && !project.getBudget().equals(oldProject.getBudget())) {
            oldProject.setBudget(project.getBudget());
        }
        if (project.getEmployees() != null && !project.getEmployees().equals(oldProject.getEmployees())) {
            oldProject.setEmployees(project.getEmployees());

        }
        projectRepo.save(project);
        return "Project updated";
    }

    public Optional<Project> getProjectById(ObjectId id) {
        return projectRepo.findById(id);
    }

    public List<Project> getProjects() {
        return projectRepo.findAll();
    }

    public String deleteProject(ObjectId id) {
        Optional<Project> project = projectRepo.findById(id);
        if (project.isEmpty()) {
            return "project not found";
        }
        projectRepo.deleteById(id);
        return "Project deleted";
    }
     public boolean verifyByProjectId(ObjectId id){
       return projectRepo.existsById(id) ;


     }

}
