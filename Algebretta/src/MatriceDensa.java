/*
    OVERVIEW :
        -   Le istanze di questa classe rapprsentanto una Matrice densa quandrata di interi
        -   Le istanze di questa classe sono immutabili
        -   Una matrice densa ha sempre almeno un elemento, dimensione >=1.
 */
public class MatriceDensa extends MatriceAbs{

    private final int[][] mat;

    /*
        AF = il valore in i-esima e j-esima posizione della matrice corrisponde al valore in i-esima e j-esima posizione di mat;
        IR = mat != null
             il numero di elementi di ogni riga è uguale al numero di righe ed è sempre positivo.
             Ogni valore contenuto in mat deve essere un intero.
     */


    //COSTRUTTORI

    /*
        REQUIRES = -
        MODIFYS = this
        EFFECTS = costruisce una questa matriceDensa composta da tutti 0 di dimensione dim
        Viene sollevata un eccezione di tipo IllegalArgumentException se dim <= 0.
     */
    private MatriceDensa(final int dim){
        if ( dim<=0) throw new IllegalArgumentException("dim <=0");
        mat= new int[dim][dim];
    }

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = Costruisce una MatriceDensa partendo da un matrice di interi mat.
        Viene sollevata una eccezione di tipo NullPointerException se mat == null
        Viene sollevata un eccezione di tipo IllegalArgumentException se mat non è quadrata oppure se dim(mat)<=0
     */

    public MatriceDensa(int[][] mat) {
        if(mat==null) throw new NullPointerException("mat non può essere un riferimento a null");
        if(mat.length == 0) throw new IllegalArgumentException("la dim di mat deve essere positiva");

        this.mat = new int[mat.length][mat.length];

        for (int i=0;i< mat.length;i++){
            if (mat[i].length != mat.length) throw new IllegalArgumentException("dimensione riga != numero di righe");
            for (int j =0; j < mat.length;j++){
                this.mat[i][j]=mat[i][j];
            }
        }
    }

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = Costruisce una MatriceDensa partendo da un vettore di interi, gli elementi del vettore diventeranno le entrate
        della diagonale principale di this.
        Viene sollevata una eccezione di tipo NullPointerException se vet == null
        Viene sollevata un eccezione di tipo IllegalArgumentException se dim(vet) == 0
     */
    public MatriceDensa(final int[] vet){
        if (vet==null) throw new NullPointerException("vet non può essere un riferimento a null");
        if (vet.length==0) throw new IllegalArgumentException("dim di vet ==0");

        mat = new int[vet.length][vet.length];
        for (int i=0;i<vet.length;i++){
            mat[i][i]=vet[i];
        }
    }

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = Costruisce this a partire da una Matrice m data
        Viene Sollevata un eccezione di tipo NullPointerException se m è un riferimento a null
     */
    public MatriceDensa(final Matrice m){
        if (m==null) throw new NullPointerException("m non può essere un riferimento a null");
        mat= new int[m.dim()][m.dim()];
        for (int i = 0; i < dim(); i++) for (int j = 0; j < dim(); j++) mat[i][j] = m.val(i, j);
    }

    //METODI

    @Override
    public int dim() {
        return mat.length;
    }

    @Override
    public int val(int i, int j) {
        if (i<0 || i > mat.length-1 || j<0 || j > mat.length-1) throw new IndexOutOfBoundsException("indici out of range");
        return mat[i][j];
    }

    @Override
    public Matrice per(int alpha) {
        //if alpha == 0 matriceNulla
        MatriceDensa nuova = new MatriceDensa(mat.length);
        for (int i=0;i<nuova.dim();i++){
            for (int j=0;j<nuova.dim();j++){
                nuova.mat[i][j]=mat[i][j]*alpha;
            }
        }
        return nuova;
    }

    @Override
    public Matrice perM(Matrice m) {
        if(m == null) throw new NullPointerException("m è un riferimento a null");
        if(!(this.conformi(m))) throw new IllegalArgumentException("this e m non sono conformi");

        if (m instanceof MatriceNulla) return new MatriceNulla(this.dim());
        if (m instanceof MatriceIdentita) return m;

        final MatriceDensa C = new MatriceDensa(dim());
        for (int i = 0; i < dim(); i++)
            for (int j = 0; j < dim(); j++)
                for (int k = 0; k < dim(); k++) C.mat[i][j] += mat[i][k] * m.val(k, j);
        return C;
    }

    @Override
    public Vettore perV(Vettore v) {
        if (v==null) throw new NullPointerException("v non può essere un riferimento a null");
        if (!(conformi(v))) throw new IllegalArgumentException("this e v non sono conformi");

        if (v instanceof VettoreNullo) return v;

        final int[] ris = new int[mat.length];

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
                ris[i]+=mat[i][j]*v.val(j);
            }
        }

        return new VettoreDenso(ris);
    }

    @Override
    public Matrice piu(Matrice m) {
        if (m == null) throw new NullPointerException("m non può essere un riferimento a null");
        if (!((this.conformi(m)))) throw new IllegalArgumentException("this e m non conformi");
        if (m instanceof MatriceNulla) return m;

        MatriceDensa ris = new MatriceDensa(m.dim());
        for (int i=0; i<ris.dim();i++){
            for (int j=0;j<ris.dim();j++){
                ris.mat[i][j] = this.mat[i][j]+m.val(i,j);
            }
        }
        return ris;
    }
}
