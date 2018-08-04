package com.darvasr.movies.dto;

public class MovieDTO {

    private String name;

    private Integer year;

    private String description;

    private String studio;

    public MovieDTO(String name, Integer year, String description, String studio) {
        this.name = name;
        this.year = year;
        this.description = description;
        this.studio = studio;
    }

    public MovieDTO() {
        //Default Constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
}
