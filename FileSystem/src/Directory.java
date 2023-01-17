import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
    OVERVIEW :
     -  le istanze di questa classe rappresentano une directory
     -  le istanze di questa classe sono mutabili
 */

public class Directory extends Entry implements Iterable<Entry> {

    private final List<Entry> directory;

    /*
        AF(directory) = rappresenta l'insieme delle entrys che compongono questa directory
        una directory vuota è rappresentata da [].
        IR = directory != null
             ogni entri in directory deve essere != null
             la directory non contiene due entrys con lo stesso nome.
     */

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = Costruisce una nuova directory a partire da un un nome e una lista di Entry
        Se nome è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
        Se nome è vuoto viene sollevata un eccezione di tipo IllegalArgumentException
        Se directory è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
        se directory contiene due directory con lo stesso nome viene sollevata un eccezione di tipo IllegalArgumentException
     */
    public Directory(final String nome, final List<Entry> directory) {
        super(nome);
        if(directory==null) throw new NullPointerException("directory non può essere un riferimento a null");
        for (Entry e : directory)
            if (Collections.frequency(directory,e.getNome())>1) throw new IllegalArgumentException("directory contiene due entry con lo stesso nome");

        this.directory = new ArrayList<>(directory);
    }

    /*
        REQUIRES = -
        MODIFYS = -
        EFFECTS = costruisce una directory vuota
        Se nome è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
        Se nome è vuoto viene sollevata un eccezione di tipo IllegalArgumentException
     */
    public Directory (final String nome){
        super(nome);
        directory=new ArrayList<>();
    }

    /*
    REQUIRES = -
    MODIFYS = -
    EFFECTS = aggiunge una entrys a questa directory
    Se entrys è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
    Se una entrys con lo stesso nome di entry è gia contenuta in this viene sollevata un eccezione di tipo IllegalArgumentException
     */
    public void add (final Entry entry){
        if(entry==null) throw new NullPointerException("entry non può essere un riferimento a null");
        for (Entry e : directory)
            if (contains(e.getNome())!=null) throw new IllegalArgumentException("entry già contenuta in this");

        directory.add(entry);
    }

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = ritora la entry se il nome cercato è contenuto in this, altrimenti ritorna null
        viene sollevata un eccezione di tipo NullPointerException se nome è un riferimento a null
     */
    public Entry contains(final String nome ){
        for (Entry tmp :directory)
            if (tmp.getNome().equals(nome)) return tmp;

        return null;
    }

    @Override
    public int dimensione() {
        int sum = 0;
        for (Entry e:directory) {
            sum += e.dimensione();
        }
        return sum;
    }

    @Override
    public Iterator<Entry> iterator() {
        return Collections.unmodifiableList(directory).iterator();
    }

    @Override
    public String toString() {
        return getNome()+"*";
    }
}
