package com.the_pangaea_paradigm.backend.dao;

import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.the_pangaea_paradigm.backend.dataobjects.ProjectList;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
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
        List<Project> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new Project(
                    "The Pangaea Paradigm",
                    "Straegge",
                    "Find like-minded people. Organize yourselves. Change the world.",
                    "The Pangaea Paradigm is a \"pure altruism-based initiative\" used to connect people on a global scale. Its primary mission statement is the proof-of-concept assumption that, using today's communication technology, **anything** can be achieved by a group of people working in separate locations just as well as if they worked in the same room.\n" +
                            "\n" +
                            "The application will allow anyone to create an AcOP, an *action-oriented project*. The key points of AcOPs are their global significance and measurable positive change (i.e. the Pangaea Paradigm is not meant to be used for local work or restricted by country borders).\n" +
                            "Anyone can see your AcOP and apply to work together with you if they possess a specific skill or the will to learn it if they don't. This open (and decentralized) process allows people who are confused about the positive action-oriented mindset to connect with you and your project members.\n" +
                            "\n" +
                            "Once an AcOP has reached a certain amount of members, you can reshape it into a PIO, a *positive impact organization*. This will not only allow you to reach more people, it will also give you access to the creation of a project fund. A project fund will simply be an Ethereum storage address that accepts Ether as well as certain ERC-20 tokens. The fund is open to the public which ensures complete transparency. This also means that it becomes the foundation for donations towards the PIO, and due to the decentralized nature of the platform the organization will never be able to spend the project fund on anything but contributions towards its original mission.",
                    "Mechanical Engineer, Functionality Designer",
                    "0x9237cCE7E813626bA9Ab7Fb1b4F7eb2387524997"
            ));
        }
        ProjectList newProjectListMerkleDagFromDag = new ProjectList(list);
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
