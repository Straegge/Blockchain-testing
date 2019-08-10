package com.the_pangaea_paradigm.backend.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * An Applicant entity.
 */
public class Applicant implements Serializable {

    @NotBlank(message = "Please enter the name you wish to apply with")
    @Size(max = 100, message = "Name must be less than or equal to 100 characters")
    private String name;

    @NotBlank(message = "Please write a short description of yourself")
    @Size(max = 500, message = "Description must be less than or equal to 500 characters")
    private String description;

    @Size(max = 200, message = "Please list your skill sets in less than 200 characters")
    private String skillSets;

    @Email
    @NotBlank(message = "Please enter your E-Mail address")
    private String emailAddress;

    @Size(max = 200, message = "Please list your other contact details in less than 200 characters")
    private String otherContactDetails;

    public Applicant() {

    }

    public Applicant(
            @NotBlank(message = "Please enter the name you wish to apply with") @Size(max = 100, message = "Name must be less than or equal to 100 characters") String name, @NotBlank(message = "Please write a short description of yourself") @Size(max = 500, message = "Description must be less than or equal to 500 characters") String description, @Size(max = 200, message = "Please list your skill sets in less than 200 characters") String skillSets, @Email @NotBlank(message = "Please enter your E-Mail address") String emailAddress, @Size(max = 200, message = "Please list your other contact details in less than 200 characters") String otherContactDetails) {
        this.name = name;
        this.description = description;
        this.skillSets = skillSets;
        this.emailAddress = emailAddress;
        this.otherContactDetails = otherContactDetails;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", skillSets='" + skillSets + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", otherContactDetails='" + otherContactDetails + '\'' +
                '}';
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

    public String getSkillSets() {
        return skillSets;
    }

    public void setSkillSets(String skillSets) {
        this.skillSets = skillSets;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getOtherContactDetails() {
        return otherContactDetails;
    }

    public void setOtherContactDetails(String otherContactDetails) {
        this.otherContactDetails = otherContactDetails;
    }
}
