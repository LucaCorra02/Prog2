package boolVect;
/*
 * OVERVIEW 
 * CLasse astratta di boolVect, implementa le operazioni di and or e xor
 */
public abstract class BoolVectAbs implements BoolVect{

    @Override
    public void and(BoolVect op) throws NullPointerException {
        if (op == null) throw new NullPointerException("op non può essere un riferimento a null");
        int d = Math.max(dimensione(),op.dimensione());
        for (int i = 0 ; i < d ; i++){
            scrivi(i, (leggi(i) && op.leggi(i)) );
        }
    }


    @Override
    public void or(BoolVect op) throws NullPointerException {
        if (op == null) throw new NullPointerException("op non può essere un riferimento a null");
        if (taglia() < op.dimensione()) throw new IllegalArgumentException("this. taglia < di op.dimensione"); 
        int d = Math.max(dimensione(), op.dimensione());
        for (int i = 0 ; i < d ; i++){
            scrivi(i, (leggi(i) || op.leggi(i)) );
        }

    }

    @Override
    public void xor(BoolVect op) throws NullPointerException {
        if (op == null) throw new NullPointerException("op non può essere un riferimento a null");
        if (taglia() < op.dimensione()) throw new IllegalArgumentException("this. taglia < di op.dimensione"); 
        int d = Math.max(dimensione(), op.dimensione());
        for (int i = 0 ; i < d ; i++){
            scrivi(i, (leggi(i) ^ op.leggi(i)) );
        }
    }
    
    @Override
    public String toString() {
        if (dimensione()==0) return "F";

        StringBuilder str = new StringBuilder();
        for (int i=dimensione()-1; i >=0 ; i--){
            if (leggi(i)) str.append("V");
            else str.append("F");
        }
        return str.toString();
    }
}