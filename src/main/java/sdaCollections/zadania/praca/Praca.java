package sdaCollections.zadania.praca;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Praca {

    private Map<Stanowisko, List<Zadania>> zadaniaNaStanowisku = new HashMap<>();

    public void dodajZadanieNaStanowisko(Stanowisko stanowisko, Zadania zadania){
        List<Zadania> listaZadan = new ArrayList<>();
        if(zadaniaNaStanowisku.containsKey(stanowisko)){
            zadaniaNaStanowisku.get(stanowisko).add(zadania);
        } else{
            listaZadan.add(zadania);
            zadaniaNaStanowisku.put(stanowisko,listaZadan);
        }
    }

    public void usńZadanieZeStanowiska(Stanowisko stanowisko, Zadania zadania){
        if(zadaniaNaStanowisku.containsKey(stanowisko)){
            zadaniaNaStanowisku.get(stanowisko).remove(zadania);
        }
    }

    public void wypiszZadaniaNaStanowisku(Stanowisko stanowisko){
        if(zadaniaNaStanowisku.containsKey(stanowisko)){
            List<Zadania> listaZadań = zadaniaNaStanowisku.get(stanowisko);
            System.out.println("Lista zadań na stanowisku " + stanowisko + " : ");
            for(Zadania zadanie : listaZadań){
                System.out.println(zadanie);
            }
        }
    }

    public List<Zadania> zwrocListeZadanPracownika(Pracownik pracownik){
        List<Zadania> listaZadan = new ArrayList<>();
        if(zadaniaNaStanowisku.containsKey(pracownik.getStanowisko())){
            listaZadan = zadaniaNaStanowisku.get(pracownik.getStanowisko());
        } else{
            System.out.println("Do tego stanowiska nie ma przypisanych zadań");
        }
        return listaZadan;
    }

    public static void main(String[] args) {
        Praca praca = new Praca();

        Pracownik pracownik1 = new Pracownik("Jan", "Nowak", Stanowisko.KIEROWCA);
        Pracownik pracownik2 = new Pracownik("Zenon", "Zet", Stanowisko.PRACOWNIK_MAGAZYNU);

        praca.dodajZadanieNaStanowisko(Stanowisko.KOORDYNATOR_PLACÓWKI, Zadania.PRZYJMOWANIE_NOWYCH_PRACOWNIKÓW);
        praca.dodajZadanieNaStanowisko(Stanowisko.KOORDYNATOR_PLACÓWKI, Zadania.ROZWIĄZYWANIE_KONFLIKTÓW);
        praca.dodajZadanieNaStanowisko(Stanowisko.KIEROWCA, Zadania.DOSTARCZANIE_PACZEK);
        praca.dodajZadanieNaStanowisko(Stanowisko.KIEROWCA, Zadania.ODBIERANIE_PACZEK);
        praca.dodajZadanieNaStanowisko(Stanowisko.KIEROWCA, Zadania.LADOWANIE_SAMOCHODU);

        praca.zadaniaNaStanowisku.forEach((stanowisko, zadania) ->
                System.out.println(stanowisko + "->" + zadania));

        praca.usńZadanieZeStanowiska(Stanowisko.KIEROWCA, Zadania.LADOWANIE_SAMOCHODU);

        praca.zadaniaNaStanowisku.forEach((stanowisko, zadania) ->
                System.out.println(stanowisko + "->" + zadania));

        praca.wypiszZadaniaNaStanowisku(Stanowisko.KOORDYNATOR_PLACÓWKI);

        System.out.println("----");
        System.out.println(praca.zwrocListeZadanPracownika(pracownik1));
    }
}
