package com.the_pangaea_paradigm.backend.dataobjects;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public class ProjectListMerkleDag implements Serializable {

    private String data;
    private List<Project> links;

    public ProjectListMerkleDag() {

    }

    public ProjectListMerkleDag(String data, List<Project> links) {
        this.data = data;
        this.links = links;
    }

    @Override
    public String toString() {
        return "";
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Project> getLinks() {
        return links;
    }

    public void setLinks(List<Project> links) {
        this.links = links;
    }
}
