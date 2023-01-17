import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        Sistema sistema = new Sistema();

        while (scan.hasNextLine()){
            String str=scan.nextLine();
            String []tmp=str.split(" ");
            Punto p1 =new Punto(Integer.parseInt(tmp[2]),Integer.parseInt(tmp[3]),Integer.parseInt(tmp[4]));
            if (tmp[0].equals("P")){
                sistema.addC(new Pianeta(tmp[1],p1,new Punto(0,0,0)));
            }else{
                sistema.addC(new Stella(tmp[1],p1));
            }
        }

        sistema.attrazioneGravitazionale(1);
        sistema.ordineAlfabetico();
        System.out.println(sistema);
        System.out.println("Energia tot sistema: "+sistema.energiaTot());
    }
}
