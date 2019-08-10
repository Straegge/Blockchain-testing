package com.the_pangaea_paradigm;

import io.ipfs.multihash.Multihash;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static Multihash PROJECT_LIST_FILE_IPFS_HASH = Multihash.fromBase58("QmSYXV6yzhoNYuQngLdcECf85JCV6R5x642hP7SWxek4V8");

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
