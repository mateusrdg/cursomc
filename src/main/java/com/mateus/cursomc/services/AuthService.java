package com.mateus.cursomc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mateus.cursomc.domain.Cliente;
import com.mateus.cursomc.repositories.ClienteRepository;
import com.mateus.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private ClienteRepository clienteRepo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private EmailService emailService;
	
	private Random random = new Random();

	public void sendNewPassword(String email) {
		Cliente cliente = clienteRepo.findByEmail(email);
		if (cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado!");
		}
		String newPass = newPassword();
		cliente.setSenha(bCryptPasswordEncoder.encode(newPass));
		clienteRepo.save(cliente);
		emailService.sendNewPassword(cliente, newPass);

	}

	private String newPassword() {
		char[] vet = new char[10];
		for (int i=0; i < 10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = random.nextInt(3);
		
		if (opt == 0) {
			return (char) (random.nextInt(10) + 48); 
		} else if (opt == 1) {
			return (char) (random.nextInt(26) + 65);
		} else {
			return (char) (random.nextInt(26) + 97);
		}
	}
}
