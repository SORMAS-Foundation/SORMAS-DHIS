/*
 * Copyright (c) 2020, Mathew Official
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.mirabilia.webapi;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mathew Official
 */
@Entity
@Table(name = "raw_")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "stagingDb.findAll", query = "SELECT s FROM stagingDb s"),
    @NamedQuery(name = "stagingDb.findByIdx", query = "SELECT s FROM stagingDb s WHERE s.idx = :idx"),
    @NamedQuery(name = "stagingDb.findByUuid", query = "SELECT s FROM stagingDb s WHERE s.uuid = :uuid"),
    @NamedQuery(name = "stagingDb.findByName", query = "SELECT s FROM stagingDb s WHERE s.name = :name"),
    @NamedQuery(name = "stagingDb.findByShortname", query = "SELECT s FROM stagingDb s WHERE s.shortname = :shortname"),
    @NamedQuery(name = "stagingDb.findByCreated", query = "SELECT s FROM stagingDb s WHERE s.created = :created"),
    @NamedQuery(name = "stagingDb.findByPathParent", query = "SELECT s FROM stagingDb s WHERE s.pathParent = :pathParent"),
    @NamedQuery(name = "stagingDb.findByLevel", query = "SELECT s FROM stagingDb s WHERE s.level = :level"),
    @NamedQuery(name = "stagingDb.findByUpdatedLast", query = "SELECT s FROM stagingDb s WHERE s.updatedLast = :updatedLast"),
    @NamedQuery(name = "stagingDb.findByRecCreated", query = "SELECT s FROM stagingDb s WHERE s.recCreated = :recCreated"),
    @NamedQuery(name = "stagingDb.findByLastEdited", query = "SELECT s FROM stagingDb s WHERE s.lastEdited = :lastEdited")})
public class stagingDb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idx")
    private Integer idx;
    @Size(max = 50)
    @Column(name = "uuid")
    private String uuid;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 50)
    @Column(name = "shortname")
    private String shortname;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 200)
    @Column(name = "path_parent")
    private String pathParent;
    @Size(max = 50)
    @Column(name = "level")
    private String level;
    @Column(name = "updated_last")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedLast;
    @Column(name = "rec_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recCreated;
    @Column(name = "last_edited")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastEdited;

    public stagingDb() {
    }

    public stagingDb(Integer idx) {
        this.idx = idx;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getPathParent() {
        return pathParent;
    }

    public void setPathParent(String pathParent) {
        this.pathParent = pathParent;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Date getUpdatedLast() {
        return updatedLast;
    }

    public void setUpdatedLast(Date updatedLast) {
        this.updatedLast = updatedLast;
    }

    public Date getRecCreated() {
        return recCreated;
    }

    public void setRecCreated(Date recCreated) {
        this.recCreated = recCreated;
    }

    public Date getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(Date lastEdited) {
        this.lastEdited = lastEdited;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idx != null ? idx.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof stagingDb)) {
            return false;
        }
        stagingDb other = (stagingDb) object;
        if ((this.idx == null && other.idx != null) || (this.idx != null && !this.idx.equals(other.idx))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mirabilia.webapi.stagingDb[ idx=" + idx + " ]";
    }
    
}
