package com.the_pangaea_paradigm.services;

import com.the_pangaea_paradigm.backend.dao.interfaces.ProjectDao;
import com.the_pangaea_paradigm.backend.dto.Project;
import com.the_pangaea_paradigm.backend.dto.ProjectList;
import com.the_pangaea_paradigm.services.interfaces.ProjectServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Service class for Projects.
 * <p>
 * Receives CRUD requests from frontend controllers (event handlers) and
 * transfers them to the Data Access Objects.
 */
@Service
public class ProjectService implements ProjectServiceInterface {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public ProjectList fetchAllProjects() throws IOException {

        return projectDao.getAll();
    }

    @Override
    public void save(Project project) throws IOException {
        projectDao.save(project);
    }
}
