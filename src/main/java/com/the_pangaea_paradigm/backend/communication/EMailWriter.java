package com.the_pangaea_paradigm.backend.communication;

import com.the_pangaea_paradigm.backend.communication.interfaces.Writer;
import com.the_pangaea_paradigm.backend.dto.Applicant;
import com.the_pangaea_paradigm.backend.dto.Project;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * This meant as a workaround for not having a running SMTP server.
 * <p>
 * This is absolute garbage code (creating a JS mailto function from Java code), but I didn't want
 * to leave the functionality of applying to a project out in the first version of the application.
 * <p>
 * In the next version, will be replaced by either correct SMTP functionality or an internal messaging system.
 */
public class EMailWriter implements Writer {

    @Override
    public String writeApplication(Applicant applicant, Project projectToApplyTo) throws UnsupportedEncodingException {
        StringBuilder builder = new StringBuilder();

        builder.append("window.open('mailto:")
                .append(projectToApplyTo.getEmailAddress())
                .append("?subject=Someone%20applied%20to%20your%20Project!&body=Hi%20")
                .append(URLEncoder.encode(projectToApplyTo.getInitiatorName(), "UTF-8").replace("+", "%20"))
                .append(",%0D%0A%0D%0A")
                .append("I%20would%20like%20to%20participate%20in%20your%20project%20")
                .append("%22")
                .append(URLEncoder.encode(projectToApplyTo.getName(), "UTF-8").replace("+", "%20"))
                .append("%22")
                .append("!%0D%0AHere%20is%20some%20info%20about%20me:%0D%0A%0D%0A")
                .append("Name%3A%20")
                .append(URLEncoder.encode(applicant.getName(), "UTF-8").replace("+", "%20"))
                .append("%0D%0A")
                .append("Description%3A%0D%0A")
                .append(URLEncoder.encode(applicant.getDescription(), "UTF-8").replace("+", "%20"))
                .append("%0D%0A")
                .append("Skill%20Sets%3A%20")
                .append(URLEncoder.encode(applicant.getSkillSets(), "UTF-8").replace("+", "%20"))
                .append("%0D%0A")
                .append("E-Mail%20Address%3A%20")
                .append(URLEncoder.encode(applicant.getEmailAddress(), "UTF-8").replace("+", "%20"))
                .append("%0D%0A")
                .append("Other%20Contact%20Details%3A%20")
                .append(URLEncoder.encode(applicant.getOtherContactDetails(), "UTF-8").replace("+", "%20"))
                .append("%0D%0A%0D%0A")
                .append("Contact%20me%20if%20I%20can%20help%20out%20with%20your%20cause!%0D%0A%0D%0A")
                .append("')");


        return builder.toString();
    }
}
