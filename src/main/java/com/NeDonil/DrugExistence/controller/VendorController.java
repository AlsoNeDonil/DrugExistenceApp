package com.NeDonil.DrugExistence.controller;

import com.NeDonil.DrugExistence.models.VendorEntity;
import com.NeDonil.DrugExistence.repository.VendorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    private final VendorRepository repository;

    public VendorController(VendorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity getAll(){
        List<VendorEntity> vendors = new ArrayList<VendorEntity>();
        Iterable<VendorEntity> result = repository.findAll();

        result.forEach(vendors::add);
        return ResponseEntity.ok().body(vendors);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody VendorEntity vendor){
        return ResponseEntity.ok().body(repository.save(vendor));
    }

}
