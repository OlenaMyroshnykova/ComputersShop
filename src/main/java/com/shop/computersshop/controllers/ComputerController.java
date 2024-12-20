package com.shop.computersshop.controllers;

import com.shop.computersshop.dtos.*;
import com.shop.computersshop.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/computers")
public class ComputerController {

    private final ComputerService computerService;

    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @GetMapping
    public ResponseEntity<List<ComputerDTO>> getAllComputers() {
        return ResponseEntity.ok(computerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComputerDTO> getComputerById(@PathVariable Long id) {
        return ResponseEntity.ok(computerService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ComputerDTO> createComputer(@RequestBody ComputerDTO computerDTO) {
        return ResponseEntity.ok(computerService.create(computerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComputer(@PathVariable Long id) {
        computerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
