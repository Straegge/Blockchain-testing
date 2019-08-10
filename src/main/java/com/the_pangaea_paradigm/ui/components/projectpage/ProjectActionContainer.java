package com.the_pangaea_paradigm.ui.components.projectpage;

import com.the_pangaea_paradigm.ui.components.global.StyledComponent;
import com.the_pangaea_paradigm.ui.components.global.TPPButton;
import com.the_pangaea_paradigm.ui.dialogs.ProjectCreationDialog;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
@SpringComponent
@UIScope
public class ProjectActionContainer extends HorizontalLayout implements StyledComponent {

    @Autowired
    private ProjectCreationDialog projectCreationDialog;

    public HorizontalLayout create() {
        style();

        addCreateProjectButton();

        return this;
    }

    private void addCreateProjectButton() {
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
