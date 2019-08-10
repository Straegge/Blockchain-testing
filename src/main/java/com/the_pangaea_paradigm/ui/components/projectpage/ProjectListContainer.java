package com.the_pangaea_paradigm.ui.components.projectpage;

import com.the_pangaea_paradigm.backend.dto.ProjectList;
import com.the_pangaea_paradigm.services.interfaces.ProjectServiceInterface;
import com.the_pangaea_paradigm.ui.components.global.StyledComponent;
import com.the_pangaea_paradigm.ui.renderers.projectlistrenderers.ProjectListRenderer;
import com.the_pangaea_paradigm.ui.renderers.projectlistrenderers.RenderProjectListAsTable;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Optional;

/**
 * Container for the rendered ProjectList. Is itself a Spring Bean so it can be autowired into the ProjectPage.
 * <p>
 * UIScoped so the Container is renewed when the ProjectPage is reloaded.
 */
@Tag("div")
@SpringComponent
@UIScope
public class ProjectListContainer extends Component implements StyledComponent, HasComponents {

    @Autowired
    private ProjectServiceInterface projectServiceInterface;
    private ProjectListRenderer projectListRenderer = new RenderProjectListAsTable();

    public Component create() {
        style();

        Optional<ProjectList> projectList = Optional.empty();

        try {
            projectList = Optional.ofNullable(projectServiceInterface.fetchAllProjects());
        } catch (IOException e) {
            Notification notification = new Notification(
                    "An error occurred while getting the Projects! " + e.getMessage(),
                    5000,
                    Notification.Position.TOP_CENTER);
            notification.open();
        }

        render(projectList.orElse(new ProjectList()));

        return this;
    }

    private void render(ProjectList projectList) {
        Component renderedProjectList = projectListRenderer.render(projectList);
        addDetachListener((ComponentEventListener<DetachEvent>) event -> removeAll());
        add(renderedProjectList);
    }

    public void setProjectListRenderer(ProjectListRenderer projectListRenderer) {
        this.projectListRenderer = projectListRenderer;
    }

    @Override
    public void style() {
        getElement().getStyle()
                .set("width", "100%")
                .set("height", "auto")
                .set("margin", "1% 0")
                .set("padding", "0")
                .set("flex", "1");
    }
}
