import java.util.ArrayList;

public class Biblioteca {
    public ArrayList<Livro> livros = new ArrayList<>();
    public ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(String titulo, String autor, int ano) {
        Livro l = new Livro();
        l.titulo = titulo;
        l.autor = autor;
        l.ano = ano;
        l.disponivel = true;
        livros.add(l);
    }

    public void realizarEmprestimo(Usuario u, String tituloLivro) {
        for (Livro l : livros) {
            if (l.titulo.equals(tituloLivro) && l.disponivel) {
                Emprestimo e = new Emprestimo();
                e.usuario = u;
                e.livro = l;
                e.data = "10/09/2025";
                emprestimos.add(e);
                l.disponivel = false;
                System.out.println("Empréstimo realizado: " + u.nome + " pegou " + l.titulo);
                return;
            }
        }
        System.out.println("Livro não disponível.");
    }

    public void listarEmprestimos() {
        for (Emprestimo e : emprestimos) {
            System.out.println("Usuário: " + e.usuario.nome + " - Livro: " + e.livro.titulo + " - Data: " + e.data);
        }
    }

    public void relatorioLivros() {
        for (Livro l : livros) {
            System.out.println(l.titulo + " - " + l.autor + " (" + l.ano + ")");
        }
    }
}
