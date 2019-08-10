package com.the_pangaea_paradigm.backend.communication;

import com.the_pangaea_paradigm.backend.dataobjects.Applicant;
import com.the_pangaea_paradigm.backend.dataobjects.Project;

import java.io.UnsupportedEncodingException;

/**
 *
 */
public interface Writer {

    String writeApplication(Applicant applicant, Project projectToApplyTo) throws UnsupportedEncodingException;
}
