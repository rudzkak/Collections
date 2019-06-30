package sdaCollections.zadania.praca;

import java.util.Objects;

public class Pracownik {

    private String imie;
    private String nazwisko;
    private Stanowisko stanowisko;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Stanowisko getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(Stanowisko stanowisko) {
        this.stanowisko = stanowisko;
    }

    public Pracownik(String imie, String nazwisko, Stanowisko stanowisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pracownik pracownik = (Pracownik) o;
        return Objects.equals(imie, pracownik.imie) &&
                Objects.equals(nazwisko, pracownik.nazwisko) &&
                stanowisko == pracownik.stanowisko;
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, stanowisko);
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", stanowisko=" + stanowisko +
                '}';
    }
}
