package com.the_pangaea_paradigm.tests.backend.dto;

import com.the_pangaea_paradigm.backend.dto.Project;
import com.the_pangaea_paradigm.backend.dto.ProjectList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ProjectListTest {

    @Test
    public void equalsTest() {
        ProjectList o1 = new ProjectList();
        List<Project> list1 = new ArrayList<>();
        list1.add(new Project());
        list1.get(0).setName("name");
        list1.get(0).setInitiatorName("initiatorname");
        list1.get(0).setShortDescription("shortdescription");
        list1.get(0).setLongDescription("longdescription");
        list1.get(0).setRequiredSkillSets("requiredskillsets");
        list1.get(0).setEmailAddress("emailaddress");
        list1.get(0).setEthereumAddress("ethereumaddress");
        o1.setProjects(list1);

        ProjectList o2 = new ProjectList();
        List<Project> list2 = new ArrayList<>();
        list2.add(new Project());
        list2.get(0).setName("anothername");
        list2.get(0).setInitiatorName("initiatorname");
        list2.get(0).setShortDescription("shortdescription");
        list2.get(0).setLongDescription("longdescription");
        list2.get(0).setRequiredSkillSets("requiredskillsets");
        list2.get(0).setEmailAddress("emailaddress");
        list2.get(0).setEthereumAddress("ethereumaddress");
        o2.setProjects(list2);

        assertNotEquals(o1, o2);

        o2.getProjects().get(0).setName("name");

        assertEquals(o1, o2);
    }
}
