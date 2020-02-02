/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdq.open_up.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author FOXCONN
 */
@Entity
@Table(name = "INPUTS")
@NamedQueries({
    @NamedQuery(name = "Inputs.findAll", query = "SELECT i FROM Inputs i"),
    @NamedQuery(name = "Inputs.findByTask", query = "SELECT i FROM Inputs i WHERE i.inputsPK.task = :task"),
    @NamedQuery(name = "Inputs.findByArtifact", query = "SELECT i FROM Inputs i WHERE i.inputsPK.artifact = :artifact"),
    @NamedQuery(name = "Inputs.findByMandatory", query = "SELECT i FROM Inputs i WHERE i.mandatory = :mandatory")})
public class Inputs implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InputsPK inputsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MANDATORY")
    private Boolean mandatory;

    public Inputs() {
    }

    public Inputs(InputsPK inputsPK) {
        this.inputsPK = inputsPK;
    }

    public Inputs(InputsPK inputsPK, Boolean mandatory) {
        this.inputsPK = inputsPK;
        this.mandatory = mandatory;
    }

    public Inputs(String task, String artifact) {
        this.inputsPK = new InputsPK(task, artifact);
    }

    public InputsPK getInputsPK() {
        return inputsPK;
    }

    public void setInputsPK(InputsPK inputsPK) {
        this.inputsPK = inputsPK;
    }

    public Boolean getMandatory() {
        return mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inputsPK != null ? inputsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inputs)) {
            return false;
        }
        Inputs other = (Inputs) object;
        if ((this.inputsPK == null && other.inputsPK != null) || (this.inputsPK != null && !this.inputsPK.equals(other.inputsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kdq.open_up.Inputs[ inputsPK=" + inputsPK + " ]";
    }
    
}
