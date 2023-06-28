package Unidades;



public class Hulk extends Unidade {

    public Hulk (String cor){
        super(900,50,50,cor);

    }

    public boolean habilidadeFuriaVerde( int numeroRodada){
        if(this.getVida()>=750 && numeroRodada >=5){
            this.setAtaque(this.getAtaque()+5);
            return true;
        }else{
            return false;
        }

    }
    @Override
    boolean verificarvantagem(Unidade unidadeAdversaria) {

        if (unidadeAdversaria instanceof Batman){
            return true;
        }
        return false;
    }

}
