package com.CezaryZal.api.limits.model.entity;

import com.CezaryZal.api.limits.model.LimitsCleanDate;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "daily_limits")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@SqlResultSetMapping(
        name="ResultToLimits",
        classes = {
                @ConstructorResult(
                        targetClass = LimitsCleanDate.class,
                        columns = {
                                @ColumnResult(name="kcal_demand", type = Integer.class),
                                @ColumnResult(name="drink_demand", type = Integer.class)

                        })
        })
@NamedNativeQuery(
        name = "Result_for_daily_limits",
        query = "select dl.kcal_demand, dl.drink_demand from daily_limits AS dl where dl.user_id=:inputUserId",
        resultSetMapping = "ResultToLimits"
)
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
