package sdaCollections.helpdesk;

import java.util.Objects;

public class Zgłoszenie {

    private final Klient klient;
    private final Kategoria kategoria;

    public Zgłoszenie(Klient klient, Kategoria kategoria) {
        this.klient = klient;
        this.kategoria = kategoria;
    }

    public Klient getKlient() {
        return klient;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zgłoszenie that = (Zgłoszenie) o;
        return Objects.equals(klient, that.klient) &&
                kategoria == that.kategoria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(klient, kategoria);
    }

    @Override
    public String toString() {
        return "Zgłoszenie{" +
                "klient=" + klient +
                ", kategoria=" + kategoria +
                '}';
    }
}
