package com.the_pangaea_paradigm.utilities;

/**
 * Enum for global constants used in the application.
 */
public enum GlobalConstants {
    LOGO("frontend/images/Logo.png"),
    LOGO_WITH_NAME("frontend/images/LogoWithName.png"),
    GITHUB_ADDRESS("https://github.com/Straegge/the-pangaea-paradigm"),
    INFURA_IPFS_GATEWAY_MULTIADDRESS("/dnsaddr/ipfs.infura.io/tcp/5001/https"),
    PROJECT_LIST_FILE_IPFS_HASH("hash");

    private final String constantName;

    GlobalConstants(String constantName) {
        this.constantName = constantName;
    }

    public String toString() {
        return constantName;
    }
}
