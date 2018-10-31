package com.the_pangaea_paradigm.views;

import com.the_pangaea_paradigm.views.main_overview_components.*;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;

/**
 * This views is the application entry point. A views may either represent a browser window
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The views is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MainOverviewUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout structureLayout = new VerticalLayout();
        final HorizontalLayout header = new Header();
        final HorizontalLayout hero = new Hero();
        final HorizontalLayout description = new Description();
        final HorizontalLayout usage = new Usage();
        final HorizontalLayout footer = new Footer();

        structureLayout.addComponents(header, hero, description, usage, footer);
        setContent(structureLayout);
    }

    @WebServlet(urlPatterns = "/*", name = "MainUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainOverviewUI.class, productionMode = false)
    public static class MainUIServlet extends VaadinServlet {
    }
}
