package sdaCollections.biblioteka;

import java.util.ArrayList;
import java.util.List;

public class Półka {

    private int numerPółki;
    private List<Książka> listaKsiążek;

    public Półka(int numerPółki) {
        this.numerPółki = numerPółki;
        this.listaKsiążek = new ArrayList<>();
    }

    public int getNumerPółki() {
        return numerPółki;
    }

    public void setNumerPółki(int numerPółki) {
        this.numerPółki = numerPółki;
    }

    public List<Książka> getListaKsiążek() {
        return listaKsiążek;
    }

    public void setListaKsiążek(List<Książka> listaKsiążek) {
        this.listaKsiążek = listaKsiążek;
    }

    @Override
    public String toString() {
        return "Półka{" +
                "numerPółki=" + numerPółki +
                ", listaKsiążek=" + listaKsiążek +
                '}';
    }
}
