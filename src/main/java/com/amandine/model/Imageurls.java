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
@Table(name = "imageurls", catalog = "twitterforcoucou", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imageurls.rowCount", query = "SELECT COUNT(i) FROM Imageurls i"),
    @NamedQuery(name = "Imageurls.findAll", query = "SELECT i FROM Imageurls i"),
    @NamedQuery(name = "Imageurls.findById", query = "SELECT i FROM Imageurls i WHERE i.imageurlsPK.id = :id"),
    @NamedQuery(name = "Imageurls.findByUrl", query = "SELECT i FROM Imageurls i WHERE i.imageurlsPK.url = :url")})
public class Imageurls implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ImageurlsPK imageurlsPK;

    public Imageurls() {
    }

    public Imageurls(ImageurlsPK imageurlsPK) {
        this.imageurlsPK = imageurlsPK;
    }

    public Imageurls(int id, String url) {
        this.imageurlsPK = new ImageurlsPK(id, url);
    }

    public ImageurlsPK getImageurlsPK() {
        return imageurlsPK;
    }

    public void setImageurlsPK(ImageurlsPK imageurlsPK) {
        this.imageurlsPK = imageurlsPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageurlsPK != null ? imageurlsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imageurls)) {
            return false;
        }
        Imageurls other = (Imageurls) object;
        if ((this.imageurlsPK == null && other.imageurlsPK != null) || (this.imageurlsPK != null && !this.imageurlsPK.equals(other.imageurlsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amandine.model.Imageurls[ imageurlsPK=" + imageurlsPK + " ]";
    }
    
}
