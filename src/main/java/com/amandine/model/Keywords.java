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
@Table(catalog = "twitterforcoucou", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Keywords.rowCount", query = "SELECT COUNT(k) FROM Keywords k"),
    @NamedQuery(name = "Keywords.findAll", query = "SELECT k FROM Keywords k"),
    @NamedQuery(name = "Keywords.findById", query = "SELECT k FROM Keywords k WHERE k.keywordsPK.id = :id"),
    @NamedQuery(name = "Keywords.findByKeyword", query = "SELECT k FROM Keywords k WHERE k.keywordsPK.keyword = :keyword")})
public class Keywords implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KeywordsPK keywordsPK;

    public Keywords() {
    }

    public Keywords(KeywordsPK keywordsPK) {
        this.keywordsPK = keywordsPK;
    }

    public Keywords(int id, String keyword) {
        this.keywordsPK = new KeywordsPK(id, keyword);
    }

    public KeywordsPK getKeywordsPK() {
        return keywordsPK;
    }

    public void setKeywordsPK(KeywordsPK keywordsPK) {
        this.keywordsPK = keywordsPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (keywordsPK != null ? keywordsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Keywords)) {
            return false;
        }
        Keywords other = (Keywords) object;
        if ((this.keywordsPK == null && other.keywordsPK != null) || (this.keywordsPK != null && !this.keywordsPK.equals(other.keywordsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amandine.model.Keywords[ keywordsPK=" + keywordsPK + " ]";
    }

}
