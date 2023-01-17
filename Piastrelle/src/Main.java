import javax.script.ScriptEngine;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        HashMap<Integer,Pavimentazione> input = new HashMap<>();
        int cont =0;
        while (s.hasNextLine()){
            Pavimentazione p = creaComponente(s.nextLine(),input);
            input.put(cont,p);
            cont++;
        }
    }

    private static Pavimentazione creaComponente(String linea,HashMap<Integer,Pavimentazione> input){
        String[] tmp = linea.split(" ");
        List<Componente> comp = new ArrayList<>();

        switch(tmp[0]) {
            case "Q":
                comp.add(new Componente(new PiastrellaQuadrata(Integer.parseInt(tmp[2]),Integer.parseInt(tmp[1])),1));
                return new Pavimentazione(comp);

            case "P":
                List<Componente> temp2 = new ArrayList<>();
                for(int i=1;i< tmp.length;i+=2){
                    int fino = Integer.parseInt(tmp[i]);
                    for (int j=0;j<fino;j++){
                        Pavimentazione temp = input.get(Integer.parseInt(tmp[i+1]));
                        for(Componente c : temp){
                            temp2.add(c);
                        }
                    }
                }
                Pavimentazione p = new Pavimentazione(temp2);
                System.out.println(p.superficie()+" "+p.costo());
                return p;

            case "R":
                comp.add(new Componente(new PiastrellaRomboidale(Integer.parseInt(tmp[3]),Integer.parseInt(tmp[2]),Integer.parseInt(tmp[1])),1));
                return new Pavimentazione(comp);
            case "T":
                comp.add(new Componente(new PiastrellaTriangolare(Integer.parseInt(tmp[3]),Integer.parseInt(tmp[2]),Integer.parseInt(tmp[1])),1));
                return new Pavimentazione(comp);
        }
        return null;
    }
}