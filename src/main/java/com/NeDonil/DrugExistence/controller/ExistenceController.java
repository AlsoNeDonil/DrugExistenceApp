package com.NeDonil.DrugExistence.controller;

import com.NeDonil.DrugExistence.models.DrugEntity;
import com.NeDonil.DrugExistence.models.ExistenceEntity;
import com.NeDonil.DrugExistence.models.PharmacyEntity;
import com.NeDonil.DrugExistence.models.VendorEntity;
import com.NeDonil.DrugExistence.repository.DrugRepository;
import com.NeDonil.DrugExistence.repository.ExistenceRepository;
import com.NeDonil.DrugExistence.repository.PharmacyRepository;
import com.NeDonil.DrugExistence.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/existence")
public class ExistenceController {

    @Autowired
    private ExistenceRepository existenceRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @Autowired
    private DrugRepository drugRepository;

    @GetMapping
    public ResponseEntity getAll(){
        List<ExistenceEntity> existencies = new ArrayList<ExistenceEntity>();
        Iterable<ExistenceEntity> result = existenceRepository.findAll();

        result.forEach(existencies::add);
        return ResponseEntity.ok().body(existencies);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody ExistenceEntity existence,
                              @RequestParam(name = "vendor_id") Long vendor_id,
                              @RequestParam(name = "pharmacy_id") Long pharmacy_id,
                              @RequestParam(name = "drug_id") Long drug_id){

        VendorEntity vendor = vendorRepository.findById(vendor_id).get();
        PharmacyEntity pharmacy = pharmacyRepository.findById(pharmacy_id).get();
        DrugEntity drug = drugRepository.findById(drug_id).get();

        existence.setVendor(vendor);
        existence.setPharmacy(pharmacy);
        existence.setDrug(drug);

        return ResponseEntity.ok().body(existenceRepository.save(existence));
    }

}

