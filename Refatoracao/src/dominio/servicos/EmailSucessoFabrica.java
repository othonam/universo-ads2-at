package dominio.servicos;

import dominio.designPatterns.factory.Fabrica;
import dominio.entidades.Email;
import dominio.entidades.Usuario;
import infra.servicosext.SmtpServico;

public class EmailSucessoFabrica extends Fabrica<Email>{

    private static EmailSucessoFabrica instancia = new EmailSucessoFabrica();
	
    private static String SUCESSO_ASSUNTO = "Empréstimo Realizado";
    private static String SUCESSO_MENSAGEM = "Caro %s, O emprestimo foi realizado %s, agradecemos sua preferência. Cuide bem do nosso livro, é importante devolvé-lo nas mesmas condições do empréstimo. Para mais informações, contate o setor de Ajuda.";    		
    
    private String mensagemPreparada = null;
    private Boolean foiPreparado = false;
    
    private Usuario destinatario = null;
    private String dataEmprestimo = null;
    
    private EmailSucessoFabrica() {}
    
    public static synchronized EmailSucessoFabrica obterInstancia() {
    	return instancia;
    }
    
    public void preparar(Usuario destinatario, String data) {
    	this.destinatario = destinatario;
    	this.dataEmprestimo = data;
    	
    	try {
			this.montarMensagem();
			this.foiPreparado = true;
		} catch (Exception e) {
            System.out.println("Erro ao preparar o Email de Sucesso. ");
            this.foiPreparado = false;
		}
    }
    
    public Email fabricar() {
    	
    	if(!this.foiPreparado) {
    		return null;
    	}
    	
    	Email emailSucesso = new Email(this.destinatario, SUCESSO_ASSUNTO, this.mensagemPreparada);
    	
    	return emailSucesso;
    }
    
    private void montarMensagem() throws Exception {
    	   
    	if (this.destinatario.obterNome() == null || this.dataEmprestimo == null) {
    		throw new Exception("Ao montar a mensagem de Email, foi detectado que o Nome ou Data de Emprestimo sao nulos. ");
    	}
    		
        this.mensagemPreparada = String.format(SUCESSO_MENSAGEM, this.destinatario.obterNome(), dataEmprestimo);
    }
}