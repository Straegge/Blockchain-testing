package com.the_pangaea_paradigm.ui.components.projectpage;

import com.the_pangaea_paradigm.backend.dataobjects.Applicant;
import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.data.binder.BeanValidationBinder;

public class ProjectApplicationForm extends Composite<FormLayout> implements StyledComponent {

    public ProjectApplicationForm(Project project) {
        style();
        FormLayout parent = getContent();

        BeanValidationBinder<Applicant> binder = new BeanValidationBinder<>(Applicant.class);

    }

    @Override
    public void style() {

    }
}
