package dominio.entidades;

import java.util.ArrayList;
import dominio.designPatterns.observable.*;
import dominio.servicos.*;


public class Biblioteca extends Observavel<Email>{
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    private EmailSucessoFabrica fabricadorEmailSucesso = EmailSucessoFabrica.obterInstancia();
    
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    // Ao encontrar o Livro, atualiza a flag emprestimo realizado, termina o loop do for com break;
    public boolean realizarEmprestimo(Usuario usuario, Livro livro, String data) {
    	var emprestimoRealizado = false;
    	
        for (Livro livroDaLista : livros) {
            if (livroDaLista.obterTitulo().equals(livro.obterTitulo()) && livroDaLista.obterDisponibilidade()) {
                Emprestimo emprestimo = new Emprestimo(usuario, livro, data );
        
                emprestimos.add(emprestimo);
                livroDaLista.alterarDisponibilidade(false);
                emprestimoRealizado = true;
                break;
            }
        }
        
        if(emprestimoRealizado) {
        	fabricadorEmailSucesso.preparar(usuario, data);
        	Email emailSucessoFabricado = fabricadorEmailSucesso.fabricar();
        	this.notificarObservadores(emailSucessoFabricado);
            System.out.println("Empréstimo realizado: " + usuario.obterNome() + " pegou " + livro.obterTitulo());
        }
        else {
            System.out.println(String.format("Livro %s não disponível.", livro.obterTitulo()));
        }
        
        return emprestimoRealizado;
    }

    public void listarEmprestimos() {
    	System.out.println("------EMPRESTIMOS-------");
        for (Emprestimo emprestimo : emprestimos) {
        	var usuarioResponsavel = emprestimo.obterUsuarioResponsavel();
        	var livroEmprestado = emprestimo.obterLivroEmprestado();
        	
            System.out.println("Usuário: " + usuarioResponsavel.obterNome() + " - Livro: " + livroEmprestado.obterTitulo() + " - Data: " + emprestimo.obterDataDeEmprestimo());
        }
        

    	System.out.println("------------------------");
    }

    public void relatorioLivros() {
        for (Livro livro : livros) {
            System.out.println(livro.obterTitulo() + " - " + livro.obterAutor() + " (" + livro.obterAno() + ")");
        }
        

    	System.out.println("--------------");
    }
}
