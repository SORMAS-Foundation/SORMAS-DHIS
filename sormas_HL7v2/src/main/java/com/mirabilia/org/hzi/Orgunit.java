/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirabilia.org.hzi;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mathew Official
 */
@Entity
@Table(name = "_orgunit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orgunit.findAll", query = "SELECT o FROM Orgunit o"),
    @NamedQuery(name = "Orgunit.findBySId", query = "SELECT o FROM Orgunit o WHERE o.sId = :sId"),
    @NamedQuery(name = "Orgunit.findByUid", query = "SELECT o FROM Orgunit o WHERE o.uid = :uid"),
    @NamedQuery(name = "Orgunit.findByHlUid", query = "SELECT o FROM Orgunit o WHERE o.hlUid = :hlUid"),
    @NamedQuery(name = "Orgunit.findByDhisUid", query = "SELECT o FROM Orgunit o WHERE o.dhisUid = :dhisUid"),
    @NamedQuery(name = "Orgunit.findByOrgLevel", query = "SELECT o FROM Orgunit o WHERE o.orgLevel = :orgLevel"),
    @NamedQuery(name = "Orgunit.findByDhisLastModification", query = "SELECT o FROM Orgunit o WHERE o.dhisLastModification = :dhisLastModification"),
    @NamedQuery(name = "Orgunit.findByHlLastSync", query = "SELECT o FROM Orgunit o WHERE o.hlLastSync = :hlLastSync"),
    @NamedQuery(name = "Orgunit.findByHlLastSyncStatus", query = "SELECT o FROM Orgunit o WHERE o.hlLastSyncStatus = :hlLastSyncStatus"),
    @NamedQuery(name = "Orgunit.findByHlLastSyncBy", query = "SELECT o FROM Orgunit o WHERE o.hlLastSyncBy = :hlLastSyncBy"),
    @NamedQuery(name = "Orgunit.findByCreated", query = "SELECT o FROM Orgunit o WHERE o.created = :created")})
public class Orgunit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "s_id")
    private Integer sId;
    @Size(max = 50)
    @Column(name = "uid")
    private String uid;
    @Size(max = 50)
    @Column(name = "hl_uid")
    private String hlUid;
    @Size(max = 50)
    @Column(name = "dhis_uid")
    private String dhisUid;
    @Size(max = 50)
    @Column(name = "org_level")
    private String orgLevel;
    @Lob
    @Size(max = 65535)
    @Column(name = "dhis_json")
    private String dhisJson;
    @Size(max = 50)
    @Column(name = "dhis_last_modification")
    private String dhisLastModification;
    @Size(max = 50)
    @Column(name = "hl_last_sync")
    private String hlLastSync;
    @Column(name = "hl_last_sync_status")
    private Integer hlLastSyncStatus;
    @Column(name = "hl_last_sync_by")
    private Integer hlLastSyncBy;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public Orgunit() {
    }

    public Orgunit(Integer sId) {
        this.sId = sId;
    }

    public Integer getSId() {
        return sId;
    }

    public void setSId(Integer sId) {
        this.sId = sId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getHlUid() {
        return hlUid;
    }

    public void setHlUid(String hlUid) {
        this.hlUid = hlUid;
    }

    public String getDhisUid() {
        return dhisUid;
    }

    public void setDhisUid(String dhisUid) {
        this.dhisUid = dhisUid;
    }

    public String getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(String orgLevel) {
        this.orgLevel = orgLevel;
    }

    public String getDhisJson() {
        return dhisJson;
    }

    public void setDhisJson(String dhisJson) {
        this.dhisJson = dhisJson;
    }

    public String getDhisLastModification() {
        return dhisLastModification;
    }

    public void setDhisLastModification(String dhisLastModification) {
        this.dhisLastModification = dhisLastModification;
    }

    public String getHlLastSync() {
        return hlLastSync;
    }

    public void setHlLastSync(String hlLastSync) {
        this.hlLastSync = hlLastSync;
    }

    public Integer getHlLastSyncStatus() {
        return hlLastSyncStatus;
    }

    public void setHlLastSyncStatus(Integer hlLastSyncStatus) {
        this.hlLastSyncStatus = hlLastSyncStatus;
    }

    public Integer getHlLastSyncBy() {
        return hlLastSyncBy;
    }

    public void setHlLastSyncBy(Integer hlLastSyncBy) {
        this.hlLastSyncBy = hlLastSyncBy;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sId != null ? sId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orgunit)) {
            return false;
        }
        Orgunit other = (Orgunit) object;
        if ((this.sId == null && other.sId != null) || (this.sId != null && !this.sId.equals(other.sId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mirabilia.org.hzi.Orgunit[ sId=" + sId + " ]";
    }
    
}
