package com.the_pangaea_paradigm.utilities;

public enum Routes {
    PROJECT_PAGE_ROUTE("projects"),
    PROJECT_CREATION_VIEW_ROUTE("projects/projectCreation"),
    PROJEC_APPLICATION_VIEW_ROUTE("projects/projectApplication");

    private final String routeName;

    Routes(String routeName) {
        this.routeName = routeName;
    }

    public String toString() {
        return routeName;
    }
}
