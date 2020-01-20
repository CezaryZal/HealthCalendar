package com.CezaryZal.api.shortReport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

//Mógłbym otrzymać obiekt na podstawie encji Day, ale w celu wyższej wydajności (m.in.N+1)
//stworzyłem oddzielną encje ShortDay
@Entity
@Table(name = "short_report")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "is_achieved_kcal")
    private boolean isAchievedKcal;

    @Column(name = "is_achieved_drink")
    private boolean isAchievedDrink;

    @Column(name = "is_alcohol")
    private boolean isAlcohol;

    @Column(name = "is_snacks")
    private boolean isSnacks;

}

