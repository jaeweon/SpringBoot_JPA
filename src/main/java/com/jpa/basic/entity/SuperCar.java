package com.jpa.basic.entity;

import com.jpa.basic.type.SuperCarType;
import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @ToString @Setter
@Table(name = "TBL_SUPER_CAR")
public class SuperCar {
    @Id @GeneratedValue
    private long id;
    @NotNull @Enumerated(value = EnumType.STRING)
    private SuperCarType superCarType;
    private String superCarBrand;
    private String superCarName;
    private String superCarColor;
    private Long superCarPrice;
    private LocalDateTime superCarReleaseDate;
}
