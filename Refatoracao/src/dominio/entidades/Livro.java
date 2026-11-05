package dominio.entidades;

public class Livro {
    private String titulo;
    private String autor;
    private int ano;
    private boolean disponivel;
    
    public Livro(String titulo, String autor, int ano, boolean disponivel) {
    	this.titulo = titulo;
    	this.autor = autor;
    	this.ano = ano;
    	this.disponivel = disponivel;
    }
    
    public String obterTitulo() {
    	return this.titulo;
    }
    
    public void alterarTitulo(String novoTitulo) {
    	this.titulo = novoTitulo;
    }
    
    public String obterAutor() {
    	return this.autor;
    }
    
    public void alterarAutor(String novoAutor) {
    	this.autor = novoAutor;
    }
    
    public int obterAno() {
    	return this.ano;
    }
    
    public void alterarAno(int novoAno) {
    	this.ano = novoAno;
    }

    public boolean obterDisponibilidade() {
    	return this.disponivel;
    }
    
    public void alterarDisponibilidade(boolean novaDisponibilidade) {
    	this.disponivel = novaDisponibilidade;
    }    
}
