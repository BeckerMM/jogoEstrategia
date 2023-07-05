import Unidades.Unidade;

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
        for (int i = 0; i < 2; i++) {
            System.out.println("Digite o nome do jogador " + (i + 1) + ":");
            nome = sc.next();
            if (i==0){

            }

        }
    }

}
