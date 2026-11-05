package infra.servicosext;
import java.util.ArrayList;

import dominio.entidades.*;
import dominio.portas.*;

public class SmtpServico implements EmailServicoInterface {
	private static final int PORTA_SMTP = 123;
	private static final String SERVIDOR_SMTP = "127.0.0.1";

    private static SmtpServico instancia = new SmtpServico();
    
    private Boolean conexaoAberta = false;
    

    private ArrayList<Email> emailsEnviados = new ArrayList<>();
    
    private void estabeleceConexao() {
    	// Simbolizando um abertura de conexao
    	this.conexaoAberta = true;
    }
    
    private void fechaConexao() {
    	//Simbolizando um fechamento de conexao
    	if(this.conexaoAberta) {
    		this.conexaoAberta = false;
    	}
    }
    
    // Metodos Singletons
    private SmtpServico() {}
    
    public static synchronized SmtpServico obterInstancia() {
    	return instancia;
    }
    
    private void enviar(Email email) throws Exception {
    	try {
    		this.estabeleceConexao();
    		var destinatario = email.obterDestinatario();
 
    		// Simbolizando envio de email para servidor SMTP
        	System.out.println("Enviando e-mail para " + destinatario.obterEmail() + ": " + email.obterMensagem());
    	}catch(Exception e){
    		throw e;
    	}finally {}
    	this.fechaConexao();
    }
    
    public void enviarEmail(Email email) {
    	try {
    		var emailValido = email.eValido();
    		
    		if(!emailValido) {
    			throw new Exception ("E-mail não é valido. ");
    		}

    		this.enviar(email);
    		
    		this.emailsEnviados.add(email);
        
    	}catch(Exception e) {
    		System.out.println(String.format("Ocorreu um erro durante a validação do envio de e-mail: %e. ", e.getMessage()));
    		
    	}
    }
    
 
}