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
    List<Dogs> findAll(Specification specification);
    Optional<Dogs> findById(Integer id);

    void deleteById(Integer id);

    @Query("select c from Dogs c where c.name like %?1%")
    Page<List<Dogs>> findAllByName(String name, Pageable pageable);
}
