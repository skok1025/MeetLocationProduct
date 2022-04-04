package com.cafe24.meet.vo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_hotplace")
@Getter @Setter
public class HotPlaceVo {
    @Id @GeneratedValue
    private Long no;
    private String name;
    private String centerX;
    private String centerY;
    private String ePointX;
    private String ePointY;
    private String sPointX;
    private String sPointY;
    private String radius;

    private String color;
}
