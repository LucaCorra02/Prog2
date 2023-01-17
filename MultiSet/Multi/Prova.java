package MultiSet.Multi;
import java.util.Scanner;

public class Prova {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        StringMultiSet m1 = new MapStringMultiSet();
        StringMultiSet m2 = new ListMultiSet();
        boolean scambio = true;

        while(myScanner.hasNextLine()){
            String[] valori = myScanner.nextLine().split(" ");
            for (String str : valori){
                if (scambio) m1.add(str);
                else m2.add(str);
            }
            if(scambio) scambio = false;
            else scambio =  true;
        }
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m1.union(m2));
        System.out.println(m1.intersection(m2));

        myScanner.close();
    }
    
}
