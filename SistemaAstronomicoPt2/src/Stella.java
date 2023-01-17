/*
    OVERVIEW :
        Le istanze di questa classe rappresentanto delle stelle caratterizzate da nome posizione e energia
        Una tipica istanza di questa classe è Stelle : nome, Posizione{x,y,z}
        Le istanze di queta classe sono mutabili
 */
public class Stella extends CorpoCeleste {

    /*
        AF = to string
        IR = Uguale a quella di corpoCeleste
     */

    public Stella(String nome, Punto posizione){
        super(nome,posizione);
    }

    /*
       REQUIRES = -
       MODIFYS = -
       EFFECTS = Ritorna un intero rappresentatante l'energia di this.
       L'ebergia è calcolato come prodotto tra L'energia cinetica e L'energia potenziale (nulla nel caso delle stelle)
    */
    @Override
    int calcolaEnergia() {
        return 0;
    }

    @Override
    public String toString() {
        return "Stella, "+super.toString();
    }
}
