package com.the_pangaea_paradigm.ui.dialogs;

import com.the_pangaea_paradigm.backend.dto.Project;
import com.the_pangaea_paradigm.ui.components.global.StyledComponent;
import com.the_pangaea_paradigm.ui.components.projectpage.ProjectApplicationForm;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dialog.Dialog;

/**
 *
 */
public final class ProjectApplicationDialog extends Composite<Dialog> implements StyledComponent {

    public ProjectApplicationDialog(Project project) {
        style();

        Dialog parent = getContent();

        parent.setCloseOnEsc(false);

        parent.add(new ProjectApplicationForm().create(project));
    }

    public void open() {
        getContent().open();
    }

    @Override
    public void style() {
        getContent().setWidth("700px");
        getContent().setHeight("auto");
    }
}
