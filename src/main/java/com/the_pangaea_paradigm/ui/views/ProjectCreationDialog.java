package com.the_pangaea_paradigm.ui.views;

import com.the_pangaea_paradigm.ui.components.projectpage.ProjectCreationForm;
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
public final class ProjectCreationDialog extends Composite<Dialog> implements StyledComponent {

    public ProjectCreationDialog(@Autowired ProjectCreationForm projectCreationForm) {
        style();

        Dialog parent = getContent();

        parent.setCloseOnEsc(false);

        parent.add(projectCreationForm.create());
    }

    public void open() {
        getContent().open();
    }

    @Override
    public void style() {
        getContent().setWidth("900px");
        getContent().setHeight("auto");
    }
}
