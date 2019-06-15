package sdaCollections.zadania.samochód;

import java.util.ArrayDeque;
import java.util.Queue;

public class Myjnia {

    private Queue<Samochód> kolejkaSamochodów = new ArrayDeque<>();

    public void dodajDoKolejki(Samochód samochód){
        kolejkaSamochodów.add(samochód);
    }

    public void umyjWszystkieSamochody(){
        while (kolejkaSamochodów.peek() != null){
            System.out.println("Został umyty: " + kolejkaSamochodów.poll());
        }
    }

    public static void main(String[] args) {
        Samochód samochód1 = new Samochód("Fiat", "Bravo", 2010, 13000);
        Samochód samochód2 = new Samochód("Jeep", "Renegade", 2017, 40000);
        Samochód samochód3 = new Samochód("Nissan", "X-trail", 2017, 90000);
        Samochód samochód4 = new Samochód("Renault", "Megane", 2018, 75000);
        Samochód samochód5 = new Samochód("Toyota", "Yaris", 2016, 35000);
        Samochód samochód6 = new Samochód("Toyota", "Yaris", 2016, 30000);
        Samochód samochód7 = new Samochód("Toyota", "Yaris", 2016, 31000);

        Myjnia myjnia = new Myjnia();
        myjnia.dodajDoKolejki(samochód1);
        myjnia.dodajDoKolejki(samochód2);
        myjnia.dodajDoKolejki(samochód3);
        myjnia.dodajDoKolejki(samochód4);
        myjnia.dodajDoKolejki(samochód5);
        myjnia.dodajDoKolejki(samochód6);
        myjnia.dodajDoKolejki(samochód7);

        myjnia.umyjWszystkieSamochody();

    }
}
