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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "Statusupdatelog.findById", query = "SELECT s FROM Statusupdatelog s WHERE s.id = :id"),
    @NamedQuery(name = "Statusupdatelog.findByTimeposted", query = "SELECT s FROM Statusupdatelog s WHERE s.timeposted = :timeposted"),
    @NamedQuery(name = "Statusupdatelog.findByTwitterid", query = "SELECT s FROM Statusupdatelog s WHERE s.twitterid = :twitterid"),
    @NamedQuery(name = "Statusupdatelog.findByStatusupdate", query = "SELECT s FROM Statusupdatelog s WHERE s.statusupdate = :statusupdate")})
public class Statusupdatelog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "timeposted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeposted;
    @Column(name = "twitterid")
    private String twitterid;
    @Column(name = "statusupdate")
    private String statusupdate;

    public Statusupdatelog() {
    }

    public Statusupdatelog(Integer id) {
        this.id = id;
    }

    public Statusupdatelog(Integer id, Date timeposted) {
        this.id = id;
        this.timeposted = timeposted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimeposted() {
        return timeposted;
    }

    public void setTimeposted(Date timeposted) {
        this.timeposted = timeposted;
    }

    public String getTwitterid() {
        return twitterid;
    }

    public void setTwitterid(String twitterid) {
        this.twitterid = twitterid;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statusupdatelog)) {
            return false;
        }
        Statusupdatelog other = (Statusupdatelog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amandine.model.Statusupdatelog[ id=" + id + " ]";
    }
    
}
