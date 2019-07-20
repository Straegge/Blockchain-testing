package com.the_pangaea_paradigm.ui.components.global;

import com.the_pangaea_paradigm.utilities.Colors;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;

@StyleSheet("button.css")
public final class TPPButton extends Composite<Button> {

    public TPPButton() {
        Button parent = getContent();
        parent.setText("Test");
        parent.addClassName("test");
        parent.getStyle().set("color", Colors.DEFAULT_TEXT_COLOR.toString());
        parent.getStyle().set("border-width", "1px");
        parent.getStyle().set("border-style", "solid");
        parent.getStyle().set("border-color", Colors.DEFAULT_BORDER_COLOR.toString());
        parent.getStyle().set("background-color", Colors.DEFAULT_BUTTON_COLOR.toString());
    }
}
