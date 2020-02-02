/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdq.open_up.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author FOXCONN
 */
@Entity
@Table(name = "ADDITIONAL_PERFORMERS")
@NamedQueries({
    @NamedQuery(name = "AdditionalPerformers.findAll", query = "SELECT a FROM AdditionalPerformers a"),
    @NamedQuery(name = "AdditionalPerformers.findByRole", query = "SELECT a FROM AdditionalPerformers a WHERE a.additionalPerformersPK.role = :role"),
    @NamedQuery(name = "AdditionalPerformers.findByTask", query = "SELECT a FROM AdditionalPerformers a WHERE a.additionalPerformersPK.task = :task")})
public class AdditionalPerformers implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AdditionalPerformersPK additionalPerformersPK;

    public AdditionalPerformers() {
    }

    public AdditionalPerformers(AdditionalPerformersPK additionalPerformersPK) {
        this.additionalPerformersPK = additionalPerformersPK;
    }

    public AdditionalPerformers(String role, String task) {
        this.additionalPerformersPK = new AdditionalPerformersPK(role, task);
    }

    public AdditionalPerformersPK getAdditionalPerformersPK() {
        return additionalPerformersPK;
    }

    public void setAdditionalPerformersPK(AdditionalPerformersPK additionalPerformersPK) {
        this.additionalPerformersPK = additionalPerformersPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (additionalPerformersPK != null ? additionalPerformersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdditionalPerformers)) {
            return false;
        }
        AdditionalPerformers other = (AdditionalPerformers) object;
        if ((this.additionalPerformersPK == null && other.additionalPerformersPK != null) || (this.additionalPerformersPK != null && !this.additionalPerformersPK.equals(other.additionalPerformersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kdq.open_up.AdditionalPerformers[ additionalPerformersPK=" + additionalPerformersPK + " ]";
    }
    
}
