package com.darvasr.movies.service;

import com.darvasr.movies.dto.ActorDTO;
import com.darvasr.movies.entity.Actor;
import com.darvasr.movies.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Actor createActor(ActorDTO actorDTO) {
        Actor actor = new Actor();
        actor.setName(actorDTO.getName());
        actor.setBirthYear(actorDTO.getBirthYear());
        actor.setBirthPlace(actorDTO.getBirthPlace());
        actor.setMovies(new ArrayList<>());

        return createActor(actor);
    }

    private Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Actor getActorById(Long id) {
        return actorRepository.getOne(id);
    }

    public Actor deleteActorById(Long id) {
        Actor actor = getActorById(id);
        actorRepository.delete(actor);
        return actor;
    }

    public List<Actor> getAllActor() {
        return actorRepository.findAll();
    }
}
