package com.the_pangaea_paradigm.ui;

import com.the_pangaea_paradigm.ui.components.global.TPPButton;
import com.the_pangaea_paradigm.ui.components.global.TPPRouterLink;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * The landing page of the application.
 */
@Route("")
//@Theme(value = Lumo.class, variant = Lumo.DARK)
public class LandingPage extends VerticalLayout {

    public LandingPage() {
        Component button = new TPPButton();
        Component routerLink = new TPPRouterLink("Test", ProjectPage.class);
        //button.addClickListener(e -> button.getUI().ifPresent(ui -> ui.navigate("some")));
        add(routerLink);
        add(button);
    }
}
