package com.CezaryZal.api.limits.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "daily_limits")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class DailyLimits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "kcal_demand")
    @NonNull private int kcalDemandPerDay;

    @Column(name = "drink_demand")
    @NonNull private int drinkDemandPerDay;

    @Column(name = "user_id")
    private Long userId;
}
