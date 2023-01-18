import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/*
 * OVERVIEW :
 *      -   Le istanze di questa classe sono mutabili
 */
public class MagazzinoLogistico{

    private final Scaffalatura[] scaffali;
    /*
     * AF(scaffali) = rappresenta un magazzino composto da un certo numero di scaffali
     * IR() = scaffali != null
     *        scaffali non deve essere vuoto len > 0
     *        scaffali non deve contenere riferimenti a null
     */

    /*
     * REQUIRES = -
     * MODIFY = this
     * EFFECTS = costruisce un nuovo magazzino logisitco a partire dal numero di scaffalature che cointiene
       viene sollevata un eccezione di tipo IllegalArgumentException se numeroScaffali <=0
     */
    public MagazzinoLogistico(final int numeroScaffali ){
        if(numeroScaffali<=0) throw new IllegalArgumentException();
        scaffali = new Scaffalatura[numeroScaffali];
        for (int i =0 ; i<numeroScaffali;i++){
            scaffali[i] = new Scaffalatura();
        }
    }

    /*
       scelgo una inner class in quanto le scaffalature non hanno senso al di fuori del loro magazzino 
     * OVERVIEW := 
     *    - le istanze di questa classe sono mutabili
     *   
     */
    private class Scaffalatura implements Iterable<Pacco>{


        private final List<Pacco> scaffale;
        /*
         * af(SCAFFALE) = rappresenta lo scaffale di un maggazino logisitco
         * IR() = scaffale != null
         *        scaffale non deve contenere riferimenti a null
         */
        private Scaffalatura(){
            scaffale = new LinkedList<>();
        }


        /*
         * REQUIRES = -
         * MODIFY = -
         * EFFECTS = restituisce il numero di pacchi in questa scaffalatura
         */
        private int dimScaffalatura(){
            return scaffale.size();
        }

         /*
          * REQUIRES = -
            MODIFY = this
            EFFECTS = aggiunge un pacco p a questa scaffalatura
            se p è un riferimento a null viene sollevata un eccezione di tipo NullPointerException 
          */
        private void aggiungiPacco(final Pacco p){
            Objects.requireNonNull(p,"p non può essere un riferimento a null");
            scaffale.add(p);
        }

        /*
          * REQUIRES = -
            MODIFY = this
            EFFECTS = rimuove il pacco in cima a questa scaffalatura (se non è vuota) e lo restiuisce
        */
        private Pacco remove(){
            if (!(scaffale.isEmpty())){
                return scaffale.remove(0); 
            }
            return null;
        }

        @Override
        public Iterator<Pacco> iterator() {
            final LinkedList<Pacco> tmp = new LinkedList<>();
            tmp.addAll(scaffale);
            Collections.reverse(tmp);
            return Collections.unmodifiableList(tmp).iterator();
        }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            for (Pacco p : this) str.append(p.toString()+"\n");
            return str.toString();
        }
    }

    /*
     * REQUIIRES = -
     * MODIFY = this 
     * EFFECTS = aggiunge in questo magazzino nella scafalatura pos il pacco P 
     * se pos è minore o >= del numero di scaffalature del magazzino viene sollevata un eccezione IndexOutOfBuond
     */
    public void aggiungiAScafalatura(int pos, Pacco p){
        Objects.requireNonNull(p);
        if(pos< 0 || pos >= scaffali.length) throw new IndexOutOfBoundsException("pos non valida");
        scaffali[pos].aggiungiPacco(p);
    }

    /*
     * REQUIIRES = -
     * MODIFY = - 
     * EFFECTS = restituisce la dimensione della scaffalatura i in questo magazzino
     *  se pos è minore o >= del numero di scaffalature del magazzino viene sollevata un eccezione IndexOutOfBuondException
     */
    public int dimScaffaleI(final int i){
        if(i< 0 || i >= scaffali.length) throw new IndexOutOfBoundsException("pos non valida");
        return scaffali[i].dimScaffalatura();
    }

    /*
     * REQUIIRES = -
     * MODIFY = - 
     * EFFECTS = restituisce la dimensione di questo magazzino
     */
    public int dimMagazzino(){
        return scaffali.length;
    }

    /* REQUIIRES = -
     * MODIFY = this 
     * EFFECTS = rimuove in questo magazzino nella scafalatura pos il pacco in cima ad essa
     * se la scafalatura pos è vuota restituisce null
     */
    public Pacco rimuoviCimaScafalatura(int pos){
        if(pos< 0 || pos >= scaffali.length) throw new IllegalArgumentException("pos non valida");
        if (scaffali[pos].dimScaffalatura() > 0){
            return scaffali[pos].remove();
        }
        return null;
    }


    @Override
    public String toString() {
        int max = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0;i<dimMagazzino();i++){
            int tmp = dimScaffaleI(i);
            if (tmp > max) max = tmp;
        }
        for (int i = 0 ; i < dimMagazzino();i++){
            str.append(scaffali[i].toString());
            str.append("------\n");
        }

        //System.out.println(max);
        return str.toString();
    }
}