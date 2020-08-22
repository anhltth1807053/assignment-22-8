package com.demo.service;

import com.demo.entity.Dogs;
import com.demo.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImp implements DogService {

    @Autowired
    DogRepository dogRepository;

    @Override
    public List<Dogs> getAll() {
        return (List<Dogs>) dogRepository.findAllDogs();
    }

    @Override
    public Dogs saveDogs(Dogs dogs) {
        dogs.setStatus(1);
        return dogRepository.save(dogs);
    }

    @Override
    public Dogs updateDogs(Dogs dogs) {
        dogs.setStatus(2);
        return dogRepository.save(dogs);
    }

    @Override
    public Dogs getDogId(int id) {
        return dogRepository.findDogsById(id);
    }

}