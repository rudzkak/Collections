package sdaCollections.mapy.hotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class Hotel {

    public static final int NIE_MA_TAKIEGO_POKOJU = -1;
    private String nazwa;
    private String miasto;
    private Map<Pokój, Gość> mapaPokoi = new HashMap<>();

    public static final Gość DEFAULT = new Gość("nikt", "ważny");

    public Hotel(String nazwa, String miasto) {
        this.nazwa = nazwa;
        this.miasto = miasto;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public Map<Pokój, Gość> getMapaPokoi() {
        return mapaPokoi;
    }

    public void setMapaPokoi(Map<Pokój, Gość> mapaPokoi) {
        this.mapaPokoi = mapaPokoi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(nazwa, hotel.nazwa) &&
                Objects.equals(miasto, hotel.miasto) &&
                Objects.equals(mapaPokoi, hotel.mapaPokoi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, miasto, mapaPokoi);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nazwa='" + nazwa + '\'' +
                ", miasto='" + miasto + '\'' +
                ", mapaPokoi=" + mapaPokoi +
                '}';
    }

    public void zameldujGościa(Pokój pokój, Gość gość){
        mapaPokoi.put(pokój,gość);
    }

    public void wymeldujGościa(Pokój pokój){
        mapaPokoi.put(pokój, DEFAULT);
    }

    public Gość znajdźGościaPoNrPokoju(int numerPokoju){
        for(Map.Entry<Pokój, Gość> wpis : mapaPokoi.entrySet()){
            if(wpis.getKey().getNumerPokoju() == numerPokoju){
                return wpis.getValue();
            }
        }
        return null;
    }

    public Optional<Gość> znajdźGościaPoNrPokojuJava8(int numerPokoju){
        return mapaPokoi.entrySet().stream()
                .filter(wpis-> wpis.getKey().getNumerPokoju() == numerPokoju)
                .findAny().map(wpis-> wpis.getValue());
    }

    public int znajdzNrPokojuPoNazwisku(String nazwisko){
        for(Map.Entry<Pokój, Gość> wpis : mapaPokoi.entrySet()){
            if(wpis.getValue().getNazwisko().equals(nazwisko)){
                return wpis.getKey().getNumerPokoju();
            }
        }
        return NIE_MA_TAKIEGO_POKOJU;
    }

    public List<Pokój> wolnePokojeWStandardzie(Standard standard){
        List<Pokój> lista = new ArrayList<>();
        for(Map.Entry<Pokój,Gość> wpis : mapaPokoi.entrySet()){
            if(wpis.getKey().getStandard().equals(standard)
            && wpis.getValue().equals(DEFAULT)){
                lista.add(wpis.getKey());
            }
        }
        return lista;
    }


    public static void main(String[] args) {
        Pokój pokójPodstawa1 = new Pokój(1, Standard.PODSTAWOWY);
        Pokój pokójPodstawa2 = new Pokój(2, Standard.PODSTAWOWY);
        Pokój pokójPodstawa3 = new Pokój(3, Standard.PODSTAWOWY);
        Pokój pokójPodstawa4 = new Pokój(4, Standard.PODSTAWOWY);
        Pokój pokójPodstawa5 = new Pokój(5, Standard.PODSTAWOWY);
        Pokój pokójPodwyższony1 = new Pokój(6, Standard.PODWYŻSZONY);
        Pokój pokójPodwyższony2 = new Pokój(7, Standard.PODWYŻSZONY);
        Pokój pokójPodwyższony3 = new Pokój(8, Standard.PODWYŻSZONY);
        Pokój pokójApartament1 = new Pokój(9, Standard.APARTAMENT);
        Pokój pokójApartament2 = new Pokój(10, Standard.APARTAMENT);

        Gość janNowak = new Gość("Jan", "Nowak");
        Gość krystynaJanda = new Gość("Krystyna", "Janda");
        Gość zenonZet = new Gość("Zenon", "Zet");
        Gość padTad = new Gość("Pad", "Tad");
        Gość jackJoe = new Gość("Jack", "Joe");
        Gość flipFlap = new Gość("Flip", "Flap");

        Hotel hotel = new Hotel("Ibis", "Kraków");

        hotel.mapaPokoi.put(pokójPodstawa1, DEFAULT);
        hotel.mapaPokoi.put(pokójPodstawa2, DEFAULT);
        hotel.mapaPokoi.put(pokójPodstawa3, DEFAULT);
        hotel.mapaPokoi.put(pokójPodstawa4, DEFAULT);
        hotel.mapaPokoi.put(pokójPodstawa5, DEFAULT);
        hotel.mapaPokoi.put(pokójPodwyższony1, DEFAULT);
        hotel.mapaPokoi.put(pokójPodwyższony2, DEFAULT);
        hotel.mapaPokoi.put(pokójPodwyższony3, DEFAULT);
        hotel.mapaPokoi.put(pokójApartament1, DEFAULT);
        hotel.mapaPokoi.put(pokójApartament2, DEFAULT);

        hotel.mapaPokoi.forEach(((pokój, gość) ->
                System.out.println(pokój + "->" + gość)));

        System.out.println();
        hotel.zameldujGościa(pokójApartament1, jackJoe);
        hotel.zameldujGościa(pokójPodstawa2, janNowak);
        hotel.zameldujGościa(pokójPodwyższony3, krystynaJanda);
        hotel.zameldujGościa(pokójPodstawa5, zenonZet);
        hotel.zameldujGościa(pokójApartament2, flipFlap);
        hotel.zameldujGościa(pokójPodstawa3, padTad);

        hotel.mapaPokoi.forEach(((pokój, gość) ->
                System.out.println(pokój + "->" + gość)));

        System.out.println();

        hotel.wymeldujGościa(pokójApartament1);

        hotel.mapaPokoi.forEach(((pokój, gość) ->
                System.out.println(pokój + "->" + gość)));

        System.out.println();

        System.out.println(hotel.znajdźGościaPoNrPokoju(5));
        System.out.println();

        Optional<Gość> wynik = hotel.znajdźGościaPoNrPokojuJava8(5);
        if(wynik.isPresent()){
            System.out.println(wynik.get());
        }

        System.out.println();

        System.out.println(hotel.znajdzNrPokojuPoNazwisku("Nowak"));
        System.out.println();

        System.out.println(hotel.wolnePokojeWStandardzie(Standard.PODSTAWOWY));
    }
}
