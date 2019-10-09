package com.CezaryZal.bodySize;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "body_size")
public class BodySize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

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
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "user_id")
    private int userId;

//    {
//        "bodyWeight": 12,
//            "neckSize": 22,
//            "armSize": 32,
//            "bustSize": 42,
//            "waist": 52,
//            "femoralSize": 72,
//            "calf": 82,
//            "date": [
//        2018,
//                5,
//                3
//],
//        "userId": 2,
//            "hipSize": 62
//    }

    public BodySize() {
    }

    public BodySize(int bodyWeight, int neckSize, int armSize, int bustSize, int waist, int hipsSize,
                    int femoralSize, int calf, LocalDate date, int userId) {
        this.bodyWeight = bodyWeight;
        this.neckSize = neckSize;
        this.armSize = armSize;
        this.bustSize = bustSize;
        this.waist = waist;
        this.hipsSize = hipsSize;
        this.femoralSize = femoralSize;
        this.calf = calf;
        this.date = date;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getHipSize() {
        return hipsSize;
    }

    public void setHipSize(int hipSize) {
        this.hipsSize = hipSize;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
                ", hipSize=" + hipsSize +
                ", femoralSize=" + femoralSize +
                ", calf=" + calf +
                ", date=" + date +
                ", userId=" + userId +
                '}';
    }
}
