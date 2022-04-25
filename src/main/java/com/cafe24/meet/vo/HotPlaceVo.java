package com.cafe24.meet.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "t_hotplace")
@Data
public class HotPlaceVo {
    @Id @GeneratedValue
    private Long no;

    @NotEmpty(message = "핫플레이스명을 등록해주세요.")
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
