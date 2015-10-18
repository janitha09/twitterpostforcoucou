/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amandine.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 222252
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.rowCountWithScreenName", query = "SELECT COUNT(u) FROM Users u where u.screenname <> \"\""),
    @NamedQuery(name = "Users.rowCount", query = "SELECT COUNT(u) FROM Users u"),
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.usersPK.id = :id"),
    @NamedQuery(name = "Users.findByTwitterid", query = "SELECT u FROM Users u WHERE u.usersPK.twitterid = :twitterid"),
    @NamedQuery(name = "Users.findByScreenname", query = "SELECT u FROM Users u WHERE u.screenname = :screenname"),
    @NamedQuery(name = "Users.findByFromscreenname", query = "SELECT u FROM Users u WHERE u.fromscreenname = :fromscreenname"),
    @NamedQuery(name = "Users.findByFollowerscount", query = "SELECT u FROM Users u WHERE u.followerscount = :followerscount"),
    @NamedQuery(name = "Users.findByLateststatus", query = "SELECT u FROM Users u WHERE u.lateststatus = :lateststatus")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsersPK usersPK;
    @Column(name = "screenname")
    private String screenname;
    @Column(name = "fromscreenname")
    private String fromscreenname;
    @Column(name = "followerscount")
    private Integer followerscount;
    @Column(name = "lateststatus")
    private String lateststatus;

    public Users() {
    }

    public Users(UsersPK usersPK) {
        this.usersPK = usersPK;
    }

    public Users(int id, String twitterid) {
        this.usersPK = new UsersPK(id, twitterid);
    }

    public UsersPK getUsersPK() {
        return usersPK;
    }

    public void setUsersPK(UsersPK usersPK) {
        this.usersPK = usersPK;
    }

    public String getScreenname() {
        return screenname;
    }

    public void setScreenname(String screenname) {
        this.screenname = screenname;
    }

    public String getFromscreenname() {
        return fromscreenname;
    }

    public void setFromscreenname(String fromscreenname) {
        this.fromscreenname = fromscreenname;
    }

    public Integer getFollowerscount() {
        return followerscount;
    }

    public void setFollowerscount(Integer followerscount) {
        this.followerscount = followerscount;
    }

    public String getLateststatus() {
        return lateststatus;
    }

    public void setLateststatus(String lateststatus) {
        this.lateststatus = lateststatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usersPK != null ? usersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.usersPK == null && other.usersPK != null) || (this.usersPK != null && !this.usersPK.equals(other.usersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amandine.model.Users[ usersPK=" + usersPK + " ]";
    }
}
