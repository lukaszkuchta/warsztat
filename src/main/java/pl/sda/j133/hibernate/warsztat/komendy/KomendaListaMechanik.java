package pl.sda.j133.hibernate.warsztat.komendy;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.HibernateUtil;
import pl.sda.j133.hibernate.warsztat.model.Mechanik;
import pl.sda.j133.hibernate.warsztat.model.Pojazd;

import java.util.List;

public class KomendaListaMechanik implements Komenda{
    private DataAccessObject<Mechanik> dataAccessObject;

    public KomendaListaMechanik() {
        this.dataAccessObject = new DataAccessObject<>();
    }
    @Override
    public String getKomenda() {
        return "lista mechanik";
    }

    @Override
    public void obsluga() {
        List<Mechanik> mechanicy = dataAccessObject.findAll(Mechanik.class);
        mechanicy.forEach(System.out::println);
    }
}
