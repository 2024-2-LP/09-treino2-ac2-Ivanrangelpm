package school.sptech;


import school.sptech.exception.ArgumentoInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes;

    @Override
    public String toString() {
        return "Livro{" +
                "autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", avaliacoes=" + avaliacoes +
                '}';
    }

    public Livro(){
        this.avaliacoes = new ArrayList<>();
    }

    public Livro(String autor, String titulo, LocalDate dataPublicacao) {
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.titulo = titulo;
        this.avaliacoes = new ArrayList<Avaliacao>();
    }


    public void adicionarAvaliacao(String descricao, Double qtdEstrelas){
        if((descricao == null || descricao.isBlank()) || qtdEstrelas == null || (qtdEstrelas > 5 || qtdEstrelas < 0)){
            throw new ArgumentoInvalidoException("O argumento é invalido");
        }else{
            Avaliacao aval = new Avaliacao(descricao, qtdEstrelas);
            avaliacoes.add(aval);

        }
    }


    public Double calcularMediaAvaliacoes(){

        if(avaliacoes.isEmpty()){
            return 0.0;
        }


        Double media = 0.0;
        for(Avaliacao aval : avaliacoes){
            media += aval.getQtdEstrelas();

        }

        return media / avaliacoes.size();
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

