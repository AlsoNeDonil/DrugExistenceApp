package com.NeDonil.DrugExistence.repository;

import com.NeDonil.DrugExistence.models.DrugEntity;
import org.springframework.data.repository.CrudRepository;

public interface DrugRepository extends CrudRepository<DrugEntity, Long> {
}
