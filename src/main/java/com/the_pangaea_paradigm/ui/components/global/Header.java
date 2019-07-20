package com.the_pangaea_paradigm.ui.components.global;

import com.the_pangaea_paradigm.ui.LandingPage;
import com.the_pangaea_paradigm.utilities.Colors;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public final class Header extends HorizontalLayout {

    public Header() {
        style();

        addLogo();
    }

    private void addLogo() {
        Image logo = new Image("frontend/images/Logo.png", "TPP Logo");
        logo.addClickListener(e -> logo.getUI().ifPresent(ui -> ui.navigate(LandingPage.class)));
        logo.setHeightFull();
        add(logo);
    }

    private void style() {
        setHeight("70px");
        setWidthFull();
        setMargin(false);
        setPadding(true);
        setAlignItems(FlexComponent.Alignment.START);
        getStyle().set("background-color", Colors.DEFAULT_BACKGROUND_COLOR.toString());
    }
}
