package Unidades;


public class OptimusPrime extends Unidade {
    public OptimusPrime(String cor) {
        super(250, 75, 40, cor);
    }


    @Override
    boolean verificarvantagem(Unidade unidadeAdversaria) {

        if (unidadeAdversaria instanceof Naruto) {
            return true;
        }
        return false;
    }

    @Override
    boolean ataqueEspecial() {
        if (this.getMana() >= 10) {
            this.setVida(this.getVida() + 10);
            this.setDefesa(this.getDefesa() + 1);
            this.setMana(this.getMana() - 10);
            return true;
        } else {
            return false;
        }
    }
}
