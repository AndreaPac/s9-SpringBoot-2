package it.epicode.be.model;

import lombok.Data;

@Data
public class RegistrazioneUtente {

	private Long id;
	private String username;
	private String nomeCompleto;
	private String mailUtente;
	
	private String plainPassword;
	private String[] nomiRuolo;
	
}
