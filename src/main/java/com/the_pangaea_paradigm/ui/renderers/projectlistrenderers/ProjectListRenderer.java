package com.the_pangaea_paradigm.ui.renderers.projectlistrenderers;

import com.the_pangaea_paradigm.backend.dto.ProjectList;
import com.vaadin.flow.component.Component;

/**
 * Strategy Interface of a Strategy Pattern (https://en.wikipedia.org/wiki/Strategy_pattern).
 * <p>
 * Implemented by concrete Strategies to render the <tt>ProjectList</tt> in order to
 * make it possible to easily exchange and extend the visualization potential of TPP Projects.
 */
@FunctionalInterface
public interface ProjectListRenderer {
    Component render(ProjectList projectList);
}
