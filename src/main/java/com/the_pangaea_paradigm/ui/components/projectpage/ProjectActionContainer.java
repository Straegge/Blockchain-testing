package com.the_pangaea_paradigm.ui.components.projectpage;

import com.the_pangaea_paradigm.ui.components.global.TPPButton;
import com.the_pangaea_paradigm.ui.views.ProjectCreationDialog;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class ProjectActionContainer extends HorizontalLayout implements StyledComponent {

    public ProjectActionContainer() {
        style();

        addCreateProjectButton();
    }

    private void addCreateProjectButton() {
        ProjectCreationDialog projectCreationDialog = new ProjectCreationDialog();
        Component createProjectButton = new TPPButton(
                "Create Project",
                buttonClickEvent -> projectCreationDialog.open()
        );
        add(createProjectButton);
    }

    @Override
    public void style() {
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultVerticalComponentAlignment(Alignment.CENTER);
        getStyle()
                .set("width", "90%")
                .set("min-height", "100px")
                .set("margin-top", "30px")
                .set("box-shadow", "rgba(0, 0, 0, 0.12) 0px 1px 6px, rgba(0, 0, 0, 0.12) 0px 1px 4px")
                .set("background-color", "white");
    }
}
