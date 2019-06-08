package sdaCollections.biblioteka;

public class Książka {

    private String tytuł;
    private String autor;

    public Książka(String tytuł, String autor) {
        this.tytuł = tytuł;
        this.autor = autor;
    }

    public String getTytuł() {
        return tytuł;
    }

    public void setTytuł(String tytuł) {
        this.tytuł = tytuł;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Książka{" +
                "tytuł='" + tytuł + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
