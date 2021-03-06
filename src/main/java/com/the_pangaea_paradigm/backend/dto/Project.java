package com.the_pangaea_paradigm.backend.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

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

    @Size(max = 200, message = "Please list some Skill Sets needed for your Project in less than 200 characters")
    private String requiredSkillSets;

    @Pattern(regexp = "(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x" +
            "0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[" +
            "a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\" +
            ".){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x2" +
            "1-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])",
            message = "Please enter a valid E-Mail Address")
    private String emailAddress;

    private String ethereumAddress;

    public Project() {

    }

    public Project(
            @NotBlank(message = "Please enter a name for your Project")
            @Size(max = 100, message = "Project name must be less than or equal to 100 characters")
                    String name,
            @NotBlank(message = "Please enter a name you wish to create your Project under")
            @Size(max = 100, message = "Initiator name must be less than or equal to 100 characters")
                    String initiatorName,
            @NotBlank(message = "Please describe your Project with a short, expressive sentence")
            @Size(max = 100, message = "Short Description must be less than or equal to 100 characters")
                    String shortDescription,
            @NotBlank(message = "Please write a more elaborate description of your Project")
            @Size(max = 1500, message = "Description must be less than or equal to 1500 characters")
                    String longDescription,
            @Size(max = 200, message = "Please list some skill sets needed for your Project in less than 200 characters")
                    String requiredSkillSets,
            @Email @NotBlank(message = "Please enter the E-Mail address you want to receive applications to")
                    String emailAddress,
            @NotBlank(message = "Please enter the Ethereum address of your Project")
            @Size(max = 100, message = "Ethereum address must be less than or equal to 100 characters")
                    String ethereumAddress
    ) {
        this.name = name;
        this.initiatorName = initiatorName;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.requiredSkillSets = requiredSkillSets;
        this.emailAddress = emailAddress;
        this.ethereumAddress = ethereumAddress;
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

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", initiatorName='" + initiatorName + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", requiredSkillSets='" + requiredSkillSets + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", ethereumAddress='" + ethereumAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return getName().equals(project.getName()) &&
                getInitiatorName().equals(project.getInitiatorName()) &&
                getShortDescription().equals(project.getShortDescription()) &&
                getLongDescription().equals(project.getLongDescription()) &&
                Objects.equals(getRequiredSkillSets(), project.getRequiredSkillSets()) &&
                getEmailAddress().equals(project.getEmailAddress()) &&
                Objects.equals(getEthereumAddress(), project.getEthereumAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getInitiatorName(), getShortDescription(), getLongDescription(), getRequiredSkillSets(), getEmailAddress(), getEthereumAddress());
    }
}
