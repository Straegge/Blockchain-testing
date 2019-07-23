package com.the_pangaea_paradigm.ui.components.global.renderers.projectlistrenderers;

import com.the_pangaea_paradigm.backend.dataobjects.ProjectList;
import com.vaadin.flow.component.Component;

/**
 * Concrete Strategy.
 *
 * Renders the <tt>ProjectList</tt> as a Table with rows and columns.
 */
public class RenderProjectListAsTable implements ProjectListRenderer {

    @Override
    public Class<? extends Component> render(ProjectList projectList) {
        //TODO Implement Renderer
        System.out.println("Implement me!");
        return null;
    }
}
