package org.chronopm.chronopmspringapi.services;

import org.chronopm.chronopmspringapi.models.DeleteResponse;

import java.util.List;

public interface EntityService<Dto> {
    List<Dto> getAll();
    Dto getById(String id);
    Dto create(Dto dto);
    Dto update(Dto dto, String id);
    DeleteResponse<Dto> delete(String id);
}
