package com.the_pangaea_paradigm.services.interfaces;

import com.the_pangaea_paradigm.backend.dto.Applicant;
import com.the_pangaea_paradigm.backend.dto.Project;

import java.io.UnsupportedEncodingException;

/**
 *
 */
public interface ApplicantServiceInterface {

    String createApplicationTemplate(Applicant applicant, Project projectToApplyTo) throws UnsupportedEncodingException;
}
