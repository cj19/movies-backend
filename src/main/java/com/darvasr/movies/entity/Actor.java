package com.darvasr.movies.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ACTOR")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Actor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "BIRTH_YEAR")
    private Integer birthYear;

    @Column(name = "BIRTH_PLACE")
    private  String birthPlace;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "MOVIE_ACTOR",
            joinColumns = @JoinColumn(name = "MOVIE_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ACTOR_ID", referencedColumnName = "id"))
    private List<Movie> movies;

    public Actor() {
        //default constructor
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

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actor actor = (Actor) o;

        if (id != null ? !id.equals(actor.id) : actor.id != null) return false;
        if (!name.equals(actor.name)) return false;
        if (birthYear != null ? !birthYear.equals(actor.birthYear) : actor.birthYear != null) return false;
        if (birthPlace != null ? !birthPlace.equals(actor.birthPlace) : actor.birthPlace != null) return false;
        return movies != null ? movies.equals(actor.movies) : actor.movies == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + name.hashCode();
        result = 31 * result + (birthYear != null ? birthYear.hashCode() : 0);
        result = 31 * result + (birthPlace != null ? birthPlace.hashCode() : 0);
        result = 31 * result + (movies != null ? movies.hashCode() : 0);
        return result;
    }
}

