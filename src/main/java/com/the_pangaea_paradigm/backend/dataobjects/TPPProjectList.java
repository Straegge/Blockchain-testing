package com.the_pangaea_paradigm.backend.dataobjects;

import com.the_pangaea_paradigm.ui.components.global.renderers.projectlistrenderers.ProjectListRenderer;
import com.the_pangaea_paradigm.ui.components.global.renderers.projectlistrenderers.RenderProjectListAsTable;

/**
 *
 */
public class TPPProjectList extends ProjectList {

    public TPPProjectList() {
        new TPPProjectList(new RenderProjectListAsTable());
    }

    public TPPProjectList(ProjectListRenderer projectListRenderer) {

    }
}
