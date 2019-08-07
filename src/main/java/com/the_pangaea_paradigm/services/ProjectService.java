package com.the_pangaea_paradigm.services;

import com.the_pangaea_paradigm.backend.dao.ProjectDao;
import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.the_pangaea_paradigm.backend.dataobjects.ProjectList;
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

    //No Qualifier needed for autowiring as long as there is only one ProjectDao (IPFSProjectDao)
    @Autowired
    private ProjectDao projectDao;

    @Override
    public ProjectList fetchAllProjects() {

        return projectDao.getAll();
    }

    @Override
    public void save(Project project) throws IOException {
        projectDao.save(project);
    }
}
