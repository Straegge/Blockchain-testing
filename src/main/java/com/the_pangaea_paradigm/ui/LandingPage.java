package com.the_pangaea_paradigm.ui;

import com.the_pangaea_paradigm.ui.components.landingpage.Description;
import com.the_pangaea_paradigm.ui.components.landingpage.Hero;
import com.the_pangaea_paradigm.ui.components.landingpage.Usage;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * The landing page of the application.
 */
@Route("")
@PageTitle("The Pangaea Paradigm")
//@Theme(value = Lumo.class, variant = Lumo.DARK)
public final class LandingPage extends PageLayoutWithHeaderAndFooter {

    public LandingPage() {
        super(new Hero(), new Description(), new Usage());
    }
}
