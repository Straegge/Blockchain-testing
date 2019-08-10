package com.the_pangaea_paradigm.backend.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper for a list of Projects.
 */
public class ProjectList implements Serializable {

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
}
