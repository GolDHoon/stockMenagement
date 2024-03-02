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
@Table(name = "TB_KIS_CODE")
public class KisCode extends BasicEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Idx", nullable = false)
    private UUID id;

    @Column(name = "Code", nullable = false)
    private Integer code;

    @Nationalized
    @Column(name = "FullCode", nullable = false, length = 36)
    private String fullCode;

    @Nationalized
    @Column(name = "CodeValue", nullable = false, length = 100)
    private String codeValue;

    @Column(name = "ParentsCode", nullable = false)
    private String parentsCode;

    @Nationalized
    @Column(name = "FullParentsCode", nullable = false, length = 15)
    private String fullParentsCode;

}