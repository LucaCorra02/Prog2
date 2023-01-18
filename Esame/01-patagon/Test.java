public class Test {
    public static void main(String[] args) {
        MagazzinoLogistico m = new MagazzinoLogistico(4);
        m.aggiungiAScafalatura(1, new Pacco("sss1",2));
        m.aggiungiAScafalatura(1, new Pacco("sss2",2));
        m.aggiungiAScafalatura(1, new Pacco("sss3",2));
        m.aggiungiAScafalatura(2, new Pacco("sss",4));
       


        MicroRobot r1 = new MicroRobot(m);
        r1.spostaDaA(1, 2, 2);

        System.out.println(m.toString());
    }
    
}
