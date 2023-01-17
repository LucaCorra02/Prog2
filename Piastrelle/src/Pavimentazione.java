import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/*
   OVERVIEW:
    -   Le isatanze di questa classe rappresentano una pavimentazione composta da componenti.
    -   Le istanze di questa classe sono immuatbili

 */
public class Pavimentazione implements Rivestimento, Iterable<Componente> {

    private final Collection<Componente> pavimentazione;

    /*
        AF(pavimentazione) = rappresenta una pavimentazione composta da i vari componeti
        IR = pavimentazione != null
             pavimentazione deve essere non vuota, deve contenere almeno un componente
             ogni componente della pavimentazione deve essere != null
     */

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = costruisce una nuova pavimentazione a parte dalla collezione dei suoi componenti
        Se pavimentazione è un riferimento a null viene sollevata un eccezione di tipo NullPointerException.
        Se pavimentazione non contiene almento un elemento viene sollevata un eccezione di tipo NoSuschElementException
        Se un Componente di pavimentazione è un riferimento a null viene sollevata un eccezione di tipo IllegalArgumentException
     */
    public Pavimentazione(Collection<Componente> pavimentazione){
        if (pavimentazione == null) throw new NullPointerException("pavimentazione non può essere un rifeirmento a null");
        if (pavimentazione.isEmpty()) throw new NoSuchElementException("pavimentazione deve avere almeno un componente");
        for (Componente c:pavimentazione){
            if (c==null) throw new IllegalArgumentException("pavimentazione non può avere componenti a null");
        }
        this.pavimentazione= List.copyOf(pavimentazione);
    }

    @Override
    public int costo() {
        int costo = 0;
        for (Rivestimento c:pavimentazione){
           costo+=c.costo();
        }
        return costo;
    }

    @Override
    public int superficie() {
        int superficie = 0;
        for (Rivestimento c:pavimentazione){
            superficie+=c.superficie();
        }
        return superficie;
    }

    @Override
    public Iterator<Componente> iterator() {
        return pavimentazione.iterator();
    }
}
