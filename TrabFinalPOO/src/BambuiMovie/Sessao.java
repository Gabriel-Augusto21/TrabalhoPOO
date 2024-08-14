package BambuiMovie;

// A classe Sessao representa uma exibição específica de um filme em um determinado horário e com uma certa capacidade de público.
public class Sessao {
    
    private Filme filme;  
    private int horario;  
    private int capacidade;  
    private int ingressosVendidos;  

    
    public Sessao(Filme filme, int horario, int capacidade) {
        this.filme = filme;  
        this.horario = horario;  
        this.capacidade = capacidade;  
        this.ingressosVendidos = 0;  // Inicializa a contagem de ingressos vendidos como 0 pois a sessão começa sem nenhum ingresso vendido.
    }

// Método para vender um ingresso para a sessão, retorna true se o ingresso foi vendido com sucesso, ou false se a sessão já estiver lotada.
    public boolean venderIngresso() {
        if (ingressosVendidos < capacidade) {  // Método para verificar se ainda há capacidade para vender mais ingressos.
            ingressosVendidos++; 
            return true;  
        } else {
            return false;
        }
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getIngressosVendidos() {
        return ingressosVendidos;
    }

    public void setIngressosVendidos(int ingressosVendidos) {
        this.ingressosVendidos = ingressosVendidos;
    }
}
