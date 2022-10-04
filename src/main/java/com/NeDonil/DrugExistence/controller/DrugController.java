package com.NeDonil.DrugExistence.controller;

import com.NeDonil.DrugExistence.models.DrugEntity;
import com.NeDonil.DrugExistence.repository.DrugRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/drug")
public class DrugController {

    private final DrugRepository repository;

    public DrugController(DrugRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity getAll(){
        List<DrugEntity> drugs = new ArrayList<DrugEntity>();
        Iterable<DrugEntity> result = repository.findAll();

        result.forEach(drugs::add);
        return ResponseEntity.ok().body(drugs);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody DrugEntity drug){
        return ResponseEntity.ok().body(repository.save(drug));
    }

}
