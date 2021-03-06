/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdq.open_up.beans;

import com.kdq.open_up.entities.Inputs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FOXCONN
 */
@Stateless
public class InputsFacade extends AbstractFacade<Inputs> {

    @PersistenceContext(unitName = "openup")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InputsFacade() {
        super(Inputs.class);
    }
    
}
