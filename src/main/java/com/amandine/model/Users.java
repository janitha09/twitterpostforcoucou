/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amandine.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 222252
 */
@Entity
@Table(name = "users", catalog = "twitterforcoucou", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByTwitterid", query = "SELECT u FROM Users u WHERE u.twitterid = :twitterid"),
    @NamedQuery(name = "Users.findByScreenname", query = "SELECT u FROM Users u WHERE u.screenname = :screenname")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "twitterid")
    private String twitterid;
    @Column(name = "screenname")
    private String screenname;
    @Column(name = "fromscreenname")
    private String fromscreenname;

    public Users() {
    }

    public Users(String twitterid) {
        this.twitterid = twitterid;
    }

    public String getTwitterid() {
        return twitterid;
    }

    public void setTwitterid(String twitterid) {
        this.twitterid = twitterid;
    }

    public String getScreenname() {
        return screenname;
    }

    public void setScreenname(String screenname) {
        this.screenname = screenname;
    }
        public String getFromScreenname() {
        return fromscreenname;
    }

    public void setFromScreenname(String screenname) {
        this.fromscreenname = screenname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (twitterid != null ? twitterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.twitterid == null && other.twitterid != null) || (this.twitterid != null && !this.twitterid.equals(other.twitterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amandine.model.Users[ twitterid=" + twitterid + " ]";
    }
    
}
