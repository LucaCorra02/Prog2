
//Interfaccia che rappresenta il contratto per vettori immutabili a valori interi
public interface Vettore {

    /*
        REQUIRES = -
        MODIFY = -
        EFFECTS = restituisce un intero rappresentante la dimensione di this (il numero delle sue componenti)
     */
    int dim();

    /*
       REQUIRES = -
       MODIFY = -
       EFFECTS = restitusce un intero rappresententante il valore dell’i-esima componente di this.
       Viene sollevata un eccezione di tipo ArrayOutOfBuondException se i< 0 or i > this.dim()-1
    */
    int val(final int i);


     /*
       REQUIRES = -
       MODIFY = -
       EFFECTS = restitusce un vettore dove l'i-esima posizione è data dal prodotto dell'i-esima pos di this per lo scalare alpha.
    */
    Vettore per(final int alpha);

    /*
      REQUIRES = -
      MODIFY = -
      EFFECTS = Restituisce un nuovo Vettore rapprsentante la somma vettoriale tra v e this.
      Viene sollevata un eccezione di tipo IllegalArgumentException se this.conformi(v) != true
      Viene sollevata un eccezione di tipo NullPointerException se v è un riferimento a null.
   */
    Vettore più(final Vettore v);


    /*
       REQUIRES = -
       MODIFY = -
       EFFECTS = restitusce true se this.dim()==v.dim() ( se la dimensione di this e dim è uguale),
       altrimenti restituisce false.
       Viene sollevata un eccezione di tipo NullPointerException se v è un riferimento a null.
     */
    default boolean conformi(final Vettore v){
        return this.dim()==v.dim();
    }

    /*
       REQUIRES = -
       MODIFY = -
       EFFECTS = restitusce true se this.dim()==v.dim() ( se la dimensione di this e dim è uguale),
       altrimenti restituisce false.
       Viene sollevata un eccezione di tipo NullPointerException se m è un riferimento a null.
     */
    default boolean conformi(final Matrice m){
        if (m==null) throw new NullPointerException("m non può essere un riferimento a null");
        return this.dim() == m.dim();
    }
}
