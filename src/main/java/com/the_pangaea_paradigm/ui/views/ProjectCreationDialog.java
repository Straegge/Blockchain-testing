package com.the_pangaea_paradigm.ui.views;

import com.the_pangaea_paradigm.ui.components.projectpage.ProjectCreationForm;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dialog.Dialog;

/**
 *
 */
public final class ProjectCreationDialog extends Composite<Dialog> implements StyledComponent {

    public ProjectCreationDialog() {
        style();
        getContent().setCloseOnEsc(false);
        //getContent().setCloseOnOutsideClick(false);

        getContent().add(new ProjectCreationForm());
    }

    public void open() {
        getContent().open();
    }

    @Override
    public void style() {
        getContent().setWidth("auto");
        getContent().setHeight("auto");
    }
}
