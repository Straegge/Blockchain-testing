package com.the_pangaea_paradigm.mvp.views.components.general;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;

public class TPPButton extends Button {
    public TPPButton(ClickEvent<Button> listener) {
        getStyle().set("color", "blue");
    }
}
