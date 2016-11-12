package net.softengine.security.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Copyright &copy; Soft Engine Inc.
 * Created on 14/05/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 14/05/16
 * Version : 1.0
 */

@Entity
@Table(name = "SEC_ATTEMPT")
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "attempt_type")
    private Integer attemptType;  // 0 = Authorized, 1 = Unauthorized

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    private String referer;

    @ManyToOne
    private Module module;

    @ManyToOne
    private Operation operation;
    private String operationName;

    @ManyToOne
    private User operator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAttemptType() {
        return attemptType;
    }

    public void setAttemptType(Integer attemptType) {
        this.attemptType = attemptType;
    }

    public Date getTime() {
        return time;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public User getOperator() {
        return operator;
    }

    public void setOperator(User operator) {
        this.operator = operator;
    }
}
