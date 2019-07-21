package com.the_pangaea_paradigm.ui.components.global;

import com.the_pangaea_paradigm.utilities.Colors;
import com.the_pangaea_paradigm.utilities.GlobalConstants;
import com.the_pangaea_paradigm.utilities.StyledComponent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * The footer that is visible on all pages of the application.
 */
public final class Footer extends VerticalLayout implements StyledComponent {

    public Footer() {
        style();

        addLinkToGithub();
        addLogo();
    }

    private void addLinkToGithub() {
        Component anchor = new TPPAnchor(GlobalConstants.GITHUB_ADDRESS.toString(), "Project on GitHub");
        anchor.getElement().getStyle().set("margin-bottom", "2em");
        add(anchor);
    }

    private void addLogo() {
        Image logo = new Image(GlobalConstants.LOGO_WITH_NAME.toString(), "TPP Header Logo");
        logo.setHeight("40%");
        add(logo);
    }

    @Override
    public void style() {
        setHeight("300px");
        setWidthFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle()
                .set("margin", "0")
                .set("background-color", Colors.DEFAULT_BACKGROUND_COLOR.toString());
    }
}
