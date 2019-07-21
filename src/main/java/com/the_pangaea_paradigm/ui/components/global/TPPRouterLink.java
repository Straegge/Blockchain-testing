package com.the_pangaea_paradigm.ui.components.global;

import com.the_pangaea_paradigm.utilities.Colors;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.VaadinService;

/**
 * Custom RouterLink component used throughout the application for internal routing.
 */
public final class TPPRouterLink extends Composite<RouterLink> implements StyledComponent {

    public TPPRouterLink(String text, Class<? extends Component> navigationTarget) {
        style();

        RouterLink parent = getContent();
        parent.setText(text);
        parent.setRoute(VaadinService.getCurrent().getRouter(), navigationTarget);
    }

    @Override
    public void style() {
        Style style = getContent().getStyle();
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
