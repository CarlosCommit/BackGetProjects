package com.information.portfolio.repository;

import com.information.portfolio.model.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectDAO {

    private final DataSource dataSource;
    protected final Logger logger = LoggerFactory.getLogger(ProjectDAO.class);

    private final String SELECT_ALL_PROJECTS = "SELECT title, description, repo FROM PORTFOLIO.PROJECTS";

    public ProjectDAO(@Qualifier("dataSourcePortfolio") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Object getAllProjects()  {
        /*
        1- Definir la conexion
        2- Preparar el statement (Statement, PreparedStatement, CallableStatement-> procedemientosAlmacenados
        3- ejecutar-> update (insert,update,delete) : int de filas modificadas
                   -> executequery ( select) : ResultSet -> iterar con next
         */

        List<Project> projectList = new ArrayList<>();
        try(Connection conn = dataSource.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_PROJECTS);)
        {

            while (resultSet.next())
            {
                Project project = new Project();
                project.setTitle(resultSet.getString("title"));
                project.setDescription(resultSet.getString("description"));
                project.setUrlRepo(resultSet.getString("repo"));
                projectList.add(project);
            }

        }catch (SQLException exception)
        {
            logger.error("Ocurrio un error al ejecutar la consulta");
        }

        return projectList;
    }
}
