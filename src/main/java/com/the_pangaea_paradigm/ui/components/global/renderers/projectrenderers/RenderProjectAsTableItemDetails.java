package com.the_pangaea_paradigm.ui.components.global.renderers.projectrenderers;

import com.the_pangaea_paradigm.backend.dto.Project;
import com.the_pangaea_paradigm.ui.components.global.TPPButton;
import com.the_pangaea_paradigm.ui.dialogs.ProjectApplicationDialog;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.ThemableLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * Concrete <tt>ProjectRenderer</tt> Strategy.
 * <p>
 * Renders the <tt>Project</tt> as a a VerticalLayout, typically used as the
 * ComponentRenderer to display project details in a table.
 */
public class RenderProjectAsTableItemDetails implements ProjectRenderer {

    private Project project;

    @Override
    public VerticalLayout render(Project project) {
        this.project = project;

        VerticalLayout projectDetailsLayout = new VerticalLayout();
        projectDetailsLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.EVENLY);
        projectDetailsLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH);
        style(projectDetailsLayout, true);

        HorizontalLayout projectAndInitiatorLayout = createProjectAndInitiatorLayout();

        VerticalLayout descriptionLayout = createDescriptionLayout();

        VerticalLayout skillSetsLayout = createSkillSetsLayout();

        VerticalLayout addressLayout = createAddressLayout();

        VerticalLayout applicationLayout = createApplicationLayout();

        projectDetailsLayout.add(
                projectAndInitiatorLayout,
                descriptionLayout,
                skillSetsLayout,
                addressLayout,
                applicationLayout
        );
        return projectDetailsLayout;
    }

    private HorizontalLayout createProjectAndInitiatorLayout() {
        HorizontalLayout projectAndInitiatorLayout = new HorizontalLayout();
        projectAndInitiatorLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.EVENLY);
        style(projectAndInitiatorLayout, true);

        VerticalLayout projectLayout = new VerticalLayout();
        style(projectLayout, false);

        HtmlComponent projectKey = new H3(
                "Project"
        );
        HtmlComponent projectValue = new Paragraph(
                project.getName()
        );
        projectLayout.add(projectKey);
        projectLayout.add(projectValue);

        VerticalLayout initiatorLayout = new VerticalLayout();
        style(initiatorLayout, false);

        HtmlComponent initiatorKey = new H3(
                "Initiator"
        );
        HtmlComponent initiatorValue = new Paragraph(
                project.getInitiatorName()
        );
        initiatorLayout.add(initiatorKey);
        initiatorLayout.add(initiatorValue);

        projectAndInitiatorLayout.add(
                projectLayout,
                initiatorLayout
        );
        return projectAndInitiatorLayout;
    }

    private VerticalLayout createDescriptionLayout() {
        VerticalLayout descriptionLayout = new VerticalLayout();
        style(descriptionLayout, true);

        HtmlComponent descriptionKey = new H3(
                "Description"
        );
        HtmlComponent descriptionValue = new Paragraph(
                project.getLongDescription()
        );

        descriptionLayout.add(
                descriptionKey,
                descriptionValue
        );
        return descriptionLayout;
    }

    private VerticalLayout createSkillSetsLayout() {
        VerticalLayout skillSetsLayout = new VerticalLayout();
        style(skillSetsLayout, true);

        HtmlComponent skillSetsKey = new H3(
                "Skill Sets"
        );
        //TODO: Split up SkillSets
//        HtmlComponent skillSetsValue = new Paragraph(
//                String.join(", ", project.getRequiredSkillSets())
//        );
        HtmlComponent skillSetsValue = new Paragraph(
                project.getRequiredSkillSets()
        );

        skillSetsLayout.add(
                skillSetsKey,
                skillSetsValue
        );
        return skillSetsLayout;
    }

    private VerticalLayout createAddressLayout() {
        VerticalLayout addressLayout = new VerticalLayout();
        style(addressLayout, true);

        HtmlComponent addressKey = new H3(
                "Ethereum Address"
        );
        HtmlComponent addressValue = new Paragraph(
                project.getEthereumAddress()
        );

        addressLayout.add(
                addressKey,
                addressValue
        );
        return addressLayout;
    }

    private VerticalLayout createApplicationLayout() {
        VerticalLayout applicationLayout = new VerticalLayout();
        style(applicationLayout, true);

        Component applicationButton = new TPPButton(
                "Apply to Project",
                buttonClickEvent -> new ProjectApplicationDialog(project).open()
        );

        applicationLayout.add(
                applicationButton
        );
        return applicationLayout;
    }

    private void style(ThemableLayout layout, boolean padded) {
        layout.setPadding(padded);
        layout.setMargin(false);
        layout.setSpacing(false);
    }
}
