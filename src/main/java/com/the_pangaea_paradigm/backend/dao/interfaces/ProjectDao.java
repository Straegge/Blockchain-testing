package com.the_pangaea_paradigm.backend.dao.interfaces;

import com.the_pangaea_paradigm.backend.dto.Project;
import com.the_pangaea_paradigm.backend.dto.ProjectList;

import java.io.IOException;
import java.util.Optional;

//TODO: Implement Abstract Factory Pattern for different data persistence strategies

/**
 * Data Access Object Interface for executing CRUD operations on Projects.
 *
 * Responsible for executing 4 different types of functionality, but Single
 * Responsibility Principle is generally agreed to be achieved by object-specific
 * DAO classes since their only responsibility is persistence of that data object.
 *
 * Keeps the Project model decoupled from the persistence layer, and as such all data
 * could be fetched/stored from/to IPFS or any other storage mechanism.
 */
public interface ProjectDao {

    Optional<Project> get(long id);

    ProjectList getAll();

    void save(Project project) throws IOException;

    void update(Project project, String[] params);

    void delete(Project project);
}
