package com.demo.entity;


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
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Dogs> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dogs> dogs) {
        this.dogs = dogs;
    }
}
