import java.util.LinkedList;
import java.util.List;

/*
 * Classe che rappresenta un microRobto, immutabile.
 * Sposta un pacco alla volta
 */
public class MicroRobot extends Robot {

    public MicroRobot(MagazzinoLogistico magazzino){
        super(magazzino);
    }

    @Override
    public void spostaDaA(int iScaf1, int iScaf2, int numeroPacchi) {
        if (iScaf1 < 0 || iScaf2 < 0 ||  iScaf1 >= magazzino.dimMagazzino() || iScaf2 >= magazzino.dimMagazzino()) throw new IndexOutOfBoundsException();
        if(numeroPacchi < 0) throw new IllegalArgumentException();
        if(numeroPacchi > magazzino.dimScaffaleI(iScaf1) || numeroPacchi > magazzino.dimScaffaleI(iScaf2)) throw new IllegalArgumentException();
        List<Pacco> scaf1 = new LinkedList<>();
        for(int i = 0;i<numeroPacchi;i++){
            scaf1.add(magazzino.rimuoviCimaScafalatura(iScaf1));
        }
        for ( int i = 0;i< scaf1.size();i++){
            magazzino.aggiungiAScafalatura(iScaf2, scaf1.get(i));
        }
        

    }

    
}
