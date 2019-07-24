package com.the_pangaea_paradigm.backend.ipfs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.the_pangaea_paradigm.backend.dataobjects.Project;
import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multiaddr.MultiAddress;
import io.ipfs.multihash.Multihash;
import org.json.JSONObject;

import java.io.IOException;

public class IPFSStarter {

    public IPFSStarter() {
        MultiAddress m = new MultiAddress("/dnsaddr/ipfs.infura.io/tcp/5001/https");

        IPFS ipfs = new IPFS(m);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(new Project("Project Name 5", "Project Description"));

        System.out.println(json);

        NamedStreamable.ByteArrayWrapper byteArray =
                new NamedStreamable.ByteArrayWrapper(json.getBytes());

        try {
            //Adding ByteArray as File to IPFS
            MerkleNode addResult = ipfs.add(byteArray).get(0);
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
        }
    }
}
