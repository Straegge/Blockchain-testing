package com.the_pangaea_paradigm.ui.components.landingpage;

import com.the_pangaea_paradigm.utilities.Colors;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * The description of the landing page.
 */
public final class Description extends HorizontalLayout implements StyledComponent {

    public Description() {
        style();


    }

    @Override
    public void style() {
        getStyle().set("margin", "0");
        setHeight("700px");
        setWidthFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultVerticalComponentAlignment(Alignment.CENTER);
        getStyle().set("background-color", Colors.DEFAULT_LANDING_PAGE_DESCRIPTION_COLOR.toString());
    }
}
