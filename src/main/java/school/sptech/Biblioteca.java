package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.LivroNaoEncontradoException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros;

    public Biblioteca() {
    }

    public Biblioteca(String nome) {
        this.nome = nome;
        this.livros = new ArrayList<Livro>();
    }

    public void adicionarLivro(Livro livro){
        if(livro == null){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }else if(livro.getTitulo() == null || livro.getTitulo().isBlank()){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }else if(livro.getAutor() == null || livro.getAutor().isBlank()){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }else if(livro.getDataPublicacao() == null){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }else{
            this.livros.add(livro);
        }
    }

    public Livro buscarLivroPorTitulo(String titulo){
        if(titulo == null || titulo.isBlank()){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }

        for(Livro livro : livros){
            if(titulo.equalsIgnoreCase(livro.getTitulo())){
                return livro;
            }
        }

        throw new LivroNaoEncontradoException("Livro nao encontrado");


    }

    public void removerLivroPorTitulo(String titulo){

        if(titulo == null || titulo.isBlank()){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }

        for (int i = 0; i < livros.size(); i++) {
            if(titulo.equalsIgnoreCase(livros.get(i).getTitulo())){
                livros.remove(i);
            }
        }
    }

    public Integer contarLivros(){
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano){
        List<Livro> livrosAno = new ArrayList<>();
        for(Livro livro : livros){
            if(ano == livro.getDataPublicacao().getYear()){
                livrosAno.add(livro);
            }
        }

        return livrosAno;
    }


    public List<Livro> retornarTopCincoLivros() {
        List<Livro> livrosComMedia = new ArrayList<>(livros);

        livrosComMedia.sort(Comparator.comparingDouble(Livro::calcularMediaAvaliacoes).reversed());

        if (livrosComMedia.size() <= 5) {
            return livrosComMedia;
        }

        return livrosComMedia.subList(0, 5);
    }


    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
