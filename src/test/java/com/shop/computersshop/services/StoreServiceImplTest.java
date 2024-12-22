package com.shop.computersshop.services;

import com.shop.computersshop.dtos.StoreDTO;
import com.shop.computersshop.models.Store;
import com.shop.computersshop.models.StoreOwner;
import com.shop.computersshop.repositories.StoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StoreServiceImplTest {

    private StoreServiceImpl storeService;

    @Mock
    private StoreRepository storeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        storeService = new StoreServiceImpl(storeRepository);
    }

    @Test
    void testGetAll() {
        // Arrange
        StoreOwner owner = new StoreOwner(1L, "John Doe");
        Store store1 = new Store(1L, "Store 1", "12345", owner);
        Store store2 = new Store(2L, "Store 2", "67890", owner);

        when(storeRepository.findAll()).thenReturn(Arrays.asList(store1, store2));

        // Act
        List<StoreDTO> storeDTOs = storeService.getAll();

        // Assert
        assertEquals(2, storeDTOs.size());
        assertEquals("Store 1", storeDTOs.get(0).name());
        assertEquals("12345", storeDTOs.get(0).taxId());
        assertEquals("John Doe", storeDTOs.get(0).ownerName());
    }

    @Test
    void testGetById() {
        // Arrange
        StoreOwner owner = new StoreOwner(1L, "John Doe");
        Store store = new Store(1L, "Store 1", "12345", owner);

        when(storeRepository.findById(1L)).thenReturn(Optional.of(store));

        // Act
        StoreDTO storeDTO = storeService.getById(1L);

        // Assert
        assertNotNull(storeDTO);
        assertEquals("Store 1", storeDTO.name());
        assertEquals("12345", storeDTO.taxId());
        assertEquals("John Doe", storeDTO.ownerName());
    }

    @Test
    void testCreate() {
        // Arrange
        StoreOwner owner = new StoreOwner(1L, "John Doe");
        Store store = new Store(null, "Store 1", "12345", owner);
        Store savedStore = new Store(1L, "Store 1", "12345", owner);

        StoreDTO storeDTO = new StoreDTO(null, "Store 1", "12345", "John Doe");

        when(storeRepository.save(any(Store.class))).thenReturn(savedStore);

        // Act
        StoreDTO createdStoreDTO = storeService.create(storeDTO);

        // Assert
        assertNotNull(createdStoreDTO);
        assertEquals(1L, createdStoreDTO.id());
        assertEquals("Store 1", createdStoreDTO.name());
        assertEquals("12345", createdStoreDTO.taxId());
        assertEquals("John Doe", createdStoreDTO.ownerName());
    }

    @Test
    void testDelete() {
        // Act
        storeService.delete(1L);

        // Assert
        verify(storeRepository, times(1)).deleteById(1L);
    }
}

