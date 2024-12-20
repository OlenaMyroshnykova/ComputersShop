package com.shop.computersshop.services;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public abstract class GenericServiceImpl<T, DTO, ID> implements GenericService<DTO, ID> {

    private final JpaRepository<T, ID> repository;

    protected GenericServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    protected abstract DTO toDTO(T entity);

    protected abstract T fromDTO(DTO dto);

    @Override
    public List<DTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public DTO getById(ID id) {
        var entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
        return toDTO(entity);
    }

    @Override
    public DTO create(DTO dto) {
        var entity = fromDTO(dto);
        var savedEntity = repository.save(entity);
        return toDTO(savedEntity);
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }
}
