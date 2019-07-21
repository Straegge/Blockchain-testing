package com.the_pangaea_paradigm.ui.components.global;

import com.the_pangaea_paradigm.utilities.Colors;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Style;

public final class TPPButton extends Composite<Button> implements StyledComponent {

    public TPPButton() {
        style();

        Button parent = getContent();
        parent.setText("Test");

        parent.getElement().setAttribute("onMouseOver",
                "this.style.backgroundColor='" + Colors.DEFAULT_HOVER_COLOR.toString() + "';" +
                        "this.style.textDecoration='none';" +
                        "this.style.transitionDuration='0.4s'"
        );
        parent.getElement().setAttribute("onMouseOut",
                "this.style.backgroundColor='" + Colors.DEFAULT_BUTTON_COLOR.toString() + "';" +
                        "this.style.transitionDuration='0.4s'"
        );
    }

    @Override
    public void style() {
        Style style = getContent().getStyle();
        style.set("padding", "0.5em 1em");
        style.set("border-width", "1px");
        style.set("border-style", "solid");
        style.set("border-color", Colors.DEFAULT_BORDER_COLOR.toString());
        style.set("color", Colors.DEFAULT_TEXT_COLOR.toString());
        style.set("background-color", Colors.DEFAULT_BUTTON_COLOR.toString());
    }
}
