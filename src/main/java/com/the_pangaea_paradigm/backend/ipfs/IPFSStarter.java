package com.the_pangaea_paradigm.backend.ipfs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.the_pangaea_paradigm.backend.dataobjects.ProjectList;
import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;

import java.io.IOException;

public class IPFSStarter {

    public IPFSStarter() {
        IPFS ipfs = new IPFS("/dnsaddr/ipfs.infura.io/tcp/5001/https");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Project projectToAdd = new Project();

        Multihash directoryMultihash;
        MerkleNode addResult;
        try {
            //Create ProjectList
            ProjectList test = new ProjectList();
            String merkleDagString = gson.toJson(test);

            NamedStreamable.ByteArrayWrapper byteArrayWrap =
                    new NamedStreamable.ByteArrayWrapper(merkleDagString.getBytes());

            addResult = ipfs.add(byteArrayWrap, true, false).get(0);
            System.out.println("Add Result: " + addResult.toJSONString() + "\n");

            //Fetch ProjectList
            directoryMultihash = addResult.hash;

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
            Multihash newDirectoryMultihash = addResult.hash;

            System.out.println(new String(ipfs.cat(newDirectoryMultihash)));
            ProjectList newProjectListMerkleDagFromDag = gson.fromJson(new String(ipfs.cat(newDirectoryMultihash)), ProjectList.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
