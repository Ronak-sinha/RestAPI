package com.restapi.restapi.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.restapi.model.Server;
import com.restapi.restapi.repo.ServerRepo;

@Service
public class ServerServices {

	@Autowired
	private ServerRepo repo;
	
	public List<Server> getAllServers() {
		return repo.findAll();
	}
	
	public Optional<Server> getServerbyId(String id) {
		return repo.findById(id);
	}
	
	public Server addServer(Server server) {
		return repo.save(server);
	}
	
	public void deleteServerById(String id) {
        repo.deleteById(id);
    }
	public List<Server> getServersByName(String name) {
        return repo.findByNameContaining(name);
    }
}
