/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdq.open_up.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author FOXCONN
 */
@Embeddable
public class OutputsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "TASK")
    private String task;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "ARTIFACT")
    private String artifact;

    public OutputsPK() {
    }

    public OutputsPK(String task, String artifact) {
        this.task = task;
        this.artifact = artifact;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getArtifact() {
        return artifact;
    }

    public void setArtifact(String artifact) {
        this.artifact = artifact;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (task != null ? task.hashCode() : 0);
        hash += (artifact != null ? artifact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OutputsPK)) {
            return false;
        }
        OutputsPK other = (OutputsPK) object;
        if ((this.task == null && other.task != null) || (this.task != null && !this.task.equals(other.task))) {
            return false;
        }
        if ((this.artifact == null && other.artifact != null) || (this.artifact != null && !this.artifact.equals(other.artifact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kdq.open_up.OutputsPK[ task=" + task + ", artifact=" + artifact + " ]";
    }
    
}
