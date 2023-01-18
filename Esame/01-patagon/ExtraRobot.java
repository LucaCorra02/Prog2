import java.util.LinkedList;
import java.util.List;

/*
 * Classe che rappresenta un ExtraRobot, immutabile.
 */
public class ExtraRobot extends Robot {

    public final int pacchiCheSposta;
    /*
     * IR()pacchichespota deve essere non negativo e > 0
     */

     /*
      * Costruisce un extrarobot a partire dal suo magazzino e dai pacchi che sposta
        viene sollevata un ecdezione di tipo IllegalArgumentException se pacchichesposta <= 0
      */
    public ExtraRobot(final MagazzinoLogistico magazzino, final int pacchiCheSposta){
        super(magazzino);
        if (pacchiCheSposta<=0) throw new IllegalArgumentException();
        this.pacchiCheSposta=pacchiCheSposta;
    }

    /*
     * EFFECTS = se numeropacchi è > pacchiCheSposta questo robot viebe sollevata un eccezione di tipo IllegalArgumentException
     */
    @Override
    public void spostaDaA(int iScaf1, int iScaf2, int numeroPacchi) {
        if (iScaf1 < 0 || iScaf2 < 0 ||  iScaf1 >= magazzino.dimMagazzino() || iScaf2 >= magazzino.dimMagazzino()) throw new IndexOutOfBoundsException();
        if(numeroPacchi < 0) throw new IllegalArgumentException();
        if(numeroPacchi > magazzino.dimScaffaleI(iScaf1) || numeroPacchi > magazzino.dimScaffaleI(iScaf2)) throw new IllegalArgumentException();
        if(numeroPacchi > pacchiCheSposta) throw new IllegalArgumentException();
        List<Pacco> scaf1 = new LinkedList<>();
        for(int i = 0;i<numeroPacchi;i++){
            scaf1.add(magazzino.rimuoviCimaScafalatura(iScaf1));
        }
        for ( int i = 0;i< scaf1.size();i++){
            magazzino.aggiungiAScafalatura(iScaf2, scaf1.get(i));
        }
    }
    
}
