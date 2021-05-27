package it.epicode.be.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.epicode.be.model.Utente;
import it.epicode.be.persistance.UtenteRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UtenteRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Utente> user = userRepository.findByUsername(username);

		if (user.isPresent()) {
			return UserDetailsImpl.build(user.get());
		} else {
			throw new UsernameNotFoundException("User Not Found with username: " + username);
		}
	}

}
