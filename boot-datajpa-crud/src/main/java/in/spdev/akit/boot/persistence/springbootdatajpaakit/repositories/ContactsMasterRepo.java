package in.spdev.akit.boot.persistence.springbootdatajpaakit.repositories;

import in.spdev.akit.boot.persistence.springbootdatajpaakit.entities.ContactsMasterEntity;
import org.springframework.data.repository.CrudRepository;

public interface ContactsMasterRepo extends CrudRepository<ContactsMasterEntity,Integer> {

}