/*
    OVERVIEW :
        -   Le Istanze di questa classe rappresentanto un corpo celeste caratterizzato da un nome e una posizione
        -   Le istanze di questa classe sono mutabili
 */
public abstract class CorpoCeleste implements Comparable<CorpoCeleste> {
    private final String nome;
    private Punto posizione;

    /*
        AF = Le istanze di questa classe rappresentanto un corpo celeste Nome,Posizione
        IR = Ir pe posizione deve essere soddisfatto
             posizione != null && nome != null && nome != ""
     */

    /*
        REQUIRES =  -
        MODIFYS = this
        EFFECTS = costruisce e istanzia this a un nuovo corpo celeste caratterizzato da un nome e una posizione.
        Viene sollevata una eccezione di tipo NullPointerException se nome è un riferimento a null.
        Viene sollevata una eccezione di tipo NullPointerException se posizione è un riferimento a null.
     */
    public CorpoCeleste(String nome, Punto posizione){
        if (nome==null || nome.equals("")) throw new NullPointerException("nome non può essere un riferimento a null");
        if (posizione==null) throw new NullPointerException("nome non può essere un riferimento a null");
        this.nome=nome;
        this.posizione=posizione;
    }

    /*
        REQUIRES = -
        MODIFYS = -
        EFFECTS = Ritorna una stringa rappresentante il nome di un corpo celeste
     */
    public String getNome() {
        return nome;
    }

    /*
        REQUIRES = -
        MODIFYS = -
        EFFECTS = Ritorna un Punto rappresentante la posizione di un CorpoCeleste
     */
    public Punto getPosizione() {
        return posizione;
    }

    /*
        REQUIRES = -
        MODIFYS = -
        EFFECTS = Ritorna un intero rappresentatante l'energia di un corpo celeste
     */
    abstract int calcolaEnergia();

    /*
      REQUIRES = -
      MODIFY = this
      EFFECTS = modifica this.posizione assegnandoli il nuovo punto p
      viene lanciata un eccezione di NullPointerException se p è un riferimento a null
   */
    public void setPosizione(Punto p){
        if (p==null) throw new NullPointerException("p non può essere un riferimento a null");
        this.posizione=p;
    }

    @Override
    public String toString() {
        return "nome: "+nome+", pos: "+posizione.toString();
    }

    @Override
    public int compareTo(CorpoCeleste o) {
        return o.getNome().compareTo(this.getNome());
    }
}
