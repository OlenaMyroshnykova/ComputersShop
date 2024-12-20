package com.shop.computersshop.dtos;

public record ComputerDTO(Long id, String brandName, int memory, 
                          String processor, String operatingSystem,
                          double price, String storeName) {}
