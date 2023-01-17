package MultiSet.Multi;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/*
 *  OVERVIEW :
 *      -   Classe che rappresenta dei multiSet
 *      -   Le istanze di questa classe sono mutabili
 */
public class MapStringMultiSet extends AbsStringMultiSet {

    private final Map<String,Integer> val ;

    /*
     * AF(val) = rappresenta un multiSet dove ogni chiave di val rappresenta un elemento in MultiSet, 
     * mentre ogni valore associato a una chiave rappresenta la molteciplità di quel elemento nel MultiSet
     * IR() = val != null
     *        val non deve avere chiavi != null e non vuote
     *        val deve contenere valori != null e > 0 
     */

    /*
     * REQUIRES = -
     * MODIFY = this 
     * EFFECTS = costruisce un multiset vuoto
     */
    public MapStringMultiSet(){
        val = new HashMap<>();
    }

    @Override
    public int add(String s) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(s,"s non può essere un riferimento a null");
        if (s.isEmpty()) throw new IllegalArgumentException("s non può essere vuoto");

        if (val.containsKey(s)) val.put(s, val.get(s)+1);
        else val.put(s, 1);
        return multiplicity(s);
    }

    @Override
    public int remove(String s) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(s,"s non può essere un riferimento a null");
        if (s.isEmpty()) throw new IllegalArgumentException("s non può essere vuoto");
        int ris = 0;
        if (val.containsKey(s)) ris = val.get(s);
        val.remove(s);
        return ris;
    }

    @Override
    public boolean contains(String s)  {
        return val.containsKey(s);
    }

    @Override
    public int multiplicity(String s) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(s,"s non può essere un riferimento a null");
        if (s.isEmpty()) throw new IllegalArgumentException("s non può essere vuoto");
        if (contains(s)) return val.get(s);
        return 0;
    }

    @Override
    public int size() {
        Collection<Integer> tmp = val.values();
        int sum = 0;
        for (Integer value : tmp){
            sum+= value;
        }
        return sum;
    }

    @Override
    public StringMultiSet union(StringMultiSet o) throws NullPointerException {
        Objects.requireNonNull(o,"o non può esser un riferimento a null");
        MapStringMultiSet ris = new MapStringMultiSet();
        for(String s : val.keySet()) ris.val.put(s,Math.max(val.get(s),o.multiplicity(s)));
        
        for(String s : o)
            if (!val.containsKey(s)) ris.val.put(s, o.multiplicity(s));

        return ris;
    }

    @Override
    public StringMultiSet intersection(StringMultiSet o) {
        Objects.requireNonNull(o,"o non può esser un riferimento a null");
        MapStringMultiSet ris = new MapStringMultiSet();

        for (String s : val.keySet())
            if(o.contains(s)) ris.val.put(s, Math.min(multiplicity(s), o.multiplicity(s)));
    
        return ris;
    }

    @Override
    public Iterator<String> iterator() {
       return Collections.unmodifiableSet(val.keySet()).iterator();
    }

    
}
