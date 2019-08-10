package com.the_pangaea_paradigm.ui.components.global;

import com.the_pangaea_paradigm.utilities.Colors;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.VaadinService;

/**
 * Custom RouterLink component used throughout the application for internal routing.
 */
public final class TPPRouterLink extends Composite<RouterLink> implements StyledComponent {

    public TPPRouterLink(String text, Class<? extends Component> navigationTarget) {
        style();
        setAttributes();

        RouterLink parent = getContent();
        parent.setText(text);
        parent.setRoute(VaadinService.getCurrent().getRouter(), navigationTarget);
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
