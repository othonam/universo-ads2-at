import dominio.entidades.*;

public class Main {
    public static void main(String[] args) {
    	
        Biblioteca b = new Biblioteca();
        Livro livroSenhorDosAneis = new Livro("O Senhor dos Anéis", "J. R. R. Tolkien", 1954, true);
        Livro livroRefatoracao = new Livro("Refatoração", "Martin Fowler", 2020, true);
        
        
        b.adicionarLivro(livroSenhorDosAneis);
        b.adicionarLivro(livroRefatoracao);

        Usuario u = new Usuario("Maria", 21, "maria@gmail.com");

        b.realizarEmprestimo(u, livroSenhorDosAneis, "2026-01-01");
        b.realizarEmprestimo(u, livroSenhorDosAneis, "2026-01-02");

        b.listarEmprestimos();
    }
}
