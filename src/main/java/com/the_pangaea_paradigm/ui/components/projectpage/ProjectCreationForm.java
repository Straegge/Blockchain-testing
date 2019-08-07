package com.the_pangaea_paradigm.ui.components.projectpage;

import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.the_pangaea_paradigm.services.ProjectServiceInterface;
import com.the_pangaea_paradigm.ui.components.global.TPPButton;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.value.ValueChangeMode;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class ProjectCreationForm extends Composite<FormLayout> implements StyledComponent {

    @Autowired
    private ProjectServiceInterface projectServiceInterface;
    private BeanValidationBinder<Project> binder = new BeanValidationBinder<>(Project.class);
    private Project projectBeingEdited = new Project();

    public ProjectCreationForm() {
        style();

        addNameField();
        addInitiatorNameField();
        addShortDescriptionField();
        addLongDescriptionField();
        addRequiredSkillSetFields();
        addEmailAddressField();
        addEthereumAddressField();
        addCancelButton();
        addCreateButton();
    }

    private void addNameField() {
        TextField name = new TextField();

        name.setValueChangeMode(ValueChangeMode.EAGER);

        binder.bind(name, "name");
        getContent().addFormItem(name, "Project Name:");
    }

    private void addInitiatorNameField() {
        TextField initiatorName = new TextField();

        binder.bind(initiatorName, "initiatorName");
        getContent().addFormItem(initiatorName, "Initiator Name:");
    }

    private void addShortDescriptionField() {
        TextField shortDescription = new TextField();

        binder.bind(shortDescription, "shortDescription");
        getContent().addFormItem(shortDescription, "Short Description:");
    }

    private void addLongDescriptionField() {
        TextField longDescription = new TextField();

        binder.bind(longDescription, "longDescription");
        getContent().addFormItem(longDescription, "Long Description:");
    }

    private void addRequiredSkillSetFields() {
        //TODO: Split up SkillSets
        TextField requiredSkillSets = new TextField();

        binder.bind(requiredSkillSets, "requiredSkillSets");
        getContent().addFormItem(requiredSkillSets, "Skill Sets:");
    }

    private void addEmailAddressField() {
        TextField emailAddress = new TextField();

        binder.bind(emailAddress, "emailAddress");
        getContent().addFormItem(emailAddress, "E-Mail Address:");
    }

    private void addEthereumAddressField() {
        TextField ethereumAddress = new TextField();

        binder.bind(ethereumAddress, "ethereumAddress");
        getContent().addFormItem(ethereumAddress, "Ethereum Address:");
    }

    private void addCancelButton() {
        TPPButton cancelButton = new TPPButton("Cancel", buttonClickEvent -> {
            Dialog parent = (Dialog) getParent().orElseThrow(() -> new IllegalStateException("The dialog you tried to close no longer exists"));
            parent.close();
        });

        getContent().addFormItem(cancelButton, "");
    }

    private void addCreateButton() {
        TPPButton createButton = new TPPButton("Create", buttonClickEvent -> {
            if (binder.writeBeanIfValid(projectBeingEdited)) {
                try {
                    projectServiceInterface.save(projectBeingEdited);

                    //TODO: Success Notification
                } catch (IOException e) {
                    //TODO: Error Notification
                }
            }
        });

        getContent().addFormItem(createButton, "");
    }

    @Override
    public void style() {

    }
}
