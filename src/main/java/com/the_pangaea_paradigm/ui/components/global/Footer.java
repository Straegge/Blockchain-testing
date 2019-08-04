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
        Component anchor = new TPPAnchor(GlobalConstants.GITHUB_ADDRESS, "Project on GitHub");
        anchor.getElement().getStyle().set("margin-bottom", "1em");
        add(anchor);
    }

    private void addLogo() {
        Image logo = new Image(GlobalConstants.LOGO_WITH_NAME, "TPP Header Logo");
        logo.setHeight("90px");
        add(logo);
    }

    @Override
    public void style() {
        setWidthFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle()
                .set("margin", "0")
                .set("padding", "35px 0px")
                .set("background-color", Colors.DEFAULT_BACKGROUND_COLOR.toString());
    }
}
