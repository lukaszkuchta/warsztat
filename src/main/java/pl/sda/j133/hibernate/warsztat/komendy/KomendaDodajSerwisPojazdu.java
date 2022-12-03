package pl.sda.j133.hibernate.warsztat.komendy;

public class KomendaDodajSerwisPojazdu implements Komenda{
    @Override
    public String getKomenda() {
        return "dodaj serwis pojazdu";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj opis");
        String opis = Komenda.scanner.nextLine();
        System.out.println("Podaj zrealizowane czynnosci");
        String zrealizowaneCzynnosci = Komenda.scanner.nextLine();
        System.out.println("Podaj koszt");
        String kosztString = Komenda.scanner.nextLine();
        Double koszt = Double.parseDouble(kosztString);
    }
}
