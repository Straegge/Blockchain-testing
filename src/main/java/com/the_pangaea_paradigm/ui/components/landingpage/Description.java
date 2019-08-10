package com.the_pangaea_paradigm.ui.components.landingpage;

import com.the_pangaea_paradigm.ui.components.global.StyledComponent;
import com.the_pangaea_paradigm.utilities.Colors;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * The application description of the landing page.
 */
public final class Description extends HorizontalLayout implements StyledComponent {

    public Description() {
        style();

        //TODO: Add Image

        VerticalLayout description = createDescription();
        description.getStyle()
                .set("width", "35%")
                .set("margin", "50px 20px");

        add(description);
    }

    private VerticalLayout createDescription() {
        H2 title = new H2("A Global Workspace");

        Paragraph firstParagraph = new Paragraph(
                "The basis of all change is gathering people who align with your vision. No one can change the " +
                        "world alone. But the concept of creating and growing an organisation locally is not only " +
                        "inefficient, it's also far too often ineffective. There could be ideal participants halfway " +
                        "around the world, and you would never know."
        );

        Paragraph secondParagraph = new Paragraph(
                "Our vision is a globally interconnected network of people working together towards aligned goals. " +
                        "Using today's co-working and communication technologies, we believe that anything which can " +
                        "be achieved by a group of people working in the same location can be accomplished far more " +
                        "reliably by an online community; a digital organisation."
        );

        return new VerticalLayout(title, firstParagraph, secondParagraph);
    }

    @Override
    public void style() {
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultVerticalComponentAlignment(Alignment.CENTER);
        getStyle()
                .set("width", "90%")
                .set("height", "auto")
                .set("padding", "0")
                .set("margin", "10px 0px")
                .set("box-shadow", "rgba(0, 0, 0, 0.12) 0px 1px 6px, rgba(0, 0, 0, 0.12) 0px 1px 4px")
                .set("background-color", Colors.DEFAULT_LANDING_PAGE_DESCRIPTION_COLOR.toString());
    }
}
