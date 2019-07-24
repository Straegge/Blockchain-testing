package com.the_pangaea_paradigm.ui.components.global.renderers.projectlistrenderers;

import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.the_pangaea_paradigm.backend.dataobjects.ProjectList;
import com.vaadin.flow.component.grid.Grid;

/**
 * Concrete Strategy.
 * <p>
 * Renders the <tt>ProjectList</tt> as a Table with rows and columns.
 */
public class RenderProjectListAsTable implements ProjectListRenderer {

    @Override
    public Grid<Project> render(ProjectList projectList) {
        //TODO Implement Renderer
        System.out.println("Implement me!");
        return new Grid<>();
    }
}
