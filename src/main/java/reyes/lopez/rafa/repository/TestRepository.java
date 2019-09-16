package reyes.lopez.rafa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import reyes.lopez.rafa.model.Test;

@Repository
public interface TestRepository extends CrudRepository<Test, Long> {
}