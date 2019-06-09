package sdaCollections.helpdesk;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HelpdeskPriority {

    private static final Comparator<Zgłoszenie> WG_KATEGORII = new Comparator<Zgłoszenie>() {
        @Override
        public int compare(Zgłoszenie z1, Zgłoszenie z2) {
            return z1.getKategoria().compareTo(z2.getKategoria());
        }
    };

    //Priority
    private final Queue<Zgłoszenie> zgłoszenia = new PriorityQueue<>(WG_KATEGORII);

    public void zgłoszenie(final Klient klient, final Kategoria kategoria) {
        zgłoszenia.offer(new Zgłoszenie(klient, kategoria));
    }

    public void procesujWszystkieZgłoszenia() {
        Zgłoszenie zgłoszenie;

        while ((zgłoszenie = zgłoszenia.poll()) != null) {
            if (zgłoszenie.getKlient().getPłeć().equals("M")) {
                zgłoszenie.getKlient().odpowiedz("Czy próbowałeś włączyć i wyłączyć?");
            } else {
                zgłoszenie.getKlient().odpowiedz("Czy próbowałaś włączyć i wyłączyć?");
            }
        }
    }


    public static void main(String[] args) {
        HelpdeskPriority helpdesk = new HelpdeskPriority();

        helpdesk.zgłoszenie(Klient.JACEK, Kategoria.TELEFON);
        helpdesk.zgłoszenie(Klient.AGATA, Kategoria.KOMPUTER);
        helpdesk.zgłoszenie(Klient.AGNIESZKA, Kategoria.DRUKARKA);
        helpdesk.zgłoszenie(Klient.JACEK, Kategoria.KOMPUTER);

        helpdesk.procesujWszystkieZgłoszenia();

    }


}

