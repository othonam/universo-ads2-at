package dominio.entidades;

public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private String data;
    
    public Emprestimo (Usuario usuario, Livro livro, String data) {
    	this.usuario = usuario;
    	this.livro = livro;
    	this.data = data;
    }
    
    public void realizarEmprestimo() {
    	this.livro.alterarDisponibilidade(false);
    }
    
    public Usuario obterUsuarioResponsavel() {
    	return this.usuario;
    }
    
    public Livro obterLivroEmprestado() {
    	return this.livro;
    }
    
    public String obterDataDeEmprestimo() {
    	return this.data;
    }
}
