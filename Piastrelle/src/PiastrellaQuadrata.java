
/*
    OVERVIEW :
        -   Le istaze di questa classe rappresentano delle piastrelle quadrate
        -   Le istanze di questa classe sono immutabili
 */
public class PiastrellaQuadrata extends Piastrella {

    public final int lato;
    /*
        AF(lato) = rappresenta una piastrella quadrata di superficie lato^2
        IR = lato > 0
     */

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = costruisce questa piastella quadrata di costo costoUnitario e superficie lato*lato
        Se costoUnitario<=0 or lato <= 0 viene sollevata un eccezione di tipo IllegalArgumentException
     */
    public PiastrellaQuadrata(final int costoUnitario,final int lato){
        super(costoUnitario);
        if (lato<=0) throw new IllegalArgumentException("lato deve essere > 0");
        this.lato=lato;
    }

    @Override
    public int superficie() {
        return lato*lato;
    }
}
