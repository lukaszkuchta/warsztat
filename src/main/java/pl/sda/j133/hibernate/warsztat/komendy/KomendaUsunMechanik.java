package pl.sda.j133.hibernate.warsztat.komendy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.HibernateUtil;
import pl.sda.j133.hibernate.warsztat.model.Mechanik;
import pl.sda.j133.hibernate.warsztat.model.Pojazd;

public class KomendaUsunMechanik implements Komenda{
    private DataAccessObject<Mechanik> dataAccessObject;

    public KomendaUsunMechanik() {
        this.dataAccessObject = new DataAccessObject<>();
    }
    @Override
    public String getKomenda() {
        return "usun mechanik";
    }

    @Override
    public void obsluga() {
        System.out.println("podaj id usuwanego mechanika");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if(dataAccessObject.delate(Mechanik.class, id)){
            System.out.println("usunieto mechanika");
        }else {
            System.err.println("nie udalo sie znalesc mechanika");
        }
    }
}
