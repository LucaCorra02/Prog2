//Contratto che stabilisce la rappresentazione di un listino prezzi
public interface Listino {

    /*
        REQUIRES = -
        MODIFY = -
        EFFECTS = ritorna un intero rappresentante il prezzo complessivo di un giocattolo.
        Viene lanciatà un eccezione di tipo NullPointerException se G è un riferimento a null
        Viene sollevata un eccezione di tipo IllegalArgumentException se quantità <= 0
        Viene sollevata un eccezione di tipo NoSuchElement exception se this non conosce g.
     */
    int prezzoComplessivo(Giocattolo g, Integer numero);

     /*
        REQUIRES = -
        MODIFY = -
        EFFECTS = ritorna true se g è presente in this, altrimenti restituisce false
        Viene lanciatà un eccezione di tipo NullPointerException se G è un riferimento a null
     */
    boolean conosce(final Giocattolo g);
}
