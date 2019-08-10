package com.the_pangaea_paradigm.ui.components.landingpage;

import com.the_pangaea_paradigm.ui.components.global.StyledComponent;
import com.the_pangaea_paradigm.utilities.Colors;
import com.vaadin.flow.component.HtmlComponent;
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

        VerticalLayout usageLayout = new VerticalLayout(
                usageTitle(),
                usageContent()
        );
        usageLayout.getStyle()
                .set("width", "35%")
                .set("margin", "50px 20px");

        add(usageLayout);
    }

    private HtmlComponent usageTitle() {
        //TODO: Write usage title
        return new H2(
                "Usage Title"
        );
    }

    private HtmlComponent usageContent() {
        //TODO: Write usage content
        return new Paragraph(
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. " +
                        "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."
        );
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
