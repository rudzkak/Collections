package sdaCollections.zadOsoba;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class RejestrOsób {
    private List<Osoba> listaOsób = new ArrayList<>();

    public void dodajOsobe(Osoba osoba){
        listaOsób.add(osoba);
    }

    public void usunOsobe(Osoba osoba){
        if(listaOsób.contains(osoba)){
            listaOsób.remove(osoba);
        } else{
            System.out.println("Takiej osoby nie ma na liście");
        }
    }

    public void wypiszListe(){
        Iterator<Osoba> iterator = listaOsób.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public Osoba znajdzOsobe(String nazwisko){
        for(Osoba osoba : listaOsób){
            if(osoba.getNazwisko().equalsIgnoreCase(nazwisko)){
                return osoba;
            }
        }
        System.out.println("Na liście nie ma osoby o takim nazwisku");
        return null;
    }

    public int avg(){
        int wiek = 0;
        for(Osoba osoba : listaOsób){
            wiek += osoba.getWiek();
        }
        int średniWiek = wiek / listaOsób.size();
        return średniWiek;
    }

    public Osoba min(){
        Osoba najmłodszy = listaOsób.get(0);
        for(Osoba osoba : listaOsób){
            if(osoba.getWiek() < najmłodszy.getWiek()){
                najmłodszy = osoba;
            }
        }
        return najmłodszy;

    }

    public Osoba max(){
        Osoba najstarszy = listaOsób.get(0);
        for(Osoba osoba : listaOsób){
          if( osoba.getWiek() > najstarszy.getWiek()){
              najstarszy = osoba;
          }
        }
        return najstarszy;
    }

    public Optional<Osoba> maxJava8(){
        return listaOsób.stream().max(Comparator.comparing(osoba -> osoba.getWiek()));
    }

    public String toString(){
        return listaOsób.toString();
    }

}
