package com.william.portfolio.service;

import com.william.portfolio.model.Project;
import com.william.portfolio.repository.ProjectRepository;
import com.william.portfolio.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final SkillRepository skillRepository;


    @Autowired
    public ProjectService(ProjectRepository projectRepository, SkillRepository skillRepository) {
        this.projectRepository = projectRepository;
        this.skillRepository = skillRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Project Not found."));
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }
    public Project updateProject(Long id, Project updateProject){
        Project project = getProjectById(id);
        project.setTitle(updateProject.getTitle());
        project.setDescription(updateProject.getDescription());
        project.setImageUrl(updateProject.getImageUrl());
        return projectRepository.save(project);
    }

}