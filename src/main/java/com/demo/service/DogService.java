package com.demo.service;

import com.demo.entity.Dogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DogService {

    List<Dogs> getAll();

    Dogs saveDogs(Dogs dogs);

    Dogs updateDogs(Dogs dogs);

    Dogs getDogId(int id);
}
