public class Main {
    public static void main(String[] args) {

       Giocattolo g1 = new Giocattolo("gaia","merda");
       Giocattolo g2 = new Giocattolo("elena","merda");

       Inventario inv = new Inventario();

       inv.aggiungiGiocattolo(g1,1);
       inv.aggiungiGiocattolo(g2,2);
       inv.aggiungiGiocattolo(g2,5);
        inv.aggiungiGiocattolo(g1,100);

        System.out.print(inv);
    }
}