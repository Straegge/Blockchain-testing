package com.the_pangaea_paradigm.backend.dataobjects;

import java.io.Serializable;
import java.util.List;

/**
 * A Project entity.
 */
public final class Project implements Serializable {

    private String name;
    private String initiatorName;
    private String shortDescription;
    private String longDescription;
    private List<String> requiredSkillSets;
    private String ethereumAddress;

    public Project() {

    }

    public Project(String name, String initiatorName,
                   String shortDescription, String longDescription,
                   List<String> requiredSkillSets, String ethereumAddress) {
        this.name = name;
        this.initiatorName = initiatorName;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.requiredSkillSets = requiredSkillSets;
        this.ethereumAddress = ethereumAddress;
    }

    @Override
    public String toString() {
        return "";
    }

    public String getName() {
        return name;
    }

    public String getInitiatorName() {
        return initiatorName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public List<String> getRequiredSkillSets() {
        return requiredSkillSets;
    }

    public String getEthereumAddress() {
        return ethereumAddress;
    }
}
