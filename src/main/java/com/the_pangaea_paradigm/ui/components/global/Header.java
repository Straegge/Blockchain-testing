package com.the_pangaea_paradigm.ui.components.global;

import com.the_pangaea_paradigm.ui.LandingPage;
import com.the_pangaea_paradigm.utilities.Colors;
import com.the_pangaea_paradigm.utilities.GlobalConstants;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * The header that is visible on all pages of the application.
 */
public final class Header extends HorizontalLayout implements StyledComponent {

    public Header() {
        style();

        addHeaderLogo();
    }

    private void addHeaderLogo() {
        Image logo = new Image(GlobalConstants.HEADER_LOGO, "TPP Header Logo");
        logo.addClickListener(e -> logo.getUI().ifPresent(ui -> ui.navigate(LandingPage.class)));
        logo.setHeightFull();
        add(logo);
    }

    @Override
    public void style() {
        setHeight("70px");
        setWidthFull();
        setAlignItems(FlexComponent.Alignment.START);
        getStyle()
                .set("position", "fixed")
                .set("z-index", "1")
                .set("padding", "10px")
                .set("background-color", Colors.TPP_BLUE_COLOR.toString());
    }
}
