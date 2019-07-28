package com.the_pangaea_paradigm.ui.components.global.renderers.projectrenderers;

import com.the_pangaea_paradigm.backend.dataobjects.Project;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * Concrete <tt>ProjectRenderer</tt> Strategy.
 * <p>
 * Renders the <tt>Project</tt> as a a VerticalLayout, typically used as the
 * ComponentRenderer to display project details in a table.
 */
public class RenderProjectAsTableItemDetails implements ProjectRenderer {

    @Override
    public VerticalLayout render(Project project) {
        //TODO Implement Renderer
        VerticalLayout projectDetailsLayout = new VerticalLayout();
        HorizontalLayout projectNameAndInitiatorLayout = new HorizontalLayout();
        HorizontalLayout descriptionLayout = new HorizontalLayout();
        HorizontalLayout skillSetsAndAddressLayout = new HorizontalLayout();
        HorizontalLayout applicationLayout = new HorizontalLayout();

        projectDetailsLayout.add(
                projectNameAndInitiatorLayout,
                descriptionLayout,
                skillSetsAndAddressLayout,
                applicationLayout);
        return projectDetailsLayout;
    }
}
