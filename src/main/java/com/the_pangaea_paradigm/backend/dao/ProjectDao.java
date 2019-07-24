package com.the_pangaea_paradigm.backend.dao;

import com.the_pangaea_paradigm.backend.dataobjects.Project;

import java.util.List;
import java.util.Optional;

//TODO: Implement Abstract Factory Pattern for different data persistence strategies

/**
 * Data Access Object Interface for executing CRUD operations on Projects.
 *
 * Single Responsibility Principle is generally thought to be achieved by object-specific
 * DAO classes since their only responsibility is persistence of that data object.
 *
 * Keeps the Project model decoupled from the persistence layer, and as such all data
 * could be fetched/stored from/to IPFS or any other storage mechanism.
 */
public interface ProjectDao {

    Optional<Project> get(long id);

    List<Project> getAll();

    void save(Project project);

    void update(Project project, String[] params);

    void delete(Project project);
}
