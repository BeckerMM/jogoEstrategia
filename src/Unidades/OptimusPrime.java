package Unidades;


public class OptimusPrime extends Unidade {
    public OptimusPrime( String cor) {
        super(250, 75, 40, cor);
    }

    public boolean habilidadePrimal(int numeroDaRodada){
        if (numeroDaRodada % 2 ==1 && numeroDaRodada>=5){
            this.setVida(this.getVida()+10);
            this.setDefesa(this.getDefesa()+1);
            return true;
        }else{
            return false;
        }
    }


    @Override
    boolean verificarvantagem(Unidade unidadeAdversaria) {

        if (unidadeAdversaria instanceof Naruto){
            return true;
        }
        return false;
    }
}
