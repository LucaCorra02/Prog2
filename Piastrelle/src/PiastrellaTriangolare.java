/*
    OVERVIEW :
        -   Le istaze di questa classe rappresentano delle piastrelle triangolari
        -   Le istanze di questa classe sono immutabili
 */
public class PiastrellaTriangolare extends Piastrella {

    public int altezza;
    public int lato;

    /*
        AF(altezza,lato) = piastrella triangolare rappresentata da aletezza e lato.
        IR = lato > 0 && altezza > 0
     */

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = costruisce questa piastrellaTriangolare di prezzo costo e superficie lato*altezza/2
        viene sollevata un eccezione di tipo IllegalArgument exception se costo < 0 or altezza < 0 or lato < 0
     */
    public PiastrellaTriangolare(final int costo, final int altezza, final int lato){
        super(costo);
        if (lato<=0 || altezza<=0) throw new IllegalArgumentException("lato e altezza devono essere >0");
        this.altezza=altezza;
        this.lato=lato;
    }

    @Override
    public int superficie() {
        return (lato*altezza)/2;
    }

}
