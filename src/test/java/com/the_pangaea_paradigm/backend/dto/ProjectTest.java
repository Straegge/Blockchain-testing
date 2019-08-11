package com.the_pangaea_paradigm.backend.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ProjectTest {

    @Test
    public void equalsTest() {
        Project o1 = new Project();
        o1.setName("name");
        o1.setInitiatorName("initiatorname");
        o1.setShortDescription("shortdescription");
        o1.setLongDescription("longdescription");
        o1.setRequiredSkillSets("requiredskillsets");
        o1.setEmailAddress("emailaddress");
        o1.setEthereumAddress("ethereumaddress");

        Project o2 = new Project();
        o2.setName("anothername");
        o2.setInitiatorName("initiatorname");
        o2.setShortDescription("shortdescription");
        o2.setLongDescription("longdescription");
        o2.setRequiredSkillSets("requiredskillsets");
        o2.setEmailAddress("emailaddress");
        o2.setEthereumAddress("ethereumaddress");

        assertNotEquals(o1, o2);

        o2.setName("name");

        assertEquals(o1, o2);
    }
}
