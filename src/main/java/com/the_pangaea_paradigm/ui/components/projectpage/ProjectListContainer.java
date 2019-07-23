package com.the_pangaea_paradigm.ui.components.projectpage;

import com.the_pangaea_paradigm.backend.dataobjects.ProjectList;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.Component;

/**
 *
 */
public class ProjectListContainer extends Component implements StyledComponent {

    //TODO: Implement Mediator that fetches the rendered ProjectList
    //private Mediator mediator;

    public ProjectListContainer() {
        style();

        addRenderedProjectList();
    }

    private Component addRenderedProjectList() {
        //mediator.get
        return null;
    }

    public void setProjectListRenderer() {
        //projectList.setProjectListRenderer();
    }

    @Override
    public void style() {

    }
}
