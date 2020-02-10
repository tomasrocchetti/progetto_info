package it.rocchetti.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@GetMapping("/country")
	public String country() throws Exception {
		return "";
	}
}
