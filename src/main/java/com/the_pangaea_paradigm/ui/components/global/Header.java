package com.the_pangaea_paradigm.ui.components.global;

import com.the_pangaea_paradigm.ui.LandingPage;
import com.the_pangaea_paradigm.utilities.Colors;
import com.the_pangaea_paradigm.utilities.StyledComponent;
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
        //TODO: Fix Logo (make smaller)
        Image logo = new Image("frontend/images/Logo.png", "TPP Header Logo");
        logo.addClickListener(e -> logo.getUI().ifPresent(ui -> ui.navigate(LandingPage.class)));
        logo.setHeightFull();
        add(logo);
    }

    @Override
    public void style() {
        setHeight("70px");
        setWidthFull();
        setPadding(true);
        setAlignItems(FlexComponent.Alignment.START);
        getStyle().set("position", "fixed");
        getStyle().set("margin", "0");
        getStyle().set("background-color", Colors.DEFAULT_BACKGROUND_COLOR.toString());
    }
}