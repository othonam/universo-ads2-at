public class Main {
    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();
        b.adicionarLivro("O Senhor dos Anéis", "J. R. R. Tolkien", 1954);
        b.adicionarLivro("Refatoração", "Martin Fowler", 2020);

        Usuario u = new Usuario();
        u.nome = "Maria";
        u.idade = 21;
        u.email = "maria@gmail.com";

        b.realizarEmprestimo(u, "O Senhor dos Anéis");
        b.realizarEmprestimo(u, "Refatoração");

        b.listarEmprestimos();
    }
}
