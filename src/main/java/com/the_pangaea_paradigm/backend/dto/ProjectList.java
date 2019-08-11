package com.the_pangaea_paradigm.backend.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "ProjectList{" +
                "projects=" + projects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectList)) return false;
        ProjectList that = (ProjectList) o;
        return getProjects().equals(that.getProjects());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProjects());
    }
}
