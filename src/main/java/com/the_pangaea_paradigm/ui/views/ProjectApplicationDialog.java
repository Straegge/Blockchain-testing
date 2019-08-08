package com.the_pangaea_paradigm.ui.views;

import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.the_pangaea_paradigm.ui.components.projectpage.ProjectApplicationForm;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
@SpringComponent
@UIScope
public final class ProjectApplicationDialog extends Composite<Dialog> implements StyledComponent {

    private Project project;

    public ProjectApplicationDialog(@Autowired ProjectApplicationForm projectApplicationForm) {
        style();

        getContent().setCloseOnEsc(false);
        getContent().setCloseOnOutsideClick(false);

        getContent().add(projectApplicationForm.create(project));
    }

    public void open() {
        getContent().open();
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public void style() {
        getContent().setWidth("700px");
        getContent().setHeight("auto");
    }
}
