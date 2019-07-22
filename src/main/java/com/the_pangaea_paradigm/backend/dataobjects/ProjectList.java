package com.the_pangaea_paradigm.backend.dataobjects;

import java.util.List;

/**
 *
 */
public class ProjectList {
    private List<Project> projectList;

    public ProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }
}
