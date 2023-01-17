package Pv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/*
 * OVERVIEW :
 *  -   Le istanze di questa classe rappresentanto un album musicale
 *  -   Le istanze di questa classe sono immutabili 
 */
public class Album  implements Iterable<Album.Brano>{

    private  final List<Brano> album;
    private  final String nome;

    /*
     * AF(album) = rappresenta un album musicale composto da brani con titolo nome
     * IR(album) = album != null
     *             album non deve contenere valori vuoti 
     *             album non può essere vuoto
     *             nome != null && nome != da stringa vuota 
     *             brani non contiene duplicati (riferimenti allo stesso oggetto)
     *             brani contiene solo brani corrispondenti ad istanze di questo album
     */

     
    
    /*
     * OVERVIEW :
     *  -   Inner class che rappresenta un brano, composto da durata e nome
     *  -   Le istanze di questa classe sono immutabili
     *  -   le istanze di questa classe sono istanziabili solamente nella classe album 
     */
    public class Brano{
        private final Durata durata;
        private final String nome;

        /*
         * AF(durata,brano) = rappresentano un brano musicale con un nome e una durata 
         * IR() = nome != null && durata != null
         *        nome != stringa vuota 
         */

        /*
         * REQUIRES = -
         * MODIFY = this 
         * EFFECTS = costruisce un brano a partire dal suo nome e dalla sua durata.
         * Se durata o nome sono dei riferimenti a null viene sollevata un eccezione di NullPointerException
         * se nome è un stringa vuota viene sollevata un eccezione di tipo IllegalArgumentException
         */
         private Brano(final Durata durata, final String nome){
            Objects.requireNonNull(durata,"durata non può essere null");
            Objects.requireNonNull(nome,"nome non può essere un riferimento a null");
            if (nome.isEmpty()) throw new IllegalArgumentException("nome non può essere vuoto");
            this.durata= durata;
            this.nome = nome;
        }

        /*
         * REQUIRES = -
         * MODIFY = -
         * EFFECTS = restituisce una stringa rappresentante il nome di questo brano
         */
        public String getNome(){
            return nome;
        }

        public Album album() {
            return Album.this;
        }

        /*
         * REQUIRES = -
         * MODIFY = -
         * EFFECTS = restituisce la durata di questo brano
         */
        public Durata getDurata(){
            return durata;
        }

        /*
         * REQUIRES = -
         * MODIFY = -
         * EFFECTS = restituisce una stringa rappresentante l'album di provenienza di questo brano.
         * 
         */
        public String albumDiprovenienza(){
            return getTiotlo();
        }

        @Override
        public String toString() {
            //"21st Century Schizoid Man" (07:24)
            return nome+" "+durata.toString();
        }
    }

    /*
     * REQUIRES = -
     * MODIFY = this 
     * EFFECTS = costruisce un nuvo album a partire da il suo titolo, la lista dei suoi brani ciascuno con la prorpia durata.
     * Viene solleavata un eccezione di tipo NullPointerExceprion se titolo == null or nomi == null or durate == null
     * Viene sollevata un eccezione di tipo NoSuchElementExceptiom se lunghezza nomi != lunghezza durate or lunghezza nome < && linghezza durate < 1 
     * Viene sollevata un eccezione di tipo IllegalArgumentExceprion se durate o nomi contengono dei riferimenti a null 
     * Viene sollevata un eccezione di tipo IllegalArgumentException se titolo è una stringa vuota 
     * Viene sollevata un eccezione di tipo  se  è una stringa vuota 
     */
    public Album(final String titolo, final List<String> nomi, final List<Durata> durate){
        Objects.requireNonNull(titolo,"titolo non può essere null");
        Objects.requireNonNull(nomi,"nomi non può essere null");
        Objects.requireNonNull(durate,"durate non può essere null");
        if (titolo.isEmpty()) throw new IllegalArgumentException("titolo non può essere nuovo");
        if (nomi.size() != durate.size() || nomi.size() < 1 || durate.size()<1 ) throw new NoSuchElementException("nomi e durate lunghezze sbagliate");
        this.nome = titolo;
        album = new ArrayList<>() ;

        for (int i =0 ; i < nomi.size();i++){
            if (nomi.get(i) == null || durate.get(i) == null) throw new IllegalArgumentException("nomi o durate contengono riferimento a null");
            Brano tmp = new Brano(durate.get(i), nomi.get(i));
            if (album.contains(tmp)) throw new IllegalArgumentException("elementi duplicati");
            album.add(tmp);
        }
    }

    /*
     * REQUIRES = -
     * MODIFY = -
     * EFFECTS = restituisce un brano dell'album con titolo nome. Se non esiste un brano con quel titolo nell'album viene restituito null
     * se nome è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
     * se nome è vuota viene sollevata un eccezione di tipo IllegalArgumentException
     */
    public Brano getBrano(final String nome){
        Objects.requireNonNull("nome non può essere un riferimento a null");
        if (nome.isEmpty()) throw new IllegalArgumentException("nome non può essere vuoto");
        for (Brano tmp : album){
            if (tmp.getNome().equals(nome)){
                return tmp;
            }
        }
        return null;
    }

    /*
     * REQUIRES = -
     * MODIFY = -
     * EFFECTS = restituisce il brano contenuto in i-esima posizione nell'album. 
     * Se i < 0 oppure i > numero canzoni album viene sollevata un eccezione di tipo IndexOutOfBuondException
     */
    public Brano getBarnoPosizione(final int i){
        if(i<=0 || i > album.size()) throw new IndexOutOfBoundsException("i vuori dal numero di canzoni di album");
        return album.get(i-1);
    }
    
    /*
     * REQUIRES = -
     * MODIFY = -
     * EFFECTS = restituisce la posizione di b in questo album.
     * Se b è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
     * Se b non è contenuto in questo album viene sollevata un eccezione di tipo NoSuchElementException
     */
    public int getPosizione(final Brano b){
        Objects.requireNonNull(b,"brano no può essere un riferimento a null");
        int cont = 0;
        for (Brano tmp : album){
            if (tmp.getNome().equals(b.nome)){
                return cont;
            }
            cont++;
        }
        throw new NoSuchElementException("b non è contenuto nell'album");
    }

    /*
     * REQUIRES = -
     * MODIFY = -
     * EFFECTS = ritorna una durata rappresentante la durata complessiva di tutti i brani di questo album
     */
    public Durata durataComplessiva(){
        StringBuilder str = new StringBuilder();
        int somma = 0;
        for (Brano tmp : album){
            somma += tmp.durata.getSecondi();
        }
        return new Durata(somma);
    }

    /*
     * REQUIRES = -
     * MODIFY = -
     * EFFECTS = restituisce una stringa rappresentante il nome di questo album
     */
    public String getTiotlo(){
        return nome;
    }

    @Override
    public Iterator<Brano> iterator() {
        return Collections.unmodifiableCollection(album).iterator();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Titolo album: "+nome+"\n");
        int cont = 1;
        for (Brano tmp : album){
            str.append(cont+" - "+tmp.toString()+"\n");
            cont++;
        }
        str.append("Durata totale: "+durataComplessiva().toString());
        return str.toString();
    }
}
