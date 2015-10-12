/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amandine.model;

import java.io.Serializable;
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
@Table(name = "targeturls", catalog = "twitterforcoucou", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Targeturls.findAll", query = "SELECT t FROM Targeturls t"),
    @NamedQuery(name = "Targeturls.findById", query = "SELECT t FROM Targeturls t WHERE t.targeturlsPK.id = :id"),
    @NamedQuery(name = "Targeturls.findByUrl", query = "SELECT t FROM Targeturls t WHERE t.targeturlsPK.url = :url")})
public class Targeturls implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TargeturlsPK targeturlsPK;

    public Targeturls() {
    }

    public Targeturls(TargeturlsPK targeturlsPK) {
        this.targeturlsPK = targeturlsPK;
    }

    public Targeturls(int id, String url) {
        this.targeturlsPK = new TargeturlsPK(id, url);
    }

    public TargeturlsPK getTargeturlsPK() {
        return targeturlsPK;
    }

    public void setTargeturlsPK(TargeturlsPK targeturlsPK) {
        this.targeturlsPK = targeturlsPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (targeturlsPK != null ? targeturlsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Targeturls)) {
            return false;
        }
        Targeturls other = (Targeturls) object;
        if ((this.targeturlsPK == null && other.targeturlsPK != null) || (this.targeturlsPK != null && !this.targeturlsPK.equals(other.targeturlsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amandine.model.Targeturls[ targeturlsPK=" + targeturlsPK + " ]";
    }
    
}
