package com.the_pangaea_paradigm.business.web3j;

import com.the_pangaea_paradigm.business.contracts.Greeter;
import com.the_pangaea_paradigm.mvp.views.MainOverview;
import com.vaadin.external.org.slf4j.Logger;
import com.vaadin.external.org.slf4j.LoggerFactory;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigDecimal;

public class Web3jStarter {

    private static final Logger log = LoggerFactory.getLogger(MainOverview.class);

    public Web3jStarter() {

        // Create a new web3j instance to connect to remote nodes on the network
        Web3j web3j = Web3j.build(new HttpService(
                "https://rinkeby.infura.io/v3/a3fb0b11dfb74879af935d0222b7822d"));
        Web3ClientVersion web3ClientVersion = null;
        try {
            web3ClientVersion = web3j.web3ClientVersion().send();
            log.info("Connected to Ethereum client version: "
                    + web3ClientVersion.getWeb3ClientVersion());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Load an Ethereum wallet file
        Credentials credentials =
                null;
        try {
            credentials = WalletUtils.loadCredentials(
                    "etherWalletPassword",
                    System.getProperty("user.dir") + "\\src\\servlets\\resources\\Wallet\\UTC--2018-10-25T06-54-43.266000000Z--cd0b165deedf8a086f71c712c08e61b11637b0e7.json");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        }
        log.info("Credentials loaded. Wallet address: " + credentials.getAddress() +
                ". Wallet Public Key: " + credentials.getEcKeyPair().getPublicKey() + ". Hurray!");


        // Send a test transaction to an unused wallet
        log.info("Sending 1 Wei ("
                + Convert.fromWei("1", Convert.Unit.ETHER).toPlainString() + " Ether)");
        TransactionReceipt transferReceipt = null;
        try {
            transferReceipt = Transfer.sendFunds(
                    web3j, credentials,
                    "0xDb371cAAC083dA45A04c153e818405a412e095B4",  // you can put any address here
                    BigDecimal.ONE, Convert.Unit.WEI)  // 1 wei = 10^-18 Ether
                    .send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Transaction complete, views it at https://rinkeby.etherscan.io/tx/"
                + transferReceipt.getTransactionHash());


        // Load a smart contract
        log.info("Loading smart contract from the network: ");
        ContractGasProvider contractGasProvider = new DefaultGasProvider();
        Greeter contract = null;
        try {
            contract = Greeter.load(
                    "0x79a8cfB6F02882e4f853E938eAC76FDaceF3e879",
                    web3j,
                    credentials,
                    contractGasProvider
            );
            log.info("Value stored in remote smart contract: " + contract.greet().send());
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Modify the value in the smart contract
        TransactionReceipt transactionReceipt = null;
        try {
            transactionReceipt = contract.newGreeting("Test Modification").send();
            log.info("New value stored in remote smart contract: " + contract.greet().send());
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Events enable us to log specific events happening during the execution of our smart
        // contract to the blockchain. Index events cannot be logged in their entirety.
        // For Strings and arrays, the hash of values is provided, not the original value.
        // For further information, refer to https://docs.web3j.io/filters.html#filters-and-events
        for (Greeter.ModifiedEventResponse event : contract.getModifiedEvents(transactionReceipt)) {
            log.info("Modify event fired, previous value: " + event.oldGreeting
                    + ", new value: " + event.newGreeting);
            log.info("Indexed event previous value: " + Numeric.toHexString(event.oldGreetingIdx)
                    + ", new value: " + Numeric.toHexString(event.newGreetingIdx));
        }
    }
}
