package sdaCollections.zadania.pralnia;

import java.util.Objects;

public class Ubranie {

    private Materiał materiał;
    private String rodzajUbrania;
    private String kolor;

    public Ubranie(Materiał materiał, String rodzajUbrania, String kolor) {
        this.materiał = materiał;
        this.rodzajUbrania = rodzajUbrania;
        this.kolor = kolor;
    }

    public Materiał getMateriał() {
        return materiał;
    }

    public void setMateriał(Materiał materiał) {
        this.materiał = materiał;
    }

    public String getRodzajUbrania() {
        return rodzajUbrania;
    }

    public void setRodzajUbrania(String rodzajUbrania) {
        this.rodzajUbrania = rodzajUbrania;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ubranie ubranie = (Ubranie) o;
        return materiał == ubranie.materiał &&
                Objects.equals(rodzajUbrania, ubranie.rodzajUbrania) &&
                Objects.equals(kolor, ubranie.kolor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(materiał, rodzajUbrania, kolor);
    }

    @Override
    public String toString() {
        return "Ubranie{" +
                "materiał=" + materiał +
                ", rodzajUbrania='" + rodzajUbrania + '\'' +
                ", kolor='" + kolor + '\'' +
                '}';
    }
}
