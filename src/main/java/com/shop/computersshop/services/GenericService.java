package com.shop.computersshop.services;

import java.util.List;

public interface GenericService<T, ID> {
    List<T> getAll();
    T getById(ID id);
    T create(T dto);
    void delete(ID id);
}