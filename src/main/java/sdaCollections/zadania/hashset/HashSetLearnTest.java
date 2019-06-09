package sdaCollections.zadania.hashset;



public class HashSetLearnTest {

    Osoba osoba1 = new Osoba("Jan","Kowalski", 20);
    Osoba osoba2 = new Osoba("Paweł","Nowak", 45);
    Osoba osoba3 = new Osoba("Konrad","Wallentod", 76);
    Osoba osoba4 = new Osoba("Krzysztof","Pająk", 27);
    Osoba osoba5 = new Osoba("Krystyna","Janda", 54);
    Osoba osoba6 = new Osoba("Kamila","Kamilksa", 34);

    HashSetLearn hashSetLearn = new HashSetLearn();

    public void dodajOsobe(){
        hashSetLearn.dodajOsobe(osoba1);
        hashSetLearn.dodajOsobe(osoba1);
        hashSetLearn.dodajOsobe(osoba2);
        hashSetLearn.dodajOsobe(osoba3);
        hashSetLearn.dodajOsobe(osoba4);
        hashSetLearn.dodajOsobe(osoba5);
        hashSetLearn.dodajOsobe(osoba6);
        hashSetLearn.dodajOsobe(osoba6);

        System.out.println("I test: " + hashSetLearn);
    }

    public void usuńOsobe(){
        hashSetLearn.usuńOsobe(osoba1);
        System.out.println("II test: " + hashSetLearn);
    }

    public void zwróćSeta(){
        System.out.println("III test: "
                + hashSetLearn.zwróćSeta(40,70));
    }

    public void usuńZSeta(){
        hashSetLearn.usuńZSeta(hashSetLearn.zwróćSeta(40,70));
        System.out.println("IV test: " + hashSetLearn.setOsob);
    }

    public static void main(String[] args) {
        HashSetLearnTest hashSetLearnTest = new HashSetLearnTest();
        hashSetLearnTest.dodajOsobe();
        hashSetLearnTest.usuńOsobe();
        hashSetLearnTest.zwróćSeta();
        hashSetLearnTest.usuńZSeta();
    }
}
