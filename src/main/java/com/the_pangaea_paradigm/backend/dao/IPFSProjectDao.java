package com.the_pangaea_paradigm.backend.dao;

import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.the_pangaea_paradigm.backend.dataobjects.ProjectList;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Concrete Data Access Object for executing CRUD operations on Projects
 * in communication with IPFS as data persistence layer.
 */
@Repository
public class IPFSProjectDao implements ProjectDao {

    @Override
    public Optional<Project> get(long id) {
        return Optional.empty();
    }

    @Override
    public ProjectList getAll() {

//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        Project projectToAdd = new Project();
//
//        Multihash directoryMultihash;
//        Multihash newDirectoryMultihash = null;
//        MerkleNode addResult;
        ProjectList newProjectListMerkleDagFromDag = new ProjectList();
//        try {
//            //Fetch ProjectList
//            directoryMultihash = Application.PROJECT_LIST_FILE_IPFS_HASH;
//
//            System.out.println(new String(GlobalConstants.INFURA_IPFS_GATEWAY_INSTANCE.cat(directoryMultihash)));
//            ProjectList projectListMerkleDagFromDag = gson.fromJson(new String(GlobalConstants.INFURA_IPFS_GATEWAY_INSTANCE.cat(directoryMultihash)), ProjectList.class);
//
//            //Add Project
//            projectListMerkleDagFromDag.getProjects().add(projectToAdd);
//
//            //Wrap the whole Dag in a byte array:
//            String projectListMerkleDagString = gson.toJson(projectListMerkleDagFromDag);
//
//            NamedStreamable.ByteArrayWrapper byteArrayWrapper =
//                    new NamedStreamable.ByteArrayWrapper(projectListMerkleDagString.getBytes());
//
//            //Add new ProjectList
//            addResult = GlobalConstants.INFURA_IPFS_GATEWAY_INSTANCE.add(byteArrayWrapper, true, false).get(0);
//            System.out.println("Add Result: " + addResult.toJSONString() + "\n");
//
//            //Fetch ProjectList again
//            newDirectoryMultihash = addResult.hash;
//
//            System.out.println(new String(GlobalConstants.INFURA_IPFS_GATEWAY_INSTANCE.cat(newDirectoryMultihash)));
//            newProjectListMerkleDagFromDag = gson.fromJson(new String(GlobalConstants.INFURA_IPFS_GATEWAY_INSTANCE.cat(newDirectoryMultihash)), ProjectList.class);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Application.PROJECT_LIST_FILE_IPFS_HASH = newDirectoryMultihash;
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
