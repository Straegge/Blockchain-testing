package com.the_pangaea_paradigm.ui.components.projectpage;

import com.the_pangaea_paradigm.ui.components.global.TPPButton;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class ProjectActionContainer extends HorizontalLayout implements StyledComponent {

    public ProjectActionContainer() {
        style();

        addCreateProjectButton();
    }

    private void addCreateProjectButton() {
        //TODO: Add ComponentEventListener to open ProjectCreationView
        Component createProjectButton = new TPPButton("Create Project", ClickEvent::getClickCount);
        add(createProjectButton);
    }

    @Override
    public void style() {
        setHeight("100px");
        setWidthFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultVerticalComponentAlignment(Alignment.CENTER);
        getStyle()
                .set("background-color", "#c2c2d6");
    }
}
