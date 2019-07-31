package com.the_pangaea_paradigm.ui;

import com.the_pangaea_paradigm.ui.components.projectpage.ProjectActionContainer;
import com.the_pangaea_paradigm.ui.components.projectpage.ProjectListContainer;
import com.the_pangaea_paradigm.utilities.Routes;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The project page of the application.
 */
@Route(Routes.PROJECT_PAGE_ROUTE)
public final class ProjectPage extends PageLayoutWithHeaderAndFooter implements StyledComponent {

    public ProjectPage(@Autowired ProjectListContainer projectListContainer) {
        super(new VerticalLayout(new ProjectActionContainer(), projectListContainer.create()));
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
