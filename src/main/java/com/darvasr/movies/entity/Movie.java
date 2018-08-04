package com.darvasr.movies.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "MOVIE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    @NotNull
    private String name;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STUDIO")
    private String studio;

    @XmlTransient
    @ManyToMany(mappedBy = "movies")
    private List<Director> directors;

    @XmlTransient
    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;

    public Movie() {
        //Default constructor
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

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != null ? !id.equals(movie.id) : movie.id != null) return false;
        if (!name.equals(movie.name)) return false;
        if (year != null ? !year.equals(movie.year) : movie.year != null) return false;
        if (description != null ? !description.equals(movie.description) : movie.description != null) return false;
        if (studio != null ? !studio.equals(movie.studio) : movie.studio != null) return false;
        if (directors != null ? !directors.equals(movie.directors) : movie.directors != null) return false;
        return actors != null ? actors.equals(movie.actors) : movie.actors == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + name.hashCode();
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (studio != null ? studio.hashCode() : 0);
        result = 31 * result + (directors != null ? directors.hashCode() : 0);
        result = 31 * result + (actors != null ? actors.hashCode() : 0);
        return result;
    }
}
