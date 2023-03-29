package com.restapi.restapi.repo;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.restapi.restapi.model.Server;

@Repository
public interface ServerRepo extends MongoRepository<Server, String> {

	List<Server> findByNameContaining(String id);
}