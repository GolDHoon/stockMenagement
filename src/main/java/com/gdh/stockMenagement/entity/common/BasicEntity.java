package com.gdh.stockMenagement.entity.common;

import com.gdh.stockMenagement.entity.User;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
public abstract class BasicEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "IsUse", nullable = false)
    private Boolean isUse = false;

    @Column(name = "IsDel", nullable = false)
    private Boolean isDel = false;

    @Column(name = "RegDate", nullable = false)
    private Instant regDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RegUser", nullable = false)
    private User regUser;

    @Column(name = "ModDate", nullable = false)
    private Instant modDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ModUser")
    private User modUser;

    @Column(name = "DelDate")
    private Instant delDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DelUser")
    private User delUser;
}
