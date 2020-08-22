package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

@Entity
public class Dogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Integer breedNameId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private String birthday;

    private int gender;

    private String color;

    private int status;

    public Dogs() {
    }


    @ManyToOne() //EAGER
    @JoinColumn(name = "breedNameId", insertable = false, updatable = false)
    private DogsType dogsType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBreedNameId() {
        return breedNameId;
    }

    public void setBreedNameId(Integer breedNameId) {
        this.breedNameId = breedNameId;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DogsType getDogsType() {
        return dogsType;
    }

    public void setDogsType(DogsType dogsType) {
        this.dogsType = dogsType;
    }

    public Dogs(int id, String name, Integer breedNameId, String birthday, int gender, String color, int status, DogsType dogsType) {
        this.id = id;
        this.name = name;
        this.breedNameId = breedNameId;
        this.birthday = birthday;
        this.gender = gender;
        this.color = color;
        this.status = status;
        this.dogsType = dogsType;
    }
}
