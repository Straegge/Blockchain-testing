package com.the_pangaea_paradigm.mvp.views;

import com.the_pangaea_paradigm.mvp.views.components.main_overview.*;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

/**
 * This is the servlets landing page of the application.
 */
@Theme("mytheme")
public class MainOverview extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout content = new VerticalLayout();

        final HorizontalLayout header = new Header();
        final HorizontalLayout hero = new Hero();
        final HorizontalLayout description = new Description();
        final HorizontalLayout usage = new Usage();
        final HorizontalLayout footer = new Footer();

        content.addComponents(header, hero, description, usage, footer);
        setContent(content);
    }

}
