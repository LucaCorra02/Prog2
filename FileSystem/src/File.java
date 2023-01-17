import javax.print.DocFlavor;

/*
    OVERVIEW :
        -   Le istanze di questa classe rappresentanto un File
        -   Le istanze di questa classe sono immutabili
 */
public class File extends Entry {

    private final int dimensione;

    /*
        AF(dimensione) = rappresenta un file di una data dimensione e un dato nome.
        IR = dimensione > 0;
     */

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = costruisce un nuovo file partendo da un nome e una dimensione.
        Se nome è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
        Se nome è vuto, viene sollevata un eccezione di tipo IllegalArgumentException
        Se dimensione è <=0 viene sollevata un eccezione di tipo IllegalArgumentException
     */
    public File(String nome, int dimensione) {
        super(nome);
        if (dimensione<=0 ) throw new IllegalArgumentException("la dimensione deve essere positivia");
        this.dimensione = dimensione;
    }

    @Override
    public int dimensione() {
        return dimensione;
    }

    @Override
    public String toString() {
        return super.getNome()+"("+dimensione+")";
    }
}
