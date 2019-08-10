package com.the_pangaea_paradigm.utilities;

/**
 * Enum for colors used in the application.
 */
public enum Colors {
    DEFAULT_TEXT_COLOR("#99d6ff"),
    DEFAULT_BORDER_COLOR("#99d6ff"),
    DEFAULT_BUTTON_COLOR("#003cb3"),
    DEFAULT_HOVER_COLOR("#1a66ff"),
    TPP_BLUE_COLOR("#000099"),
    DEFAULT_BACKGROUND_COLOR("#f2f2f2"),
    DEFAULT_LANDING_PAGE_DESCRIPTION_COLOR("#9999ff"),
    DEFAULT_LANDING_PAGE_USAGE_COLOR("#e6ffff");

    private final String colorName;

    Colors(String colorName) {
        this.colorName = colorName;
    }

    public String toString() {
        return colorName;
    }
}
