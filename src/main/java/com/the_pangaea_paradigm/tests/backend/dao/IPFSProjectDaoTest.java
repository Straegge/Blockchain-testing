package com.the_pangaea_paradigm.tests.backend.dao;

import com.the_pangaea_paradigm.Application;
import com.the_pangaea_paradigm.backend.dao.IPFSProjectDao;
import com.the_pangaea_paradigm.backend.dao.interfaces.ProjectDao;
import com.the_pangaea_paradigm.backend.dto.Project;
import com.the_pangaea_paradigm.backend.dto.ProjectList;
import io.ipfs.multihash.Multihash;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IPFSProjectDaoTest {

    private static Project project = new Project();
    private static Project project2 = new Project();
    private static ProjectList projectList;

    @BeforeClass
    public static void onlyOnce() {
        Application.PROJECT_LIST_FILE_IPFS_HASH = Multihash.fromBase58("QmNoYN7dtoeAAeLmQmwN9ApMiQsTYyenS599WbvHg53tTw");

        project.setName("projectname");
        project.setInitiatorName("initiatorname");
        project.setShortDescription("shortdescription");
        project.setLongDescription("longdescription");
        project.setRequiredSkillSets("skillsets");
        project.setEmailAddress("email@address.com");
        project.setEthereumAddress("ethereumaddress");

        project2.setName("projectname2");
        project2.setInitiatorName("initiatorname2");
        project2.setShortDescription("shortdescription2");
        project2.setLongDescription("longdescription2");
        project2.setRequiredSkillSets("skillsets2");
        project2.setEmailAddress("email2@address.com");
        project2.setEthereumAddress("ethereumaddress2");

        List<Project> projects = new ArrayList<>();
        projects.add(project);
        projects.add(project2);

        projectList = new ProjectList(projects);
    }

    @Test
    public void getAllReturnsCorrectProjectListFromIPFS() throws IOException {
        ProjectDao projectDao = new IPFSProjectDao();

        assertEquals(
                projectList,
                projectDao.getAll()
        );
    }
}
