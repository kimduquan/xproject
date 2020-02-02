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
@Table(name = "OUTPUTS")
@NamedQueries({
    @NamedQuery(name = "Outputs.findAll", query = "SELECT o FROM Outputs o"),
    @NamedQuery(name = "Outputs.findByTask", query = "SELECT o FROM Outputs o WHERE o.outputsPK.task = :task"),
    @NamedQuery(name = "Outputs.findByArtifact", query = "SELECT o FROM Outputs o WHERE o.outputsPK.artifact = :artifact")})
public class Outputs implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OutputsPK outputsPK;

    public Outputs() {
    }

    public Outputs(OutputsPK outputsPK) {
        this.outputsPK = outputsPK;
    }

    public Outputs(String task, String artifact) {
        this.outputsPK = new OutputsPK(task, artifact);
    }

    public OutputsPK getOutputsPK() {
        return outputsPK;
    }

    public void setOutputsPK(OutputsPK outputsPK) {
        this.outputsPK = outputsPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (outputsPK != null ? outputsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Outputs)) {
            return false;
        }
        Outputs other = (Outputs) object;
        if ((this.outputsPK == null && other.outputsPK != null) || (this.outputsPK != null && !this.outputsPK.equals(other.outputsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kdq.open_up.Outputs[ outputsPK=" + outputsPK + " ]";
    }
    
}
