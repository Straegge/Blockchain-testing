package com.the_pangaea_paradigm.ui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("some")
public class ProjectPage extends Div {
    public ProjectPage() {
        add(new Text("lol works"));
    }
}
