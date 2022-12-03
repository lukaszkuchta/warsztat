package pl.sda.j133.hibernate.warsztat.komendy;

import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.model.Pojazd;
import pl.sda.j133.hibernate.warsztat.model.SerwisPojazdu;

import java.util.List;

public class KomendaListaSerwisPojazdu implements Komenda{
    private DataAccessObject<SerwisPojazdu> dataAccessObject;

    public KomendaListaSerwisPojazdu() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista serwis";
    }

    @Override
    public void obsluga() {
        List<SerwisPojazdu> serwisyPojazdow = dataAccessObject.findAll(SerwisPojazdu.class);
        serwisyPojazdow.forEach(System.out::println);
    }
}
