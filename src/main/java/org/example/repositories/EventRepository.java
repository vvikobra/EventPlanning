package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.models.entities.Event;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class EventRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(Event event) {
        entityManager.persist(event);
    }

    public Optional<Event> findById(UUID id) {
        return Optional.ofNullable(entityManager.find(Event.class, id));
    }

    public List<Event> findAll() {
        return entityManager.createQuery("SELECT e FROM " + Event.class.getSimpleName() + " e", Event.class)
                .getResultList();
    }

    @Transactional
    public void update(Event event) {
        entityManager.merge(event);
    }
}
