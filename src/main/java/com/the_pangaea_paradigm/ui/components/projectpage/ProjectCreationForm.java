package com.the_pangaea_paradigm.ui.components.projectpage;

import com.the_pangaea_paradigm.backend.dto.Project;
import com.the_pangaea_paradigm.services.interfaces.ProjectServiceInterface;
import com.the_pangaea_paradigm.ui.components.global.StyledComponent;
import com.the_pangaea_paradigm.ui.components.global.TPPButton;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 *
 */
@SpringComponent
@UIScope
public class ProjectCreationForm extends Composite<FormLayout> implements StyledComponent {

    @Autowired
    private ProjectServiceInterface projectServiceInterface;
    private BeanValidationBinder<Project> binder = new BeanValidationBinder<>(Project.class);
    private Project projectBeingEdited = new Project();

    public Component create() {
        style();

        FormLayout parent = getContent();
        parent.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));
        HorizontalLayout buttonLayout = new HorizontalLayout(createCreateButton(), createCancelButton());
        buttonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        buttonLayout.getStyle().set("margin-top", "20px");

        parent.add(
                new HorizontalLayout(
                        createNameField("15%"),
                        createInitiatorNameField("15%"),
                        createShortDescriptionField("70%")
                ),
                new HorizontalLayout(
                        createLongDescriptionField("100%", "170px")
                ),
                new HorizontalLayout(
                        createRequiredSkillSetFields("33%"),
                        createEmailAddressField("33%"),
                        createEthereumAddressField("33%")
                ),
                buttonLayout
        );

        return this;
    }

    private TextField createNameField(String width) {
        TextField name = new TextField("Project Name:");
        name.setWidth(width);

        binder.bind(name, "name");
        return name;
    }

    private TextField createInitiatorNameField(String width) {
        TextField initiatorName = new TextField("Initiator Name:");
        initiatorName.setWidth(width);

        binder.bind(initiatorName, "initiatorName");
        return initiatorName;
    }

    private TextField createShortDescriptionField(String width) {
        TextField shortDescription = new TextField("Short Description:");
        shortDescription.setWidth(width);

        binder.bind(shortDescription, "shortDescription");
        return shortDescription;
    }

    private TextArea createLongDescriptionField(String width, String height) {
        TextArea longDescription = new TextArea("Long Description:");
        longDescription.setWidth(width);
        longDescription.setHeight(height);

        binder.bind(longDescription, "longDescription");
        return longDescription;
    }

    private TextField createRequiredSkillSetFields(String width) {
        //TODO: Split up SkillSets
        TextField requiredSkillSets = new TextField("Skill Sets:");
        requiredSkillSets.setWidth(width);

        binder.bind(requiredSkillSets, "requiredSkillSets");
        return requiredSkillSets;
    }

    private TextField createEmailAddressField(String width) {
        TextField emailAddress = new TextField("E-Mail Address:");
        emailAddress.setWidth(width);

        binder.bind(emailAddress, "emailAddress");
        return emailAddress;
    }

    private TextField createEthereumAddressField(String width) {
        TextField ethereumAddress = new TextField("Ethereum Address:");
        ethereumAddress.setWidth(width);

        binder.bind(ethereumAddress, "ethereumAddress");
        return ethereumAddress;
    }

    private TPPButton createCreateButton() {
        TPPButton createButton = new TPPButton("Create", buttonClickEvent -> {
            if (binder.writeBeanIfValid(projectBeingEdited)) {
                try {
                    projectServiceInterface.save(projectBeingEdited);

                    Notification notification = new Notification(
                            "Project was successfully created!",
                            5000,
                            Notification.Position.MIDDLE);
                    notification.open();

                    UI.getCurrent().getPage().reload();
                } catch (IOException e) {
                    Notification notification = new Notification(
                            "Project Creation failed! " + e.getMessage(),
                            5000,
                            Notification.Position.TOP_CENTER);
                    notification.open();
                }
            }
        });

        createButton.getContent().getStyle()
                .set("width", "180px")
                .set("margin-right", "90px");

        return createButton;
    }

    private TPPButton createCancelButton() {
        TPPButton cancelButton = new TPPButton("Cancel", buttonClickEvent -> {
            Dialog dialog = (Dialog) getParent().orElseThrow(
                    () -> new IllegalStateException("The dialog you tried to close no longer exists")
            );
            dialog.close();
        });

        cancelButton.getContent().setWidth("180px");

        return cancelButton;
    }

    @Override
    public void style() {

    }
}
