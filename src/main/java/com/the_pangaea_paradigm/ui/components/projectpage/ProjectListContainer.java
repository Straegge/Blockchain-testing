package com.the_pangaea_paradigm.ui.components.projectpage;

import com.the_pangaea_paradigm.backend.dataobjects.ProjectList;
import com.the_pangaea_paradigm.services.ProjectService;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.Component;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
public class ProjectListContainer extends Component implements StyledComponent {

    //TODO: Add ProjectListRenderer and return rendered component in renderProjectList()


    @Autowired
    private ProjectService projectService;

    public ProjectListContainer() {
        style();

        renderProjectList();
    }

    private Component renderProjectList() {
        ProjectList projectList = projectService.fetchAllProjects();
        return null;
    }

    @Override
    public void style() {

    }
}
