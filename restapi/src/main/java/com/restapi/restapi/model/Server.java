package com.restapi.restapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Servers")
public class Server {

    @Id
    private String id;

    private String name;
    private String language;
    private String framework;

    public Server() {}

    public Server(String name, String language, String framework) {
        this.name = name;
        this.language = language;
        this.framework = framework;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

	@Override
	public String toString() {
		return "server [id=" + id + ", name=" + name + ", language=" + language + ", framework=" + framework + "]";
	}
    
}
