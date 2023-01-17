import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
    OVERVIEW :
        -   Le istanze di questa classe rappresentanto l'inventario di una bancarella
        -   Le istanze di questa classe sono mutabili
 */
public class Inventario implements Iterable<Giocattolo> {

    private final HashMap<Giocattolo,Integer> inventario;

    /*
        AF(Inventario) = rappresenta l'inventario di una bancarella.
        l'inventario vuoto è rappresentato da []

        IR = Inventario != null
             Le chiavi di inventario devono essere != null
             i valori associati alle chiavi devono essere positivi.
     */

    //COSTRUTTORI

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = istanzia this ad un inventario vuoto.
     */
    public Inventario(){
        inventario = new HashMap<>();
    }

    /*
       REQUIRES = -
       MODIFY = this
       EFFECTS = istanzia this ad un inventario copiato
    */
    public Inventario(Inventario inv){
        inventario = inv.inventario;
    }

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = modifica this aggiungendo un giocattolo nuovo con la rispettiva quantità all'inventario. This = {g1:q1,..,gn:qn} this_Post = {g1:q1,g2:q2,..,gn:qn}
        Se il giocattolo è gia presente, viene aggiornata la quantità nell'inventario.This = {g1:q1,..,gn:qn} this_Post = {g1:q1+nuova q}
        Viene sollevata un eccezione di tipo NullPointerException se g è un riferimento a null
        Viene sollevata un eccezione di tipo IlligalArgumentException se quantità è <= 0.
     */
    public void aggiungiGiocattolo(final Giocattolo g, final Integer quantita){
        if (g==null) throw new NullPointerException("g non può essere un riferimento a null");
        if (quantita<=0) throw new IllegalArgumentException("quantià deve essere >=0");

        if (inventario.containsKey(g)) inventario.replace(g, inventario.get(g)+quantita);
        else inventario.put(g, quantita);

    }

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = modifica this togliendo alla quantità del giocattolo indicato la quantità passata.
        Se la quantità di un giocattolo dopo la modifica è == 0 viene rimosso dall'invetario.
        Se la quantità del giocattolo che si vuole togliere eccede la quantità attuale viene Sollevata un eccezione di tipo IllegalArgumentException
        Se il giocattolo non è presente nell'inventatio viene sollevata un eccezzione di tipo NoScuchElementException

        Viene sollevata un eccezione di tipo NullPointerException se g è un riferimento a null
        Viene sollevata un eccezione di tipo IlligalArgumentException se quantità è >= 0.
     */
    public void rimuoviGiocattolo(final Giocattolo giocattolo, final Integer quantita){
        if (giocattolo==null) throw new NullPointerException("giocattolo non può essere un riferimento a null");
        if (quantita >= 0) throw new IllegalArgumentException("quantità non negativa");

        if (!(inventario.containsKey(giocattolo))) throw new NoSuchElementException("il giocatolo passato non è presente nell'invenatario");

        int q = inventario.get(giocattolo) + quantita;
        if ( q < 0 ) throw new IllegalArgumentException("quantià di giocattolo non disponibile");

        if (q == 0) inventario.remove(giocattolo);
        inventario.replace(giocattolo,q);
    }

    /*
       REQUIRES = -
       MODIFY = -
       EFFECTS = Ritorna un intero rappresentante la quantità di g in questo inventario.
       Se un Giocattolo non è presente in this viene ritornato 0.
       Viene sollevata un eccezione di tipo NullPointerException se g è un riferimento a null.
     */

    public int quantita (final Giocattolo g){
        if (g==null) throw new NullPointerException("g è un riferimento a null");

        if (!(inventario.containsKey(g))) return 0;
        return inventario.get(g);
    }

    /*
        REQUIRES = this non deve essere modificato mentre il generatore è in uso.
        MODIFY = -
        EFFECTS = Ritorna un generatore che produce i gioccatoli prenseti in questo inventario in un ordine arbitrario.
     */
    public Iterator<Giocattolo> iterator() {



        return new Iterator<Giocattolo>() {
            private final ArrayList <Giocattolo> copia = new ArrayList<>(inventario.keySet());
            private int cont = 0;

            @Override
            public Giocattolo next() {
                if (!hasNext()) throw new NoSuchElementException();
                Giocattolo g = copia.get(cont);
                cont++;
                return g;
            }

            @Override
            public boolean hasNext() {
                return cont < copia.size();
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Giocattolo g:this) {
            if (quantita(g) != 0) str.append("num. " + quantita(g) + " " + g.toString() + "\n");
        }
        return str.toString();
    }
}
