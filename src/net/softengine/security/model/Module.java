package net.softengine.security.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "SEC_MODULE")
public class Module implements Serializable {

    private static final long serialVersionUID = 5368971495940924284L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String alias;
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "defaultModule")
    @Fetch(value = FetchMode.SELECT)
    private List<User> defaultUserList = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "module")
    @Fetch(value = FetchMode.SELECT)
    private List<Operation> operationList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getDefaultUserList() {
        return defaultUserList;
    }

    public void setDefaultUserList(List<User> defaultUserList) {
        this.defaultUserList = defaultUserList;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Operation> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<Operation> operationList) {
        this.operationList = operationList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
