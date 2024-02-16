package com.information.portfolio.service;

import com.information.portfolio.model.Project;
import com.information.portfolio.model.response.Result;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectService {
    public ResponseEntity<Result> getAllProjects();
}
