package gent.springframework.spring5mvcwebfluxrest.repositories;

import gent.springframework.spring5mvcwebfluxrest.domain.Vendor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VendorRepository extends ReactiveMongoRepository<Vendor , String> {

}
