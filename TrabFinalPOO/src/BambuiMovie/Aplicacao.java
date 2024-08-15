package BambuiMovie;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
// Criando todos os objetos das classes para iniciar o programa
        Cinema cinema = new Cinema("BambuiMovie");
        List<Cliente> clientes = new ArrayList<>();// Lista de clientes que serão usados como exemplo
        List<Ingresso> ingressosVendidos = new ArrayList<>();// Lista de ingressos criada

        
        Filme filme1 = new Filme("Robocop", "Ação", 148);
        Filme filme2 = new Filme("Toy Story", "Animação", 81);

        cinema.adicionarFilme(filme1);
        cinema.adicionarFilme(filme2);

        
        Sessao sessao1 = new Sessao(filme1, 19, 100);
        Sessao sessao2 = new Sessao(filme2, 15, 50);  

        cinema.adicionarSessao(sessao1);
        cinema.adicionarSessao(sessao2);

        
        Consumivel pipoca = new Consumivel("Pipoca", 12.0);
        Consumivel refrigerante = new Consumivel("Refrigerante", 5.0);

        cinema.adicionarConsumivel(pipoca);
        cinema.adicionarConsumivel(refrigerante);

        Scanner scanner = new Scanner(System.in);
        
//Criando switch case para o menu do cinema
        int opcao;
        do {
            System.out.println("Selecione a opção desejada:");
            System.out.println("1 - Ver filmes em cartaz");
            System.out.println("2 - Comprar ingresso");
            System.out.println("3 - Ver consumíveis à venda");
            System.out.println("4 - Mostrar clientes");
            System.out.println("5 - Relatório de vendas por período (antes ou depois das 17 horas)");
            System.out.println("6 - Fila de clientes");
            System.out.println("0 - Finalizar programa");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    verFilmesEmCartaz(cinema);
                    break;
                case 2:
                    comprarIngresso(cinema, clientes, ingressosVendidos, scanner);
                    break;
                case 3:
                    verConsumiveis(cinema);
                    break;
                case 4:
                    mostrarClientes(clientes);
                    break;
                case 5:
                    relatorioVendasPorPeriodo(ingressosVendidos);
                    break;
                case 6:
                    mostrarFilaClientes(clientes);
                    break;
                case 0:
                    System.out.println("Finalizando programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void verFilmesEmCartaz(Cinema cinema) {
        System.out.println("Filmes em cartaz:");
        for (Filme filme : cinema.getFilmes()) {
            System.out.println(filme.getTitulo() + " - " + filme.getGenero() + " - " + filme.getDuracao() + " minutos");
        }
    }

    public static void comprarIngresso(Cinema cinema, List<Cliente> clientes, List<Ingresso> ingressosVendidos, Scanner scanner) {
        System.out.println("Digite seu nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite sua idade:");
        int idade = scanner.nextInt();
        scanner.nextLine(); 

        Cliente cliente = new Cliente(nome, idade);
        clientes.add(cliente);

        System.out.println("Escolha uma sessão para comprar ingresso:");
        for (int i = 0; i < cinema.getSessoes().size(); i++) { // como estamos usando uma lista em java, temos a opção de colocar um ".size" que ja obtemos o tamanho da lista
        	// de forma fácil, bem melhor que o lista.ultimo de c++ que temos que atualizar toda hora
            Sessao sessao = cinema.getSessoes().get(i);
            System.out.println((i + 1) + ": " + sessao.getFilme().getTitulo() + " às " + sessao.getHorario());
        }

        int escolhaSessao = scanner.nextInt();
        Sessao sessaoEscolhida = cinema.getSessoes().get(escolhaSessao - 1);

        System.out.println("Quantos ingressos deseja comprar?");
        int quantidade = scanner.nextInt();

        double precoIngresso = 20.0; 
        double precoIngressoMeia = 12.0; 
        double total = 0;
        List<Consumivel> consumiveisComprados = new ArrayList<>(); 

        for (int i = 0; i < quantidade; i++) {
            boolean meiaEntrada = idade < 18;

            if (sessaoEscolhida.venderIngresso() && meiaEntrada) {
            	Ingresso ingresso = new Ingresso(sessaoEscolhida.getFilme(), sessaoEscolhida.getHorario(), sessaoEscolhida.getCapacidade(), precoIngressoMeia, meiaEntrada, consumiveisComprados, quantidade);
                ingressosVendidos.add(ingresso);
                total += ingresso.getPreco()* quantidade;
                System.out.println("Ingresso comprado para a sessão: " + sessaoEscolhida.getFilme().getTitulo());
            } else {
            	Ingresso ingresso = new Ingresso(sessaoEscolhida.getFilme(), sessaoEscolhida.getHorario(), sessaoEscolhida.getCapacidade(), precoIngresso, meiaEntrada, consumiveisComprados, quantidade);
            	ingressosVendidos.add(ingresso);
            	total += ingresso.getPreco() * quantidade;
                System.out.println("Ingresso comprado para a sessão: " + sessaoEscolhida.getFilme().getTitulo());
                break;
            }
        }


        System.out.println("Deseja comprar consumíveis? (s/n)");
        String respostaConsumiveis = scanner.next();
        if (respostaConsumiveis.equalsIgnoreCase("s")) { //equalsIgnoreCase é uma função de java para string que permite utilizar isso para facilitar a comparação
        	// de diferentes tipos de letras como por exemplo maiúscula e minuscula
            System.out.println("Quantos refrigerantes deseja comprar? (R$5,00 cada)");
            int totalRefri = scanner.nextInt();

            System.out.println("Quantas pipocas deseja comprar? (R$12,00 cada)");
            int totalPipoca = scanner.nextInt();

            int totalConsumivel = (totalRefri * 5) + (totalPipoca * 12);
            total += totalConsumivel; // O += consegue pegar o valor atribuido anteriormente a variavel e somar com algo novo de forma rápida

            System.out.println("Total de consumíveis: R$" + totalConsumivel);
        } 
        System.out.println("Total da compra (ingressos + consumíveis): R$" + total);
    }

   
    public static void verConsumiveis(Cinema cinema) {
        System.out.println("Consumíveis à venda:");
        for (Consumivel consumivel : cinema.getConsumiveis()) {
            System.out.println(consumivel.getNome() + " - R$" + consumivel.getPreco());
        }
    }

    public static void mostrarClientes(List<Cliente> clientes) {
        System.out.println("Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNome() + " - Idade: " + cliente.getIdade());
        }
    }

    public static void relatorioVendasPorPeriodo(List<Ingresso> ingressosVendidos) {
        System.out.println("Relatório de vendas:");
        double totalAntes17 = 0;
        double totalDepois17 = 0;

        // Loop simples para somar o valor dos ingressos vendidos e consumíveis
        for (int i = 0; i < ingressosVendidos.size(); i++) {
            Ingresso ingresso = ingressosVendidos.get(i);
            double precoTotal = ingresso.getPreco() * ingresso.getQuantidade();

            // Soma o preço dos consumíveis comprados junto com o ingresso
            List<Consumivel> consumiveisComprados = ingresso.getConsumiveisComprados();
            for (int j = 0; j < consumiveisComprados.size(); j++) {
                Consumivel consumivel = consumiveisComprados.get(j);
                precoTotal += consumivel.getPreco();
            }

            // Verifica o horário da sessão e adiciona ao total antes ou depois das 17h
            if (ingresso.getHorario() < 17) {
                totalAntes17 += precoTotal;
            } else {
                totalDepois17 += precoTotal;
            }
        }

        System.out.println("Total(em dinheiro) de ingressos vendidos antes das 17 horas: R$" + totalAntes17);
        System.out.println("Total(em dinheiro) de ingressos vendidos depois das 17 horas: R$" + totalDepois17);
    }

    public static void mostrarFilaClientes(List<Cliente> clientes) {
        System.out.println("Fila de clientes:");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            System.out.println((i + 1) + ": " + cliente.getNome() + " - Idade: " + cliente.getIdade());
        }
    }
}


