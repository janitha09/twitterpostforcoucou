/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amandine.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 222252
 */
@Entity
@Table(name = "statusupdatelog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statusupdatelog.findAll", query = "SELECT s FROM Statusupdatelog s"),
    @NamedQuery(name = "Statusupdatelog.findById", query = "SELECT s FROM Statusupdatelog s WHERE s.statusupdatelogPK.id = :id"),
    @NamedQuery(name = "Statusupdatelog.findByTimeposted", query = "SELECT s FROM Statusupdatelog s WHERE s.timeposted = :timeposted"),
    @NamedQuery(name = "Statusupdatelog.findByTwitterid", query = "SELECT s FROM Statusupdatelog s WHERE s.statusupdatelogPK.twitterid = :twitterid"),
    @NamedQuery(name = "Statusupdatelog.findByStatusupdate", query = "SELECT s FROM Statusupdatelog s WHERE s.statusupdate = :statusupdate")})
public class Statusupdatelog implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StatusupdatelogPK statusupdatelogPK;
    @Basic(optional = false)
    @Column(name = "timeposted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeposted;
    @Column(name = "statusupdate")
    private String statusupdate;

    public Statusupdatelog() {
    }

    public Statusupdatelog(StatusupdatelogPK statusupdatelogPK) {
        this.statusupdatelogPK = statusupdatelogPK;
    }

    public Statusupdatelog(StatusupdatelogPK statusupdatelogPK, Date timeposted) {
        this.statusupdatelogPK = statusupdatelogPK;
        this.timeposted = timeposted;
    }

    public Statusupdatelog(int id, String twitterid) {
        this.statusupdatelogPK = new StatusupdatelogPK(id, twitterid);
    }

    public StatusupdatelogPK getStatusupdatelogPK() {
        return statusupdatelogPK;
    }

    public void setStatusupdatelogPK(StatusupdatelogPK statusupdatelogPK) {
        this.statusupdatelogPK = statusupdatelogPK;
    }

    public Date getTimeposted() {
        return timeposted;
    }

    public void setTimeposted(Date timeposted) {
        this.timeposted = timeposted;
    }

    public String getStatusupdate() {
        return statusupdate;
    }

    public void setStatusupdate(String statusupdate) {
        this.statusupdate = statusupdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusupdatelogPK != null ? statusupdatelogPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statusupdatelog)) {
            return false;
        }
        Statusupdatelog other = (Statusupdatelog) object;
        if ((this.statusupdatelogPK == null && other.statusupdatelogPK != null) || (this.statusupdatelogPK != null && !this.statusupdatelogPK.equals(other.statusupdatelogPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amandine.model.Statusupdatelog[ statusupdatelogPK=" + statusupdatelogPK + " ]";
    }
    
}
