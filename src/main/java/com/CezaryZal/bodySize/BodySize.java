package com.CezaryZal.bodySize;


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

    @Column(name = "hip_size")
    private int hipSize;

    @Column(name = "femoral_size")
    private int femoralSize;

    @Column(name = "calf")
    private int calf;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "user_id")
    private int userId;


    public BodySize() {
    }

    public BodySize(int bodyWeight, int neckSize, int armSize, int bustSize, int waist, int hipSize,
                    int femoralSize, int calf, LocalDate date, int userId) {
        this.bodyWeight = bodyWeight;
        this.neckSize = neckSize;
        this.armSize = armSize;
        this.bustSize = bustSize;
        this.waist = waist;
        this.hipSize = hipSize;
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
        return hipSize;
    }

    public void setHipSize(int hipSize) {
        this.hipSize = hipSize;
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
                ", hipSize=" + hipSize +
                ", femoralSize=" + femoralSize +
                ", calf=" + calf +
                ", date=" + date +
                ", userId=" + userId +
                '}';
    }
}
