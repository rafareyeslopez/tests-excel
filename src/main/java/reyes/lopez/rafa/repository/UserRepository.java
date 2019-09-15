package reyes.lopez.rafa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import reyes.lopez.rafa.model.Pregunta;

@Repository
public interface UserRepository extends CrudRepository<Pregunta, Long> {
}