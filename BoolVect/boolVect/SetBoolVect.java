package boolVect;

import java.util.SortedSet;
import java.util.TreeSet;

/*
 * OVERVIEW :
 * -    Le istanze di questa classe rappresentano un vettore denso di booleani
 * -    Le istanze di questa cllasse sono mutabili
 */
public class SetBoolVect extends BoolVectAbs {

    private final SortedSet<Integer> val = new TreeSet<Integer>() ;
    private final int taglia = Integer.MAX_VALUE;

    /*
     * AF(val) = rappresenta un vettore voleano dove se l'i-esima posizione contiene un vallore booleano true il suo indice è presente in val
     * se size val = 0, rappresenta un vettoreBooleano con solo valori false
     * IR() = val != null e non coentiene null
     */

     /*
      * REQUIRES = -
        MODIFY = this
        EFFECTS = costruisce un bollvect a partire da una stringa.
        La stringa può contenere un carattere qualsiasi, l'i-esimo elemento del vettore corrisponderà al valore booleano dell'i-esimo elemento della 
        stringa partend da destra.

        Viene sollevata un eccezione di tipo NullPointerException se str è un riferimento a null
      */

    /*
     * REQUIRES = 
     * MODIFY = this 
     * EFFECTS = costruisce un boolVect partendo da una stringa 
     * se str è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
     * se str è vuota viene sollevata un eccezione di tipo illegalArgumentException
     */
    public SetBoolVect(final String str ){
        if (str==null) throw new NullPointerException("str non può essere un riferimento a null");
        if (str.length()< 1) throw new IllegalArgumentException("errore sulla taglia");

        final int len = str.length();
        for (int i = 0 ;i< len; i++){
            if (str.charAt(len-i-1)=='V') val.add(i);
        }
    }

    @Override
    public int dimensione() {
        if (val.size() > 0) return val.last()+1;
        return 0;
    }

    @Override
    public boolean leggi(int i) throws IndexOutOfBoundsException {
        if (i<0) throw new IndexOutOfBoundsException();
        return val.contains(i);
    }

    @Override
    public void scrivi(int i, boolean val) throws IndexOutOfBoundsException {
        if (i<0) throw new IndexOutOfBoundsException();
        if (val) this.val.add(i);
        else this.val.remove(i);
    }
    
    @Override
    public int taglia() {
        return taglia;
    }

    @Override
    public void or(BoolVect op) throws NullPointerException {
        if (op == null) throw new NullPointerException();
        if (op instanceof SetBoolVect){
            SetBoolVect tmp = (SetBoolVect) op;
            val.addAll(tmp.val);
        }else{
            super.or(op);
        }
    }

    @Override
    public void and(BoolVect op) throws NullPointerException {
        if (op == null) throw new NullPointerException();
        if (op instanceof SetBoolVect){
            SetBoolVect tmp = (SetBoolVect) op;
            val.retainAll(tmp.val);
        }else{
            super.and(op);
        }
    }

    @Override
    public void xor(BoolVect op) throws NullPointerException {
        if (op == null) throw new NullPointerException();
        if (op instanceof SetBoolVect){
            SetBoolVect tmp = (SetBoolVect) op;
            tmp.val.retainAll(val);
            val.addAll(tmp.val);
            val.retainAll(tmp.val);
        }else{
            super.xor(op);
        }
    }

    
}