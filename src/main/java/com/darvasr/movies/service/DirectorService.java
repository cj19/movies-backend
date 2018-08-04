package com.darvasr.movies.service;

import com.darvasr.movies.dto.DirectorDTO;
import com.darvasr.movies.entity.Director;
import com.darvasr.movies.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public Director createDirector(DirectorDTO directorDTO) {
        Director director = new Director();
        director.setName(directorDTO.getName());
        director.setBirthYear(directorDTO.getBirthYear());
        director.setBirthPlace(directorDTO.getBirthPlace());
        director.setMovies(new ArrayList<>());

        return createDirector(director);
    }

    private Director createDirector(Director director) {
        return directorRepository.save(director);
    }

    public Director getDirectorById(Long id) {
        return directorRepository.getOne(id);
    }

    public Director deleteDirectorById(Long id) {
        Director director = getDirectorById(id);
        directorRepository.delete(director);
        return director;
    }

    public List<Director> getAllDirector() {
        return directorRepository.findAll();
    }
}
