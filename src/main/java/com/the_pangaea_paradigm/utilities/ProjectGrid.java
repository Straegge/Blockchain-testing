package com.the_pangaea_paradigm.utilities;

import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.grid.Grid;

import java.util.List;

/**
 *
 */
public class ProjectGrid extends Composite<Grid<Project>> implements StyledComponent {

    public ProjectGrid() {
        style();

    }

    public void setItems(List<Project> projects) {
        getContent().setItems(projects);
    }

    @Override
    public void style() {

    }
}
