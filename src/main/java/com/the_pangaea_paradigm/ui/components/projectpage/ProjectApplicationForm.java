package com.the_pangaea_paradigm.ui.components.projectpage;

import com.the_pangaea_paradigm.backend.dataobjects.Applicant;
import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.the_pangaea_paradigm.ui.components.global.TPPButton;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import java.util.ArrayList;
import java.util.List;

public class ProjectApplicationForm extends Composite<FormLayout> implements StyledComponent {

    private Binder<Applicant> binder = new Binder<>(Applicant.class);

    public ProjectApplicationForm(Project project) {
        style();

        addNameField();
        addDescriptionField();
        addSkillSetFields();
        addEmailAddressField();
        addOtherContactDetailFields();
        addCancelButton();
        addApplyButton();
    }

    private void addNameField() {
        TextField name = new TextField();

        getContent().addFormItem(name, "Name:");
    }

    private void addDescriptionField() {
        TextField description = new TextField();

        getContent().addFormItem(description, "Description:");
    }

    private void addSkillSetFields() {
        List<TextField> skillSets = new ArrayList<>();

        //getContent().addFormItem(name, "Skill Sets:");
    }

    private void addEmailAddressField() {
        TextField emailAddress = new TextField();

        getContent().addFormItem(emailAddress, "E-Mail Address:");
    }

    private void addOtherContactDetailFields() {
        List<TextField> otherContactDetails = new ArrayList<>();

        //getContent().addFormItem(name, "Other Contact Details:");
    }

    private void addCancelButton() {
        TPPButton cancelButton = new TPPButton("Cancel", ClickEvent::getClickCount);

        getContent().addFormItem(cancelButton, "");
    }

    private void addApplyButton() {
        TPPButton applyButton = new TPPButton("Apply", ClickEvent::getClickCount);

        getContent().addFormItem(applyButton, "");
    }

    @Override
    public void style() {

    }
}
