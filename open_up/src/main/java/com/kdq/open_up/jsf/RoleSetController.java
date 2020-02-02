/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdq.open_up.jsf;

import com.kdq.open_up.beans.RoleSetFacade;
import com.kdq.open_up.entities.RoleSet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.faces.FacesException;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import com.kdq.open_up.jsf.util.JsfUtil;
import com.kdq.open_up.jsf.util.PagingInfo;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

/**
 *
 * @author FOXCONN
 */
public class RoleSetController {

    public RoleSetController() {
        pagingInfo = new PagingInfo();
        converter = new RoleSetConverter();
    }
    private RoleSet roleSet = null;
    private List<RoleSet> roleSetItems = null;
    private RoleSetFacade jpaController = null;
    private RoleSetConverter converter = null;
    private PagingInfo pagingInfo = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(getJpaController().count());
        }
        return pagingInfo;
    }

    public RoleSetFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (RoleSetFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "roleSetJpa");
        }
        return jpaController;
    }

    public SelectItem[] getRoleSetItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getRoleSetItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public RoleSet getRoleSet() {
        if (roleSet == null) {
            roleSet = (RoleSet) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentRoleSet", converter, null);
        }
        if (roleSet == null) {
            roleSet = new RoleSet();
        }
        return roleSet;
    }

    public String listSetup() {
        reset(true);
        return "roleSet_list";
    }

    public String createSetup() {
        reset(false);
        roleSet = new RoleSet();
        return "roleSet_create";
    }

    public String create() {
        try {
            //utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(roleSet);
            try {
                //utx.commit();
            //} catch (javax.transaction.RollbackException ex) {
            //    transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("RoleSet was successfully created.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                //utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("roleSet_detail");
    }

    public String editSetup() {
        return scalarSetup("roleSet_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        roleSet = (RoleSet) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentRoleSet", converter, null);
        if (roleSet == null) {
            String requestRoleSetString = JsfUtil.getRequestParameter("jsfcrud.currentRoleSet");
            JsfUtil.addErrorMessage("The roleSet with id " + requestRoleSetString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String roleSetString = converter.getAsString(FacesContext.getCurrentInstance(), null, roleSet);
        String currentRoleSetString = JsfUtil.getRequestParameter("jsfcrud.currentRoleSet");
        if (roleSetString == null || roleSetString.length() == 0 || !roleSetString.equals(currentRoleSetString)) {
            String outcome = editSetup();
            if ("roleSet_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit roleSet. Try again.");
            }
            return outcome;
        }
        try {
            //utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(roleSet);
            try {
                //utx.commit();
            //} catch (javax.transaction.RollbackException ex) {
            //    transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("RoleSet was successfully updated.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                //utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return detailSetup();
    }

    public String remove() {
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentRoleSet");
        String id = idAsString;
        try {
            //utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().remove(getJpaController().find(id));
            try {
                //utx.commit();
            //} catch (javax.transaction.RollbackException ex) {
            //    transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("RoleSet was successfully deleted.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                //utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return relatedOrListOutcome();
    }

    private String relatedOrListOutcome() {
        String relatedControllerOutcome = relatedControllerOutcome();
        //if ((ERROR)) {
        //    return relatedControllerOutcome;
        //}
        return listSetup();
    }

    public List<RoleSet> getRoleSetItems() {
        if (roleSetItems == null) {
            getPagingInfo();
            roleSetItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return roleSetItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "roleSet_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "roleSet_list";
    }

    private String relatedControllerOutcome() {
        String relatedControllerString = JsfUtil.getRequestParameter("jsfcrud.relatedController");
        String relatedControllerTypeString = JsfUtil.getRequestParameter("jsfcrud.relatedControllerType");
        if (relatedControllerString != null && relatedControllerTypeString != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Object relatedController = context.getApplication().getELResolver().getValue(context.getELContext(), null, relatedControllerString);
            try {
                Class<?> relatedControllerType = Class.forName(relatedControllerTypeString);
                Method detailSetupMethod = relatedControllerType.getMethod("detailSetup");
                return (String) detailSetupMethod.invoke(relatedController);
            } catch (ClassNotFoundException e) {
                throw new FacesException(e);
            } catch (NoSuchMethodException e) {
                throw new FacesException(e);
            } catch (IllegalAccessException e) {
                throw new FacesException(e);
            } catch (InvocationTargetException e) {
                throw new FacesException(e);
            }
        }
        return null;
    }

    private void reset(boolean resetFirstItem) {
        roleSet = null;
        roleSetItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        RoleSet newRoleSet = new RoleSet();
        String newRoleSetString = converter.getAsString(FacesContext.getCurrentInstance(), null, newRoleSet);
        String roleSetString = converter.getAsString(FacesContext.getCurrentInstance(), null, roleSet);
        if (!newRoleSetString.equals(roleSetString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
