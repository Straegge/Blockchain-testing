package com.the_pangaea_paradigm.backend.ipfs;

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

        //Creating JSONObject and adding items
        JSONObject originJson = new JSONObject();
        originJson.put("Project Name", "DUBI in Zimbabwe");
        originJson.put("Creator Name", "Straegge");

        NamedStreamable.ByteArrayWrapper byteArray =
                new NamedStreamable.ByteArrayWrapper(originJson.toString(2).getBytes());

        try {
            //Adding ByteArray as File to IPFS
            MerkleNode addResult = ipfs.add(byteArray).get(0);
            String ipfsHash = addResult.hash.toString();

            //Fetching File from IPFS
            Multihash filePointer = Multihash.fromBase58(ipfsHash);
            String fileContentString = new String(ipfs.cat(filePointer));

            //Serializing to JSON Object
            JSONObject destinationJson = new JSONObject(fileContentString);

            //Now get contents with json.getString("key")!
            System.out.println("Project Name: " + destinationJson.getString("Project Name"));
            System.out.println("Creator Name: " + destinationJson.getString("Creator Name"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
