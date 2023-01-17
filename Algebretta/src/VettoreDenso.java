import javax.print.DocFlavor;

/*
    OVERVIEW :
        -   Le istanze di questa classe rappresentanto un VettoreDenso contenete solo membri interi.
        -   Le istanze di questa classe sono immutabili.
        -   Un vettoreDenso ha sempre una dimensione >= 1.
 */
public class VettoreDenso implements Vettore {

    private final int[] vet;

    /*
        AF = l'i-esimo valore del vettore corrisponde all'i-esimo valore di vet.

        IR = vet != null
             la dimensione di vet deve essere almeno 1
             Ogni elemento contenuto in vet deve essere un intero.
     */

    //COSTRUTTORI :
    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = costruisce this istanziandolo a un Vettore di dimensione data, dove tutti i membri sono 0.
        Viene sollevata un eccezione di tipo IllegalArgumentException se dim è <= 0
     */
    private VettoreDenso(final int dim){
        if (dim<=0) throw new IllegalArgumentException("dim <=0");
        vet=new int[dim];
    }

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = costruisce this istanziandolo ad un VettoreDenso dove l'i-esima posizione di this corrisponde
        all'i-esima posizione di vet.
        Viene sollevata un eccezione di tipo NullPointerException se vet è un riferimento a null
        Viene sollevata un eccezione di tipo IllegalArgumentException se la dimensione di vet è < 1
     */
    public VettoreDenso(final int[] vet){
        if (vet==null) throw new NullPointerException("vet non può essere un riferimento a null");
        if (vet.length<1) throw new IllegalArgumentException("vet deve contenere almento un elemento");
        this.vet = vet.clone();
    }

    //METODI
    @Override
    public int dim() {
        return vet.length;
    }

    @Override
    public int val(final int i) {
        if (i<0 || i > vet.length-1) throw new IllegalArgumentException();
        return vet[i];
    }

    @Override
    public Vettore per(final int alpha) {
        if (alpha==0) return new VettoreDenso(this.dim());
        VettoreDenso val = new VettoreDenso(this.dim());
        for (int i=0;i<this.dim();i++){
            val.vet[i] = vet[i]*alpha;
        }
        return val;
    }

    @Override
    public Vettore più(Vettore v) {
        if (v==null)throw new NullPointerException("v non può essere un riferimento a null");
        if (!this.conformi(v)) throw new IllegalArgumentException("v non conforme a this");

        VettoreDenso tmp = new VettoreDenso(this.dim());
        for (int i=0;i<tmp.dim();i++){
            tmp.vet[i]= this.vet[i] + v.val(i);
        }
        return tmp;
    }

    @Override
    public boolean conformi(final Vettore v) {
        if (v==null) throw new NullPointerException("v non può essere un riferimento a null");
        return Vettore.super.conformi(v);
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("(");
        int i;
        for (i=0;i<vet.length-1;i++){
            str.append(vet[i]+", ");
        }
        str.append(vet[i]+")");
        return str.toString();
    }
}
