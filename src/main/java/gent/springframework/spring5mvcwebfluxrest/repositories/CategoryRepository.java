package gent.springframework.spring5mvcwebfluxrest.repositories;

import gent.springframework.spring5mvcwebfluxrest.domain.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
}
