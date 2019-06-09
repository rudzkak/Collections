package sdaCollections.helpdesk;

import java.util.Objects;

public class Klient {

    private String imie;
    private String płeć;

    public Klient(String imie, String płeć) {
        this.imie = imie;
        this.płeć = płeć;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getPłeć() {
        return płeć;
    }

    public void setPłeć(String płeć) {
        this.płeć = płeć;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klient klient = (Klient) o;
        return Objects.equals(imie, klient.imie) &&
                Objects.equals(płeć, klient.płeć);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, płeć);
    }

    @Override
    public String toString() {
        return "Klient{" +
                "imie='" + imie + '\'' +
                ", płeć='" + płeć + '\'' +
                '}';
    }

    public void odpowiedz(String wiadomość){
        System.out.println(imie + ":" + wiadomość);
    }

    public static final Klient JACEK = new Klient("Jacek", "M");
    public static final Klient AGNIESZKA = new Klient("Agnieszka", "K");
    public static final Klient AGATA = new Klient("Agata", "K");
}
