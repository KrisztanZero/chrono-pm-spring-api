package org.chronopm.chronopmspringapi.services;

import java.util.List;

public interface IEntityService<Dto> {
    List<Dto> getAll();

    Dto getById(String id);

    Dto create(Dto dto);

    Dto update(Dto dto, String id);

    String delete(String id);
}
