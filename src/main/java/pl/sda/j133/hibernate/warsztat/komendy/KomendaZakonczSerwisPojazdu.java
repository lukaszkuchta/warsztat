package pl.sda.j133.hibernate.warsztat.komendy;

import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.model.Pojazd;
import pl.sda.j133.hibernate.warsztat.model.SerwisPojazdu;

import java.time.LocalDateTime;
import java.util.Optional;

public class KomendaZakonczSerwisPojazdu implements Komenda {
    private DataAccessObject<SerwisPojazdu> dataAccessObject;

    public KomendaZakonczSerwisPojazdu() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "zakoncz serwis";
    }

    @Override
    public void obsluga() {
        System.out.println("podaj id serwisu");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        Optional<SerwisPojazdu> serwisPojazduOptional = dataAccessObject.find(SerwisPojazdu.class, id);
        if (serwisPojazduOptional.isEmpty()) {
            System.err.println("Serwis o takim id nie istnieje");
            return;
        }
        SerwisPojazdu oryginalnySeriwsPojazdu = serwisPojazduOptional.get();

        System.out.println("podaj zrealizowane czynnosci");
        String czynnosci = Komenda.scanner.nextLine();
        System.out.println("podaj koszt serwisu");
        String kosztString = Komenda.scanner.nextLine();
        Double koszt = Double.parseDouble(kosztString);

        SerwisPojazdu serwisPojazdu = SerwisPojazdu.builder()
                .czasZrealizowania(LocalDateTime.now())
                .zrealizowaneCzynnosci(czynnosci)
                .koszt(koszt)
                .opis(oryginalnySeriwsPojazdu.getOpis())
                .czasDodania(oryginalnySeriwsPojazdu.getCzasDodania())
                .id(id)
                .build();

        dataAccessObject.update(SerwisPojazdu.class, id, serwisPojazdu);
    }
}
