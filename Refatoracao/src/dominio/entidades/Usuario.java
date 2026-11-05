package dominio.entidades;

public class Usuario {
    private String nome;
    private int idade;
    private String email;
    
    public Usuario (String nome, int idade, String email) {
    	this.nome = nome;
    	this.idade = idade;
    	this.email = email;
    }
    
    public String obterNome() {
    	return this.nome;
    }
    
    public void alterarNome(String novoNome) {
    	this.nome = novoNome;
    }
    
    public String obterEmail() {
    	return this.email;
    }
    
    public void alterarEmail(String novoEmail) {
    	this.email = novoEmail;
    }
    
    public int obterIdade() {
    	return this.idade;
    }
    
    public void alterarIdade(int novaIdade) {
    	this.idade = novaIdade;
    }
}
