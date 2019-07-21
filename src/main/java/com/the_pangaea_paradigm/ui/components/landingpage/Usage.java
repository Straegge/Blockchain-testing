package com.the_pangaea_paradigm.ui.components.landingpage;

import com.the_pangaea_paradigm.utilities.Colors;
import com.the_pangaea_paradigm.utilities.StyledComponent;
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

        VerticalLayout usage = new VerticalLayout();
        usage.add(usageTitle());
        usage.add(usageContent());

        add(usage);
    }

    private HtmlComponent usageTitle() {
        //TODO: Write usage title
        HtmlComponent usageTitle = new H2(
                "Usage Title"
        );
        usageTitle.setWidth("30%");
        return usageTitle;
    }

    private HtmlComponent usageContent() {
        //TODO: Write usage content
        HtmlComponent usageContent = new Paragraph(
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. " +
                        "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."
        );
        usageContent.setWidth("30%");
        return usageContent;
    }

    @Override
    public void style() {
        setHeight("700px");
        setWidthFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultVerticalComponentAlignment(Alignment.CENTER);
        getStyle().set("margin", "0");
        getStyle().set("background-color", Colors.DEFAULT_LANDING_PAGE_USAGE_COLOR.toString());
    }
}
