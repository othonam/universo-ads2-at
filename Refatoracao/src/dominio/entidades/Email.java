package dominio.entidades;

import java.util.ArrayList;

public class Email {
	
    private Usuario destinatario;
    private String assunto;
    private String mensagem;
    
    public Email(Usuario destinatario, String assunto, String mensagem) {
    	this.destinatario = destinatario;
    	this.assunto = assunto;
    	this.mensagem = mensagem;
    }
    
    private ArrayList<String> obterErros() {
    	ArrayList<String> erros = new ArrayList<>();
    	
    	if (this.destinatario == null) {
    		erros.add("Destinatário não é válido. ");
    	}
    	
    	if (
    		this.destinatario.obterEmail() == null || 
    		!this.destinatario.obterEmail().contains(String.valueOf('@'))) {

    		erros.add("E-mail do Destinatário não é válido. ");
    	}
    	
    	if ( this.assunto == null) {
    		erros.add("Assunto não é valido. ");
    	}
    	
    	if (this.mensagem == null) {
    		erros.add("Mensagem não é valida. ");
    	}
    	
    	return erros;
    }
    
    public boolean eValido() {
    	try {
        	var erros = this.obterErros();
        	
        	if(!erros.isEmpty()) {

        		var motivos = "";
        		for (String erro : erros) {
        			motivos = ", " + erro;
        		}

            	System.out.println(String.format("Encontrado erros no e-mail. Erros %m .", motivos));
        		
            	return false;
        	}
        	
        	return true;
    	}catch(Exception e) {
    		System.out.println(String.format("Ocorreu um erro durante a validação do e-mail: %e", e.getMessage()));
    		return false;
    	}
    }
    
    public Usuario obterDestinatario() {
    	return this.destinatario;
    }
    
    public String obterMensagem() {
    	return this.mensagem;
    }
    
    public String obterAssunto() {
    	return this.assunto;
    }
}
