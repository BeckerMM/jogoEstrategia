import Unidades.*;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

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
                break;
            case 2:
                break;
            case 3:
                break;
        }


    }

    private static void iniciarUmaPartida() {
        Jogador listaDeJogadores[] = new Jogador[2];
        String cor = "";
        Unidade listaDeUnidades[] = new Unidade[3];
        String nome = "";
        int decisao = 0;
        for (int i = 0; i < 2; i++) {
            System.out.println("Digite o nome do jogador " + (i + 1) + ":");
            nome = sc.next();
            if (i==0){
                cor = "Branco";
            }else{
                cor = "Preto";
            }
            System.out.println("escolha as unidades do jogador "+i+":"+"""
                    1-Batman;
                    2-Dragão;
                    3-Hulk;
                    4-Naruto;
                    5-OptimusPrime
                    """);

            for (int j = 0; j <4 ; j++) {
                decisao=sc.nextInt();
                switch (decisao){
                    case 1:
                        Batman batman = new Batman(cor);
                        listaDeUnidades[j]= batman;
                        break;
                    case 2:
                        Dragao dragao = new Dragao(cor);
                        break;
                    case 3:
                        Hulk hulk = new Hulk(cor);
                        break;
                    case 4:
                        Naruto naruto = new Naruto(cor);
                        break;
                    case 5:
                        OptimusPrime optimusPrime = new OptimusPrime(cor);
                        break;
                }
            }

        }
    }

}
