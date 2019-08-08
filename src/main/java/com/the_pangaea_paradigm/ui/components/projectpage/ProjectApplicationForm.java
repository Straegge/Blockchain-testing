package com.the_pangaea_paradigm.ui.components.projectpage;

import com.the_pangaea_paradigm.backend.dataobjects.Applicant;
import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.the_pangaea_paradigm.services.ProjectServiceInterface;
import com.the_pangaea_paradigm.ui.components.global.TPPButton;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
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
public class ProjectApplicationForm extends Composite<FormLayout> implements StyledComponent {

    @Autowired
    private ProjectServiceInterface projectServiceInterface;
    private BeanValidationBinder<Applicant> binder = new BeanValidationBinder<>(Applicant.class);
    private Applicant applicantBeingEdited = new Applicant();

    public Component create(Project project) {
        style();

        FormLayout parent = getContent();
        parent.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));
        HorizontalLayout buttonLayout = new HorizontalLayout(createApplyButton(project), createCancelButton());
        buttonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        buttonLayout.getStyle().set("margin-top", "20px");

        parent.add(
                new HorizontalLayout(
                        createNameField("50%"),
                        createEmailAddressField("50%")
                ),
                new HorizontalLayout(
                        createDescriptionField("100%", "140px")
                ),
                new HorizontalLayout(
                        createSkillSetFields("50%"),
                        createOtherContactDetailFields("50%")
                ),
                buttonLayout
        );

        return this;
    }

    private TextField createNameField(String width) {
        TextField name = new TextField("Name:");
        name.setWidth(width);

        binder.bind(name, "name");
        return name;
    }

    private TextArea createDescriptionField(String width, String height) {
        TextArea description = new TextArea("Description:");
        description.setWidth(width);
        description.setHeight(height);

        binder.bind(description, "description");
        return description;
    }

    private TextField createSkillSetFields(String width) {
        TextField skillSets = new TextField("Skill Sets:");
        skillSets.setWidth(width);

        binder.bind(skillSets, "skillSets");
        return skillSets;
    }

    private TextField createEmailAddressField(String width) {
        TextField emailAddress = new TextField("E-Mail Address:");
        emailAddress.setWidth(width);

        binder.bind(emailAddress, "emailAddress");
        return emailAddress;
    }

    private TextField createOtherContactDetailFields(String width) {
        TextField otherContactDetails = new TextField("Other Contact Details:");
        otherContactDetails.setWidth(width);

        binder.bind(otherContactDetails, "otherContactDetails");
        return otherContactDetails;
    }

    private TPPButton createApplyButton(Project project) {
        TPPButton createButton = new TPPButton("Apply", buttonClickEvent -> {
            System.out.println("Project E-Mail: " + project.getEmailAddress());

            if (binder.writeBeanIfValid(applicantBeingEdited)) {
                try {
                    //TODO: Send E-Mail to project initiator

                    Notification notification = new Notification("Project was successfully created!", 0, Notification.Position.MIDDLE);
                    notification.open();

                    throw new IOException();
                } catch (IOException e) {
                    Notification notification = new Notification("Project Creation failed!", 0, Notification.Position.MIDDLE);
                    notification.open();
                }
            }
        });

        createButton.getContent().getStyle()
                .set("width", "180px")
                .set("margin-right", "70px");

        return createButton;
    }

    private TPPButton createCancelButton() {
        TPPButton cancelButton = new TPPButton("Cancel", buttonClickEvent -> {
            Dialog parent = (Dialog) getParent().orElseThrow(() -> new IllegalStateException("The dialog you tried to close no longer exists"));

            parent.close();
        });

        cancelButton.getContent().setWidth("180px");

        return cancelButton;
    }

    @Override
    public void style() {

    }
}
