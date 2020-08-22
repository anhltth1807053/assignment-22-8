package com.demo.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "dogtype")
public class DogsType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "breedNameId")
    private Integer breedNameId;

    @Column(name = "breedName")
    private String breedName;

    @Column(name = "createdAt")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private String createdAt;

     @Column(name = "updatedAt")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private String updatedAt;



    @JsonIgnore
    @OneToMany(mappedBy = "dogsType")
    private List<Dogs> dogs;

    public Integer getBreedNameId() {
        return breedNameId;
    }

    public void setBreedNameId(Integer breedNameId) {
        this.breedNameId = breedNameId;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Dogs> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dogs> dogs) {
        this.dogs = dogs;
    }

    public DogsType() {
    }

    public DogsType(Integer breedNameId, String breedName, String createdAt, String updatedAt, List<Dogs> dogs) {
        this.breedNameId = breedNameId;
        this.breedName = breedName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.dogs = dogs;
    }
}
