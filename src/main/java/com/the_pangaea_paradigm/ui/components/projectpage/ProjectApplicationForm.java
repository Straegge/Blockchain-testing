package com.the_pangaea_paradigm.ui.components.projectpage;

import com.the_pangaea_paradigm.backend.dataobjects.Applicant;
import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import java.util.ArrayList;
import java.util.List;

public class ProjectApplicationForm extends Composite<FormLayout> implements StyledComponent {

    private TextField description = new TextField();
    private List<TextField> requiredSkillSets = new ArrayList<>();
    private TextField emailAddress = new TextField();
    private List<TextField> otherContactDetails = new ArrayList<>();
    private Binder<Applicant> binder = new Binder<>(Applicant.class);

    public ProjectApplicationForm(Project project) {
        style();
        FormLayout parent = getContent();

        parent.addFormItem(createNameField(), "Name:");
    }

    private TextField createNameField() {
        TextField name = new TextField();
        return name;
    }

    @Override
    public void style() {

    }
}
