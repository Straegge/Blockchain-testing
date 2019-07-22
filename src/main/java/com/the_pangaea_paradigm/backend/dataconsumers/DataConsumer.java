package com.the_pangaea_paradigm.backend.dataconsumers;

import com.the_pangaea_paradigm.backend.dataobjects.Project;

/**
 * Interface used throughout the application to consume data objects
 * (for example to add a created project to IPFS).
 * <p>
 * Since the {@link #add(Project)} method does not make any further assumptions about the implementation,
 * the concretion is easily exchangeable (the project could be added to IPFS
 * or a database, there is no difference for the user).
 */
public interface DataConsumer {
    void add(Project project);
}
