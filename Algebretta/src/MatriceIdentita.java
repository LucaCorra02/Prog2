/*
    OVERVIEW :
        -   Le istanze di quela classe rappresetanto delle Matrici di identita quadrate con i componenti sulla diagonale principale pari 1 e tutti gli altri pari a 0
        -   Le istanze di questa classe sono immutabili
        -   Le istanze di questa classe hanno dimensione positiva
 */
public class MatriceIdentita extends MatriceAbs {

    private final int dimensione;

    /*
        AF(dimensione) = dimensione rappresenta un matrice d'identità quadrata con ...
        IR = dimensione > 0
     */

    //COSTRUTTORI

    /*
        REQUIRES = -
        MODIFY = -
        EFFECTS = costruisce this a un MatriceIdentità di dimensione dim
        Viene sollevata un eccezione di tipo IllegalArgumentException se dim <= 0
     */
    public MatriceIdentita(final int dim){
        if (dim<=0) throw new IllegalArgumentException("dim non può essere un riferimento a null");
        this.dimensione=dim;
    }

    //METODI
    @Override
    public int dim() {
        return dimensione;
    }

    @Override
    public int val(int i, int j) {
        if (i<0 || i > dimensione-1 || j<0 || j > dimensione-1) throw new IndexOutOfBoundsException("indici out of range");
        if (i==j) return 1;
        return 0;
    }

    @Override
    public Matrice per(int alpha) {
        if (alpha==0) return new MatriceNulla(dimensione);

        int[] ris = new int[dimensione];
        for (int i=0;i<dimensione;i++){
            ris[i]=alpha;
        }
        return new MatriceDiagonale(ris);
    }

    @Override
    public Matrice perM(Matrice m) {
        if (m==null) throw new NullPointerException("m non può essere un riferimento a null");
        if (!(conformi(m))) throw new IllegalArgumentException("this e m non conformi");
        return m;
    }

    @Override
    public Vettore perV(Vettore v) {
        if (v==null) throw new NullPointerException("v non può essere un riferimento a null");
        if (!(conformi(v))) throw new IllegalArgumentException("this e v non sono conformi");
        return v;
    }

    @Override
    public Matrice piu(Matrice m) {
        if (m==null) throw new NullPointerException("m non può essere un riferimento a null");
        if (!(conformi(m))) throw new IllegalArgumentException("this e m non conformi");

        if (m instanceof MatriceNulla) return m;
        return new MatriceDensa(this).piu(m);

    }
}
