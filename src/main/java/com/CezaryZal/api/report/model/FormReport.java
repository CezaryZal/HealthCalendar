package com.CezaryZal.api.report.model;

import com.CezaryZal.api.meal.model.DailyDiet;
import com.CezaryZal.api.note.model.Header;
import com.CezaryZal.api.report.shortened.model.ShortReportDto;
import com.CezaryZal.api.training.model.TrainingsSummary;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@ToString
@Getter
@NoArgsConstructor
public abstract class FormReport {

    private Long id;
    private LocalDate date;
    private Long userId;
    private int portionsDrink;
    private int portionsAlcohol;
    private int portionsSnack;
    private String nick;
    private String lastDateMeasureBody;
    private boolean isAchievedDrink;
    private boolean isAchievedKcal;
    private DailyDiet dailyDiet;
    private TrainingsSummary trainings;
    private List<Header> listHeaders;
    private List<ShortReportDto> listShortsDayDto;

    public static final class Builder{
        private Long id;
        private LocalDate date;
        private Long userId;
        private int portionsDrink;
        private int portionsAlcohol;
        private int portionsSnack;
        private String nick;
        private String lastDateMeasureBody;
        private boolean isAchievedDrink;
        private boolean isAchievedKcal;
        private DailyDiet dailyDiet;
        private TrainingsSummary trainings;
        private List<Header> listHeaders;
        private List<ShortReportDto> listShortsDayDto;

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
        public Builder userId(Long userId){
            this.userId = userId;
            return this;
        }
        public Builder portionsDrink(int portionsDrink){
            this.portionsDrink = portionsDrink;
            return this;
        }
        public Builder portionsAlcohol(int portionsAlcohol){
            this.portionsAlcohol = portionsAlcohol;
            return this;
        }
        public Builder portionsSnack(int portionsSnack){
            this.portionsSnack = portionsSnack;
            return this;
        }
        public Builder nick(String nick){
            this.nick = nick;
            return this;
        }
        public Builder isAchievedDrink(boolean isAchievedDrink){
            this.isAchievedDrink = isAchievedDrink;
            return this;
        }
        public Builder lastDateMeasureBody(String lastDateMeasureBody){
            this.lastDateMeasureBody = lastDateMeasureBody;
            return this;
        }
        public Builder isAchievedKcal(boolean isAchievedKcal){
            this.isAchievedKcal = isAchievedKcal;
            return this;
        }
        public Builder dailyDiet(DailyDiet dailyDiet){
            this.dailyDiet = dailyDiet;
            return this;
        }
        public Builder trainings(TrainingsSummary trainings){
            this.trainings = trainings;
            return this;
        }
        public Builder listHeaders(List<Header> listHeaders) {
            this.listHeaders = listHeaders;
            return this;
        }
        public Builder listShortsDayDto(List<ShortReportDto> listShortsDayDto){
            this.listShortsDayDto = listShortsDayDto;
            return this;
        }

        public FormReport buildReport(){
            FormReport formReport = new Report();
            return passDataToCreateFormReport(formReport);
        }

        public FormReport buildLongReport(){
            FormReport formReport = new LongReport();
            formReport.dailyDiet = this.dailyDiet;
            formReport.trainings = this.trainings;
            formReport.listHeaders = this.listHeaders;
            formReport.listShortsDayDto = this.listShortsDayDto;
            return passDataToCreateFormReport(formReport);
        }

        private FormReport passDataToCreateFormReport(FormReport formReport){
            formReport.id = this.id;
            formReport.date = this.date;
            formReport.userId = this.userId;
            formReport.portionsDrink = this.portionsDrink;
            formReport.portionsAlcohol = this.portionsAlcohol;
            formReport.portionsSnack = this.portionsSnack;
            formReport.nick = this.nick;
            formReport.lastDateMeasureBody = this.lastDateMeasureBody;
            formReport.isAchievedDrink = this.isAchievedDrink;
            formReport.isAchievedKcal = this.isAchievedKcal;
            return formReport;
        }
    }
}
