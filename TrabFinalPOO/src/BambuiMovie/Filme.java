package BambuiMovie;

// A classe Filme representa um filme com título, gênero e duração.
public class Filme {
    
    private String titulo; 
    private String genero;  
    private int duracao; 

    public Filme(String titulo, String genero, int duracao) {
        this.titulo = titulo;  
        this.genero = genero;  
        this.duracao = duracao;  
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

   
    public void setGenero(String genero) {
        this.genero = genero;
    }
   
    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
