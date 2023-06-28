package Unidades;



public class Dragao extends Unidade {

    public Dragao( String cor) {
        super(500, 35, 45, cor);
    }

    @Override
    boolean verificarvantagem(Unidade unidadeAdversaria) {

        if (unidadeAdversaria instanceof Hulk){
            return true;
        }
        return false;
    }


}
