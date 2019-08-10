package com.the_pangaea_paradigm.services.interfaces;

import com.the_pangaea_paradigm.backend.dto.Project;
import com.the_pangaea_paradigm.backend.dto.ProjectList;

import java.io.IOException;

/**
 *
 */
public interface ProjectServiceInterface {

    ProjectList fetchAllProjects();

    void save(Project project) throws IOException;
}
