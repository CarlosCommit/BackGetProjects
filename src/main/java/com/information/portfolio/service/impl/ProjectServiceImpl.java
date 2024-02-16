package com.information.portfolio.service.impl;

import com.information.portfolio.repository.ProjectDAO;
import com.information.portfolio.service.ProjectService;
import org.springframework.stereotype.Service;

@Service("jdbcImpl")
public class ProjectServiceImpl implements ProjectService {
    private final ProjectDAO projectDAO;

    public ProjectServiceImpl(ProjectDAO projectDAO)
    {
        this.projectDAO = projectDAO;
    }
    @Override
    public Object getAllProjects() {
        return projectDAO.getAllProjects();
    }
}
