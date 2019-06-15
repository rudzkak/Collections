package sdaCollections.zadania.pralnia;

import java.util.Objects;

public class Usługa implements Comparable<Usługa>{

    private Klient klient;
    private Ubranie ubranie;

    public Usługa(Klient klient, Ubranie ubranie) {
        this.klient = klient;
        this.ubranie = ubranie;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Ubranie getUbranie() {
        return ubranie;
    }

    public void setUbranie(Ubranie ubranie) {
        this.ubranie = ubranie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usługa usługa = (Usługa) o;
        return Objects.equals(klient, usługa.klient) &&
                Objects.equals(ubranie, usługa.ubranie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(klient, ubranie);
    }

    @Override
    public String toString() {
        return "Usługa{" +
                "klient=" + klient +
                ", ubranie=" + ubranie +
                '}';
    }

    @Override
    public int compareTo(Usługa u) {
        return this.getUbranie().getMateriał()
                .compareTo(u.getUbranie().getMateriał());
    }
}
