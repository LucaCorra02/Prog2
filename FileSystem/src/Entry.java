/*
    Classe che rappresenta una entri
 */
public abstract class Entry {

    private final String nome;

    /*
        RI = nome != null
             nome non può essere vuoto
     */

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = costruisce una nuova entry a partire dal suo nome;
        Se nome è un riferimento a null viene sollevata un eccezione di tipo nullPointerException
        se nome è vuoto viene sollevata un eccezione di tipo IllegalArgumentException
     */
    public Entry(String nome){
        if (nome==null) throw new NullPointerException("nome non può essere un riferimento a null");
        if (nome.isEmpty()) throw new IllegalArgumentException("nome non può essere vuoto");
        this.nome = nome;
    }

    /*
        REQUIRES = -
        MODIFY = -
        EFFECTS = restituisce il nome di this.
     */
    public String getNome(){
        return nome;
    }

    /*
       REQUIRES = -
       MODIFY = -
       EFFECTS = restituisce un intero rappresentante la dimensione delle entry
    */
    public abstract  int dimensione();
}
