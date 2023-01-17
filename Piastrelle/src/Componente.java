/*
     OVERVIEW :
        -   Le istanze di questa classe rappresentano un componente della pavimentazione
        -   Le isatanze di questa classe sono immutabili
    */
public class Componente implements Rivestimento{
    private final Rivestimento rivestimento;
    private final int Quantità;

        /*
            AF(rivestimento,quantità) = rappresentano un componente della pavimentazione composto dal rivestimento di cui è fatto e la quantità
            IR = rivestimento != null
                 quantià > 0
         */

    /*
        REQUIRES = -
        MODIFY = this
        EFFECTS = costruisce un componente della pavimentazione a partire dal rivestimento e la quantità di esso.
        Viene sollevata un eccezione di tipo NullPointerException se rivestimento è un riferimento a null
        Viene sollevata un eccezione di tipo IllegalArgumentException se quantità è <=0
     */
    public Componente(final Rivestimento rivestimento, final int quantià) {
        if (rivestimento==null) throw new NullPointerException("rivestimento non può essere un riferimento a null");
        if (quantià<=0) throw new IllegalArgumentException("quantità deve essere >0");
        this.rivestimento = rivestimento;
        Quantità = quantià;
    }

    public Rivestimento getRivestimento(){
        return this.rivestimento;
    }

    public int getQuantià() {
        return Quantità;
    }

    @Override
    public int costo() {
        return rivestimento.costo()*getQuantià();
    }

    @Override
    public int superficie() {
        return rivestimento.superficie()*getQuantià();
    }
}
