package com.mateus.cursomc.services;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.mateus.cursomc.domain.Pedido;

public abstract class AbstractEmailService implements EmailService{
	
	@Value("${default.sender}")
	private String sender;
	
	@Override
	public void sendOrderConfirmationPedido (Pedido obj) {
		SimpleMailMessage sm = preparaSimpleMailMessageFromPedido(obj);
		sendMail(sm);
	}

	protected SimpleMailMessage preparaSimpleMailMessageFromPedido(Pedido obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getCliente().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Pedido confirmado código: " + obj.getId());
		sm.setSentDate(Calendar.getInstance().getTime());;
		sm.setText(obj.toString());
		return sm;
	}
}
