package com.the_pangaea_paradigm.utilities;

public enum Colors {
    DEFAULT_TEXT_COLOR("#99d6ff"),
    DEFAULT_BORDER_COLOR("#99d6ff"),
    DEFAULT_BUTTON_COLOR("#003cb3"),
    DEFAULT_BACKGROUND_COLOR("#000099");

    private final String colorName;

    Colors(String colorName) {
        this.colorName = colorName;
    }

    public String toString() {
        return colorName;
    }
}
