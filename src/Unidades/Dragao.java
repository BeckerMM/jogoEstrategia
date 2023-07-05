package Unidades;


public class Dragao extends Unidade {

    public Dragao(String cor) {
        super(500, 35, 45, cor);
    }


    @Override
    boolean verificarvantagem(Unidade unidadeAdversaria) {

        if (unidadeAdversaria instanceof Hulk) {
            return true;
        }
        return false;
    }

    @Override
    boolean ataqueEspecial() {
        if (this.getMana() >= 25) {
            this.setAtaque(this.getAtaque() + 10);
            this.setDefesa(this.getDefesa() + 10);
            this.setMana(this.getMana()-25);
            return true;
        }
        else{
            return false;
        }
    }


}
