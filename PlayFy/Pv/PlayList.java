package Pv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

import Pv.Album.Brano;

/*
 * OVERVIEW :
 * -    Le istanze di questa classe rappresentano una plylist di brani 
 * -    Le istanze di questa classe sono mutabiliù
 */
public class PlayList implements Iterable<Album.Brano>{

    private final String nome;
    private final List<Album.Brano> playlist = new ArrayList<>();

    /*
     * AF(playlist) = rappresenta un aplylist composta da più brani
     * IR() = playlist != null
     *        ogni brano presente in playlist deve essere != null 
     *        nome != null && nome != da stringa vuota
     */


     /*
      * REQUIRES = -
      MODIFY = this
      EFFECTS = costruisce una playlist a partire da suo nome 
      se nome è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
      se nome è una stringa vuota viene sollevata un eccezione di tipo IllegalArgumentException
      */
    public PlayList(final String nome){
        Objects.requireNonNull(nome,"nome == null");
        if (nome.isEmpty()) throw new IllegalArgumentException("nome deve essere != da stringa vuota");
        this.nome = nome;
    }

    /*
     * REQUIRES = -
     * MODIFY = this
     * EFFECTS = aggiunge b a questa playlist
     * se b è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
     */
    public void addBrano(final Album.Brano b){
        Objects.requireNonNull(b,"b non può essere null");
        if (!(playlist.contains(b))){
            playlist.add(b);
        }
    }

    /*
     * REQUIRES = -
     * MODIFY = this
     * EFFECTS = rimuove b da questa playlist se presnete 
     * se b è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
     * se la questa playlist è vuota viene sollevata un eccezione di tipo OutOfBoundException
     */
    public void rimuoviBrano(final Album.Brano b){
        Objects.requireNonNull(b,"b non può essere null");
        if (playlist.isEmpty()) throw new IndexOutOfBoundsException("la playlist è vuota");
        if (playlist.contains(b)){
            playlist.remove(b);
        }
    }

    @Override
    public Iterator<Brano> iterator() {
        return Collections.unmodifiableCollection(playlist).iterator();
    }
    
    /*
     * REQUIRES = -
     * MODIFY = -
     * EFFECTS = restituisce true se b è presente in questo album, altrimenti false
     * Se b è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
     */
    public boolean contains(final Album.Brano b){
        Objects.requireNonNull(b,"b non può essere null");
        return playlist.contains(b);
    }


     /*
     * REQUIRES = -
     * MODIFY = -
     * EFFECTS = restituisce un brano corrsispondente al brano nell'i-esima posizione di questa playlist
     * se i è <=0 ||i > dimensione playlist viene sollevata un eccezione di IndexOutofBuondException
     */
    public Album.Brano getBrano(final int i){
        if(i<=0 || i > playlist.size()) throw new IndexOutOfBoundsException("i fuori dal numero di canzoni di playlist");
        return playlist.get(i);
    }

    /*
     * REQUIRES = -
     * MODIFY = -
     * EFFECTS = ritorna una durata rappresentante la durata complessiva di tutti i brani di questa playlist
     */
    public Durata durataComplessiva(){
        int somma = 0;
        for (Album.Brano tmp : playlist){
            somma += tmp.getDurata().getSecondi();
        }
        return new Durata(somma);
    }
    

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Nome playlist: "+nome+"\n");
        int cont = 1;
        for (Album.Brano tmp : playlist){
            str.append(cont+" - "+tmp.toString()+", (da "+tmp.albumDiprovenienza()+")"+"\n");
            cont++;
        }
        str.append("Durata totale: "+durataComplessiva().toString());
        return str.toString();
    }

    /*
     * REQUIRES = -
     * MODIFY = -
     * EFFECTS = restituisce una lista di brani contenuti in questa playlist dove il nome del loro album di appartenenza è ugaule a nomeAlbum
     * Se non ci sono brani in questa playlist provenienti da nomeAlbum viene restituito una lista vuota, se questa playlist è vuota restituisce null
     * viene sollevata un eccezione di tipo NullPointerException se nomeAlbum è un riferimento a null
     * viene sollevata un eccezione di tipo IllegalArgumentException se nomeAlbum è una stringa vuota
     */
    public List<Album.Brano> braniConAlbum(final String nomeAlbum){
        Objects.requireNonNull(nomeAlbum,"nomeAlbum non può essere un riferimento a null");
        if (nomeAlbum.isEmpty()) throw new IllegalArgumentException("la stringa non può essere vuota");
        if (playlist.isEmpty()) return null;

        final List<Album.Brano> tmp = new ArrayList<>();
       
        for (final Album.Brano b : playlist){
            if(b.albumDiprovenienza().equals(nomeAlbum)) tmp.add(b);
        }
        return List.copyOf(tmp);
    }

    /*
     * REQUIRES = -
     * MODIFY = -
     * EFFECTS = restituisce un set contenente fgli album di provenienza dei brani di questa playlist.
     * se la playlist è vuota restituisce null
     */
    public Set<String> albumPlaylist() {
        final Set<String> tmp = new HashSet<>();
        if (playlist.isEmpty()) return null;

        for (final Album.Brano b : playlist)
            tmp.add(b.albumDiprovenienza());
        return Set.copyOf(tmp);
    }

    /*
     * REQUIRES = -
     * MODIFY = -
     * EFFECTS = restituisce una nuova PlayList con titolo nome, ottenuta fondendo questa playList con pl (non contiene copie di brani)
     * vengono prima messi in ordine i brani di questa playlist e successivamente quelli di pl
     * Se pl è un riferimento a null viene sollevata un eccezione di tipo NullPointerException 
     * Se pl è un rifeirmeno a null viene sollevata un eccezione di tipo NUllPointerException
     * Se pl è vuota viene sollevata un eccezione di tipo IllegalArgumentException
     */
    public PlayList fondi(final PlayList pl, final String nome) {
        Objects.requireNonNull(pl,"pl non può essere un riferimento a null");
        Objects.requireNonNull(nome,"nome non può essere un riferimento a null");
        if (nome.isEmpty()) throw new IllegalArgumentException("nome non può essere vuota");
        
        PlayList nuova = new PlayList(nome);
        for (Album.Brano tmp : playlist) nuova.addBrano(tmp);
        for (Album.Brano tmp : pl) nuova.addBrano(tmp);

        return nuova;
    }

    public final Iterator<Album.Brano> brani (Album a){
        Objects.requireNonNull(a,"a non può essere null");
        return new Iterator<Album.Brano>() {

            private final Iterator<Album.Brano> it = a.iterator();
            private Album.Brano next = null;

            @Override
            public boolean hasNext() {
                if (next != null) return true;
                while (it.hasNext()){
                    next = it.next();
                    if (next.albumDiprovenienza().equals(a)) return true;
                }
                next = null;
                return false;
            }

            @Override
            public Brano next() {
                if (!hasNext()) throw new NoSuchElementException();
                final Album.Brano tmp = next ;
                next = null;
                return tmp;
            }

        };
    }

    public final Iterator<Album> brani(){
        return new Iterator<Album>() {
            private final Iterator<Album.Brano> it = iterator();
            private Album next = null;

            private final Set<Album> ris = new HashSet<>();

            @Override
            public boolean hasNext() {
                if(next!=null) return true;
                while(it.hasNext()){
                    Album next = it.next().album();
                    if (ris.add(next)) return true;
                }
                next = null;
                return false;
            }

            @Override
            public Album next() {
                if (!hasNext()) throw new NoSuchElementException();
                final Album tmp = next ;
                next = null;
                return tmp;
            }
            
        };
    }

}
