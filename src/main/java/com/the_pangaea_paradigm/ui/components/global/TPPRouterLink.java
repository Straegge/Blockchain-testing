package com.the_pangaea_paradigm.ui.components.global;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.VaadinService;

public final class TPPRouterLink extends Composite<RouterLink> {

    public TPPRouterLink(String text, Class<? extends Component> navigationTarget) {
        RouterLink parent = getContent();
        parent.setText(text);
        parent.setRoute(VaadinService.getCurrent().getRouter(), navigationTarget);
    }
}
