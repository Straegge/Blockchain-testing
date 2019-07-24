package com.the_pangaea_paradigm.services;

import com.the_pangaea_paradigm.backend.dao.ProjectDao;
import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.the_pangaea_paradigm.backend.dataobjects.ProjectList;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *  Service class for Projects.
 *
 *  Receives CRUD requests from frontend controllers (event handlers) and
 *  transfers them to the Data Access Objects.
 */
public class ProjectService {

    //No Qualifier needed for autowiring as long as there is only one ProjectDao (IPFSProjectDao)
    @Autowired
    private ProjectDao projectDao;

    public ProjectList fetchAllProjects() {
        List<Project> projectList = projectDao.getAll();

        return new ProjectList(projectList);
    }
}
