

package net.softengine.security.model;


import net.softengine.common.model.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Table(name= "SEC_USER_MASTER")
public class User implements Serializable {

    private static final long serialVersionUID = 7389991231663740924L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "token")
    private Token token;
    @Column(name = "u_act")
    private boolean active;
    @Column(name = "u_name")
    private String name;

    @OneToOne(mappedBy = "user")
    private UserDetails details;

    @OneToOne(mappedBy = "holder")
    private PresentAddress presentAddress;

    @OneToOne(mappedBy = "holder")
    private PermanentAddress permanentAddress;

    @OneToOne(mappedBy = "holder")
    private OfficeAddress officeAddress;


    @OneToOne(mappedBy = "owner")
    private Signature signature;

    @OneToOne(mappedBy = "owner")
    private Avatar avatar;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    @Fetch(FetchMode.SELECT)
    private List<Document> docList = new ArrayList<>(0);  // mok

    // This could be replace by UserType class
    @Column(name = "u_id")
    private Integer uid;

    @Column(name = "u_type")
    private Integer type;

    @ManyToOne
    @JoinColumn(name = "u_dmid")
    private Module defaultModule;

    @Transient
    private Date lastActivity;

    @Temporal(TemporalType.DATE)
    @Column(name = "u_ed")
    private Date entryDate;

    @ManyToOne
    @JoinColumn(name = "u_opid")
    private User operator;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    @JoinTable(name = "SEC_zt_user_group",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "id")})
    private List<Group> groupList = new ArrayList<Group>(0);

    @Transient
    public String getDiscriminatorValue(){
        DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );
        return val == null ? this.getClass().getSimpleName() : val.value();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public UserDetails getDetails() {
        return details;
    }

    public void setDetails(UserDetails details) {
        this.details = details;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public User getOperator() {
        return operator;
    }

    public void setOperator(User operator) {
        this.operator = operator;
    }

    public Module getDefaultModule() {
        return defaultModule;
    }

    public void setDefaultModule(Module defaultModule) {
        this.defaultModule = defaultModule;
    }

    public PresentAddress getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(PresentAddress presentAddress) {
        this.presentAddress = presentAddress;
    }

    public PermanentAddress getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(PermanentAddress permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public OfficeAddress getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(OfficeAddress officeAddress) {
        this.officeAddress = officeAddress;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Signature getSignature() {
        return signature;
    }

    public void setSignature(Signature signature) {
        this.signature = signature;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public List<Document> getDocList() {
        return docList;
    }

    public void setDocList(List<Document> docList) {
        this.docList = docList;
    }
}
