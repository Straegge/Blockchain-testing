package com.the_pangaea_paradigm.backend.dataobjects;

/**
 * The entity class for a Project.
 */
public class Project {
    private String name;
    private String description;

    public Project() {

    }

    @Override
    public String toString() {
        return "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
