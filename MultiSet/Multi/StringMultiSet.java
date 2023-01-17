package MultiSet.Multi;

interface StringMultiSet extends Iterable<String> {
    /*
     * REQUIRES = -
     * MODIFY = this 
     * EFFECTS = aggiunge s a questo multiSet e ne restituisce la cardinalità dopo il sio inserimento 
     * Se s è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
     * Se s è una stringa vuota viene sollevata un eccezione di tipo IllegalArgumentException
     */
    int add(String s) throws NullPointerException,IllegalArgumentException;

    /*
     * REQUIRES = -
     * MODIFY = this 
     * EFFECTS = rimuove un l'elemento s da questo multiSet.Viene restituito un intero rappresentante la molteciplità di s prima della sua rimozione
     * Se s è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
     * Se s è una stringa vuota viene sollevata un eccezione di tipo IllegalArgumentException
     */
    int remove(String s) throws NullPointerException,IllegalArgumentException;

    /*
     * REQUIRES = -
     * MODIFY  = -
     * EFFECTS = ritorna ture se s è presente in questo MultiSet, altrimenti false 
     * Se s è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
     */
    boolean contains(String s) ;

    /*
     * REQUIRES = -
     * MODFIY = -
     * EFFECTS = restituisce un intero rappresentante la molteplicità di s in questo multiSet. Se s non è presente 
     * in questo multiSet, verrà restituito 0.
     * Se s è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
     * Se s è una stringa vuota viene sollevata un eccezione di tipo IllegalArgumentException
     */
    int multiplicity(String s) throws NullPointerException,IllegalArgumentException;

    /*
     * REQUIRES = -
     * MODIFY = -
     * EFFECTS = restituisce un intero rappresentante la  cardinalità(somma delle molteciplità dei suoi elementi) di questo multiSet. 
     * Se il multiset è vuoto restituisce 0
     */
    int size();

    /*
     * REQUIRES = -
     * MODIFY = - 
     * EFFECTS = restitusice un nuovo multiSet costruito dall'unione di this e o.
     * Se o è un riferimento a null viene sollevata un eccezione di tipo NullPointerException 
     */
    StringMultiSet union(StringMultiSet o) throws NullPointerException;

    /*
     * REQUIRES = -
     * MODIFY = - 
     * EFFECTS = restitusice un nuovo multiSet costruito dall'intersezione di this e o.
     * Se o è un riferimento a null viene sollevata un eccezione di tipo NullPointerException 
     */
    StringMultiSet intersection(StringMultiSet o);
  }