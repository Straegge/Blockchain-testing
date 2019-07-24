package com.the_pangaea_paradigm.backend.dao;

import com.the_pangaea_paradigm.backend.dataobjects.Project;

import java.util.List;
import java.util.Optional;

//TODO: Implement Abstract Factory Pattern for different Data Access Object strategies

/**
 * Data Access Object Interface for Projects.
 * <p>
 * Keeps the Project model decoupled from the persistence layer, and as such all data could be
 * fetched/stored from/to IPFS or any other storage mechanism.
 */
public interface ProjectDao {

    Optional<Project> get(long id);

    List<Project> getAll();

    void save(Project project);

    void update(Project project, String[] params);

    void delete(Project project);
}
