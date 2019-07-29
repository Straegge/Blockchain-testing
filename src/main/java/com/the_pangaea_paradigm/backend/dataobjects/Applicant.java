package com.the_pangaea_paradigm.backend.dataobjects;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class Applicant {

    @NotBlank(message = "Please enter the Name you wish to apply with")
    @Max(value = 100, message = "Name must be less than or equal to 100 characters")
    private String name;

    @NotBlank(message = "Please write a short Description of yourself")
    @Max(value = 500, message = "Description must be less than or equal to 500 characters")
    private String description;

    private List<String> requiredSkillSets;

    @Email
    @NotBlank(message = "Please enter your E-Mail Address")
    private String emailAddress;

    private List<String> otherContactDetails;
}
