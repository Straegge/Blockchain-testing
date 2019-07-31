package com.the_pangaea_paradigm.ui;

import com.the_pangaea_paradigm.ui.components.global.Footer;
import com.the_pangaea_paradigm.ui.components.global.Header;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public abstract class PageLayoutWithHeaderAndFooter extends VerticalLayout {

    public PageLayoutWithHeaderAndFooter(VerticalLayout content) {
        Header header = new Header();
        Footer footer = new Footer();

        add(header, content, footer);
    }
}
