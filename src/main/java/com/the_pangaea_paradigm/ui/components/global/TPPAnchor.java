package com.the_pangaea_paradigm.ui.components.global;

import com.the_pangaea_paradigm.utilities.Colors;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.dom.Style;

/**
 * Custom Anchor component used throughout the application for external routing.
 */
public class TPPAnchor extends Composite<Anchor> implements StyledComponent {

    TPPAnchor(String href, String text) {
        style();

        Anchor parent = getContent();
        parent.setHref(href);
        parent.setText(text);
    }

    @Override
    public void style() {
        Style style = getContent().getStyle();
        getElement().setAttribute("target", "_blank");
        style.set("cursor", "default");
        style.set("padding", "0.5em 1em");
        style.set("border-width", "1px");
        style.set("border-style", "solid");
        style.set("border-color", Colors.DEFAULT_BORDER_COLOR.toString());
        style.set("color", Colors.DEFAULT_TEXT_COLOR.toString());
        style.set("background-color", Colors.DEFAULT_BUTTON_COLOR.toString());
        setHoverStyle();
    }

    private void setHoverStyle() {
        getContent().getElement().setAttribute("onMouseOver",
                "this.style.backgroundColor='" + Colors.DEFAULT_HOVER_COLOR.toString() + "';" +
                        "this.style.textDecoration='none';" +
                        "this.style.transitionDuration='0.4s'"
        );
        getContent().getElement().setAttribute("onMouseOut",
                "this.style.backgroundColor='" + Colors.DEFAULT_BUTTON_COLOR.toString() + "';" +
                        "this.style.transitionDuration='0.4s'"
        );
    }
}
