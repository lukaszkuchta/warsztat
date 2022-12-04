package pl.sda.j133.hibernate.warsztat.komendy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.HibernateUtil;
import pl.sda.j133.hibernate.warsztat.model.Mechanik;
import pl.sda.j133.hibernate.warsztat.model.Pojazd;

public class KomendaAktualizujMechanik implements Komenda{
    private DataAccessObject<Mechanik> dataAccessObject;

    public KomendaAktualizujMechanik() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "aktualizuj mechanik";
    }

    @Override
    public void obsluga() {
        System.out.println("podaj id mechanika");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if(dataAccessObject.exists(Mechanik.class, id)){
            System.err.println("Mechanik o takim id nie istnieje");
            return;
        }

        System.out.println("Podaj imie mechanika");
        String imie = Komenda.scanner.nextLine();
        System.out.println("Podaj kwalifikacje mechanika");
        String kwalifikacje = Komenda.scanner.nextLine();
        System.out.println("Podaj specjalizacje mechanika");
        String specjalizacja = Komenda.scanner.nextLine();

        Mechanik mechanik = Mechanik.builder()
                .imie(imie)
                .kwalifikacje(kwalifikacje)
                .specjalizacja(specjalizacja)
                .id(id)
                .build();

        dataAccessObject.update(Mechanik.class, id, mechanik);
    }
}
