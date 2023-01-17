package Pv;

import java.util.Objects;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * OVERVIEW :
 *  -   La classe rappresenta la durata di un brano 
 *  -   Le istanze di questa classe sono immutabili
 */
public class Durata{

    private final int secondi;

    /*
     * AF(secondi) = rappresentano la durata di un brano espressa come HH:MM:SS
     * IR() = durata deve essere >= 0 
     */

     /*
      * REQUIRES = -
        MODIFY = this 
        EFFECTS = costruisce una nuova durata partendo da una stringa.
        Se str è un riferimeno a null viene sollevata une eccezione di tipo NullPointerException
        Se str non è nel formato HH:MM:SS oppure duarata = 0 viene sollevata un eccezione di tipo IllegalArgumentException
      */
    
    public Durata(final String str){
        Objects.requireNonNull(str,"str non può essere un riferimento a null");
        DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        try {
           Date date = sdf.parse(str);  
           int tmp = (int)date.getTime()/1000;
           if (tmp == 0) throw new IllegalArgumentException("durata non può essere a 0");
           this.secondi = tmp;
        } catch (Exception e) {
            throw new IllegalArgumentException("str non è nel formato HH:MM:SS");
        }
    }

    /*
      * REQUIRES = -
        MODIFY = this 
        EFFECTS = costruisce una nuova durata partendo dalla sua durata in secondi
        se secondi <= 0 viene sollevata un eccezione di tipo IllegalArgumentException
      */
      public Durata(final int secondi){
       if (secondi<=0) throw new IllegalArgumentException("durata 0 o negativa");
       this.secondi = secondi;
    }




    /*
     * REQUIRES = -
     * MODIFY = this 
     * EFFECTS = costruisce una nuova durata a partire dai secondi che dura
     * se secondi è <= 0 viene sollevata IllegalArgumentException
     */
    public String daStringa(int secondi){
        if (secondi <= 0 ) throw new IllegalArgumentException("secondi non può essere < 0");
        return String.format("%d:%d:%d", secondi / 3600,(secondi % 3600) / 60 , secondi % 60);
    }

    /*
     * REQUIRES = -
     * MODIFY  = -
     * EFFECTS = ritorana una nuova durata ottenuta sommando i secondi di this a quelli di d
     * se d è un riferimento a null viene sollevata un eccezione di tipo NullPointerException()
     */
    public Durata somma(Durata d){
        if(d==null) throw new NullPointerException("d non può essere un riferimento a null");
        return new Durata(daStringa(this.secondi+d.secondi));
    }

    /*
     * REQUIRES = -
     * MODIFY  = -
     * EFFECTS = ritorana una nuova durata ottenuta sotraendo i secondi di this a quelli di d
     * viene sollevata un eccezione di tipo IllegalArgumentException se sencondi di d >= secondi di this
     */
    public Durata sottrai(Durata d){
        if(d==null) throw new NullPointerException("d non può essere un riferimento a null");
        if (d.secondi >= this.secondi ) throw new IllegalArgumentException("sotrazzione negativa");
        return new Durata(daStringa(this.secondi-d.secondi));
    }

    /*
     * REQUIRES = -
     * MODIFY = -
     * EFFECTS = ritorna un intero rappresentante i secondi di this
     */
    public int getSecondi(){
        return this.secondi;
    }

    @Override
    public String toString() {
        return "("+daStringa(this.secondi)+")";
    }
    
}