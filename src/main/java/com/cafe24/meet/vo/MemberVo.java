package com.cafe24.meet.vo;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "t_member", uniqueConstraints = {@UniqueConstraint(
        name = "USER_ID_UNIQUE",
        columnNames = {"userId"} )})
@Data
public class MemberVo {
    @Id @GeneratedValue
    private Long no;

    @NotEmpty(message = "ID 값은 필수값입니다.")
    private String userId;


    @NotEmpty(message = "패스워드 값은 필수값입니다.")
    @Column(name = "password", columnDefinition = "VARBINARY(128)")
    private String password;

    @NotEmpty
    private String placeX;

    @NotEmpty
    private String placeY;
}
