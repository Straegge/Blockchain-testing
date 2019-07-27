package com.the_pangaea_paradigm.backend.dataobjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper for a list of Projects.
 */
public class ProjectList {

    private List<Project> projects;

    public ProjectList() {
        projects = new ArrayList<>();
    }
    public ProjectList(List<Project> projects) {
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
