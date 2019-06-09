package sdaCollections.zadania.hashset;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class HashSetLearn {

    SortedSet<Osoba> setOsob = new TreeSet<>(Osoba.BY_WIEK);

    public void dodajOsobe(Osoba osoba) {
        setOsob.add(osoba);
    }

    public void usuńOsobe(Osoba osoba) {
        if (setOsob.contains(osoba)) {
            setOsob.remove(osoba);
        } else {
            System.out.println("Takiej osoby nie ma w secie");
        }
    }

    public Set<Osoba> zwróćSeta(int wiekOd, int wiekDo) {

        if (wiekOd < wiekDo) {
            Osoba osobaOd = null;
            Osoba osobaDo = null;

            for (Osoba osoba : setOsob) {
                if (osoba.getWiek() >= wiekOd) {
                    osobaOd = osoba;
                    break;
                }
            }
            if (osobaOd == null) {
                System.out.println("W secie nie ma osoby starszej niż podany wiek");
            }

            for (Osoba osoba : setOsob) {
                if (osoba.getWiek() <= wiekDo) {
                    osobaDo = osoba;
                }
            }
//            Set<Osoba> set = new TreeSet<>(Osoba.BY_WIEK);
//            for(Osoba osoba : setOsob){
//                if(osoba.getWiek()>= osobaOd.getWiek()
//                && osoba.getWiek() <= osobaDo.getWiek()){
//                    set.add(osoba);
//                }
//            }


            return setOsob.subSet(osobaOd, osobaDo);
            //return set;
        } else {
            System.out.println("Błędne dane wejściowe");
            return null;
        }
    }

    public void usuńZSeta(Set<Osoba> set){

        setOsob.removeAll(set);
    }

    public String toString() {
        return setOsob.toString();
    }
}
