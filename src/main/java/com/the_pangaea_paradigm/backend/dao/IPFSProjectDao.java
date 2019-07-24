package com.the_pangaea_paradigm.backend.dao;

import com.the_pangaea_paradigm.backend.dataobjects.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IPFSProjectDao implements ProjectDao {

    @Override
    public Optional<Project> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Project> getAll() {
        return new ArrayList<>();
    }

    @Override
    public void save(Project project) {

    }

    @Override
    public void update(Project project, String[] params) {

    }

    @Override
    public void delete(Project project) {

    }
}
