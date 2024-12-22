package com.shop.computersshop.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BrandTest {

    @Test
    void testBrandConstructorAndGetters() {
        // Arrange
        Long expectedId = 1L;
        String expectedName = "HP";

        // Act
        Brand brand = new Brand();
        brand.setId(expectedId);
        brand.setName(expectedName);

        // Assert
        assertEquals(expectedId, brand.getId(), "ID does not match");
        assertEquals(expectedName, brand.getName(), "Name does not match");
    }

    @Test
    void testSetId() {
        // Arrange
        Brand brand = new Brand();
        Long newId = 2L;

        // Act
        brand.setId(newId);

        // Assert
        assertEquals(newId, brand.getId(), "ID was not set correctly");
    }

    @Test
    void testSetName() {
        // Arrange
        Brand brand = new Brand();
        String newName = "Dell";

        // Act
        brand.setName(newName);

        // Assert
        assertEquals(newName, brand.getName(), "Name was not set correctly");
    }

}

