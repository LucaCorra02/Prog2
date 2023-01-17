//L'iterfaccia Matrice stabilisce il contratto per matrici quadrate di interi non mutabili.

public interface Matrice {

    /*
       REQUIRES = -
       MODIFY = -
       EFFECTS = restituisce un intero rappresentante la dimensione di this
    */
    int dim();

    /*
     REQUIRES = -
     MODIFY = -
     EFFECTS = restitusce un intero rappresententante il valore situato all’i-esima riga e j-esima colonna di this.
     Viene sollevata un eccezione di tipo IndexOutOfBuondException < se i< 0 or i > this.dim()-1 or j < 0 or j > this.dim()-1
  */
    int val(final int i, final int j);

    /*
      REQUIRES = -
      MODIFY = -
      EFFECTS = restitusce una Matrice ottenuta moltiplicando this per lo scalare alpha (entrata per entrata)
   */
    Matrice per(final int alpha);

    /*
      REQUIRES = -
      MODIFY = -
      EFFECTS = restitusce una Matrice ottenuta esegundo il prodotto matriciale tra this e m
      Viene sollevata un eccezione di tipo IlligalArgumentException se m e this non sono conformi
      Viene sollevata un eccezione di tipo NullPointerException se m è un riferimento a null
   */
    Matrice perM(final Matrice m);

    /*
      REQUIRES = -
      MODIFY = -
      EFFECTS = restitusce una Vettore ottenuta esegundo il prodotto matriciale tra this e v
      Viene sollevata un eccezione di tipo IlligalArgumentException se v e this non sono conformi
      Viene sollevata un eccezione di tipo NullPointerException se v è un riferimento a null
   */
    Vettore perV(final Vettore v);


    /*
      REQUIRES = -
      MODIFY = -
      EFFECTS = restitusce una Matrice ottenuta esegundo la somma matriciale tra m e this.
      Viene lanciata un eccezione di IlligalArgumentException se m e this non sono conformi tra di loro.
      Viene sollevata un eccezione di tipo NullPointerException se m è un riferimento a null.
   */
    Matrice piu(final Matrice m);

    /*
     REQUIRES = -
     MODIFY = -
     EFFECTS = restituisce true se  m è conforme a this ( se hanno la stessa dimensione) altrimenti false.
     Viene sollevata un eccezione di tipo NullPointerException se m è un riferimento a null.
  */
    default boolean conformi(Matrice m){
        if (m==null) throw new NullPointerException("v non può essere un riferimento a null");
        return m.dim()==this.dim();
    }

    /*
    REQUIRES = -
    MODIFY = -
    EFFECTS = restituisce true se  v è conforme a this ( se hanno la stessa dimensione) altrimenti false.
    Viene sollevata un eccezione di tipo NullPointerException se v è un riferimento a null.
 */
    default boolean conformi(Vettore v){
        if (v==null) throw new NullPointerException("v non può essere un riferimento a null");
        return v.dim()==this.dim();
    }

}
