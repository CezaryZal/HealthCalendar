package com.CezaryZal.bodySize;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "body_size")
public class BodySize {

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

    public BodySize() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBodyWeight() {
        return bodyWeight;
    }

    public void setBodyWeight(int bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public int getNeckSize() {
        return neckSize;
    }

    public void setNeckSize(int neckSize) {
        this.neckSize = neckSize;
    }

    public int getArmSize() {
        return armSize;
    }

    public void setArmSize(int armSize) {
        this.armSize = armSize;
    }

    public int getBustSize() {
        return bustSize;
    }

    public void setBustSize(int bustSize) {
        this.bustSize = bustSize;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public int getHipsSize() {
        return hipsSize;
    }

    public void setHipsSize(int hipsSize) {
        this.hipsSize = hipsSize;
    }

    public int getFemoralSize() {
        return femoralSize;
    }

    public void setFemoralSize(int femoralSize) {
        this.femoralSize = femoralSize;
    }

    public int getCalf() {
        return calf;
    }

    public void setCalf(int calf) {
        this.calf = calf;
    }

    public LocalDate getDateMeasurement() {
        return dateMeasurement;
    }

    public void setDateMeasurement(LocalDate date) {
        this.dateMeasurement = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BodySize{" +
                "id=" + id +
                ", bodyWeight=" + bodyWeight +
                ", neckSize=" + neckSize +
                ", armSize=" + armSize +
                ", bustSize=" + bustSize +
                ", waist=" + waist +
                ", hipsSize=" + hipsSize +
                ", femoralSize=" + femoralSize +
                ", calf=" + calf +
                ", dateMeasurement=" + dateMeasurement +
                ", userId=" + userId +
                '}';
    }
}
