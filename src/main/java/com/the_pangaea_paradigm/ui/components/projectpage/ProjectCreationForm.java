package com.the_pangaea_paradigm.ui.components.projectpage;

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

public class ProjectCreationForm extends Composite<FormLayout> implements StyledComponent {

    private Binder<Project> binder = new Binder<>(Project.class);

    public ProjectCreationForm() {
        style();

        addNameField();
        addInitiatorNameField();
        addShortDescriptionField();
        addLongDescriptionField();
        addRequiredSkillSetFields();
        addEthereumAddressField();
        addCancelButton();
        addCreateButton();
    }

    private void addNameField() {
        TextField projectName = new TextField();

        getContent().addFormItem(projectName, "Project Name:");
    }

    private void addInitiatorNameField() {
        TextField initiatorName = new TextField();

        getContent().addFormItem(initiatorName, "Project Name:");
    }

    private void addShortDescriptionField() {
        TextField shortDescription = new TextField();

        getContent().addFormItem(shortDescription, "Project Name:");
    }

    private void addLongDescriptionField() {
        TextField longDescription = new TextField();

        getContent().addFormItem(longDescription, "Project Name:");
    }

    private void addRequiredSkillSetFields() {
        List<TextField> requiredSkillSets = new ArrayList<>();

        //getContent().addFormItem(name, "Skill Sets:");
    }

    private void addEthereumAddressField() {
        TextField name = new TextField();

        getContent().addFormItem(name, "Project Name:");
    }

    private void addCancelButton() {
        TPPButton cancelButton = new TPPButton("Cancel", ClickEvent::getClickCount);

        getContent().addFormItem(cancelButton, "");
    }

    private void addCreateButton() {
        TPPButton createButton = new TPPButton("Create", ClickEvent::getClickCount);

        getContent().addFormItem(createButton, "");
    }

    @Override
    public void style() {

    }
}
