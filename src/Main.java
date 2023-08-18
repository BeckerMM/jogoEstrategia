import Unidades.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static CampoDeBatalha campodeBatalha;

    public static void main(String[] args) {

        while (!menuInicial()) ;


    }

    private static boolean menuInicial() {

        System.out.println("""
                1- Iniciar uma partida
                2- Regras do jogo
                3- Sair""");
        int decisao = sc.nextInt();
        switch (decisao) {
            case 1 -> iniciarUmaPartida();
            case 2 -> regrasDoJogo();
            case 3 -> System.exit(0);
            default -> System.out.println("Valor inválido!!");
        }
        return false;
    }

    private static void iniciarUmaPartida() {
        ArrayList<Jogador> listaDeJogadores = new ArrayList<>();
        int decisao = 0;

        for (int i = 0; i < 2; i++) {
            String cor = "";
            String nome = "";
            ArrayList<Unidade> listaDeUnidades = new ArrayList<>();
            System.out.println("Digite o nome do jogador " + (i + 1) + ":");
            nome = sc.next();

            if (i == 0) {
                cor = "Branco";
            } else {
                cor = "Preto";
            }
            System.out.println("\nEscolha as unidades do jogador " + (i + 1) + ":" + """
                                        
                    1-Batman
                    2-Dragão
                    3-Hulk
                    4-Naruto
                    5-OptimusPrime """);

            for (int j = 0; j < 3; j++) {

                Unidade unidade;
                do {

                    decisao = sc.nextInt();
                    unidade = retornaUnidade(decisao, cor);
                    if (unidade == null) {
                        System.out.println("Valor inválido!");
                    }
                } while (unidade == null);
                listaDeUnidades.add(unidade);

            }

            Jogador jogador = new Jogador(listaDeUnidades, cor, nome);
            listaDeJogadores.add(jogador);
        }

        System.out.println(listaDeJogadores.get(0).getListaDeUnidades() + " " + listaDeJogadores.get(1).getListaDeUnidades());
        campodeBatalha = new CampoDeBatalha(listaDeJogadores);
        campoDeBatalha();
    }

    private static Unidade retornaUnidade(int decisao, String cor) {
        return switch (decisao) {
            case 1 -> new Batman(cor);
            case 2 -> new Dragao(cor);
            case 3 -> new Hulk(cor);
            case 4 -> new Naruto(cor);
            case 5 -> new OptimusPrime(cor);
            default -> null;
        };
    }

    private static void campoDeBatalha() {
        int cont = 0;
        do {

            System.out.println(campodeBatalha);
            if (cont == 0) {
                System.out.println("\nBEM VINDOS AO CAMPO DE BATALHA!");
            }
            acoes(campodeBatalha.getListaDeJogadores().get(cont % 2));

            campodeBatalha.verificarVidaDaUnidade();
            cont++;
            for (Unidade unidade : campodeBatalha.getListaDeJogadores()[0].getListaDeUnidades()) {
                if (unidade.getMana() <= 90) {
                    unidade.setMana(unidade.getMana() + 10);
                }
            }
            for (Unidade unidade : campodeBatalha.getListaDeJogadores()[1].getListaDeUnidades()) {
                if (unidade.getMana() <= 90) {
                    unidade.setMana(unidade.getMana() + 10);
                }
            }

        } while (campodeBatalha.verificarVencedor() == null);
        System.out.println("O vencedor foi o Jogador: " + campodeBatalha.getVencedor());
    }

    private static Unidade escolherUnidade(Jogador jogador) {
        int unidadeDeAtaque;
        Unidade unidade;
        int contador = 0;
        do {
            if (contador != 0) {
                System.out.println("\nEscolha outra unidade!!");
            }
            System.out.println("Escolha sua unidade de ataque:");
            unidadeDeAtaque = sc.nextInt();
            unidade = jogador.getUnidade(unidadeDeAtaque);

            contador++;
        } while (unidadeDeAtaque >= jogador.getListaDeUnidades().size() || unidadeDeAtaque < 0);
        return unidade;
    }

    private static int escolherAcao( ){
    int contador = 0;
    int decisao;
        do {
            if (contador != 0) {
                System.out.println("valor Iválido!");
            }
            System.out.println("""
                    Escolha a ação:
                    1- Atacar
                    2- Habilidade Especial""");
            decisao = sc.nextInt();
            contador++;
        } while (decisao > 2 || decisao < 1);
        return decisao;
    }

    private static void acoes(Jogador jogador) {

        int unidadeAtacada = 0;
        int decisao = escolherAcao();

        switch (decisao) {
            case 1 -> acaoAtacar(jogador);
            case 2 -> acaoEspecial(jogador, escolherUnidade(jogador));
            default -> System.out.println("\nNúmero inválido!!");

        }
    }

    private static void acaoEspecial(Jogador jogador, Unidade unidadeDeAtaque) {

        if (jogador.habilidaEspecial(unidadeDeAtaque)) {
            System.out.println("\nHabilidade utilizada com sucesso!");
        } else {
            System.out.println("\nMana baixa!");
        }
    }

    private static void acaoAtacar(Jogador jogador){
            int cont = 0;

            do {
                if (cont != 0) {
                    System.out.println("\nEscolha outra unidade!!");
                }
                System.out.println("\nEscolha a unidade para ser atacada:");
                unidadeAtacada = sc.nextInt();
                while (unidadeAtacada > 3 || unidadeAtacada < 0) {
                    System.out.println("Valor Inválido!!");
                    System.out.println("Escolha a unidade para ser atacada:");
                    unidadeAtacada = sc.nextInt();

                }
                cont++;

            } while (campodeBatalha.verificarUnidade(unidadeAtacada, (adversario)));

            if (campodeBatalha.atacar((numeroDoJogador - 1), unidadeDeAtaque, unidadeAtacada)) {
                jogador.atacar();
                System.out.println("\nAtaque realizado com sucesso!!");
            } else {
                System.out.println("\nUnidade Morta!!");
            }
        }
        }

    private static void regrasDoJogo() {
        System.out.println("""
                --REGRAS DO JOGO--
                                
                1- O campo de batalha será composto por 2 jogadores;
                2- Cada Jogador poderá escolher 3 unidades;
                3- O jogador 1 começará atacando;
                4- Cada unidade possui duas ações atacar e sua Habilidade Especial;
                5- O jogador vencedor será aquele que conseguir derrotar todas as unidades do seu adversário    
                """);
    }


}
