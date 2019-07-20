package com.the_pangaea_paradigm.ui;

import com.the_pangaea_paradigm.ui.components.global.Header;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("projects")
public class ProjectPage extends VerticalLayout {
    public ProjectPage() {
        style();

        final Component header = new Header();

        add(header);
    }

    private void style() {
        setMargin(false);
        setPadding(false);
    }
}
