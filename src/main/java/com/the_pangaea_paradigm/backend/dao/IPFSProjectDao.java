package com.the_pangaea_paradigm.backend.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.the_pangaea_paradigm.Application;
import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.the_pangaea_paradigm.backend.dataobjects.ProjectList;
import com.the_pangaea_paradigm.utilities.GlobalConstants;
import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Optional;

/**
 * Concrete Data Access Object for executing CRUD operations on Projects
 * in communication with IPFS as data persistence layer.
 */
@Repository
public class IPFSProjectDao implements ProjectDao {

    private static final IPFS ipfs = new IPFS(GlobalConstants.INFURA_IPFS_GATEWAY_MULTIADDRESS);

    @Override
    public Optional<Project> get(long id) {
        return Optional.empty();
    }

    @Override
    public ProjectList getAll() {

        System.out.println("IPFS Protocol: " + ipfs.protocol);
        System.out.println("IPFS Host: " + ipfs.host);
        System.out.println("IPFS Port: " + ipfs.port + "\n");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Project projectToAdd = new Project("Best Project Name 5", "Best Project Description 5");

        Multihash directoryMultihash;
        Multihash newDirectoryMultihash = null;
        MerkleNode addResult;
        ProjectList newProjectListMerkleDagFromDag = new ProjectList();
        try {
            //Fetch ProjectList
            directoryMultihash = Application.PROJECT_LIST_FILE_IPFS_HASH;

            System.out.println(new String(ipfs.cat(directoryMultihash)));
            ProjectList projectListMerkleDagFromDag = gson.fromJson(new String(ipfs.cat(directoryMultihash)), ProjectList.class);

            //Add Project
            projectListMerkleDagFromDag.getProjects().add(projectToAdd);

            //Wrap the whole Dag in a byte array:
            String projectListMerkleDagString = gson.toJson(projectListMerkleDagFromDag);

            NamedStreamable.ByteArrayWrapper byteArrayWrapper =
                    new NamedStreamable.ByteArrayWrapper(projectListMerkleDagString.getBytes());

            //Add new ProjectList
            addResult = ipfs.add(byteArrayWrapper, true, false).get(0);
            System.out.println("Add Result: " + addResult.toJSONString() + "\n");

            //Fetch ProjectList again
            newDirectoryMultihash = addResult.hash;

            System.out.println(new String(ipfs.cat(newDirectoryMultihash)));
            newProjectListMerkleDagFromDag = gson.fromJson(new String(ipfs.cat(newDirectoryMultihash)), ProjectList.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        Application.PROJECT_LIST_FILE_IPFS_HASH = newDirectoryMultihash;
        return newProjectListMerkleDagFromDag;
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
