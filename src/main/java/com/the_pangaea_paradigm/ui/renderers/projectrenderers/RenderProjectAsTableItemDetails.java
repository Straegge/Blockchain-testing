package com.the_pangaea_paradigm.ui.renderers.projectrenderers;

import com.the_pangaea_paradigm.backend.dto.Project;
import com.the_pangaea_paradigm.ui.components.global.TPPButton;
import com.the_pangaea_paradigm.ui.dialogs.ProjectApplicationDialog;
import com.the_pangaea_paradigm.utilities.Colors;
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
        projectDetailsLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        projectDetailsLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH);
        projectDetailsLayout.getStyle()
                .set("border-width", "2px")
                .set("border-style", "solid")
                .set("border-color", Colors.TPP_BLUE_COLOR.toString())
                .set("border-radius", "0");

        HorizontalLayout projectAndInitiatorLayout = new HorizontalLayout(
                createProjectLayout(),
                createInitiatorLayout()
        );
        style(projectAndInitiatorLayout);

        HorizontalLayout descriptionLayout = new HorizontalLayout(
                createDescriptionLayout()
        );
        style(descriptionLayout);

        HorizontalLayout skillSetsAndAddressLayout = new HorizontalLayout(
                createSkillSetsLayout(),
                createAddressLayout()
        );
        style(skillSetsAndAddressLayout);

        projectDetailsLayout.add(
                projectAndInitiatorLayout,
                descriptionLayout,
                skillSetsAndAddressLayout,
                new HorizontalLayout(
                        createApplicationLayout()
                )
        );

        return projectDetailsLayout;
    }

    private VerticalLayout createProjectLayout() {
        VerticalLayout projectLayout = new VerticalLayout();

        HtmlComponent projectKey = new H3(
                "Project"
        );
        HtmlComponent projectValue = new Paragraph(
                project.getName()
        );

        projectLayout.add(
                projectKey,
                projectValue
        );

        return projectLayout;
    }

    private VerticalLayout createInitiatorLayout() {
        VerticalLayout initiatorLayout = new VerticalLayout();

        HtmlComponent initiatorKey = new H3(
                "Initiator"
        );
        HtmlComponent initiatorValue = new Paragraph(
                project.getInitiatorName()
        );

        initiatorLayout.add(
                initiatorKey,
                initiatorValue
        );

        return initiatorLayout;
    }

    private VerticalLayout createDescriptionLayout() {
        VerticalLayout descriptionLayout = new VerticalLayout();

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
        applicationLayout.setAlignItems(FlexComponent.Alignment.END);

        TPPButton applicationButton = new TPPButton(
                "Apply to Project",
                buttonClickEvent -> new ProjectApplicationDialog(project).open()
        );
        applicationButton.getContent().getStyle()
                .set("width", "230px")
                .set("height", "50px")
                .set("margin-right", "90px");

        applicationLayout.add(
                applicationButton
        );

        return applicationLayout;
    }

    private void style(ThemableLayout layout) {
        layout.getElement().getStyle().set("box-shadow", "rgba(0, 0, 0, 0.12) 0px 1px 6px, rgba(0, 0, 0, 0.12) 0px 1px 4px");
        layout.setMargin(true);
    }
}
