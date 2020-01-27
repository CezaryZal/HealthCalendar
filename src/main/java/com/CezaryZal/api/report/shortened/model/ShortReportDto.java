package com.CezaryZal.api.report.shortened.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@NoArgsConstructor
public class ShortReportDto {

    private Long id;
    private LocalDate date;
    private boolean isAchievedKcal;
    private boolean isAchievedDrink;
    private boolean isAlcohol;
    private boolean isSnacks;

    public static final class Builder{
        private Long id;
        private LocalDate date;
        private boolean isAchievedKcal;
        private boolean isAchievedDrink;
        private boolean isAlcohol;
        private boolean isSnacks;

        public static Builder builder(){
            return new Builder();
        }

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

        public ShortReportDto build(){
            ShortReportDto shortReportDto = new ShortReportDto();
            shortReportDto.id = this.id;
            shortReportDto.date = this.date;
            shortReportDto.isAchievedKcal = this.isAchievedKcal;
            shortReportDto.isAchievedDrink = this.isAchievedDrink;
            shortReportDto.isAlcohol = this.isAlcohol;
            shortReportDto.isSnacks = this.isSnacks;
            return shortReportDto;
        }
    }
}
