/*
    OVERVIEW :
        -   Classe che rappresenta una piastrella immutabile
 */
public abstract class Piastrella implements Rivestimento {

    private final int costoUnitario;

    /*
        IR = costoUnitario >0
     */

    /*
        REQUIRES :=
        MODIFY := this
        EFFECTS := Costruisce questa piastrella con costo pari a costoUnitario
        costoUnitario <=0 viene sollevata un eccezione di tipo IllegalArgumentException
     */
    public Piastrella(final int costoUnitario){
        if (costoUnitario<=0) throw new IllegalArgumentException("costoUnitario <=0");
        this.costoUnitario=costoUnitario;
    }

    @Override
    public int costo(){
        return costoUnitario;
    }

}
