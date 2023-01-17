import java.util.HashMap;
import java.util.NoSuchElementException;

/*
    OVERVIEW :
        -   Le istanze di questa classe rappresentnto il prezzoUnitario per un listino di giocattoli
        -   Le istanze di questa classe sono immutabili
 */
public class PrezzoUnitario extends ListinoAbs{

    public PrezzoUnitario(HashMap<Giocattolo,Integer> li){
        super(li);
    }

    /*
       REQUIRES = -
       MODIFY = -
       EFFECTS = ritorna un intero rappresentante il prezzo complessivo di un giocattolo.
       Viene lanciatà un eccezione di tipo NullPointerException se G è un riferimento a null
       Viene sollevata un eccezione di tipo IllegalArgumentException se numero <= 0
       Viene sollevata un eccezione di tipo NoSuchElement exception se this non conosce g.
    */
    @Override
    public int prezzoComplessivo(Giocattolo g, Integer numero) {
        if (numero<=0) throw new IllegalArgumentException("numero <=0");
        return prezzo(g)*numero;
    }
}
