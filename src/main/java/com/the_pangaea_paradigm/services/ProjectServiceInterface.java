package com.the_pangaea_paradigm.services;

import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.the_pangaea_paradigm.backend.dataobjects.ProjectList;

import java.io.IOException;

/**
 *
 */
public interface ProjectServiceInterface {

    ProjectList fetchAllProjects();

    void save(Project project) throws IOException;
}
