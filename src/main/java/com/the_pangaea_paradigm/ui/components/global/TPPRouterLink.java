package com.the_pangaea_paradigm.ui.components.global;

import com.the_pangaea_paradigm.utilities.Colors;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.VaadinService;

//TODO: Add stylesheet import for hover effect
public final class TPPRouterLink extends Composite<RouterLink> {

    public TPPRouterLink(String text, Class<? extends Component> navigationTarget) {
        RouterLink parent = getContent();
        Style style = parent.getStyle();
        parent.setText(text);
        parent.setRoute(VaadinService.getCurrent().getRouter(), navigationTarget);
        style.set("padding", "0.5em 1em");
        style.set("border-width", "1px");
        style.set("border-style", "solid");
        style.set("border-color", Colors.DEFAULT_BORDER_COLOR.toString());
        style.set("color", Colors.DEFAULT_TEXT_COLOR.toString());
        style.set("background-color", Colors.DEFAULT_BUTTON_COLOR.toString());
    }
}
