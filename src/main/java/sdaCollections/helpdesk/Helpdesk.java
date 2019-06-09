package sdaCollections.helpdesk;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Predicate;

public class Helpdesk {

    //FIFO
    private final Queue <Zgłoszenie> zgłoszenia = new ArrayDeque<>();

    public void zgłoszenie(final Klient klient, final Kategoria kategoria){
        zgłoszenia.offer(new Zgłoszenie(klient,kategoria));
    }

    public void procesujWszystkieZgłoszenia(){
        Zgłoszenie zgłoszenie;

        while ((zgłoszenie = zgłoszenia.poll()) != null){
            if(zgłoszenie.getKlient().getPłeć().equals("M")){
                zgłoszenie.getKlient().odpowiedz("Czy próbowałeś włączyć i wyłączyć?");
            } else {
                zgłoszenie.getKlient().odpowiedz("Czy próbowałaś włączyć i wyłączyć?");
            }
        }
    }

    public void procesujZgłoszeniaDrukarek(){
        String wiadomość = "Czy nie skończył się papier?";
        Predicate<Zgłoszenie> warunek = (z -> z.getKategoria() == Kategoria.DRUKARKA);

        procesujZgłoszenie(wiadomość, warunek);
    }

    public void procesujZgłoszeniaGeneralne(){
        String wiadomość = "Czy próbowałeś/aś włączyć i wyłączyć?";
        Predicate<Zgłoszenie> warunek = (z -> z.getKategoria() != Kategoria.DRUKARKA);

        procesujZgłoszenie(wiadomość, warunek);
    }

    public void procesujZgłoszenie(String wiadomość, Predicate<Zgłoszenie> warunek) {
        final Zgłoszenie zgłoszenie = zgłoszenia.peek();
        if (zgłoszenie != null && warunek.test(zgłoszenie)) {
            zgłoszenia.remove();
            zgłoszenie.getKlient().odpowiedz(wiadomość);
        } else {
            System.out.println("Nie ma zgłoszeń");
        }
    }


    public static void main(String[] args) {
        Helpdesk helpdesk = new Helpdesk();

        helpdesk.zgłoszenie(Klient.AGATA, Kategoria.KOMPUTER);
        helpdesk.zgłoszenie(Klient.AGNIESZKA, Kategoria.DRUKARKA);
        helpdesk.zgłoszenie(Klient.JACEK, Kategoria.KOMPUTER);

        //helpdesk.procesujWszystkieZgłoszenia();

        helpdesk.procesujZgłoszeniaDrukarek();
        helpdesk.procesujZgłoszeniaGeneralne();
        helpdesk.procesujZgłoszeniaDrukarek();
        helpdesk.procesujZgłoszeniaGeneralne();
    }




}
