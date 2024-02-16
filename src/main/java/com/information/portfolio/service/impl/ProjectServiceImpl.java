package com.information.portfolio.service.impl;

import com.information.portfolio.constant.Constant;
import com.information.portfolio.handle.HandleSql;
import com.information.portfolio.model.Project;
import com.information.portfolio.model.response.Result;
import com.information.portfolio.repository.ProjectDAO;
import com.information.portfolio.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

@Service("jdbcImpl")
public class ProjectServiceImpl implements ProjectService {
    private final ProjectDAO projectDAO;
    private final HandleSql handleSql;


    public ProjectServiceImpl(ProjectDAO projectDAO, HandleSql handleSql) {
        this.projectDAO = projectDAO;
        this.handleSql = handleSql;
    }

    @Override
    public ResponseEntity<Result> getAllProjects() {
        Result result = new Result();
        try {
            List<Project> projectList = projectDAO.getAllProjects();
            handleSql.handleExecuteSqlSuccess(result, projectList);
        } catch (SQLException e) {
            handleSql.handleExecuteSqlFail(result, e);
        }
        return new ResponseEntity<>(result, result.getCode().equals(Constant.CODE_OK) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
