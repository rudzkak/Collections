package sdaCollections.biblioteka;

import java.util.List;

public class Biblioteka {

    public void dodajNaPółkę(Półka półka, Książka książka){
        półka.getListaKsiążek().add(książka);
    }


    public void wypiszZawartość(Półka półka){
        List<Książka> lista = półka.getListaKsiążek();
        System.out.println("Zawartość półki: " + półka.getNumerPółki());
        for(Książka książka : lista){
            System.out.println(książka);
        }
    }

    public void przełóżKsiążkę(Półka staraPółka, Książka książka, Półka nowaPółka){
        if(staraPółka.getListaKsiążek().contains(książka)){
            staraPółka.getListaKsiążek().remove(książka);
            nowaPółka.getListaKsiążek().add(książka);
        } else {
            System.out.println("Podanej książki nie ma na wskazanej półce");
        }
    }

    public void zdejmijKsiążki(Półka półka, int indeksOd, int indeksDo){
        List<Książka> listaKsiążek = półka.getListaKsiążek();
        if(indeksOd < listaKsiążek.size() && indeksDo <= listaKsiążek.size() && indeksOd < indeksDo ) {
            List<Książka> subListaKsiażek = listaKsiążek.subList(indeksOd, indeksDo);
            listaKsiążek.removeAll(subListaKsiażek);
        } else{
            System.out.println("Błędne wartości indeksów");
        }
    }

    public void opróżnijPółkę(Półka półka){
        półka.getListaKsiążek().clear();
    }

    public int liczbaPozycjiNaPółce(Półka półka){

        return półka.getListaKsiążek().size();
    }

    public int numerPozycjiNaPółce(Książka książka, Półka półka){
        return półka.getListaKsiążek().indexOf(książka);
    }
}
