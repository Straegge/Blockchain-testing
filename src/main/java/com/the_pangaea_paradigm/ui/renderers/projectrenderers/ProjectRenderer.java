package com.the_pangaea_paradigm.ui.renderers.projectrenderers;

import com.the_pangaea_paradigm.backend.dto.Project;
import com.vaadin.flow.component.Component;

/**
 * Strategy Interface of a Strategy Pattern (https://en.wikipedia.org/wiki/Strategy_pattern).
 * <p>
 * Implemented by concrete Strategies to render a <tt>Project</tt> in order to
 * make it possible to easily exchange and extend the visualization potential of TPP Projects.
 */
@FunctionalInterface
public interface ProjectRenderer {
    Component render(Project project);
}
