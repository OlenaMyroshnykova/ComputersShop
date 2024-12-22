package com.shop.computersshop.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    private Computer computer;
    private Brand mockBrand;
    private Store mockStore;

    @BeforeEach
    void setUp() {
        // Создание mock-объектов
        mockBrand = mock(Brand.class);
        mockStore = mock(Store.class);

        // Инициализация объекта Computer
        computer = new Computer(1L, mockBrand, 16, "Intel i7", "Windows 11", 1200.0, mockStore);
    }

    @Test
    void testGetters() {
        // Проверяем корректность работы геттеров
        assertEquals(1L, computer.getId());
        assertEquals(mockBrand, computer.getBrand());
        assertEquals(16, computer.getMemory());
        assertEquals("Intel i7", computer.getProcessor());
        assertEquals("Windows 11", computer.getOperatingSystem());
        assertEquals(1200.0, computer.getPrice());
        assertEquals(mockStore, computer.getStore());
    }

    @Test
    void testSetters() {
        // Создаем новые mock-объекты для обновления значений
        Brand newMockBrand = mock(Brand.class);
        Store newMockStore = mock(Store.class);

        // Устанавливаем новые значения
        computer.setId(2L);
        computer.setBrand(newMockBrand);
        computer.setMemory(32);
        computer.setProcessor("AMD Ryzen 7");
        computer.setOperatingSystem("Linux");
        computer.setPrice(1500.0);
        computer.setStore(newMockStore);

        // Проверяем корректность работы сеттеров
        assertEquals(2L, computer.getId());
        assertEquals(newMockBrand, computer.getBrand());
        assertEquals(32, computer.getMemory());
        assertEquals("AMD Ryzen 7", computer.getProcessor());
        assertEquals("Linux", computer.getOperatingSystem());
        assertEquals(1500.0, computer.getPrice());
        assertEquals(newMockStore, computer.getStore());
    }

    @Test
    void testInteractionWithMocks() {
        // Проверяем взаимодействие с mock-объектами
        when(mockBrand.getName()).thenReturn("Mock Brand");
        when(mockStore.getName()).thenReturn("Mock Store");

        assertEquals("Mock Brand", mockBrand.getName());
        assertEquals("Mock Store", mockStore.getName());

        // Убеждаемся, что методы были вызваны
        verify(mockBrand, times(1)).getName();
        verify(mockStore, times(1)).getName();
    }
}
