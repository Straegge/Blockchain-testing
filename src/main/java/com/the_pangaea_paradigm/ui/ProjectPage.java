package com.the_pangaea_paradigm.ui;

import com.the_pangaea_paradigm.ui.components.global.Footer;
import com.the_pangaea_paradigm.ui.components.global.Header;
import com.the_pangaea_paradigm.ui.components.projectpage.ProjectActionContainer;
import com.the_pangaea_paradigm.ui.components.projectpage.ProjectGridContainer;
import com.the_pangaea_paradigm.utilities.Routes;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * The project page of the application.
 */
@Route(Routes.PROJECT_PAGE_ROUTE)
public final class ProjectPage extends VerticalLayout implements StyledComponent {
    public ProjectPage() {
        style();

        final Component header = new Header();
        final Component projectActionContainer = new ProjectActionContainer();
        final Component projectGrid = new ProjectGridContainer();
        final Component footer = new Footer();

        add(header, projectActionContainer, projectGrid, footer);
    }

    @Override
    public void style() {
        getStyle()
                .set("margin", "0")
                .set("padding", "0");

        getElement().executeJavaScript("document.body.style.overflowX = 'hidden'");
    }
}
