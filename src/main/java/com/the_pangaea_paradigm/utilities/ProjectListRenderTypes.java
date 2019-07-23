package com.the_pangaea_paradigm.utilities;

/**
 * Enum for ProjectList visualization types.
 *
 * Used by the <tt>ProjectListRendererFactory</tt> Creator of the Factory Pattern to determine
 * which <tt>ProjectListRenderer</tt> Strategy of the Strategy Pattern to apply.
 *
 * The RenderTypes are used to render the <tt>ProjectList</tt>...
 */
public enum ProjectListRenderTypes {

    /**
     * ...as a Table with rows and columns.
     */
    TABLE(0),

    /**
     * ...as a visualized List.
     */
    LIST(1),

    /**
     * ...as a catalogue of Flashcards.
     */
    FLASHCARDS(2);

    ProjectListRenderTypes(int renderType) {
    }
}
