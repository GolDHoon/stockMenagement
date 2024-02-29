package com.gdh.stockMenagement.entity;

import com.gdh.stockMenagement.entity.common.BasicEntity;
import lombok.*;
import org.hibernate.annotations.Nationalized;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_LOGI_CODE")
public class LogiCode extends BasicEntity implements Serializable {
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
    @Column(name = "CodeName", nullable = false, length = 100)
    private String codeName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ParentsCode", nullable = false, referencedColumnName = "Code")
    @ToString.Exclude
    private Code parentsCode;

    @Nationalized
    @Column(name = "FullParentsCode", nullable = false, length = 4)
    private String fullParentsCode;

    @Nationalized
    @Column(name = "Discription", length = 1000)
    private String discription;

    public UUID getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getFullCode() {
        return fullCode;
    }

    public String getCodeName() {
        return codeName;
    }

    public Code getParentsCode() {
        return parentsCode;
    }

    public String getFullParentsCode() {
        return fullParentsCode;
    }

    public String getDiscription() {
        return discription;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setFullCode(String fullCode) {
        this.fullCode = fullCode;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public void setParentsCode(Code parentsCode) {
        this.parentsCode = parentsCode;
    }

    public void setFullParentsCode(String fullParentsCode) {
        this.fullParentsCode = fullParentsCode;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        LogiCode logiCode = (LogiCode) o;
        return getId() != null && Objects.equals(getId(), logiCode.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}