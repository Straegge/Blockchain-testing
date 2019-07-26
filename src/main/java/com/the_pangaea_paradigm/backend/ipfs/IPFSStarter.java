package com.the_pangaea_paradigm.backend.ipfs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.the_pangaea_paradigm.backend.dataobjects.ProjectListMerkleDag;
import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.cid.Cid;
import io.ipfs.multihash.Multihash;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class IPFSStarter {

    public IPFSStarter() {

        //TODO: Flood with sout and check the values of IPFS and MerkleNode properties => FIND OUT WHERE IPNS IS STORED AND HOW TO CREATE DIRECTORY

        /*
            HASH OF DIRECTORY: QmUNLLsPACCz1vLxQVkXqqLX5R1X345qqfHbsf67hvA3Nn
         */
        IPFS ipfs = new IPFS("/dnsaddr/ipfs.infura.io/tcp/5001/https");

        System.out.println("IPFS Protocol: " + ipfs.protocol);
        System.out.println("IPFS Host: " + ipfs.host);
        System.out.println("IPFS Port: " + ipfs.port + "\n");

        Multihash filePointer = Multihash.fromBase58("QmUNLLsPACCz1vLxQVkXqqLX5R1X345qqfHbsf67hvA3Nn");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(new Project("Best Project Name 3", "Best Project Description 3"));

        NamedStreamable.ByteArrayWrapper byteArrayWrapper =
                new NamedStreamable.ByteArrayWrapper(json.getBytes());

        MerkleNode addResultProject;
        MerkleNode addResult;
        String ipfsHash = null;
        try {
            //ProjectListMerkleDag projectListMerkleDag = gson.fromJson(new String(ipfs.dag.get(new Cid(filePointer))), ProjectListMerkleDag.class);
            //System.out.println("Data: " + projectListMerkleDag.getData());
            //System.out.println("Links: " + projectListMerkleDag.getLinks());

            //ipfs method not allowed...
            //addResult = ipfs.object.patch(filePointer, "add-link", Optional.empty(), Optional.of("Test 1"), Optional.of(addResultProject.hash));
            addResultProject = ipfs.add(byteArrayWrapper).get(0);
            System.out.println("Hash of added ProjectMerkleDag: " + addResultProject.hash);
            boolean addedToLinks = ipfs.object.get(filePointer).links.add(addResultProject);
            //System.out.println("Hash of patched ProjectListMerkleDag: " + addResult.hash);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
            ADD DIRECTORY

        NamedStreamable.DirWrapper dirWrapper =
                new NamedStreamable.DirWrapper("Test", new ArrayList<>());

        MerkleNode addResult;
        String ipfsHash = null;
        try {
            addResult = ipfs.add(dirWrapper).get(0);
            ipfsHash = addResult.hash.toString();
            System.out.println("addResult.toJSON.toString: " + addResult.toJSON().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Hash: " + ipfsHash);*/




        /*
            FIRST TEST STORE & FETCH

        Multihash filePointer = Multihash.fromBase58("");
        String fileContentString = null;

        try {
            fileContentString = new String(ipfs.cat(filePointer));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File Contents: " + fileContentString);


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(new Project("Project Name 5", "Project Description"));

        System.out.println(json);

        NamedStreamable.ByteArrayWrapper dirWrapper =
                new NamedStreamable.ByteArrayWrapper(json.getBytes());

        try {
            //Adding ByteArray as File to IPFS
            MerkleNode addResult = ipfs.add(dirWrapper).get(0);
            String ipfsHash = addResult.hash.toString();

            System.out.println("Hash: " + ipfsHash);

            //Fetching File from IPFS
            Multihash filePointer = Multihash.fromBase58(ipfsHash);
            String fileContentString = new String(ipfs.cat(filePointer));
            System.out.println("File Contents: " + fileContentString);

            //Deserializing to Project Object
            Project project = gson.fromJson(fileContentString, Project.class);

            //Now get contents!
            System.out.println("Project Name: " + project.getName());
            System.out.println("Project Description: " + project.getDescription());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
