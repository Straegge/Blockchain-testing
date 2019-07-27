package com.the_pangaea_paradigm.backend.dataobjects;

import java.io.Serializable;

/**
 * A Project entity.
 */
public class Project implements Serializable {
    private String name;
    private String description;

    public Project() {

    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
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
