package com.cloudinn.backend.domain.data;

import java.util.Collection;
import java.util.List;

public interface DomainEntityMapper<I extends InputDto, O extends OutputDto, E extends DomainEntity> {

    E mapInputToEntity(I input, Class<E> entityClass);
    O mapEntityToOutput(E entity, Class<O> outputClass);
    List<O> mapEntitiesToOutputList(Collection<E> entities, Class<O> outputClass);
    void copyPropertiesBetweenEntities(E source, E destination);


}
