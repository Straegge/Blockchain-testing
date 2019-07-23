package com.the_pangaea_paradigm.backend.dataobjects;

import com.the_pangaea_paradigm.ui.components.global.renderers.projectlistrenderers.ProjectListRenderer;
import com.the_pangaea_paradigm.ui.components.global.renderers.projectlistrenderers.RenderProjectListAsTable;
import com.vaadin.flow.component.Component;

/**
 * Represents an abstract list of Projects.
 */
public abstract class ProjectList {

    private ProjectListRenderer projectListRenderer = new RenderProjectListAsTable();

    public void setProjectListRenderer(ProjectListRenderer projectListRenderer) {
        this.projectListRenderer = projectListRenderer;
    }

    public Class<? extends Component> render(ProjectList projectList) {
        return projectListRenderer.render(projectList);
    }
}
