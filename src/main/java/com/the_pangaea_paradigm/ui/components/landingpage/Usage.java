package com.the_pangaea_paradigm.ui.components.landingpage;

import com.the_pangaea_paradigm.ui.components.global.StyledComponent;
import com.the_pangaea_paradigm.utilities.Colors;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * The usage description of the landing page.
 */
public final class Usage extends HorizontalLayout implements StyledComponent {

    public Usage() {
        style();

        //TODO: Add Image

        VerticalLayout usage = createUsage();
        usage.getStyle()
                .set("width", "35%")
                .set("margin", "50px 20px");

        add(usage);
    }

    private VerticalLayout createUsage() {
        H2 title = new H2("Create or Apply, Permanently");

        Paragraph firstParagraph = new Paragraph(
                "Projects created in the application are persistently saved on IPFS. They're accessible to " +
                        "everyone forever, we only provide a usable interface for interaction. The IPFS hash of the " +
                        "file holding the existing Project is freely viewable and can be used to extend or remodel " +
                        "the functionality of the application."
        );

        Paragraph secondParagraph = new Paragraph(
                "Anyone can create an altruistic Project, and anyone can apply to join. A Project Initiator has " +
                        "the possibility to describe essential skills needed for the Project, but the most important " +
                        "skill is the will to learn and provide help in any way possible."
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
                .set("margin", "0px 0px 10px 0px")
                .set("box-shadow", "rgba(0, 0, 0, 0.12) 0px 1px 6px, rgba(0, 0, 0, 0.12) 0px 1px 4px")
                .set("background-color", Colors.DEFAULT_LANDING_PAGE_USAGE_COLOR.toString());
    }
}
