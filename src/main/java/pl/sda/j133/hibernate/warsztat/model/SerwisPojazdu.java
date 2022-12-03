package pl.sda.j133.hibernate.warsztat.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SerwisPojazdu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String opis;
    private String zrealizowaneCzynnosci;
    private Double koszt;

    @CreationTimestamp
    private LocalDateTime czasDodania;

    private LocalDateTime czasZrealizowania;

    @ManyToOne
    @ToString.Exclude
    private Pojazd pojazd;

    @ManyToOne
    @ToString.Exclude
    private Mechanik mechanik;

}
