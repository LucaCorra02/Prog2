import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
    OVERVIEW :
        -   Le istanze di questa classe rappresentano un path di nome di entrys
        -   Le istanze di questa classe sono immutabili
 */
public class Path implements Iterable<String> {

    public static final String SEPARATOR = ":";

    private final List<String> path;
    private final boolean absolute;

    /*
        AF(path,aboslute) = rappresntano un path di nome di entrys, se il path è assoluto comincia con il carattere :(COSTANTe SEPARATOR)
        RI = path != null
             path non contiene dei valori a null
             path non contiene dei valori vuoti o che siano il separatore
     */


    /*
        REQUIRES = -
        MODIFY = -
        EFFECTS = costruisce un path partendo da una lista di nomi, se è assoluto, absolute=true
        Se path è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
        Se path contiene dei valori a null o vuoti o il carattere separatore viene sollevata un eccezione di tipo IllegalArgumentException
     */
    private Path(final boolean absolute, List<String> path){
        if(path==null) throw new NullPointerException("path non può essere un riferimento a null");
        for (String str : path)
            if (str==null || str.isEmpty() || str.equals(SEPARATOR)) throw new IllegalArgumentException("path contiene dei valori a null o vuoti o il carattere separatore");

        this.path = new ArrayList<>(path);
        this.absolute=absolute;
    }

    public Path(final boolean absolute, final String pathPartenza){
        if(pathPartenza==null) throw new NullPointerException("pathPartenza non può essere un riferimento a null");


    }


    public boolean isAbsolute(){
        return absolute;
    }

    public boolean isRelative(){
        return absolute;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if absolute{
            str.append(":");
        }
        for (String s : path){
            str.append(s+":");
        }
        str.deleteCharAt(str.length()-1);
        return str.toString();
    }

    @Override
    public Iterator<String> iterator() {
        return Collections.unmodifiableList(path).iterator();
    }
}
