package com.shop.computersshop.repositories;

import com.shop.computersshop.models.Computer;

import java.util.List;

public interface ComputerRepository extends GenericRepository<Computer, Long> {
    List<Computer> findByBrand_NameIgnoreCase(String brandName);
    List<Computer> findByStore_NameIgnoreCase(String storeName);
}
