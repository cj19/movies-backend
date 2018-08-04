package com.darvasr.movies.dto;

public class ActorDTO {

    private String name;

    private Integer birthYear;

    private  String birthPlace;

    public ActorDTO(String name, Integer birthYear, String birthPlace) {
        this.name = name;
        this.birthYear = birthYear;
        this.birthPlace = birthPlace;
    }

    public ActorDTO() {
        //Default Constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }
}
