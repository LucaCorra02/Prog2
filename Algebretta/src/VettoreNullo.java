/*
    OVERVIEW :
        -   Le istanze di questa classe rappresentano un Vettore dove tutti gli elementi sono nulli (o)
        -   Le istanze di questa classe sono immutabili
 */
public class VettoreNullo implements Vettore{

    private final int dimensione;

    /*
        AF(dimensione) = dimensione rappresnta un vettore con tutti gli elementi nulli di dim dimensione.
        IR = dimensione > 0
     */

    //COSTRUTTORI
    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = Costruisce this a un vettore con entrate nulle di dimensione dim
        Viene sollevata un eccezione di tipo IlligalArgumentException se dim <=0
     */
    public VettoreNullo(final int dimensione){
        if (dimensione<=0) throw new IllegalArgumentException("dim <=0");
        this.dimensione=dimensione;
    }

    @Override
    public int dim() {
        return dimensione;
    }

    @Override
    public int val(int i) {
        if (i<0 || i > dim()-1) throw new IllegalArgumentException("i eccede la dimensione di this");
        return 0;
    }

    @Override
    public Vettore per(int alpha) {
        return new VettoreNullo(dimensione);
    }

    @Override
    public Vettore più(Vettore v) {
        if (v==null) throw new NullPointerException("v non può essere un riferimento a null");
        if (!(conformi(v))) throw new IllegalArgumentException("v e this non sono conformi");

        if (v instanceof VettoreNullo) return this;
        return v;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i=0;i<dimensione-1;i++){
            str.append(0+", ");
        }
        str.append(0+"]");
        return str.toString();
    }
}
