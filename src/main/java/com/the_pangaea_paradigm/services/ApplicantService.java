package com.the_pangaea_paradigm.services;

import com.the_pangaea_paradigm.backend.communication.EMailWriter;
import com.the_pangaea_paradigm.backend.dto.Applicant;
import com.the_pangaea_paradigm.backend.dto.Project;
import com.the_pangaea_paradigm.services.interfaces.ApplicantServiceInterface;

import java.io.UnsupportedEncodingException;

/**
 *
 */
public class ApplicantService implements ApplicantServiceInterface {

    @Override
    public String createApplicationTemplate(Applicant applicant, Project projectToApplyTo) throws UnsupportedEncodingException {
        return new EMailWriter().writeApplication(applicant, projectToApplyTo);
    }
}
