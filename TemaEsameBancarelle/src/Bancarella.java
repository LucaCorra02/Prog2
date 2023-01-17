import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
    OVERVIEW :
        -   LE Istanze di questa classe rappresentano una bancarella di giocattoli
        -   Le istande di questa classe sono mutabili
 */
public class Bancarella implements Iterable<Giocattolo> {

    private final Inventario inventario;
    private final Listino listino;
    private final String proprietario;

    /*
        AF(listino,bancarella) = rappresentano una bancherella di giocattoli con un proprio proprietario.

        IR = inventario != null && listino != null.
             proprietario diverso da stringa vuota.
             il listino conosce il prezzo di ogni giocattolo presente nell'inventario.
     */

    /*
        REQUIRES =
        MODIFY = this
        EFFECTS = Costruisce e istanzia this a una nuova bancarella.
        Viene sollevata un eccezione di tipo NullPointerException se inventario == null or listino == null or proprietario == null
        Viene sollevata un eccezione di tipo IllegalArgumentException se proprietario è una stringa vuota.
        Viene sollevata un eccezione di tipo IllegalArgumentException se l'inventario non conosce il prezzo di un oggetto nel listino
     */
    public Bancarella(final Inventario inventario, final Listino listino, final String proprietario){
        if (inventario==null || listino==null || proprietario==null) throw new NullPointerException();
        if (proprietario.isEmpty()) throw new IllegalArgumentException();

        for (Giocattolo g : inventario){
            if (!listino.conosce(g)) throw new IllegalArgumentException();
        }
        this.proprietario= proprietario;
        this.listino = listino;
        this.inventario= new Inventario(inventario);
    }

    /*
        REQUIRES = -
        MODIFY = inventario
        EFFECTS = modifica l'invantario di this togliendo la quantià al giocattolo g
        Se la quantità del giocattolo che si vuole togliere eccede la quantità attuale viene Sollevata un eccezione di tipo IllegalArgumentException
        Se il giocattolo non è presente nell'inventatio viene sollevata un eccezzione di tipo NoScuchElementException

        Viene sollevata un eccezione di tipo NullPointerException se g è un riferimento a null
        Viene sollevata un eccezione di tipo IlligalArgumentException se quantità è >= 0.
     */
    public void vendi( final Giocattolo g, final Integer quantita){
        inventario.rimuoviGiocattolo(g,quantita);
    }


    /*
        REQUIRES = -
        MODIFY = -
        EFFECTS = restituisce un intero rappresentante la quantità del gioccatolo G disponibile in this
        Viene sollevata un eccezione di tipo NullPointerException se g è un riferimento a null
     */
    public int quantita(final Giocattolo g){
         return inventario.quantita(g);
    }

    /*
        REQUIRES = -
        MODIFY = -
        EFFECTS = ritorna un intero rappresentante il prezzo complessivo di un giocattolo.
        Viene lanciatà un eccezione di tipo NullPointerException se G è un riferimento a null
        Viene sollevata un eccezione di tipo NoSuchElement exception g non è noto al listino della bancarella.
     */
    public int Prezzo(final Giocattolo g, final int quantita){
        return listino.prezzoComplessivo(g,quantita);
    }


    /*
        REQUIRES = -
        MODIFY = -
        EFFECTS = ritorna una stringa rappresentante il nome del proprietario di questa bancarella.
     */
    public String getProprietario(){ return proprietario;}


    @Override
    public Iterator<Giocattolo> iterator() {
        return inventario.iterator();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Bancarella di: ");
        str.append(this.proprietario+"\n");
        for (Giocattolo g: inventario)
            str.append("num. "+inventario.quantita(g)+" "+g.toString()+", prezzo: "+listino.prezzoComplessivo(g,1)+"\n");

        return str.toString();
    }
}
