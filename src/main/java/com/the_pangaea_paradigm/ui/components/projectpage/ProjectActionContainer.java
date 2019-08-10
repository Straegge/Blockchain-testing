package com.the_pangaea_paradigm.ui.components.projectpage;

import com.the_pangaea_paradigm.Application;
import com.the_pangaea_paradigm.ui.components.global.StyledComponent;
import com.the_pangaea_paradigm.ui.components.global.TPPButton;
import com.the_pangaea_paradigm.ui.dialogs.ProjectCreationDialog;
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
        addCurrentProjectListFileIPFSHash();

        return this;
    }

    private void addCreateProjectButton() {
        TPPButton createProjectButton = new TPPButton(
                "Create Project",
                buttonClickEvent -> projectCreationDialog.open()
        );
        createProjectButton.getElement().getStyle().set("margin-right", "30px");
        add(createProjectButton);
    }

    private void addCurrentProjectListFileIPFSHash() {
        add("Projects currently stored under this hash: " + Application.PROJECT_LIST_FILE_IPFS_HASH.toString());
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
