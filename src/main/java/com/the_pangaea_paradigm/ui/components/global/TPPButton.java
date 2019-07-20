package com.the_pangaea_paradigm.ui.components.global;

import com.the_pangaea_paradigm.utilities.Colors;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.dom.Style;

@StyleSheet("button.css")
public final class TPPButton extends Composite<Button> {

    public TPPButton() {
        Button parent = getContent();
        Style style = parent.getStyle();
        parent.setText("Test");
        style.set("color", Colors.DEFAULT_TEXT_COLOR.toString());
        style.set("border-width", "1px");
        style.set("border-style", "solid");
        style.set("border-color", Colors.DEFAULT_BORDER_COLOR.toString());
        style.set("background-color", Colors.DEFAULT_BUTTON_COLOR.toString());
    }
}
