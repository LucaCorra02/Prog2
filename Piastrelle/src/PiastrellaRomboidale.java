/*
    OVERVIEW :
        -   Le istaze di questa classe rappresentano delle piastrelle romboidali
        -   Le istanze di questa classe sono immutabili
 */

public class PiastrellaRomboidale extends Piastrella{

    private final int maggiore;
    private final int minore;

    /*
        AF(maggiore,minore) = rappresentano una piastrella romboidale costuita da due diagonali
        IR = diagonale1 > 0 && diagonale2 > 0
     */

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = costrusice una poastrella diagonale dato il suo costo e la lunghezza delle sue diagonali.
        viene sollevata un eccezione di tipo IllegalArgument exception se costo < 0 or diagonale1 < 0 or diagonale2 < 0
     */
    public PiastrellaRomboidale(final int costo, final int diagonale1, final int diagonale2){
        super(costo);
        if (diagonale1<=0 && diagonale2<=0) throw new IllegalArgumentException("diagonale1 e diagonale2 devono essere > 0");
        if (diagonale1>diagonale2){
            maggiore=diagonale1;
            minore = diagonale2;
        }else{
            minore=diagonale2;
            maggiore=diagonale1;
        }

    }

    @Override
    public int superficie() {
        return (maggiore*minore)/2;
    }
}
