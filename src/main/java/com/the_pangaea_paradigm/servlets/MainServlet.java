package com.the_pangaea_paradigm.servlets;

import com.the_pangaea_paradigm.mvp.views.MainOverview;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

/**
 * This is the servlet that serves the main overview. It initializes
 * the connections to Infura at the first start-up.
 */
@WebServlet(urlPatterns = "/*", name = "MainServlet", asyncSupported = true)
@VaadinServletConfiguration(ui = MainOverview.class, productionMode = false)
public class MainServlet extends VaadinServlet {

    @Override
    protected void servletInitialized()
            throws ServletException {
        super.servletInitialized();
    }

}