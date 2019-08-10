package com.the_pangaea_paradigm.ui.components.landingpage;

import com.the_pangaea_paradigm.ui.components.global.StyledComponent;
import com.the_pangaea_paradigm.utilities.Colors;
import com.vaadin.flow.component.HtmlComponent;
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

        VerticalLayout description = new VerticalLayout();
        description.add(descriptionTitle());
        description.add(descriptionContent());

        add(description);
    }

    private HtmlComponent descriptionTitle() {
        //TODO: Write description title
        HtmlComponent descriptionTitle = new H2(
                "Description Title"
        );
        descriptionTitle.setWidth("30%");
        return descriptionTitle;
    }

    private HtmlComponent descriptionContent() {
        //TODO: Write description content
        HtmlComponent descriptionContent = new Paragraph(
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. " +
                        "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."
        );
        descriptionContent.setWidth("30%");
        return descriptionContent;
    }

    @Override
    public void style() {
        setHeight("700px");
        setWidthFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultVerticalComponentAlignment(Alignment.CENTER);
        getStyle()
                .set("margin", "0")
                .set("padding", "0")
                .set("background-color", Colors.DEFAULT_LANDING_PAGE_DESCRIPTION_COLOR.toString());
    }
}
