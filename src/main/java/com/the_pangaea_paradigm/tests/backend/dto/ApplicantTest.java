package com.the_pangaea_paradigm.tests.backend.dto;

import com.the_pangaea_paradigm.backend.dto.Applicant;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ApplicantTest {

    @Test
    public void equalsTest() {
        Applicant o1 = new Applicant();
        o1.setName("name");
        o1.setDescription("description");
        o1.setSkillSets("skillsets");
        o1.setEmailAddress("emailaddress");
        o1.setOtherContactDetails("othercontactdetails");

        Applicant o2 = new Applicant();
        o2.setName("anothername");
        o2.setDescription("description");
        o2.setSkillSets("skillsets");
        o2.setEmailAddress("emailaddress");
        o2.setOtherContactDetails("othercontactdetails");

        assertNotEquals(o1, o2);

        o2.setName("name");

        assertEquals(o1, o2);
    }
}
