package BambuiMovie;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
	
    private String nome;
    private List<Filme> filmes;// Lista para armazenar objetos da classe Filme, representando os filmes disponíveis no cinema
    private List<Sessao> sessoes;// Lista para armazenar objetos da classe Sessao, representando as sessões disponíveis no cinema
    private List<Consumivel> consumiveis;// Lista para armazenar objetos da classe Consumivel, representando os itens como pipoca, refrigerante

    public Cinema(String nome) {
        this.nome = nome;  
        this.filmes = new ArrayList<>();// Inicializa a lista de filmes como uma nova ArrayList
        this.sessoes = new ArrayList<>();// Inicializa a lista de sessões como uma nova ArrayList
        this.consumiveis = new ArrayList<>();// Inicializa a lista de consumíveis como uma nova ArrayList
    }

// Método para adicionar um filme à lista de filmes
    public void adicionarFilme(Filme filme) {
        filmes.add(filme);// Adiciona o filme à lista de filmes
    }

// Método para adicionar uma sessão à lista de sessões
    public void adicionarSessao(Sessao sessao) {
        sessoes.add(sessao);// Adiciona a sessão à lista de sessões
    }

// Método para adicionar um consumível à lista de consumíveis
    public void adicionarConsumivel(Consumivel consumivel) {
        consumiveis.add(consumivel);// Adiciona o consumível à lista de consumíveis
    }
    
// Como estamos usando uma lista, em java é possivel usar metodos como por exemplo o ".add" para manipular essa lista, no caso estamos usando para adicionar itens a lista 

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public List<Sessao> getSessoes() {
        return sessoes;
    }

    public void setSessoes(List<Sessao> sessoes) {
        this.sessoes = sessoes;
    }

    public List<Consumivel> getConsumiveis() {
        return consumiveis;
    }

    public void setConsumiveis(List<Consumivel> consumiveis) {
        this.consumiveis = consumiveis;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
