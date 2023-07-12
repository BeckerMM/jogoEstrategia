import Unidades.*;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static CampoDeBatalha campodeBatalha;

    public static void main(String[] args) {

        menuInicial();


    }

    private static void menuInicial() {

        System.out.println("""
                1- Iniciar uma partida
                2- Regras do jogo
                3- Sair""");
        int decisao = sc.nextInt();
        switch (decisao) {
            case 1:
                iniciarUmaPartida();
                break;
            case 2:
                break;
            case 3:
                break;
        }


    }

    private static void iniciarUmaPartida() {
        Jogador listaDeJogadores[] = new Jogador[2];



        int decisao = 0;
        for (int i = 0; i < 2; i++) {
            String cor = "";
            String nome = "";
            Unidade listaDeUnidades[] = new Unidade[3];
            System.out.println("Digite o nome do jogador " + (i + 1) + ":");
            nome = sc.next();
            if (i == 0) {
                cor = "Branco";
            } else {
                cor = "Preto";
            }
            System.out.println("\nescolha as unidades do jogador " + i + ":" + """
                    
                    1-Batman;
                    2-Dragão;
                    3-Hulk;
                    4-Naruto;
                    5-OptimusPrime """);

            for (int j = 0; j < 3; j++) {
                decisao = sc.nextInt();
                switch (decisao) {
                    case 1:
                        Batman batman = new Batman(cor);
                        listaDeUnidades[j] = batman;
                        break;
                    case 2:
                        Dragao dragao = new Dragao(cor);
                        listaDeUnidades[j] = dragao;
                        break;
                    case 3:
                        Hulk hulk = new Hulk(cor);
                        listaDeUnidades[j] = hulk;
                        break;
                    case 4:
                        Naruto naruto = new Naruto(cor);
                        listaDeUnidades[j] = naruto;
                        break;
                    case 5:
                        OptimusPrime optimusPrime = new OptimusPrime(cor);
                        listaDeUnidades[j] = optimusPrime;
                        break;
                    default:
                        System.out.println("Valor inválido");
                        break;
                }
                System.out.println(listaDeUnidades[j]);

            }
            Jogador jogador = new Jogador(listaDeUnidades, cor, nome);
            listaDeJogadores[i] =jogador ;
        }

        System.out.println(listaDeJogadores[0].getListaDeUnidades()[0]+" "+ listaDeJogadores[1].getListaDeUnidades()[0]);
        campodeBatalha = new CampoDeBatalha(listaDeJogadores);
        campoDeBatalha();
    }

    private static void campoDeBatalha() {
        int cont = 0;
        do {

            System.out.println(campodeBatalha);
            if (cont == 0) {
                System.out.println("\nBEM VINDOS AO CAMPO DE BATALHA!");
            }
            if (cont % 2 == 0) {
                acaoAtaque(1);
            } else {
                acaoAtaque(2);
            }
            cont++;
            for (Unidade unidade:campodeBatalha.getListaDeJogadores()[0].getListaDeUnidades()) {
                unidade.setMana(unidade.getMana()+10);
            }
            for (Unidade unidade:campodeBatalha.getListaDeJogadores()[1].getListaDeUnidades()) {
                unidade.setMana(unidade.getMana()+10);
            }

        } while (campodeBatalha.verificarVencedor()==null);
        System.out.println("O vencedor foi o Jogador: "+ campodeBatalha.getVencedor());
    }

    private static void acaoAtaque(int numeroDoJogador){
        int unidadeDeAtaque=0;
        int unidadeAtacada = 0;
        int decisao = 0;
        System.out.println("Jogador "+numeroDoJogador+"\nEscolha sua unidade de ataque: ");
        unidadeDeAtaque = sc.nextInt();
        System.out.println("""
                        Escolha a ação:
                        1- Atacar
                        2- Habilidade Especial""");
        decisao = sc.nextInt();
        if (decisao == 1){
            System.out.println("Escolha a unidade para ser atacada:");
            unidadeAtacada = sc.nextInt();

            campodeBatalha.atacar((numeroDoJogador-1),unidadeDeAtaque,unidadeAtacada);
        }else{
            if(campodeBatalha.getListaDeJogadores()[numeroDoJogador-1].getListaDeUnidades()[unidadeAtacada].ataqueEspecial()){
                System.out.println("\nHabilidade utilizada com sucesso!");
            }else{
                System.out.println("\nMana baixa!");
            }
        }
    }


}
