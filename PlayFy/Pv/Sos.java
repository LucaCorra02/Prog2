package Pv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.LeafElement;

public class Sos {
   
    public static void main(String[] args) {


       Scanner myScanner = new Scanner(System.in);
       String titolo = new String();
       boolean controlla = false;
       boolean controllaPl = false;
       List<String> titoli = new ArrayList<>();
       List<Durata> durate = new ArrayList<>();
       List<Album> album = new ArrayList<>();
       List<PlayList> playlist = new ArrayList<>();
       List<Album.Brano> playlistTmp = new ArrayList<>() ;

       while(myScanner.hasNextLine()){
            String linea = myScanner.nextLine();

            if (linea.equals(".")){
                if(controlla){
                    Album sos = new Album(titolo, titoli, durate);
                    System.out.println(sos.toString());
                    album .add(sos);
                    controlla = false;
                    titoli.removeAll(titoli);
                    durate.removeAll(durate);
                }
                if(controllaPl){
                    controllaPl=false;
                    PlayList pl = new PlayList(titolo);
                    for (Album.Brano br : playlistTmp){
                        pl.addBrano(br);
                    }
                    playlistTmp.removeAll(playlistTmp);
                    playlist.add(pl);
                    System.out.println(pl.toString());
                }
                System.out.println("-------------------------------------------");    
            }

            if (controlla){
                String[] tmp = linea.split(" - ");
                durate.add(new Durata(tmp[0]));
                titoli.add(tmp[1]);
            }

            if (controllaPl){
                String[] indici = linea.split(" ");
                int al = Integer.parseInt(indici[0])-1;
                int br = Integer.parseInt(indici[1]);
               // System.out.println(album,al);
                playlistTmp.add(album.get(al).getBarnoPosizione(br));
            }
            
            if (linea.contains("ALBUM")){
                titolo = new String(linea.replace("ALBUM", "").trim());
                controlla = true;
            }

            if (linea.contains("PLAYLIST")){
                titolo = new String(linea.replace("ALBUM", "").trim());
                controllaPl = true;
            }
       }
       
       String titoloNuovo = new String("FONDI");
       PlayList fondi = new PlayList(titoloNuovo); 

       for (int i = 0 ; i< playlist.size()-1;i+=2){
           fondi = playlist.get(i).fondi(playlist.get(i+1), titoloNuovo); 
       }
       System.out.println("fondi"+fondi.toString());
    }
}
