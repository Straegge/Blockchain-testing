package com.the_pangaea_paradigm.ui;

import com.the_pangaea_paradigm.ui.components.global.Footer;
import com.the_pangaea_paradigm.ui.components.global.Header;
import com.the_pangaea_paradigm.ui.components.landingpage.Description;
import com.the_pangaea_paradigm.ui.components.landingpage.Hero;
import com.the_pangaea_paradigm.ui.components.landingpage.Usage;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * The landing page of the application.
 */
@Route("")
//@Theme(value = Lumo.class, variant = Lumo.DARK)
public final class LandingPage extends VerticalLayout implements StyledComponent {

    public LandingPage() {
        style();

        final Component header = new Header();
        final Component hero = new Hero();
        final Component description = new Description();
        final Component usage = new Usage();
        final Component footer = new Footer();

        add(header, hero, description, usage, footer);
    }

    @Override
    public void style() {
        getStyle()
                .set("margin", "0")
                .set("padding", "0");

        getElement().executeJavaScript("document.body.style.overflowX = 'hidden'");
    }
}
