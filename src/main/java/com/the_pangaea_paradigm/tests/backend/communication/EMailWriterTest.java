package com.the_pangaea_paradigm.tests.backend.communication;

import com.the_pangaea_paradigm.backend.communication.EMailWriter;
import com.the_pangaea_paradigm.backend.communication.interfaces.Writer;
import com.the_pangaea_paradigm.backend.dto.Applicant;
import com.the_pangaea_paradigm.backend.dto.Project;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;

public class EMailWriterTest {

    private static Project project = new Project();
    private static Applicant applicant = new Applicant();

    @BeforeClass
    public static void onlyOnce() {
        project.setName("projectname");
        project.setInitiatorName("projectinitiatorname");
        project.setShortDescription("projectshortdescription");
        project.setLongDescription("projectlongdescription");
        project.setRequiredSkillSets("projectrequiredskillsets");
        project.setEmailAddress("projectemailaddress");
        project.setEthereumAddress("projectethereumaddress");

        applicant.setName("applicantname");
        applicant.setDescription("applicantdescription");
        applicant.setSkillSets("applicantskillsets");
        applicant.setEmailAddress("applicantemailaddress");
        applicant.setOtherContactDetails("applicantothercontactdetails");
    }

    @Test
    public void writeApplicationReturnsCorrectEMailString() throws UnsupportedEncodingException {
        Writer eMailWriter = new EMailWriter();

        assertEquals(
                "window.open('mailto:projectemailaddress?subject=Someone%20applied%20to%20your%20" +
                        "Project!&body=Hi%20projectinitiatorname,%0D%0A%0D%0AI%20would%20like%20to%20participate%20" +
                        "in%20your%20project%20%22projectname%22!%0D%0AHere%20is%20some%20info%20about%20me:%0D%0A%0" +
                        "D%0AName%3A%20applicantname%0D%0ADescription%3A%0D%0Aapplicantdescription%0D%0ASkill%20Sets" +
                        "%3A%20applicantskillsets%0D%0AE-Mail%20Address%3A%20applicantemailaddress%0D%0AOther%20Conta" +
                        "ct%20Details%3A%20applicantothercontactdetails%0D%0A%0D%0AContact%20me%20if%20I%20can%20hel" +
                        "p%20out%20with%20your%20cause!%0D%0A%0D%0A')",
                eMailWriter.writeApplication(applicant, project)
        );
    }
}
