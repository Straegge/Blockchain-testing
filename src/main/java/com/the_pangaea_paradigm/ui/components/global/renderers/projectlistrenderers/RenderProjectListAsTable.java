package com.the_pangaea_paradigm.ui.components.global.renderers.projectlistrenderers;

import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.the_pangaea_paradigm.backend.dataobjects.ProjectList;
import com.the_pangaea_paradigm.ui.components.global.renderers.projectrenderers.ProjectRenderer;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Concrete <tt>ProjectListRenderer</tt> Strategy.
 * <p>
 * Renders the <tt>ProjectList</tt> as a Table with rows and columns.
 */
@SpringComponent
@UIScope
public class RenderProjectListAsTable implements ProjectListRenderer {

    @Autowired
    private ProjectRenderer projectRenderer;

    @Override
    public Grid<Project> render(ProjectList projectList) {
        Grid<Project> projectTable = new Grid<>(Project.class, false);
        style(projectTable);

        projectTable.setItems(projectList.getProjects());
        projectTable.setColumns("name", "initiatorName", "shortDescription");
        projectTable.setSelectionMode(Grid.SelectionMode.NONE);
        projectTable.setItemDetailsRenderer(new ComponentRenderer<>(project -> projectRenderer.render(project)));

        return projectTable;
    }

    private void style(Grid<Project> projectTable) {
        projectTable.setHeightByRows(true);
        projectTable.getStyle()
                .set("width", "90%")
                .set("min-height", "100%")
                .set("margin", "0 auto")
                .set("box-shadow", "rgba(0, 0, 0, 0.12) 0px 1px 6px, rgba(0, 0, 0, 0.12) 0px 1px 4px");
    }
}
