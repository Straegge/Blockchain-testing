package com.the_pangaea_paradigm.backend.communication.interfaces;

import com.the_pangaea_paradigm.backend.dto.Applicant;
import com.the_pangaea_paradigm.backend.dto.Project;

import java.io.UnsupportedEncodingException;

/**
 *
 */
public interface Writer {

    String writeApplication(Applicant applicant, Project projectToApplyTo) throws UnsupportedEncodingException;
}
