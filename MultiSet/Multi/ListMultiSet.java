package MultiSet.Multi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;


/*
 * OVERVIEW :
 *  -   Le istenze di questa classe sono mutabili
 *  -   Classe concreta per multiSet con liste
 */
public class ListMultiSet extends AbsStringMultiSet{

    private final List<String> elementi ;

    /*
     * AF(elementi) = rappresenta un MultiSet dove l'i-esimo elemento di elementi è l'i-esimo elemento di un MultiSet
     * IR(elementi) = elementi != null
     *                Elementi non deve contenere stringhe vuote o riferimenti a null
     */

    /*
     * REQUIRES = -
     * MODIFY = this
     * EFFECTS = costruisce un nuovo multiSet vuoto
     */
    public ListMultiSet(){
        elementi = new ArrayList<>();
    }

    @Override
    public int add(String s) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(s,"s non può essere un riferimento a null");
        if (s.isEmpty()) throw new IllegalArgumentException("s non può essere una stringa vuota");
        elementi.add(s);
        return multiplicity(s);
    }

    @Override
    public int remove(String s) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(s,"s non può essere un riferimento a null");
        if (s.isEmpty()) throw new IllegalArgumentException("s non può essere una stringa vuota");

        int ris = multiplicity(s);
        if (contains(s)) {
            remove(s);
        }
            return ris;
    }

    @Override
    public boolean contains(String s){
        return elementi.contains(s);
    }

    @Override
    public int multiplicity(String s) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(s,"s non può essere un riferimento a null");
        if (s.isEmpty()) throw new IllegalArgumentException("s non può essere una stringa vuota");
        return Collections.frequency(elementi, s);
    }

    @Override
    public int size() {
        final Iterator<String> ie = iterator();
        int cardinalita = 0;
        while (ie.hasNext()) cardinalita+=multiplicity(ie.next());
        return cardinalita;
    }

    @Override
    public StringMultiSet union(StringMultiSet o) throws NullPointerException {
        Objects.requireNonNull(o,"o non può essere un riferiment a null");
        ListMultiSet ris = new ListMultiSet();
        ris.elementi.addAll(elementi);
        
        for (String elem : o){
            int mul = o.multiplicity(elem) - multiplicity(elem);
            if (mul > 0) ris.elementi.addAll(Collections.nCopies(mul, elem));
        }
    
        return ris;
    }

    @Override
    public StringMultiSet intersection(StringMultiSet o) {
        Objects.requireNonNull(o,"o non può essere un riferiment a null");
        ListMultiSet ris = new ListMultiSet();

        for (String elem : this){
            int min = Math.min(multiplicity(elem), o.multiplicity(elem));
            if (min > 0) ris.elementi.addAll(Collections.nCopies(min, elem));
        }
        return ris;
    }

    @Override
    public Iterator<String> iterator() {

        /*
         * REQUIRES = this non deve essere modificato mentre viene utilizzato l'iteratore
         */
        return new Iterator<>() {
            
            private final Iterator<String> it = elementi.iterator();
            private String next = null;
            private int idx = -1;


            @Override
            public boolean hasNext() {
                if (next != null) return true;
                while (it.hasNext()) {
                    final String candidate = it.next();
                    idx++;
                    if (elementi.indexOf(candidate) == idx) {
                        next = candidate;
                        return true;
                    }
                }
                return false;
            }
      
            @Override
            public String next() {
                if (!hasNext()) throw new NoSuchElementException();
                final String result = next;
                next = null;
                return result;
            }
        };
    }
}

