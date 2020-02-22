package com.CezaryZal.api.limits.model.entity;

import com.CezaryZal.api.limits.model.DefaultDailyLimits;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "daily_limits")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
//@SqlResultSetMapping(
//        name="ResultToLimits",
//        classes = {
//                @ConstructorResult(
//                        targetClass = DefaultDailyLimits.class,
//                        columns = {
//                                @ColumnResult(name="kcal_demand", type = Integer.class),
//                                @ColumnResult(name="drink_demand", type = Integer.class)
//
//                        })
//        })
//@NamedNativeQuery(
//        name = "Result_for_daily_limits",
//        query = "SELECT dl.kcal_demand, dl.drink_demand FROM daily_limits AS dl, user AS u " +
//                "WHERE  dl.id = u.daily_limits_id AND u.id=:inputUserId",
//        resultSetMapping = "ResultToLimits"
//)
public class DailyLimits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "kcal_demand")
    @NonNull private int kcalDemandPerDay;

    @Column(name = "drink_demand")
    @NonNull private int drinkDemandPerDay;
}
