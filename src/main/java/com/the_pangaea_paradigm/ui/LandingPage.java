package com.the_pangaea_paradigm.ui;

import com.the_pangaea_paradigm.ui.components.landingpage.Description;
import com.the_pangaea_paradigm.ui.components.landingpage.Hero;
import com.the_pangaea_paradigm.ui.components.landingpage.Usage;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * The landing page of the application.
 */
@Route("")
//@Theme(value = Lumo.class, variant = Lumo.DARK)
public final class LandingPage extends PageLayoutWithHeaderAndFooter implements StyledComponent {

    public LandingPage() {
        super(new VerticalLayout(new Hero(), new Description(), new Usage()));
        style();
    }

    @Override
    public void style() {
        getStyle()
                .set("margin", "0")
                .set("padding", "0");

        getElement().executeJavaScript("document.body.style.overflowX = 'hidden'");
    }
}
