/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amandine.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author 222252
 */
@Embeddable
public class UsersPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "twitterid")
    private String twitterid;

    public UsersPK() {
    }

    public UsersPK(int id, String twitterid) {
        this.id = id;
        this.twitterid = twitterid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTwitterid() {
        return twitterid;
    }

    public void setTwitterid(String twitterid) {
        this.twitterid = twitterid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (twitterid != null ? twitterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersPK)) {
            return false;
        }
        UsersPK other = (UsersPK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.twitterid == null && other.twitterid != null) || (this.twitterid != null && !this.twitterid.equals(other.twitterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amandine.model.UsersPK[ id=" + id + ", twitterid=" + twitterid + " ]";
    }
    
}
