package com.information.portfolio.repository;

import com.information.portfolio.model.Project;
import com.information.portfolio.model.Tecnology;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProjectDAO {

    private final DataSource dataSource;
    protected final Logger logger = LoggerFactory.getLogger(ProjectDAO.class);

    private final String SELECT_ALL_PROJECTS = "Select projectos.project_id, projectos.repo ,projectos.title, projectos.description, tech.name, tech.url from portfolio.project_technology pivot JOIN portfolio.projects projectos ON projectos.project_id = pivot.id_project JOIN portfolio.technologies tech ON tech.id = pivot.id_technology;";

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

            Map<String, Project> projectMap = new HashMap<>();

            while (resultSet.next()) {
                String projectId = resultSet.getString("project_id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String repoUrl = resultSet.getString("repo");
                String tecnologyName = resultSet.getString("name");
                String tecnologyUrl = resultSet.getString("url");
                Project project = projectMap.get(projectId);
                if (project == null) {
                    project = new Project();
                    project.setId(projectId);
                    project.setTitle(title);
                    project.setDescription(description);
                    project.setUrlRepo(repoUrl);
                    project.setTechnologies(new ArrayList<>());
                    projectMap.put(projectId, project);
                }
                Tecnology technology = new Tecnology();
                technology.setName(tecnologyName);
                technology.setUrl(tecnologyUrl);
                project.getTechnologies().add(technology);
            }

           projectList = new ArrayList<>(projectMap.values());



        }catch (SQLException exception)
        {
            logger.error("Ocurrio un error al ejecutar la consulta");
        }

        return projectList;
    }
}
