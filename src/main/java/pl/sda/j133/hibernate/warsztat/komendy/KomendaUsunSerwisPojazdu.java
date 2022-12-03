package pl.sda.j133.hibernate.warsztat.komendy;

import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.model.Pojazd;
import pl.sda.j133.hibernate.warsztat.model.SerwisPojazdu;

public class KomendaUsunSerwisPojazdu implements Komenda{
    private DataAccessObject<SerwisPojazdu> dataAccessObject;

    public KomendaUsunSerwisPojazdu() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun serwis";
    }

    @Override
    public void obsluga() {
        System.out.println("podaj id usuwanego serwisu");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if(dataAccessObject.delate(SerwisPojazdu.class, id)){
            System.out.println("usunieto serwis");
        }else {
            System.err.println("nie udalo sie znalesc serwisu");
        }
    }
}
