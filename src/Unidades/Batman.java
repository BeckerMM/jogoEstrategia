package Unidades;



public class Batman extends Unidade {


    public Batman( String cor) {
        super(100, 55, 25, cor);
    }

    @Override
    boolean verificarvantagem(Unidade unidadeAdversaria) {

        if (unidadeAdversaria instanceof OptimusPrime){
            return true;
        }
        return false;
    }

}
