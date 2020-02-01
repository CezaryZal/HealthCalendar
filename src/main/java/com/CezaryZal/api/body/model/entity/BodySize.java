package com.CezaryZal.api.body.model.entity;

import com.CezaryZal.api.structure.FormEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "body_size")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BodySize implements FormEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "body_weight")
    private int bodyWeight;

    @Column(name = "neck_size")
    private int neckSize;

    @Column(name = "arm_size")
    private int armSize;

    @Column(name = "bust_size")
    private int bustSize;

    @Column(name = "waist")
    private int waist;

    @Column(name = "hips_size")
    private int hipsSize;

    @Column(name = "femoral_size")
    private int femoralSize;

    @Column(name = "calf")
    private int calf;

    //    @NotBlank
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    //Spring Boot change automation date type, but use this annotation to show it
//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "date")
    private LocalDate dateMeasurement;

    @Column(name = "user_id")
    private Long userId;


    public static Builder builder(){
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

        public BodySize build() {
            BodySize bodySize = new BodySize();
            bodySize.id = this.id;
            bodySize.bodyWeight = this.bodyWeight;
            bodySize.neckSize = this.neckSize;
            bodySize.armSize = this.armSize;
            bodySize.bustSize = this.bustSize;
            bodySize.waist = this.waist;
            bodySize.hipsSize = this.hipsSize;
            bodySize.femoralSize = this.femoralSize;
            bodySize.calf = this.calf;
            bodySize.dateMeasurement = this.dateMeasurement;
            bodySize.userId = this.userId;
            return bodySize;
        }
    }
}
