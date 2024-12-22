package com.shop.computersshop.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StoreOwnerTest {

    @Test
    void testStoreOwnerConstructorAndGetters() {
        // Arrange
        Long expectedId = 1L;
        String expectedName = "John Doe";

        // Act
        StoreOwner owner = new StoreOwner(expectedId, expectedName);

        // Assert
        assertEquals(expectedId, owner.getId(), "ID does not match");
        assertEquals(expectedName, owner.getName(), "Name does not match");
    }

    @Test
    void testSetId() {
        // Arrange
        StoreOwner owner = new StoreOwner();
        Long newId = 2L;

        // Act
        owner.setId(newId);

        // Assert
        assertEquals(newId, owner.getId(), "ID was not set correctly");
    }

    @Test
    void testSetName() {
        // Arrange
        StoreOwner owner = new StoreOwner();
        String newName = "Jane Doe";

        // Act
        owner.setName(newName);

        // Assert
        assertEquals(newName, owner.getName(), "Name was not set correctly");
    }

}

