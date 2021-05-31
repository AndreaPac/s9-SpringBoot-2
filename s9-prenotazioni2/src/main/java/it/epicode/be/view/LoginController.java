package it.epicode.be.view;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.model.RegistrazioneUtente;
import it.epicode.be.model.login.LoginRequest;
import it.epicode.be.model.login.LoginResponse;
import it.epicode.be.persistance.UtenteRepository;
import it.epicode.be.security.JwtUtils;
import it.epicode.be.security.service.UserDetailsImpl;
import it.epicode.be.service.UtenteService;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	UtenteRepository utenteRepository;

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UtenteService utenteService;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/login")

	public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new LoginResponse(jwt, userDetails.getId(), userDetails.getUsername(),
				userDetails.getEmail(), roles, userDetails.getExpirationTime()));
	}

	@PostMapping("/login/registrautente")
	public RegistrazioneUtente registraUtente(@RequestBody RegistrazioneUtente registrazioneUtente) {

		utenteService.registraUtente(registrazioneUtente);
		
		return registrazioneUtente;

	}

}
