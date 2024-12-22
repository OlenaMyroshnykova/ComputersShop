package com.shop.computersshop.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StoreTest {

    private Store store;
    private StoreOwner mockOwner;
    private List<Computer> mockComputers;

    @BeforeEach
    void setUp() {
        // Создаем mock-объекты
        mockOwner = mock(StoreOwner.class);
        Computer mockComputer1 = mock(Computer.class);
        Computer mockComputer2 = mock(Computer.class);

        // Инициализируем список компьютеров
        mockComputers = new ArrayList<>();
        mockComputers.add(mockComputer1);
        mockComputers.add(mockComputer2);

        // Инициализация объекта Store
        store = new Store(1L, "Tech Store", "TAX123456", mockOwner);
    }

    @Test
    void testGetters() {
        // Проверяем корректность работы геттеров
        assertEquals(1L, store.getId());
        assertEquals("Tech Store", store.getName());
        assertEquals("TAX123456", store.getTaxId());
        assertEquals(mockOwner, store.getOwner());
    }

    @Test
    void testSetters() {
        // Создаем новый mock-объект для владельца
        StoreOwner newMockOwner = mock(StoreOwner.class);

        // Устанавливаем новые значения
        store.setId(2L);
        store.setName("Gadget Store");
        store.setTaxId("NEW123456");
        store.setOwner(newMockOwner);

        // Проверяем корректность работы сеттеров
        assertEquals(2L, store.getId());
        assertEquals("Gadget Store", store.getName());
        assertEquals("NEW123456", store.getTaxId());
        assertEquals(newMockOwner, store.getOwner());
    }

    @Test
    void testInteractionWithMocks() {
        // Настраиваем mock-объект
        when(mockOwner.getName()).thenReturn("John Doe");

        // Проверяем взаимодействие с mock-объектом
        assertEquals("John Doe", mockOwner.getName());

        // Убеждаемся, что метод был вызван
        verify(mockOwner, times(1)).getName();
    }
}

