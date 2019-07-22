package com.the_pangaea_paradigm.ui.components.projectpage;

import com.the_pangaea_paradigm.backend.ipfs.IPFSHandler;
import com.the_pangaea_paradigm.utilities.ProjectGrid;
import com.vaadin.flow.component.Composite;

public class ProjectGridContainer extends Composite<ProjectGrid> {

    public ProjectGridContainer() {
        getContent().setItems(
                IPFSHandler.fetchProjects()
        );
    }

    public static void add() {

    }
}
