package com.the_pangaea_paradigm.ui.components.global;

import com.the_pangaea_paradigm.utilities.Colors;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Anchor;

/**
 * Custom Anchor component used throughout the application for external routing.
 */
public final class TPPAnchor extends Composite<Anchor> implements StyledComponent {

    TPPAnchor(String href, String text) {
        style();
        setAttributes();

        Anchor parent = getContent();
        parent.setHref(href);
        parent.setText(text);
    }

    @Override
    public void style() {
        getContent().getStyle()
                .set("cursor", "default")
                .set("padding", "0.5em 1em")
                .set("border-width", "1px")
                .set("border-style", "solid")
                .set("border-color", Colors.DEFAULT_BORDER_COLOR.toString())
                .set("color", Colors.DEFAULT_TEXT_COLOR.toString())
                .set("background-color", Colors.DEFAULT_BUTTON_COLOR.toString());
    }

    private void setAttributes() {
        getElement()
                .setAttribute("target", "_blank")
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
