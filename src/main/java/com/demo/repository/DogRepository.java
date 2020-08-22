package com.demo.repository;

import com.demo.entity.Dogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DogRepository extends CrudRepository<Dogs, Integer>, JpaSpecificationExecutor<Dogs> {

    @Query("select c from Dogs c where c.status = 1")
    List<Dogs> findAllDogs();

    @Query("select c from Dogs c where c.id=:id and c.status=1")
    Dogs findDogsById(int id);
}
