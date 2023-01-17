
/*
    OVERVIEW :
        -   Le istanze di questa classe rappresentanto una MatriceDiagonale quadrata con i valori sulla diagonale principale
            APP a N mentre le altre entrate a 0, hanno dimesione positiva
        -   Le istanze di questa classe sono immutabili
 */

public class MatriceDiagonale extends MatriceAbs {

    private final int[] diagonale;

    /*
        AF(diagonale) = diagonale rappresenta una Matrice diagonale quadrata dove le entrate della diagonale principale
        sono gli elementi di diagonale.

        IR = diagonale != null
             dim diagonale > 0
     */


    //COSTRUTTORI
    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = costruisce this a una Matrice Diagonale con entrate sulla diagonale principale pari agli elementi contenuti in elem.
        Viene sollevata un eccezione di tipo NullPointerException se elem è un riferimento a null
        Viene sollevata un eccezione di tipo IllegalArgumentException se dim elem ==0
     */
    public MatriceDiagonale(final int[] entrate){
        if (entrate==null) throw new NullPointerException("entrate non può essere un riferimento a null");
        if (entrate.length==0) throw new IllegalArgumentException("entrate deve contenere almeno un elemento");

        diagonale=new int[entrate.length];

        for (int i=0;i<entrate.length;i++){
            diagonale[i]=entrate[i];
        }
    }

    @Override
    public int dim() {
        return diagonale.length;
    }

    @Override
    public int val(int i, int j) {
        if (i<0 || i > diagonale.length-1 || j<0 || j > diagonale.length-1) throw new IndexOutOfBoundsException("indici out of range");
        if (i==j) return diagonale[i];
        return 0;
    }

    @Override
    public Matrice per(int alpha) {
        if (alpha==0) return new MatriceNulla(diagonale.length);

        MatriceDiagonale ris = new MatriceDiagonale(diagonale);
        for(int i=0;i<diagonale.length;i++){
            ris.diagonale[i]=diagonale[i]*alpha;
        }
        return ris;
    }

    @Override
    public Matrice perM(Matrice m) {
        if (m==null) throw new NullPointerException("m non può essere un riferimento a null");
        if (!(conformi(m))) throw new IllegalArgumentException("m non è conforme a this");

        if (m instanceof MatriceNulla) return m;
        if (m instanceof MatriceIdentita) return this;
        return new MatriceDensa(diagonale).perM(m);
    }

    @Override
    public Vettore perV(Vettore v) {
        if (v==null) throw new NullPointerException("v non può essere un riferimento a null");
        if (!(conformi(v))) throw new IllegalArgumentException("this e v non sono conformi");

        if (v instanceof VettoreNullo) return v;

        final int[]ris = new int[diagonale.length];
        for (int i=0;i<diagonale.length;i++){
            ris[i] = diagonale[i]*v.val(i);
        }
        return new VettoreDenso(ris);
    }

    @Override
    public Matrice piu(Matrice m) {
        if (m==null) throw new NullPointerException("m non può essere un riferimento a null");
        if (!(conformi(m))) throw new IllegalArgumentException("m non è conforme a this");

        if (m instanceof MatriceNulla) return this;
        return new MatriceDensa(diagonale).piu(m);
    }
}
