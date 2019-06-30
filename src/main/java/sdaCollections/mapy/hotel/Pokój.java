package sdaCollections.mapy.hotel;

import java.util.Objects;

public class Pokój {

    private int numerPokoju;
    private Standard standard;

    public Pokój(int numerPokoju, Standard standard) {
        this.numerPokoju = numerPokoju;
        this.standard = standard;
    }

    public int getNumerPokoju() {
        return numerPokoju;
    }

    public void setNumerPokoju(int numerPokoju) {
        this.numerPokoju = numerPokoju;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokój pokój = (Pokój) o;
        return numerPokoju == pokój.numerPokoju &&
                standard == pokój.standard;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerPokoju, standard);
    }

    @Override
    public String toString() {
        return "Pokój{" +
                "numerPokoju=" + numerPokoju +
                ", standard=" + standard +
                '}';
    }
}
