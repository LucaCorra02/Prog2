/*
    OVERVIEW :
        -  Le istanze di questa classe rappresentanto delle matrici quadrate nulle ogni entrata è pari a 0.
        -  Le istanze di questa classe sono immutabili.
 */
public class MatriceNulla extends MatriceAbs {

    private final int dimensione;

    /*
        AF(dimensione) = dimensione rappresenta una matrice dimensione x dimensione con tutte le entrate a 0.
        IR = dimensione > 0
     */


    // Costruttore
    /*
        -  REQUIRES = -
        -  MODIFY = this
        -  EFFECTS = Costruisce this a una matriceNulla di dimensione dim
        Viene sollevata un eccezione di tipo IllegalArgumentException se dim <=0
     */
    public MatriceNulla(final int dim){
        if (dim<=0) throw new IllegalArgumentException("dim<=0");
        dimensione=dim;
    }


    //METODI
    @Override
    public int dim() {
        return dimensione;
    }

    @Override
    public int val(int i, int j) {
        if (i<0 || i > dimensione-1 || j<0 || j > dimensione-1) throw new IndexOutOfBoundsException("i out of range");
        return 0;
    }

    @Override
    public Matrice per(int alpha) {
        return this;
    }

    @Override
    public Matrice perM(Matrice m) {
        if (m==null) throw new NullPointerException("m non può essere un riferimento a null");
        if (!(this.conformi(m))) throw new IllegalArgumentException("m e this non sono conformi");

        return this;
    }

    @Override
    public Vettore perV(Vettore v) {
        if (v==null) throw new NullPointerException("v non può essere un riferimento a null");
        if (!(conformi(v))) throw new IllegalArgumentException("this e v non sono conformi");
        return new VettoreNullo(dimensione);
    }

    @Override
    public Matrice piu(Matrice m) {
        if (m==null) throw new NullPointerException("m non può essere un riferimento a null");
        if (!(this.conformi(m))) throw new IllegalArgumentException("m e this non sono conformi");

        return m;
    }
}
