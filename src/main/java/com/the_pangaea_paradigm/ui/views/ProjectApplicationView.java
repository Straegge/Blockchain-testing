package com.the_pangaea_paradigm.ui.views;

import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dialog.Dialog;

/**
 *
 */
public final class ProjectApplicationView extends Composite<Dialog> implements StyledComponent {

    public ProjectApplicationView(Project project) {
        style();

        getContent().open();
    }

    @Override
    public void style() {
        getContent().setWidth("50%");
    }
}
