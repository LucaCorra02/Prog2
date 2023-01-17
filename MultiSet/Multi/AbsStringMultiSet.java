package MultiSet.Multi;
import java.util.Iterator;

/*
 * Classe astratta per string multiSet
 */
public abstract class AbsStringMultiSet implements StringMultiSet{

    @Override
    public String toString() {
        
        final StringBuilder str = new StringBuilder(size()+" {");
        final Iterator<String> ie = iterator();

        while (ie.hasNext()){
            String tmp = ie.next();
            str.append(tmp+": "+multiplicity(tmp));
            if (ie.hasNext()) str.append(", ");
        }
        str.append("}");
        return str.toString();
    }
    
}
