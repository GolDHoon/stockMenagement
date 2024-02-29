package com.gdh.stockMenagement.entity;

import com.gdh.stockMenagement.entity.common.BasicEntity;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_CODE")
public class Code extends BasicEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Idx", nullable = false)
    private UUID id;

    @Nationalized
    @Column(name = "Code", nullable = false, length = 4)
    private String code;

    @Nationalized
    @Column(name = "CodeName", nullable = false, length = 100)
    private String codeName;

    @Nationalized
    @Column(name = "Discription", length = 1000)
    private String discription;

}