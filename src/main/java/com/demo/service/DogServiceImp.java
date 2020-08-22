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
        return (List<Dogs>) dogRepository.findAll();
    }

    @Override
    public Page<List<Dogs>> findAllByName(String name, Pageable pageable) {
        return dogRepository.findAllByName(name,pageable);
    }

    @Override
    public Dogs saveDog(Dogs dogs) {
        return dogRepository.save(dogs);
    }

    @Override
    public Optional<Dogs> getDogById(Integer id) {
        return dogRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        dogRepository.deleteById(id);
    }
}
