package com.the_pangaea_paradigm.ui.components.global;

import com.the_pangaea_paradigm.utilities.Colors;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;

/**
 * Custom Button component used throughout the application.
 */
public final class TPPButton extends Composite<Button> implements StyledComponent {

    public TPPButton(String text) {
        style();
        setAttributes();

        getContent().setText(text);
    }

    public TPPButton(String text, ComponentEventListener<ClickEvent<Button>> clickEventListener) {
        style();
        setAttributes();

        Button parent = getContent();
        parent.setText(text);
        parent.addClickListener(clickEventListener);
    }

    @Override
    public void style() {
        getContent().getStyle()
                .set("cursor", "default")
                .set("height", "auto")
                .set("font-weight", "400")
                .set("padding", "0.32em 1em")
                .set("border-width", "1px")
                .set("border-style", "solid")
                .set("border-color", Colors.DEFAULT_BORDER_COLOR.toString())
                .set("border-radius", "0")
                .set("color", Colors.DEFAULT_TEXT_COLOR.toString())
                .set("background-color", Colors.DEFAULT_BUTTON_COLOR.toString());
    }

    private void setAttributes() {
        getElement()
                .setAttribute("onMouseOver",
                        "this.style.backgroundColor='" + Colors.DEFAULT_HOVER_COLOR.toString() + "';" +
                                "this.style.textDecoration='none';" +
                                "this.style.transitionDuration='0.4s'"
                )
                .setAttribute("onMouseOut",
                        "this.style.backgroundColor='" + Colors.DEFAULT_BUTTON_COLOR.toString() + "';" +
                                "this.style.transitionDuration='0.4s'"
                );
    }
}
