package com.the_pangaea_paradigm.backend.dao;

import com.google.gson.Gson;
import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.the_pangaea_paradigm.backend.ipfs.IPFSStarter;
import com.the_pangaea_paradigm.utilities.GlobalConstants;
import io.ipfs.api.IPFS;
import io.ipfs.multihash.Multihash;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Concrete Data Access Object for executing CRUD operations on Projects
 * in communication with IPFS as data persistence layer.
 */
@Repository
public class IPFSProjectDao implements ProjectDao {

    //private IPFS ipfs = new IPFS(GlobalConstants.INFURA_IPFS_GATEWAY_MULTIADDRESS.toString());

    @Override
    public Optional<Project> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Project> getAll() {
        //IPFSStarter ipfsStarter = new IPFSStarter();
        List<Project> projectList = new ArrayList<>();
        /*Gson gson = new Gson();
        Multihash filePointerToProjectListFile = Multihash.fromBase58(GlobalConstants.PROJECT_LIST_FILE_IPFS_HASH.toString());

        String fileContentString = null;
        try {
            fileContentString = new String(ipfs.cat(filePointerToProjectListFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Project project = gson.fromJson(fileContentString, Project.class);*/
        return projectList;
    }

    @Override
    public void save(Project project) {

    }

    @Override
    public void update(Project project, String[] params) {

    }

    @Override
    public void delete(Project project) {

    }
}
