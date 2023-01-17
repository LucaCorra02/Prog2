/*
    OVERVIEW :
        -   Le istanze di questa classe rappresentanto dei Pianteti )
        -   Le istanze di questa classe sono mutabili
        -   Una tipica istanza di questa classe è : Pianeta{nome,Posizione{x,y,z},Velocità{x,y,z}
 */
public class Pianeta extends CorpoCeleste {

    private Punto velocita;

    /*
        AF = to string. Le istanze di questa classe rappresentato un Pianta composto da nome posizione e velocità (entrambe Punti)
        IR = Invariante per corpo celeste soddisfatto
             Velocità deve soddisfarre l'ir di Punto.
             velocità != null
     */

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = istanzia this a un Pianeta
        Viene sollevata un eccezione di tipo NullPointerException se velocita è un riferimento a null
     */
    public Pianeta(String nome, Punto posizione, Punto velocita){
        super(nome,posizione);
        if (velocita==null) throw new NullPointerException("velocita non può essere un riferimento a null");
        this.velocita=velocita;

    }

    /*
        REQUIRES = -
        MODIFY = -
        EFFECTS = ritorna un intero rappresentante L'energia di this. L'energia di un pianetà viene calcolata
        dal prodotto tra L'energia cinetica e L'energia potenziale.
     */
    @Override
    int calcolaEnergia() {
        return velocita.norma()*super.getPosizione().norma();
    }

    /*
        REQUIRES = -
        MODIFY = -
        EFFECTS = Ritorna un punto rappresentante la velocità di this.
     */
    public Punto getVelocita() {
        return velocita;
    }

    //aggiungere setPosizione e setvelocità

    /*
       REQUIRES = -
       MODIFY = this
       EFFECTS = modifica this.velocità assegnandoli il nuovo punto p
       viene lanciata un eccezione di NullPointerException se p è un riferimento a null
    */
    public void setVelocita(Punto p){
        if (p==null) throw new NullPointerException("p non può essere un riferimento a null");
        this.velocita=p;
    }

    @Override
    public String toString() {
        String tmp= super.toString();
        return "Pianeta, "+tmp+", vel: "+velocita.toString();
    }
}
