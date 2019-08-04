package com.the_pangaea_paradigm.ui;

import com.the_pangaea_paradigm.ui.components.global.Footer;
import com.the_pangaea_paradigm.ui.components.global.Header;
import com.the_pangaea_paradigm.utilities.Colors;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public abstract class PageLayoutWithHeaderAndFooter extends VerticalLayout {

    public PageLayoutWithHeaderAndFooter(Component... componentsToBeDisplayedVertically) {
        Header header = new Header();
        Footer footer = new Footer();

        VerticalLayout content = new VerticalLayout();
        for (Component component :
                componentsToBeDisplayedVertically) {
            content.add(component);
        }
        content.setSizeFull();
        content.getStyle()
                .set("margin", "0")
                .set("margin-top", "70px")
                .set("padding", "0");
        content.add(footer);
        content.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        setSizeFull();
        setSpacing(false);
        getStyle()
                .set("margin", "0")
                .set("padding", "0")
                .set("background-color", Colors.DEFAULT_BACKGROUND_COLOR.toString());
        add(header, content);

        getElement().executeJavaScript("document.documentElement.style.height = '100%'");
        getElement().executeJavaScript("document.body.style.overflowX = 'hidden'");
    }
}
