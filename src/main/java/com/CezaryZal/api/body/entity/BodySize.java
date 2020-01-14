package com.CezaryZal.api.body.entity;


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
public class BodySize{


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

}
