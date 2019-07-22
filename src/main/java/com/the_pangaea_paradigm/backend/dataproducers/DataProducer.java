package com.the_pangaea_paradigm.backend.dataproducers;

import com.the_pangaea_paradigm.backend.dataobjects.ProjectList;

/**
 * Interface used throughout the application to produce data objects
 * (for example to add existing projects to the <tt>ProjectGrid</tt>).
 *
 * Since the {@link #fetchProjects()} method returns a <tt>ProjectList</tt> and does not
 * make any further assumptions about the implementation, the concretion is easily exchangeable
 * (the projects could have been fetched from IPFS or a database, there is no difference for the user).
 */
public interface DataProducer {
    ProjectList fetchProjects();
}
