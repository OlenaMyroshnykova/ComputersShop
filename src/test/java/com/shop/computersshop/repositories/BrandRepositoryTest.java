package com.shop.computersshop.repositories;

import com.shop.computersshop.models.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BrandRepositoryTest {

    @Autowired
    private BrandRepository brandRepository;

    @Test
    void shouldSaveBrand() {
        // Arrange
        Brand brand = new Brand();
        brand.setName("Test Brand");

        // Act
        Brand savedBrand = brandRepository.save(brand);

        // Assert
        assertThat(savedBrand.getId()).isNotNull();
        assertThat(savedBrand.getName()).isEqualTo("Test Brand");
    }

    @Test
    void shouldFindBrandById() {
        // Arrange
        Brand brand = new Brand();
        brand.setName("Test Brand");
        Brand savedBrand = brandRepository.save(brand);

        // Act
        Optional<Brand> foundBrand = brandRepository.findById(savedBrand.getId());

        // Assert
        assertThat(foundBrand).isPresent();
        assertThat(foundBrand.get().getName()).isEqualTo("Test Brand");
    }

    @Test
    void shouldUpdateBrand() {
        // Arrange
        Brand brand = new Brand();
        brand.setName("Old Name");
        Brand savedBrand = brandRepository.save(brand);

        // Act
        savedBrand.setName("Updated Name");
        Brand updatedBrand = brandRepository.save(savedBrand);

        // Assert
        assertThat(updatedBrand.getName()).isEqualTo("Updated Name");
    }

    @Test
    void shouldDeleteBrand() {
        // Arrange
        Brand brand = new Brand();
        brand.setName("Test Brand");
        Brand savedBrand = brandRepository.save(brand);

        // Act
        brandRepository.delete(savedBrand);
        Optional<Brand> deletedBrand = brandRepository.findById(savedBrand.getId());

        // Assert
        assertThat(deletedBrand).isNotPresent();
    }
}
