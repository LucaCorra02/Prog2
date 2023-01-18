import java.util.Objects;
//In questo caso era meglio implementare robot microRobot come classe concreto e ExtraRobot e cautoRobt come sottotipi di mircorobot
//i quali anndavo a sovrascrivere i metodi per spsostare i pacchi e aggiungevano dei campi in più
/*
 * Classe astratta robot
 */
public abstract class Robot {

    /*
     * Magazzino a cui appartiene il robot
     */
    protected final MagazzinoLogistico magazzino;



    /*
     * REQUIRES = -
     * MODIFY = -
     * EFFECTS = cotruisce un nuovo robot a partire dal magazzino che gestisce
     * se magazzino è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
     */
    public Robot(MagazzinoLogistico magazzino){
        Objects.requireNonNull(magazzino, "magazzino non può essere un riferimento a null");
        this.magazzino = magazzino;
    }

    /*
     * REQUIRES = -
     * MODIFY = magazzino
     * EFFECTS = sposta dalla scaffalatura di indice iscaf1 alla scaffalatura di indice Iscaf2 dei pacchi (in quantità numeroPacchi) secondo una polcy arbitraria
     * restituisce un eccezione di tipo IndexOutOfBuondException se iscaf1 o iscaf2 sono < 0 || > dim magazzino
     * restituisce un eccezione di tipo IllegalArgumentException se numeroPacchi < 0
     * * restituisce un eccezione di tipo IllegalArgumentException se il numeroPacchi da prellevare è maggiore di quello contenuto nella scafalature 
     */
    public abstract void spostaDaA(int iScaf1, int iScaf2, int numeroPacchi);

}
