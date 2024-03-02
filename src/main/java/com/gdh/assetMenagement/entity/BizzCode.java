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

@ToString
@Accessors(chain = true)
@Entity
@Table(name = "TB_BIZZ_CODE")
public class BizzCode extends BasicEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Idx", nullable = false)
    private UUID id;

    @Nationalized
    @Column(name = "Code", nullable = false, length = 4)
    private String code;

    @Nationalized
    @Column(name = "FullCode", nullable = false, length = 9)
    private String fullCode;

    @Nationalized
    @Column(name = "CodeValue", nullable = false, length = 100)
    private String codeValue;

    @Column(name = "ParentsCode", nullable = false)
    private String parentsCode;

    @Nationalized
    @Column(name = "FullParentsCode", nullable = false, length = 4)
    private String fullParentsCode;

    @Nationalized
    @Column(name = "Discription", length = 1000)
    private String discription;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullCode() {
        return fullCode;
    }

    public void setFullCode(String fullCode) {
        this.fullCode = fullCode;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getParentsCode() {
        return parentsCode;
    }

    public void setParentsCode(String parentsCode) {
        this.parentsCode = parentsCode;
    }

    public String getFullParentsCode() {
        return fullParentsCode;
    }

    public void setFullParentsCode(String fullParentsCode) {
        this.fullParentsCode = fullParentsCode;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}