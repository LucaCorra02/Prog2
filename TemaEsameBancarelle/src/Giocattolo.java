import java.util.Objects;

/*
    OVERVIEW :
        -   Le istanze di questa classe rappresentanto un giocattolo composto da nome e il materiale di cui è fatto
        -   Le istanze di questa classe sono immutabili
 */
public class Giocattolo {

    private final String nome;
    private final String materiale;

    /*
        AF(nome,materiale) = Un giocattolo è rappresentato da un nome e un materiale di cui è fatto

        IR = nome != null && materiale != null
             nome != " "  && materiale != " "
     */

    //COSTRUTTORI

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = istanzia this a un nuovo giocattolo con Nome e Materiale
        Viene sollevata un eccezione di tipo NullPointerException se Nome == null || Materiale == null
        Viene sollevata un eccezione di tipo IllegalArgumentException se Nome è vuoto or Materiale è vuoto
     */
    public Giocattolo(String nome, String materiale){
        if (nome==null || materiale == null) throw new NullPointerException("Nome e Materiale riferimenti a null");
        if (nome.isEmpty() || materiale.isEmpty()) throw new IllegalArgumentException("nome deve essere != ' ' e materiale...");

        this.nome = nome;
        this.materiale = materiale;
    }

    //METODI
     /*
        REQUIRES = -
        MODIFY = -
        EFFECTS = ritorna il nome di questo giocattolo
     */
    public String getNome(){
        return nome;
    }

    /*
        REQUIRES = -
        MODIFY = -
        EFFECTS = ritorna il materiale di questo giocattolo
     */
    public String getMateriale(){
        return materiale;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome,materiale);
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Giocattolo)) return false;
        Giocattolo g = (Giocattolo) obj;
        return nome.equals(g.getNome()) && materiale.equals(g.getMateriale());
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(nome);
        str.append(" di ");
        str.append(materiale);
        return str.toString();
    }
}
