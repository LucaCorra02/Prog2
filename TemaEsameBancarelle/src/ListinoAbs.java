import java.util.HashMap;
import java.util.IllegalFormatWidthException;
import java.util.NoSuchElementException;

 /*
    Classe astratta immutabile che rappresenta i listini in cui il prezzo di un certo numero di
    giocattoli di un certo tipo dipende dal prezzo unitario di un giocattolo di tale tipo
  */
public abstract class ListinoAbs implements Listino {

    private final HashMap<Giocattolo,Integer> listino;

    /*
        IR = chiavi non nulle e valori positivi
     */

    /*
        REQUIRES = -
        MODIFYS = this
        EFFECTS = costruisce un nuovo listino this contenente le coppie Giocattolo prezzo di li.
        Solleva un eccezione di tipo NullPointerException se li == null.
        Solleva un eccezione di tipo IllegalArgument se li contiene una chiave nulla o se li contiene un valore <=0
     */
    public ListinoAbs(HashMap<Giocattolo,Integer> li ){
        if (li==null) throw new NullPointerException();
        listino = new HashMap<>();
        for (Giocattolo g: li.keySet()) {
            if (g==null || li.get(g)==null ||li.get(g)<=0) throw new IllegalArgumentException();
            listino.put(g,li.get(g));
        }
    }

    /*
        REQUIRES = -
        MODIFY = -
        EFFECTS = restituisce un intero corrispondente al prezzo in questo listino di g.
        Se g non è presente in questo listino viene sollevata un eccezione di tipo NoSuchElementException
        Se g è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
     */
    public int prezzo(final Giocattolo g){
        if (g==null) throw new NullPointerException("g non può essere un riferimento a null");
        if (!listino.containsKey(g)) throw new NoSuchElementException("g non è in questo listino");
        return listino.get(g);
    }

    @Override
    public abstract int prezzoComplessivo(Giocattolo g, Integer numero);

    @Override
    public boolean conosce(Giocattolo g) {return listino.containsKey(g);}

}
