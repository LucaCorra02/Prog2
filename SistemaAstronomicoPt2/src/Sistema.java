import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    OVERVIEW :
        -   Le istanze di questa classe rappresentanto un sistema astronomico, ovvero una collezione di corpi celesti.
        -   Le istanze di questa classe sono mutabili
        -   Una tipica istanza di quetsa classe è Sistema:{x1,...xn} dove i=1,...n xi è un corpo celeste
 */
public class Sistema {

    private final List<CorpoCeleste> sistema ;
    private int stato;

    /*
        AF = to string
             un sistema vuoto (senza alcun corpo celeste) è rappresentanto da []
        IR = sistema != null
             tutti gli elementi di sistema devono essere dei corpi celesti o delle sue istanze.

     */

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = istanzia this ad un nuovo sistema
     */
    public Sistema() {
        sistema=new ArrayList<>();
        stato=0;
    }

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = aggiunge un nuovo coropoCeleste a this
        Viene sollevata un eccezione di tipo NullPointerException se c è un riferimento a null.
     */
    public void addC(CorpoCeleste c){
        if (c == null) throw new NullPointerException("c non può essere un riferimento a null");
        sistema.add(c);
    }

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = Modifica l'attrazione gravitazionale dei pianeti in this per un numero di round pari ad n.
        Viene sollevata un eccezione di tipo IllegalArgumentException se n <=0.
     */
    public void attrazioneGravitazionale(int n){
        if (n<=0) throw new IllegalArgumentException("n non può essere <=0");
        int cont=0;
        while (stato < n) {
            for (CorpoCeleste c : sistema) {
                if (c instanceof Pianeta){
                    Pianeta tmp = (Pianeta) c;
                    for (int i = 0; i < cont; i++) {
                            modificaVelocita(tmp,sistema.get(i));
                    }
                    for (int i = cont +1; i < sistema.size(); i++) {
                            modificaVelocita(tmp,sistema.get(i));
                    }
                }
                cont++;
            }
            cont=0;
            stato++;
            aggiornaPosizioni();
        }

    }

    /*
        REQUIRES = -
        MODIFIES = this
        EFFECTS = modifica le posizioni dei pianeti in this assegnandoli un nuovo punto corrispondente al somma
        tra la posizione di un pianeta e la velocità di un pianeta.
     */
    private void aggiornaPosizioni(){
        for (CorpoCeleste c: sistema) {
            if (c instanceof Pianeta){
                Pianeta p = (Pianeta) c;
                p.setPosizione(p.getPosizione().somma(p.getVelocita()));
            }
        }
    }

    /*
        REQUIRES = -
        MODIFIES = Pianeta P
        EFFECTS = modifica la velocità del pianeta P assegnandoli un nuovo punto corrispondente al confronto
        tra coordinate con p e c.
        Viene lanciata un eccezione di NullPointerException se p o c sono dei riferimenti a null
     */
    private void modificaVelocita(Pianeta p, CorpoCeleste c){
        if (p==null || c ==null) throw new NullPointerException();
        int x=0,y=0,z=0;
        if (p.getPosizione().getX() < c.getPosizione().getX()){
            x=1;
        }else {
            if (p.getPosizione().getX() > c.getPosizione().getX()){
                x=-1;
            }
        }
        if (p.getPosizione().getY() < c.getPosizione().getY()){
            y=1;
        }else{
            if (p.getPosizione().getY() > c.getPosizione().getY()){
                y=-1;
            }
        }
        if (p.getPosizione().getZ() < c.getPosizione().getZ()){
            z=1;
        }else{
            if (p.getPosizione().getZ() > c.getPosizione().getZ()){
                z=-1;
            }
        }
        p.setVelocita(p.getVelocita().somma(new Punto(x,y,z)));
    }

    /*
        REQUIRES = -
        MODIFYS = this
        EFFECTS = modifica this, ordidando i suoi elementi(corpi celesti) in ordine alfabetico per nome
     */
    public void ordineAlfabetico(){
        Collections.sort(sistema, new Comparator<CorpoCeleste>() {
            public int compare(CorpoCeleste v1, CorpoCeleste v2) {
                return v1.getNome().compareTo(v2.getNome());
            }
        });
    }

    /*
        REQUIRES = -
        MODIFYS = -
        EFFECTS = ritorna un intero rappresentante la somma di tutte le energie dei corpi celesti in this.
     */
        public int energiaTot(){
            int sum=0;
            for (CorpoCeleste c: sistema) {
                sum+=c.calcolaEnergia();
            }
            return sum;
        }

    @Override
    public String toString() {
        StringBuilder str =new StringBuilder();
        for (CorpoCeleste c: sistema) {
            if (c instanceof Pianeta){
                Pianeta tmp = (Pianeta) c;
                str.append(tmp);
            }else{
                Stella tmp = (Stella) c;
                str.append(c);
            }
            str.append("\n");
        }
        return str.toString();
    }
}
