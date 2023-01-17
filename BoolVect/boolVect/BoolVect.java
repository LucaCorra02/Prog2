package boolVect;

public interface BoolVect{

    /*
        REQUIRES = -
        MODIFY = - 
        EFFECTS = restituisce un intero rappresentante la dimensione di this.
        La dimensione è definta come 1 più la posizione più grande in cui si trova un valore di verità uguale a vero
     */
    int dimensione();

    /*
     *  REQUIRES = -
     *  MODIFY = -
     *  EFFECTS = restiutisce la taglia di this.
     * La taglia  definta come è la massima dimensione che esso può raggiungere
     */
    int taglia();

   /*
     *  REQUIRES = -
     *  MODIFY = -
     *  EFFECTS = restiutisce un booleano rappresentante il valore di verità nella i-esima posizione di this.
     *  Se i è > dimensione di this viene restituito il valore false 
     * Se i è negativo viene sollevata un eccezione di tipo IndexOutOfBuondException
     */
    boolean leggi(final int  i) throws IndexOutOfBoundsException;

    /*
     *  REQUIRES = -
     *  MODIFY = this
     *  EFFECTS = scrive nell'iesima posizione di this il valore val .
     *  Se i è > della dimensione di this oppure i è negativo, viene sollevata un eccezio ne di tipo OutOfBoundException
     */
    void scrivi(final int i, final boolean val) throws IndexOutOfBoundsException;

    /*
     * REQUIRES = -
     * MODIFY = this 
     * EFFECTS = modifica this esegundo l'operazione and componente per componente con op
     * Anche se la dimensione degli operandi può essere diversa, essa non può eccedere la minore tra le due.
     * Se op è un riferimento a null viene sollevata un eccezione di tipo NullPointerException 
     */
    void and(final BoolVect op) throws NullPointerException ;

    /*
     * REQUIRES = -
     * MODIFY = this 
     * EFFECTS = modifica this esegundo l'operazione and componente per componente con op
     * Anche se la dimensione degli operandi può essere diversa, essa sarà pari alla maggiore tra le due.
     * Se op è un riferimento a null viene sollevata un eccezione di tipo NullPointerException 
     * 
     *Si osservi che se la dimensione dell'altro BoolVect è maggiore della taglia (e quindi
     * dimensione) di questo, allora il valore di verità in posizione pari alla dimensione dell'altro
     * BoolVect sarà, ma non potrà essere memorizzato in questo BoolVect per via della
   * sua taglia. viene sollevata un eccezione di tipo IllegalArgumentException se dimensione di op > taglia di this 
     */
   void or(final BoolVect op) throws NullPointerException, IllegalArgumentException;

    /*
     * REQUIRES = -
     * MODIFY = this 
     * EFFECTS = modifica this esegundo l'operazione xor componente per componente con op 
     * Se op è un riferimento a null viene sollevata un eccezione di tipo NullPointerException 
     * Se taglia di this < di dimensione di op viene sollevata un eccezione di tipo IllegalArgumentException
     */
    void xor(final BoolVect op) throws NullPointerException;
}