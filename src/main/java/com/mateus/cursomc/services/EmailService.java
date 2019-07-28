package com.mateus.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.mateus.cursomc.domain.Cliente;
import com.mateus.cursomc.domain.Pedido;

public interface EmailService {
	void sendOrderConfirmationPedido (Pedido obj);
	
	void sendMail(SimpleMailMessage msg);
	
	void sendOrderConfirmationHtmlEmail(Pedido obj); 
	
	void sendHtmlEmail(MimeMessage msg);

	void sendNewPassword(Cliente cliente, String newPass); 
}
