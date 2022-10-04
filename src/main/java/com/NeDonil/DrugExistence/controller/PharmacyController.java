package com.NeDonil.DrugExistence.controller;

import com.NeDonil.DrugExistence.models.PharmacyEntity;
import com.NeDonil.DrugExistence.repository.PharmacyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pharmacy")
public class PharmacyController {

    private final PharmacyRepository repository;

    public PharmacyController(PharmacyRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity getAll(){
        List<PharmacyEntity> pharmacies = new ArrayList<PharmacyEntity>();
        Iterable<PharmacyEntity> result = repository.findAll();

        result.forEach(pharmacies::add);
        return ResponseEntity.ok().body(pharmacies);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody PharmacyEntity drug){
        return ResponseEntity.ok().body(repository.save(drug));
    }

}
