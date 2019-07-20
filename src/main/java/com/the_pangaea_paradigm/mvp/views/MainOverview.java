package com.the_pangaea_paradigm.mvp.views;

import com.the_pangaea_paradigm.mvp.views.components.main_overview.*;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * This is the @MainServlet landing page of the application.
 */
@Route
@Theme(value = Lumo.class, variant = Lumo.DARK)
public class MainOverview extends VerticalLayout {

    public MainOverview() {
        final HorizontalLayout header = new Header();
        final HorizontalLayout hero = new Hero();
        final HorizontalLayout description = new Description();
        final HorizontalLayout usage = new Usage();
        final HorizontalLayout footer = new Footer();

        add(new Button("Lolz"));
        add(header, hero, description, usage, footer);
    }

}
