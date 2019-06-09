package sdaCollections.zadOsoba;

public class RejestrOsóbTest {

    Osoba osoba1 = new Osoba("Kowalski", 20);
    Osoba osoba2 = new Osoba("Nowak", 45);
    Osoba osoba3 = new Osoba("Wallentod", 76);
    Osoba osoba4 = new Osoba("Pająk", 27);
    Osoba osoba5 = new Osoba("Janda", 54);
    Osoba osoba6 = new Osoba("Kamilksa", 34);

    RejestrOsób rejestrOsób = new RejestrOsób();

    public void dodajOsobe(){
        rejestrOsób.dodajOsobe(osoba1);
        rejestrOsób.dodajOsobe(osoba2);
        rejestrOsób.dodajOsobe(osoba3);
        rejestrOsób.dodajOsobe(osoba4);
        rejestrOsób.dodajOsobe(osoba5);
        rejestrOsób.dodajOsobe(osoba6);
        System.out.println("I test: " + rejestrOsób);
    }

    public void usuńOsobe(){
        rejestrOsób.usunOsobe(osoba1);
        System.out.println("II test: " + rejestrOsób);
    }

    public void usuńOsobeBrak(){
        rejestrOsób.usunOsobe(new Osoba("Pietrzk", 24));
        System.out.println("III test: " + rejestrOsób);
    }

    public void wypiszListe(){
        System.out.println("IV test: ");
        rejestrOsób.wypiszListe();
    }

    public void znajdzOsobe(){
        System.out.println("V test: " );
        System.out.println(rejestrOsób.znajdzOsobe("Wallentod"));
    }

    public void znajdzOsobeBrak(){
        System.out.println("VI test: ");
        System.out.println(rejestrOsób.znajdzOsobe("Wallenrod"));
    }

    public void avg(){
        System.out.println("VII test: " + rejestrOsób.avg());
    }


    public void min(){
        System.out.println("VIII test: " + rejestrOsób.min());
    }

    public void max(){
        System.out.println("IX test: " + rejestrOsób.max());
    }
    public static void main(String[] args) {
        RejestrOsóbTest rejestrOsóbTest = new RejestrOsóbTest();
        rejestrOsóbTest.dodajOsobe();
        rejestrOsóbTest.usuńOsobe();
        rejestrOsóbTest.usuńOsobeBrak();
        rejestrOsóbTest.wypiszListe();
        rejestrOsóbTest.znajdzOsobe();
        rejestrOsóbTest.znajdzOsobeBrak();
        rejestrOsóbTest.avg();
        rejestrOsóbTest.min();
        rejestrOsóbTest.max();
    }


}
