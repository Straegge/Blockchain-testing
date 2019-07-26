package com.the_pangaea_paradigm.ui.components.projectpage;

import com.the_pangaea_paradigm.backend.dataobjects.ProjectList;
import com.the_pangaea_paradigm.services.ProjectServiceInterface;
import com.the_pangaea_paradigm.ui.components.global.renderers.projectlistrenderers.ProjectListRenderer;
import com.the_pangaea_paradigm.ui.components.global.renderers.projectlistrenderers.RenderProjectListAsTable;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
@Tag("div")
@org.springframework.stereotype.Component
public class ProjectListContainer extends Component implements StyledComponent, HasComponents {

    @Autowired
    private ProjectServiceInterface projectServiceInterface;
    private ProjectListRenderer projectListRenderer = new RenderProjectListAsTable();

    public Component create() {
        style();

        ProjectList projectList = projectServiceInterface.fetchAllProjects();
        render(projectList);

        return this;
    }

    private void render(ProjectList projectList) {
        Component renderedProjectList = projectListRenderer.render(projectList);
        add(renderedProjectList);
    }

    public void setProjectListRenderer(ProjectListRenderer projectListRenderer) {
        this.projectListRenderer = projectListRenderer;
    }

    @Override
    public void style() {
        getElement().getStyle().set("width", "100%");
        getElement().getStyle().set("margin", "0");
        getElement().getStyle().set("padding", "0");
    }
}
