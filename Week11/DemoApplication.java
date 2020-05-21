package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/showallplayers")
	public String showallplayers() {
		return String.format("return allplayers list");
		new Player("showallplayers");
	}

	@GetMapping("/addplayer")
	public String addplayer(@RequestParam(value = "name", defaultValue = "no_name_specified") String name) {
		return String.format("We're sorry but there's %s . Please give a GET parameter.", name);
	}

	@GetMapping("/renameplayer")
	public String renameplayer(@RequestParam(value = "id", defaultValue = "Need a 'name' parameter to delete") String name) {
		return String.format("Please write the id of the player you want to rename %s!", name);
	}

	@GetMapping("/removeplayer")
	public String removeplayer(@RequestParam(value = "id", defaultValue = "World") String name) {
		return String.format("Please write the id of the player you want to delete %s!", name);
	}


}