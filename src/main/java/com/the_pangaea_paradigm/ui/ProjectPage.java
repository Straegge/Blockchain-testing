package com.the_pangaea_paradigm.ui;

import com.the_pangaea_paradigm.ui.components.projectpage.ProjectActionContainer;
import com.the_pangaea_paradigm.ui.components.projectpage.ProjectListContainer;
import com.the_pangaea_paradigm.utilities.Routes;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The project page of the application.
 */
@Route(Routes.PROJECT_PAGE_ROUTE)
public final class ProjectPage extends PageLayoutWithHeaderAndFooter {

    public ProjectPage(@Autowired ProjectListContainer projectListContainer) {
        super(new ProjectActionContainer(), projectListContainer.create());
    }

}
