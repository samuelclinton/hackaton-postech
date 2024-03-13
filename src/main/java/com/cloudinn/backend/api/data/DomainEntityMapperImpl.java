package com.cloudinn.backend.api.data;

import com.cloudinn.backend.domain.data.InputDto;
import com.cloudinn.backend.domain.data.OutputDto;
import com.cloudinn.backend.domain.data.DomainEntityMapper;
import com.cloudinn.backend.domain.data.DomainEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class DomainEntityMapperImpl<I extends InputDto, O extends OutputDto, E extends DomainEntity>
        implements DomainEntityMapper<I, O, E> {

    private final ModelMapper modelMapper;

    public DomainEntityMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public E mapInputToEntity(I input, Class<E> entityClass) {
        return this.modelMapper.map(input, entityClass);
    }

    @Override
    public O mapEntityToOutput(E entity, Class<O> outputClass) {
        return this.modelMapper.map(entity, outputClass);
    }

    @Override
    public List<O> mapEntitiesToOutputList(Collection<E> entities, Class<O> outputClass) {
        return entities.stream()
                .map(entidade -> this.mapEntityToOutput(entidade, outputClass))
                .toList();
    }

    @Override
    public void copyPropertiesBetweenEntities(E source, E destination) {
        this.modelMapper.map(source, destination);
    }

}
