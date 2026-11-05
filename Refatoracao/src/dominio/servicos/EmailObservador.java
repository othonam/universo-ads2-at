package dominio.servicos;

import dominio.entidades.*;
import dominio.designPatterns.observable.Observador;
import dominio.portas.*;
import infra.servicosext.*;

public class EmailObservador extends Observador<Email> {

	EmailServicoInterface adapter = SmtpServico.obterInstancia();
	
	public EmailObservador() {}
	
	@Override
	public void reagir(Email evento) {
		this.adapter.enviarEmail(evento);
	}

}