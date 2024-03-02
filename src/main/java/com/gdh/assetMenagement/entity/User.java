package com.gdh.assetMenagement.entity;

import com.gdh.assetMenagement.entity.common.BasicEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@Entity
@Table(name = "TB_USER")
public class User extends BasicEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Idx", nullable = false)
    private UUID id;

    @Nationalized
    @Column(name = "UserId", nullable = false, length = 20)
    private String userId;

    @Nationalized
    @Column(name = "Password", nullable = false, length = 128)
    private String password;

    @Column(name = "Ukcd", nullable = false)
    private String ukcd;

}