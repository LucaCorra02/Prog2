import java.util.LinkedList;
import java.util.List;

public class CautoRobot extends Robot {

    public final int altezzaMax;
    /*
     * IR()altezzaMax deve essere non negativo e > 0
     */

     /*
      * Costruisce un extrarobot a partire dal suo magazzino e dall'altezza max dei pacchi che posta
        viene sollevata un ecdezione di tipo IllegalArgumentException se altezzaMax <= 0
      */
    public CautoRobot(final MagazzinoLogistico magazzino, final int altezzaMax){
        super(magazzino);
        if (altezzaMax<=0) throw new IllegalArgumentException();
        this.altezzaMax = altezzaMax;
    }

    @Override
    public void spostaDaA(int iScaf1, int iScaf2, int numeroPacchi) {
        if (iScaf1 < 0 || iScaf2 < 0 ||  iScaf1 >= magazzino.dimMagazzino() || iScaf2 >= magazzino.dimMagazzino()) throw new IndexOutOfBoundsException();
        if(numeroPacchi < 0) throw new IllegalArgumentException();
        if(numeroPacchi > magazzino.dimScaffaleI(iScaf1) || numeroPacchi > magazzino.dimScaffaleI(iScaf2)) throw new IllegalArgumentException();
        
        int sumAltezza = 0;
        //rimuovere il primo elemento di iScaf1 a Iscaf2
        //successivamente iniziare a rimuovere elementi da iScaf1 salvandoli in una lista,
        //controllare che la somma delle altezze non ecceda quella massima, in caso contrario sollevare une ccezione di OutOfBuond
        
    }
    
}
