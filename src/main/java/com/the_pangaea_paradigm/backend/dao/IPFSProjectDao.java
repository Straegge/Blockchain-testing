package com.the_pangaea_paradigm.backend.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.the_pangaea_paradigm.Application;
import com.the_pangaea_paradigm.backend.dao.interfaces.ProjectDao;
import com.the_pangaea_paradigm.backend.dto.Project;
import com.the_pangaea_paradigm.backend.dto.ProjectList;
import com.the_pangaea_paradigm.utilities.GlobalConstants;
import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Concrete Data Access Object for executing CRUD operations on Projects
 * in communication with IPFS as data persistence layer.
 */
@Repository
public class IPFSProjectDao implements ProjectDao {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private Logger logger = Logger.getLogger(IPFSProjectDao.class.getName());

    @Override
    public Optional<Project> get(long id) {
        return Optional.empty();
    }

    @Override
    public ProjectList getAll() throws IOException {
        Multihash projectListMultihash = Application.PROJECT_LIST_FILE_IPFS_HASH;

        //Fetch ProjectList from IPFS
        String projectListAsString = new String(
                new IPFS(GlobalConstants.INFURA_IPFS_GATEWAY_ADDRESS)
                        .cat(projectListMultihash)
        );

        return gson.fromJson(projectListAsString, ProjectList.class);
    }

    @Override
    public void save(Project project) throws IOException {
        //Fetch ProjectList from IPFS
        ProjectList projectList = getAll();
        //Add Project
        projectList.getProjects().add(project);

        //Wrap the ProjectList in a byte array
        String projectListJsonString = gson.toJson(projectList);

        NamedStreamable.ByteArrayWrapper projectListStreamable =
                new NamedStreamable.ByteArrayWrapper(projectListJsonString.getBytes());

        //Add new ProjectList to IPFS
        MerkleNode addResult =
                new IPFS(GlobalConstants.INFURA_IPFS_GATEWAY_ADDRESS)
                        .add(projectListStreamable, true, false).get(0);

        //Update Hash pointing to ProjectList
        Application.PROJECT_LIST_FILE_IPFS_HASH = addResult.hash;

        logger.info("New IPFS Hash: " + addResult.hash);
    }

    @Override
    public void update(Project project, String[] params) {

    }

    @Override
    public void delete(Project project) {

    }
}
