package Unidades;


public class Naruto extends Unidade {
    public Naruto(String cor) {
        super(50, 75, 10, cor);
    }

    public void habilidadeJutsoDaVida(){
        this.setVida(this.getVida()+5);
        this.setDefesa(this.getDefesa()+2);
    }

    @Override
    boolean verificarvantagem(Unidade unidadeAdversaria) {

        if (unidadeAdversaria instanceof Dragao) {
            return true;
        }
        return false;
    }

}
