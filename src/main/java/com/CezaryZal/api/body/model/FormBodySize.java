package com.CezaryZal.api.body.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@NoArgsConstructor
public abstract class FormBodySize {

    private Long id;
    private int bodyWeight;
    private int neckSize;
    private int armSize;
    private int bustSize;
    private int waist;
    private int hipsSize;
    private int femoralSize;
    private int calf;
    private LocalDate dateMeasurement;
    private Long userId;

    public static final class Builder {
        private Long id;
        private int bodyWeight;
        private int neckSize;
        private int armSize;
        private int bustSize;
        private int waist;
        private int hipsSize;
        private int femoralSize;
        private int calf;
        private LocalDate dateMeasurement;
        private Long userId;

        public static Builder builder(){
            return new Builder();
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder bodyWeight(int bodyWeight){
            this.bodyWeight = bodyWeight;
            return this;
        }
        public Builder neckSize(int neckSize){
            this.neckSize = neckSize;
            return this;
        }
        public Builder armSize(int armSize){
            this.armSize = armSize;
            return this;
        }
        public Builder bustSize(int bustSize){
            this.bustSize = bustSize;
            return this;
        }
        public Builder waist(int waist){
            this.waist = waist;
            return this;
        }
        public Builder hipsSize(int hipsSize){
            this.hipsSize = hipsSize;
            return this;
        }
        public Builder femoralSize(int femoralSize){
            this.femoralSize = femoralSize;
            return this;
        }
        public Builder calf(int calf){
            this.calf = calf;
            return this;
        }
        public Builder dateMeasurement(LocalDate dateMeasurement){
            this.dateMeasurement = dateMeasurement;
            return this;
        }
        public Builder userId(Long userId){
            this.userId = userId;
            return this;
        }

        public FormBodySize buildDto() {
            return passDateToObject(new BodySizeDto());
        }

        private FormBodySize passDateToObject(FormBodySize formBodySize){
            formBodySize.id = this.id;
            formBodySize.bodyWeight = this.bodyWeight;
            formBodySize.neckSize = this.neckSize;
            formBodySize.armSize = this.armSize;
            formBodySize.bustSize = this.bustSize;
            formBodySize.waist = this.waist;
            formBodySize.hipsSize = this.hipsSize;
            formBodySize.femoralSize = this.femoralSize;
            formBodySize.calf = this.calf;
            formBodySize.dateMeasurement = this.dateMeasurement;
            formBodySize.userId = this.userId;
            return formBodySize;
        }
    }
}
