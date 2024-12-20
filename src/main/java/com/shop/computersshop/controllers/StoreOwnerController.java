package com.shop.computersshop.controllers;

import com.shop.computersshop.dtos.*;
import com.shop.computersshop.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store-owners")
public class StoreOwnerController {

    private final StoreOwnerService storeOwnerService;

    public StoreOwnerController(StoreOwnerService storeOwnerService) {
        this.storeOwnerService = storeOwnerService;
    }

    @GetMapping
    public ResponseEntity<List<StoreOwnerDTO>> getAllStoreOwners() {
        return ResponseEntity.ok(storeOwnerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreOwnerDTO> getStoreOwnerById(@PathVariable Long id) {
        return ResponseEntity.ok(storeOwnerService.getById(id));
    }

    @PostMapping
    public ResponseEntity<StoreOwnerDTO> createStoreOwner(@RequestBody StoreOwnerDTO storeOwnerDTO) {
        return ResponseEntity.ok(storeOwnerService.create(storeOwnerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStoreOwner(@PathVariable Long id) {
        storeOwnerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
