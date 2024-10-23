package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.LivroNaoEncontradoException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros;

    public Biblioteca(){
         this.livros = new ArrayList<Livro>();
    }

    public Biblioteca( String nome) {
        this.nome = nome;
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro){
        if(livro == null || livro.getAutor() == null || livro.getAutor().isBlank() || livro.getTitulo() == null || livro.getTitulo().isBlank() || livro.getDataPublicacao() == null ){
            throw new ArgumentoInvalidoException("Erro ao adicionar livro");
        }else{
            this.livros.add(livro);
        }
    }

    public void removerLivroPorTitulo(String titulo){
        Livro livro = buscarLivroPorTitulo(titulo);
        livros.remove(livro);

    }



    public Livro buscarLivroPorTitulo(String titulo){
        if(titulo == null || titulo.isBlank()){
            throw new ArgumentoInvalidoException("O argumento é invalido");
        }else{
            for(Livro livro : this.livros){
                if(titulo.equalsIgnoreCase(livro.getTitulo())){
                    return livro;
                }
            }

            throw new LivroNaoEncontradoException();
        }
    }


    public Integer contarLivros(){
        return this.livros.size();
    }
    public List<Livro> obterLivrosAteAno(Integer ano){
        List<Livro> livrosAteAno = new ArrayList<>();
        for(Livro livro : this.livros){
            if(livro.getDataPublicacao().getYear() <= ano){
                livrosAteAno.add(livro);
            }
        }

        return livrosAteAno;
    }

    public List<Livro> retornarTopCincoLivros() {
        List<Livro> livrosComMedia = new ArrayList<>(livros);

        livrosComMedia.sort(Comparator.comparingDouble(Livro::calcularMediaAvaliacoes).reversed());

        if (livrosComMedia.size() <= 5) {
            return livrosComMedia;
        }

        return livrosComMedia.subList(0, 5);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "livros=" + livros +
                ", nome='" + nome + '\'' +
                '}';
    }


}
