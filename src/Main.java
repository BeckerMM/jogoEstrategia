import Unidades.*;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static CampoDeBatalha campodeBatalha;

    public static void main(String[] args) {

        do {

        }while(!menuInicial());


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
            case 3 -> {
                return logout();
            }
            default -> System.out.println("Valor inválido!!");
        }


        return false;
    }

    private static boolean logout(){
        return true;
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
            campodeBatalha.verificarVidaDaUnidade();
            cont++;
            for (Unidade unidade:campodeBatalha.getListaDeJogadores()[0].getListaDeUnidades()) {
                if (unidade == null) {

                }else if(unidade.getMana()<=90){
                    unidade.setMana(unidade.getMana() + 10);
                }
            }
            for (Unidade unidade:campodeBatalha.getListaDeJogadores()[1].getListaDeUnidades()) {
                if (unidade == null){

                }else if (unidade.getMana()<=90){
                    unidade.setMana(unidade.getMana()+10);
                }
            }

        } while (campodeBatalha.verificarVencedor()==null);
        System.out.println("O vencedor foi o Jogador: "+ campodeBatalha.getVencedor());
    }

    private static void acaoAtaque(int numeroDoJogador){
        int unidadeDeAtaque=0;
        int unidadeAtacada = 0;
        int decisao = 0;
        int contador=0;
        do {
            if(contador!=0) {
                System.out.println("\nEscolha outra unidade!!");
            }
            System.out.println("Jogador "+numeroDoJogador+"\nEscolha sua unidade de ataque: ");
            unidadeDeAtaque = sc.nextInt();
            contador++;
        }while(campodeBatalha.verificarUnidade(unidadeDeAtaque,(numeroDoJogador-1)));

        System.out.println("""
                        Escolha a ação:
                        1- Atacar
                        2- Habilidade Especial""");
        decisao = sc.nextInt();
        switch (decisao){
            case 1:
                int adversario=0;
                int cont=0;
                if (numeroDoJogador==1){
                    adversario=1;
                }else if (numeroDoJogador==2){
                    adversario=0;
                }
                do {
                    if(cont!=0) {
                        System.out.println("\nEscolha outra unidade!!");
                    }
                    System.out.println("\nEscolha a unidade para ser atacada:");
                    unidadeAtacada = sc.nextInt();
                    cont++;

                }while(campodeBatalha.verificarUnidade(unidadeAtacada, (adversario)));

                if(campodeBatalha.atacar((numeroDoJogador-1),unidadeDeAtaque,unidadeAtacada)){
                System.out.println("\nAtaque realizado com sucesso!!");
            }else{
                System.out.println("\nUnidade Morta!!");
            }
            break;
            case 2:
            if(campodeBatalha.getListaDeJogadores()[numeroDoJogador-1].getListaDeUnidades()[unidadeDeAtaque].ataqueEspecial()){
                System.out.println("\nHabilidade utilizada com sucesso!");
            }else{
                System.out.println("\nMana baixa!");
            }
            break;
            default:
                System.out.println("\nNúmero inválido!!");
        }
    }

    private static void regrasDoJogo(){
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
