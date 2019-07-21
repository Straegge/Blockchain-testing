package com.the_pangaea_paradigm.utilities;

public enum GlobalConstants {
    LOGO("frontend/images/Logo.png"),
    LOGO_WITH_NAME("frontend/images/LogoWithName.png");

    private final String constantName;

    GlobalConstants(String constantName) {
        this.constantName = constantName;
    }

    public String toString() {
        return constantName;
    }
}
