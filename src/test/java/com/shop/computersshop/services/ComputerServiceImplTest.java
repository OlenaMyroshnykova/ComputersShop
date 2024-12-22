package com.shop.computersshop.services;

import com.shop.computersshop.dtos.ComputerDTO;
import com.shop.computersshop.models.Brand;
import com.shop.computersshop.models.Computer;
import com.shop.computersshop.models.Store;
import com.shop.computersshop.repositories.ComputerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ComputerServiceImplTest {

    @Mock
    private ComputerRepository computerRepository;

    @InjectMocks
    private ComputerServiceImpl computerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testToDTO() {
        // Arrange
        Brand brand = new Brand();
        brand.setName("HP");

        Store store = new Store();
        store.setName("TechStore");

        Computer computer = new Computer();
        computer.setId(1L);
        computer.setBrand(brand);
        computer.setMemory(16);
        computer.setProcessor("Intel i7");
        computer.setOperatingSystem("Windows 10");
        computer.setPrice(1200.0);
        computer.setStore(store);

        // Act
        ComputerDTO computerDTO = computerService.toDTO(computer);

        // Assert
        assertEquals(1L, computerDTO.id());
        assertEquals("HP", computerDTO.brandName());
        assertEquals(16, computerDTO.memory());
        assertEquals("Intel i7", computerDTO.processor());
        assertEquals("Windows 10", computerDTO.operatingSystem());
        assertEquals(1200.0, computerDTO.price());
        assertEquals("TechStore", computerDTO.storeName());
    }

    @Test
    void testFromDTO() {
        // Arrange
        ComputerDTO computerDTO = new ComputerDTO(
                1L,
                "HP",
                16,
                "Intel i7",
                "Windows 10",
                1200.0,
                "TechStore"
        );

        // Act
        Computer computer = computerService.fromDTO(computerDTO);

        // Assert
        assertEquals(1L, computer.getId());
        assertEquals(16, computer.getMemory());
        assertEquals("Intel i7", computer.getProcessor());
        assertEquals("Windows 10", computer.getOperatingSystem());
        assertEquals(1200.0, computer.getPrice());
        // Проверка на связи пропущена, т.к. они устанавливаются отдельным сервисом/репозиторием
    }

}

