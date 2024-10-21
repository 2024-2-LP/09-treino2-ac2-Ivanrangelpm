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

  public Livro() {
  }

  public Livro(String autor, LocalDate dataPublicacao, String titulo) {
    this.autor = autor;
    this.dataPublicacao = dataPublicacao;
    this.titulo = titulo;
    this.avaliacoes = new ArrayList<Avaliacao>();
  }

  public void adicionarAvaliacao(String descricao, Double qtdEstrelas){
    if(descricao.isBlank() || descricao.isEmpty()){
      throw new ArgumentoInvalidoException("O argumento é invalido");
    }else if(qtdEstrelas < 0 || qtdEstrelas > 5){
      throw new ArgumentoInvalidoException("O argumento é invalido");
    }else{
      avaliacoes.add(new Avaliacao(descricao, qtdEstrelas));
    }
  }

  public Double calcularMediaAvaliacoes(){
    Double media = 0.0;

    if (avaliacoes.isEmpty()){
      return media;
    }

    for(Avaliacao av : avaliacoes){
      media += av.getQtdEstrelas();
    }

    return media / avaliacoes.size();

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

  public List<Avaliacao> getAvaliacoes() {
    return avaliacoes;
  }

  public void setAvaliacoes(List<Avaliacao> avaliacoes) {
    this.avaliacoes = avaliacoes;
  }

  @Override
  public String toString() {
    return "Livro{" +
            "autor='" + autor + '\'' +
            ", titulo='" + titulo + '\'' +
            ", dataPublicacao=" + dataPublicacao +
            '}';
  }
}

