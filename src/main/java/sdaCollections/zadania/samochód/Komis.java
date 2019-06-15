package sdaCollections.zadania.samochód;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Komis {

    public List<Samochód> listaSamochodów = new ArrayList<>();
    public Set<Samochód> setSamochodów = new HashSet<>();

    public void dodajSamochód(Samochód samochód) {
        listaSamochodów.add(samochód);
        setSamochodów.add(samochód);
    }

    public void kupionoSamochód(Samochód samochód) {
        int licznik = 0;
        for (Samochód auto : listaSamochodów) {
            if (auto.equals(samochód)) {
                licznik++;
            }
        }
        if (licznik == 1) {
            setSamochodów.remove(samochód);
        }
        listaSamochodów.remove(samochód);
    }

    public List<Samochód> samochodyMarki(String marka) {
        List<Samochód> lista = new ArrayList<>();
        for (Samochód samochód : listaSamochodów) {
            if (samochód.getMarka().equalsIgnoreCase(marka)) {
                lista.add(samochód);
            }
        }
        if (lista.isEmpty()) {
            System.out.println("W komisie nie ma takiej marki");
        }
        return lista;
    }

    public List<Samochód> samochodyMarkiIModelu(String marka, String model) {
        List<Samochód> lista = new ArrayList<>();
        for (Samochód samochód : listaSamochodów) {
            if (samochód.getMarka().equalsIgnoreCase(marka)
                    && samochód.getModel().equalsIgnoreCase(model)) {
                lista.add(samochód);
            }
        }
        if (lista.isEmpty()) {
            System.out.println("Nie ma takiego samochodu w komisie");
        }

        return lista;
    }

    public List<Samochód> samochodyZPrzedziałuLat(int dataOd, int dataDo) {
        List<Samochód> lista = new ArrayList<>();
        for (Samochód samochód : listaSamochodów) {
            if (samochód.getRokProdukcji() >= dataOd
                    && samochód.getRokProdukcji() <= dataDo) {
                lista.add(samochód);
            }
        }
        if (lista.isEmpty()) {
            System.out.println("W komisie nie ma samochodu z takiego przedziału lat");
        }
        return lista;
    }

    public List<Samochód> samochodyZPrzedziałuLatJava8(int dataOd, int dataDo){
        return listaSamochodów.stream()
                .filter(samochód -> samochód.getRokProdukcji() >= dataOd && samochód.getRokProdukcji() <= dataDo)
                .collect(Collectors.toList());
    }

    public List<Samochód> samochodyDoKwoty(int cena){
        List<Samochód> lista = new ArrayList<>();
        for(Samochód samochód : listaSamochodów){
            if(samochód.getCena() <= cena){
                lista.add(samochód);
            }
        }
        return lista;
    }

    public List<Samochód> samochodyDoKwotyJava8(int cena){
        return listaSamochodów.stream()
                .filter(samochód -> samochód.getCena() <= cena)
                .collect(Collectors.toList());
    }

    public void wypiszDostepneSamochody(){
        System.out.println(setSamochodów);
    }



    public static void main(String[] args) {
        Samochód samochód1 = new Samochód("Fiat", "Bravo", 2010, 13000);
        Samochód samochód2 = new Samochód("Jeep", "Renegade", 2017, 40000);
        Samochód samochód3 = new Samochód("Nissan", "X-trail", 2017, 90000);
        Samochód samochód4 = new Samochód("Renault", "Megane", 2018, 75000);
        Samochód samochód5 = new Samochód("Toyota", "Yaris", 2016, 35000);
        Samochód samochód6 = new Samochód("Toyota", "Yaris", 2016, 30000);
        Samochód samochód7 = new Samochód("Toyota", "Yaris", 2016, 31000);

        Komis komis = new Komis();
        komis.dodajSamochód(samochód1);
        komis.dodajSamochód(samochód2);
        komis.dodajSamochód(samochód3);
        komis.dodajSamochód(samochód4);
        komis.dodajSamochód(samochód5);
        komis.dodajSamochód(samochód6);
        komis.dodajSamochód(samochód7);

        System.out.println("Lista samochodów: " + komis.listaSamochodów);
        System.out.println("Set samochodów: " + komis.setSamochodów);

        komis.kupionoSamochód(samochód7);
        System.out.println();
        System.out.println("Lista samochodów: " + komis.listaSamochodów);
        System.out.println("Set samochodów: " + komis.setSamochodów);

        komis.kupionoSamochód(samochód1);
        System.out.println();
        System.out.println("Lista samochodów: " + komis.listaSamochodów);
        System.out.println("Set samochodów: " + komis.setSamochodów);

        System.out.println();
        System.out.println(komis.samochodyMarki("Toyota"));
        System.out.println();
        System.out.println(komis.samochodyMarki("Ford"));
        System.out.println();
        System.out.println(komis.samochodyMarkiIModelu("Jeep", "Renegade"));
        System.out.println();
        System.out.println(komis.samochodyMarkiIModelu("Ford", "Focus"));
        System.out.println();
        System.out.println(komis.samochodyZPrzedziałuLat(2017, 2019));
        System.out.println();
        System.out.println(komis.samochodyDoKwoty(45000));
        System.out.println();
        System.out.println(komis.samochodyDoKwotyJava8(45000));
        System.out.println();
        komis.wypiszDostepneSamochody();
    }
}
