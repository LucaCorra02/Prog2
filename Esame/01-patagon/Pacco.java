import java.util.Objects;

/*
 * OVERVIEW :
 *  -   Le istanze di questa classe sono immutabili
 */
public class Pacco{

    private final String nome;
    private final int altezza;

    /*
     * AF(nome,altezza) = nome e altezza rappresentano il nome di un oggetto contenuto in un pacco con una certa altezza
     * IR() = nome non vuoto
     *        nome non può essere un riferimento a null
     *        altezza > 0
     */

     /*
      * REQUIRES = -
        MODIFY = this
        EFFECTS = costruisce un nuovo pacco a partire dal suo nome
        Se nome è un riferimento a null viene sollevata un eccezione di tipo NullPointerException
        Se nome è una stringa vuota viene sollevata un eccezione di tipo IllegalArgmentException
        Se altezza è un intero <= 0 viene sollevata un eccezione di tipo IllegalArgmentException

      */
     public Pacco(final String nome, final int altezza){
        Objects.requireNonNull(nome,"nome non può essere un riferimento a null");
        if(nome.isEmpty()) throw new IllegalArgumentException("nome nn può essere vuoto");
        if (altezza<=0) throw new IllegalArgumentException("altezza <=0");
        this.nome = nome;
        this.altezza = altezza;
     }

     /*
      * REQUIRES =-
        MODIFY = -
        EFFECTS = restituisce il nome di questo pacco
      */
      public String getNome(){
        return nome;
      }

      /*
      * REQUIRES =-
        MODIFY = -
        EFFECTS = restituisce l'altezza di questo pacco
      */
      public int getAltezza(){
        return altezza;
      }

      @Override
      public String toString() {
          return nome+"["+altezza+"]";
      }

      @Override
      public boolean equals(Object obj) {
          if (!(obj instanceof Pacco)) return false;
          Pacco tmp = (Pacco) obj;
          return tmp.altezza == altezza && tmp.nome.equals(nome);
      }
      @Override
      public int hashCode() {
          return Objects.hash(nome,altezza);
      }

}