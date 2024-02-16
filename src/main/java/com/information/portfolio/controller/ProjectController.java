package com.information.portfolio.controller;

import com.information.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${base.url}")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(@Qualifier("jdbcImpl") ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(path = "/projects", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getProjects() {
        return ResponseEntity.ok().body(projectService.getAllProjects());
    }

}
