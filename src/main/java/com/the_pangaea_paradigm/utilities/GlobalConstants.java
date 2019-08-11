package com.the_pangaea_paradigm.utilities;

import io.ipfs.api.IPFS;

/**
 * Stores global constants used in the application. The constants are not interchangeable,
 * so this isn't the right use case for an Enum.
 */
public final class GlobalConstants {
    public static final String LOGO = "frontend/images/Logo.png";
    public static final String FOOTER_LOGO = "frontend/images/Footer_Logo.png";
    public static final String HEADER_LOGO = "frontend/images/Header_Logo.png";
    public static final String GITHUB_ADDRESS = "https://github.com/Straegge/the-pangaea-paradigm";
    public static final IPFS INFURA_IPFS_GATEWAY_INSTANCE = new IPFS("/dnsaddr/ipfs.infura.io/tcp/5001/https");
}
