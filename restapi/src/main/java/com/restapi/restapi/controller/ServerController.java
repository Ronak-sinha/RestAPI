package com.restapi.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.restapi.model.Server;
import com.restapi.restapi.services.ServerServices;

@RestController
@RequestMapping("/servers")
public class ServerController {

	@Autowired
	private ServerServices service;
	
	@GetMapping("")
	public ResponseEntity<List<Server>> getAllServers() {
        List<Server> servers = service.getAllServers();
        return new ResponseEntity<>(servers, HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Server> getServerById(@PathVariable("id") String id) {
        Optional<Server> server = service.getServerbyId(id);
        if (server.isPresent()) {
            return new ResponseEntity<>(server.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@PostMapping("")
    public ResponseEntity<Server> addServer(@RequestBody Server server) {
        Server newServer = service.addServer(server);
        return new ResponseEntity<>(newServer, HttpStatus.CREATED);
    }
	@DeleteMapping("/{id}")
    public void deleteServerById(@PathVariable("id") String id) {
		service.deleteServerById(id);;
	}
	@GetMapping("/findByName")
    public ResponseEntity<List<Server>> getServersByName(@RequestParam("name") String name) {
        List<Server> servers = service.getServersByName(name);
        if (servers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servers, HttpStatus.OK);
    }
}
