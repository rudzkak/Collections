package sdaCollections.katalog;

import sdaCollections.Produkt;

import java.util.ArrayList;
import java.util.List;

public class Dostawca {

    private String nazwa;
    private List<Produkt> listaProduktów = new ArrayList<>();


    public Dostawca(String nazwa) {
        this.nazwa = nazwa;
    }
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<Produkt> getListaProduktów() {
        return listaProduktów;
    }

    public void setListaProduktów(List<Produkt> listaProduktów) {
        this.listaProduktów = listaProduktów;
    }

    @Override
    public String toString() {
        return "Dostawca{" +
                "nazwa='" + nazwa + '\'' +
                ", listaProduktów=" + listaProduktów +
                '}';
    }
}
