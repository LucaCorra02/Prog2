package boolVect;

import java.util.Scanner;

public class Prova{
    public static void main(String[] args) {
        
        Scanner myScanner = new Scanner(System.in);

        while (myScanner.hasNextLine()){
            String[] tmp = myScanner.nextLine().split(" ");
            leggi(tmp);
        }
            
    }

    public static void  leggi(String[] tmp){
      int indice;
      boolean val;
      BoolVect bv,bv2;

        switch(tmp[0]) {
            case "S":
              indice = Integer.parseInt(tmp[1]);
              val = tmp[2].equals("V");
              bv = new SetBoolVect(tmp[3]);
              bv.scrivi(indice, val);
              System.out.println(bv.toString());
              break;

            case "G":
              indice = Integer.parseInt(tmp[1]);
              bv = new SetBoolVect(tmp[2]);
              if (bv.leggi(indice)) System.out.println("V");
              else System.out.println("F");
              break;

            case "&":
              bv = new SetBoolVect(tmp[1]);
              bv2 = new SetBoolVect(tmp[2]);
              bv.and(bv2);
              System.out.println(bv.toString());
              break;

            case "|":
              bv = new SetBoolVect(tmp[1]);
              bv2 = new SetBoolVect(tmp[2]);
              bv.or(bv2);
              System.out.println(bv.toString());
              break;
              
            case "^":
              bv = new SetBoolVect(tmp[1]);
              bv2 = new SetBoolVect(tmp[2]);
              bv.xor(bv2);
              System.out.println(bv.toString());
              break;
          }
    }



}