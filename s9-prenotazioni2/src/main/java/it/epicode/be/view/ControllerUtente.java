package it.epicode.be.view;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUtente {
	
	
	
	@GetMapping("/helloUtente")
	public String hello() {

		return "hello";
	}
}
