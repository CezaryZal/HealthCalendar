package com.CezaryZal.api.report.shortened.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

//Mógłbym otrzymać obiekt na podstawie encji Day, ale w celu wyższej wydajności (m.in.N+1)
//stworzyłem oddzielną encje ShortReport
@Entity
@Table(name = "short_report")
@Data
@NoArgsConstructor
public class ShortReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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


    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder{
        private Long id;
        private LocalDate date;
        private boolean isAchievedKcal;
        private boolean isAchievedDrink;
        private boolean isAlcohol;
        private boolean isSnacks;

        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder date(LocalDate date){
            this.date = date;
            return this;
        }
        public Builder isAchievedKcal(boolean isAchievedKcal){
            this.isAchievedKcal = isAchievedKcal;
            return this;
        }
        public Builder isAchievedDrink(boolean isAchievedDrink){
            this.isAchievedDrink = isAchievedDrink;
            return this;
        }
        public Builder isAlcohol(boolean isAlcohol){
            this.isAlcohol = isAlcohol;
            return this;
        }
        public Builder isSnacks(boolean isSnacks){
            this.isSnacks = isSnacks;
            return this;
        }

        public ShortReport build(){
            ShortReport shortReport = new ShortReport();
            shortReport.id = this.id;
            shortReport.date = this.date;
            shortReport.isAchievedKcal = this.isAchievedKcal;
            shortReport.isAchievedDrink = this.isAchievedDrink;
            shortReport.isAlcohol = this.isAlcohol;
            shortReport.isSnacks = this.isSnacks;
            return shortReport;
        }
    }
}

