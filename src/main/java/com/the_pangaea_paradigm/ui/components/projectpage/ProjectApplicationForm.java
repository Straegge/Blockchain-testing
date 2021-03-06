package com.the_pangaea_paradigm.ui.components.projectpage;

import com.the_pangaea_paradigm.backend.dto.Applicant;
import com.the_pangaea_paradigm.backend.dto.Project;
import com.the_pangaea_paradigm.services.ApplicantService;
import com.the_pangaea_paradigm.ui.components.global.StyledComponent;
import com.the_pangaea_paradigm.ui.components.global.TPPButton;
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

import java.io.UnsupportedEncodingException;

/**
 *
 */
public class ProjectApplicationForm extends Composite<FormLayout> implements StyledComponent {

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
            if (binder.writeBeanIfValid(applicantBeingEdited)) {
                try {
                    getElement().executeJavaScript(new ApplicantService().createApplicationTemplate(applicantBeingEdited, project));
                } catch (UnsupportedEncodingException e) {
                    Notification notification = new Notification(
                            "Project Creation failed! " + e.getMessage(),
                            5000,
                            Notification.Position.TOP_CENTER
                    );
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
