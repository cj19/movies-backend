package com.darvasr.movies.resource;

import com.darvasr.movies.dto.DirectorDTO;
import com.darvasr.movies.entity.Director;
import com.darvasr.movies.repository.DirectorRepository;
import com.darvasr.movies.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/director")
public class DirectorResource {

    private final DirectorService directorService;

    @Autowired
    public DirectorResource(DirectorService directorService) {
        this.directorService = directorService;
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Director> createDirector(@RequestBody DirectorDTO directorDTO) {
        Director director = directorService.createDirector(directorDTO);
        return ResponseEntity.ok(director);
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Director> getDirectorById(@PathVariable("id") Long id) {
        Director director = directorService.getDirectorById(id);
        return ResponseEntity.ok(director);
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Director> deleteDirectorById(@PathVariable("id") Long id) {
        Director director = directorService.deleteDirectorById(id);
        return ResponseEntity.ok(director);
    }
}
