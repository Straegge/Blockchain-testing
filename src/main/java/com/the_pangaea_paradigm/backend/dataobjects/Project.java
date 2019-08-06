package com.the_pangaea_paradigm.backend.dataobjects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A Project entity.
 */
public class Project implements Serializable {

    @NotBlank(message = "Please enter a name for your Project")
    @Size(max = 100, message = "Project name must be less than or equal to 100 characters")
    private String name;

    @NotBlank(message = "Please enter a name you wish to create your Project under")
    @Size(max = 100, message = "Initiator name must be less than or equal to 100 characters")
    private String initiatorName;

    @NotBlank(message = "Please describe your Project with a short, expressive sentence")
    @Size(max = 100, message = "Short Description must be less than or equal to 100 characters")
    private String shortDescription;

    @NotBlank(message = "Please write a more elaborate description of your Project")
    @Size(max = 1500, message = "Description must be less than or equal to 1500 characters")
    private String longDescription;

    @Size(max = 200, message = "Please list some skill sets needed for your Project in less than 200 characters")
    private String requiredSkillSets;

    @Email
    @NotBlank(message = "Please enter the E-Mail address you want to receive applications to")
    private String emailAddress;

    @NotBlank(message = "Please enter the Ethereum address of your Project")
    @Size(max = 100, message = "Ethereum address must be less than or equal to 100 characters")
    private String ethereumAddress;

    public Project() {

    }

    public Project(String name, String initiatorName,
                   String shortDescription, String longDescription,
                   String requiredSkillSets, String ethereumAddress) {
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

    public void setName(String name) {
        this.name = name;
    }

    public String getInitiatorName() {
        return initiatorName;
    }

    public void setInitiatorName(String initiatorName) {
        this.initiatorName = initiatorName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getRequiredSkillSets() {
        return requiredSkillSets;
    }

    public void setRequiredSkillSets(String requiredSkillSets) {
        this.requiredSkillSets = requiredSkillSets;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEthereumAddress() {
        return ethereumAddress;
    }

    public void setEthereumAddress(String ethereumAddress) {
        this.ethereumAddress = ethereumAddress;
    }
}
