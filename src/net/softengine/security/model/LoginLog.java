package net.softengine.security.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Copyright &copy; Soft Engine Inc.
 * Created on 21/06/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 21/06/16
 * Version : 1.0
 */
@Entity
@Table(name = "sec_login_log")
public class LoginLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "is_in")
    private Boolean in;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Temporal(TemporalType.TIME)
    private Date time;

    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIn() {
        return in;
    }

    public void setIn(Boolean in) {
        this.in = in;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
