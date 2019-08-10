package com.the_pangaea_paradigm.services;

import com.the_pangaea_paradigm.backend.dataobjects.Applicant;
import com.the_pangaea_paradigm.backend.dataobjects.Project;

import java.io.UnsupportedEncodingException;

/**
 *
 */
public interface ApplicantServiceInterface {

    String createApplicationTemplate(Applicant applicant, Project projectToApplyTo) throws UnsupportedEncodingException;
}
