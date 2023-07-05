package Unidades;


public class Naruto extends Unidade {
    public Naruto(String cor) {
        super(50, 75, 10, cor);
    }

    @Override
    boolean verificarvantagem(Unidade unidadeAdversaria) {

        if (unidadeAdversaria instanceof Dragao) {
            return true;
        }
        return false;
    }

    @Override
    boolean ataqueEspecial() {
        if (this.getMana()>=5){
            this.setVida(this.getVida()+5);
            this.setDefesa(this.getDefesa()+2);
            this.setMana(this.getMana()-5);
            return true;
        }else {
            return false;
        }
    }

}
