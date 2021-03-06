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
public class AdditionalPerformersPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "ROLE")
    private String role;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "TASK")
    private String task;

    public AdditionalPerformersPK() {
    }

    public AdditionalPerformersPK(String role, String task) {
        this.role = role;
        this.task = task;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (role != null ? role.hashCode() : 0);
        hash += (task != null ? task.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdditionalPerformersPK)) {
            return false;
        }
        AdditionalPerformersPK other = (AdditionalPerformersPK) object;
        if ((this.role == null && other.role != null) || (this.role != null && !this.role.equals(other.role))) {
            return false;
        }
        if ((this.task == null && other.task != null) || (this.task != null && !this.task.equals(other.task))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kdq.open_up.AdditionalPerformersPK[ role=" + role + ", task=" + task + " ]";
    }
    
}
