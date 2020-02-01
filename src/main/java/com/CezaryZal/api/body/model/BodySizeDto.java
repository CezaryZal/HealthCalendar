package com.CezaryZal.api.body.model;

import com.CezaryZal.api.structure.FormEntityDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@NoArgsConstructor
public class BodySizeDto extends FormEntityDto {

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


    public static Builder builder() {
        return new Builder();
    }

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

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder bodyWeight(int bodyWeight) {
            this.bodyWeight = bodyWeight;
            return this;
        }

        public Builder neckSize(int neckSize) {
            this.neckSize = neckSize;
            return this;
        }

        public Builder armSize(int armSize) {
            this.armSize = armSize;
            return this;
        }

        public Builder bustSize(int bustSize) {
            this.bustSize = bustSize;
            return this;
        }

        public Builder waist(int waist) {
            this.waist = waist;
            return this;
        }

        public Builder hipsSize(int hipsSize) {
            this.hipsSize = hipsSize;
            return this;
        }

        public Builder femoralSize(int femoralSize) {
            this.femoralSize = femoralSize;
            return this;
        }

        public Builder calf(int calf) {
            this.calf = calf;
            return this;
        }

        public Builder dateMeasurement(LocalDate dateMeasurement) {
            this.dateMeasurement = dateMeasurement;
            return this;
        }

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public BodySizeDto buildDto() {
            BodySizeDto bodySizeDto = new BodySizeDto();
            bodySizeDto.id = this.id;
            bodySizeDto.bodyWeight = this.bodyWeight;
            bodySizeDto.neckSize = this.neckSize;
            bodySizeDto.armSize = this.armSize;
            bodySizeDto.bustSize = this.bustSize;
            bodySizeDto.waist = this.waist;
            bodySizeDto.hipsSize = this.hipsSize;
            bodySizeDto.femoralSize = this.femoralSize;
            bodySizeDto.calf = this.calf;
            bodySizeDto.dateMeasurement = this.dateMeasurement;
            bodySizeDto.userId = this.userId;
            return bodySizeDto;
        }
    }
}
