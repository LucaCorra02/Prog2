package boolVect;

import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;
import java.util.List;

/*
 * OVERVIEW := 
 *    Le istanze di questa classe rappresentano un Boolvect denso
 *    Le istanze di questa classe sono mutabili
 */
public class IntBoolVectDenso extends BoolVectAbs {

    private final List<Boolean> vect;
    private final int taglia = Integer.SIZE;

    /*
     * AF(vect)= l'i-esimo elemento di vect rappresenta l'i-esimo valore boolenao di un vettore booleano.
     * IR = vect != null 
     */


     /*
      * REQUIRES = -
        MODIFY = this
        EFFECTS = costruisce un bollvect a partire da una stringa.
        La stringa può contenere un carattere qualsiasi, l'i-esimo elemento del vettore corrisponderà al valore booleano dell'i-esimo elemento della 
        stringa partend da destra.

        Viene sollevata un eccezione di tipo NullPointerException se str è un riferimento a null
        Viene sollevata un eccezione di tipo IllegalArgumentException se str ha una lunghezza < 1 or lunghezza di str > taglia.
      */
    public IntBoolVectDenso(String str){
        if (str==null) throw new NullPointerException("str non può essere un riferimento a null");
        if (str.length()< 1 || str.length() > taglia) throw new IllegalArgumentException("la taglia deve essere alemeno 1");

        final int len = str.length();
        vect = new ArrayList<>(len);
    
        for (int i = 0 ;i<len; i++){
            vect.add(str.charAt(len-i-1)=='V');
        }
    }
    
    @Override
    public int dimensione() {
        for (int i = vect.size()-1 ;i>=0; i--){
            if (vect.get(i)) return i+1;
        }
        return 0;
    }

    @Override
    public int taglia() {
        return taglia;
    }

    @Override
    public boolean leggi(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= taglia()) throw new IndexOutOfBoundsException("i negativo");
        if (i > dimensione()-1) return false;
        return vect.get(i);
    }

    @Override
    public void scrivi(int i, boolean val) throws IndexOutOfBoundsException {
        if (i < 0 || i >= taglia )throw new IndexOutOfBoundsException("i non è un indice valido");
        vect.set(i, val);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}