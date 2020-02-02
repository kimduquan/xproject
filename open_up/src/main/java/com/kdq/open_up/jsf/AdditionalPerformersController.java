/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdq.open_up.jsf;

import com.kdq.open_up.beans.AdditionalPerformersFacade;
import com.kdq.open_up.entities.AdditionalPerformers;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.faces.FacesException;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import com.kdq.open_up.jsf.util.JsfUtil;
import com.kdq.open_up.entities.AdditionalPerformersPK;
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
public class AdditionalPerformersController {

    public AdditionalPerformersController() {
        pagingInfo = new PagingInfo();
        converter = new AdditionalPerformersConverter();
    }
    private AdditionalPerformers additionalPerformers = null;
    private List<AdditionalPerformers> additionalPerformersItems = null;
    private AdditionalPerformersFacade jpaController = null;
    private AdditionalPerformersConverter converter = null;
    private PagingInfo pagingInfo = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(getJpaController().count());
        }
        return pagingInfo;
    }

    public AdditionalPerformersFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (AdditionalPerformersFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "additionalPerformersJpa");
        }
        return jpaController;
    }

    public SelectItem[] getAdditionalPerformersItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getAdditionalPerformersItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public AdditionalPerformers getAdditionalPerformers() {
        if (additionalPerformers == null) {
            additionalPerformers = (AdditionalPerformers) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentAdditionalPerformers", converter, null);
        }
        if (additionalPerformers == null) {
            additionalPerformers = new AdditionalPerformers();
        }
        return additionalPerformers;
    }

    public String listSetup() {
        reset(true);
        return "additionalPerformers_list";
    }

    public String createSetup() {
        reset(false);
        additionalPerformers = new AdditionalPerformers();
        additionalPerformers.setAdditionalPerformersPK(new AdditionalPerformersPK());
        return "additionalPerformers_create";
    }

    public String create() {
        // TODO: no setter methods were found in your primary key class
        //    com.kdq.open_up.entities.AdditionalPerformersPK
        // and therefore initialization code need manual adjustments.
        try {
            //utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(additionalPerformers);
            try {
                //utx.commit();
            //} catch (javax.transaction.RollbackException ex) {
            //    transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("AdditionalPerformers was successfully created.");
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
        return scalarSetup("additionalPerformers_detail");
    }

    public String editSetup() {
        return scalarSetup("additionalPerformers_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        additionalPerformers = (AdditionalPerformers) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentAdditionalPerformers", converter, null);
        if (additionalPerformers == null) {
            String requestAdditionalPerformersString = JsfUtil.getRequestParameter("jsfcrud.currentAdditionalPerformers");
            JsfUtil.addErrorMessage("The additionalPerformers with id " + requestAdditionalPerformersString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        // TODO: no setter methods were found in your primary key class
        //    com.kdq.open_up.entities.AdditionalPerformersPK
        // and therefore initialization code need manual adjustments.
        String additionalPerformersString = converter.getAsString(FacesContext.getCurrentInstance(), null, additionalPerformers);
        String currentAdditionalPerformersString = JsfUtil.getRequestParameter("jsfcrud.currentAdditionalPerformers");
        if (additionalPerformersString == null || additionalPerformersString.length() == 0 || !additionalPerformersString.equals(currentAdditionalPerformersString)) {
            String outcome = editSetup();
            if ("additionalPerformers_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit additionalPerformers. Try again.");
            }
            return outcome;
        }
        try {
            //utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(additionalPerformers);
            try {
                //utx.commit();
            //} catch (javax.transaction.RollbackException ex) {
            //    transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("AdditionalPerformers was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentAdditionalPerformers");
        AdditionalPerformersPK id = converter.getId(idAsString);
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
                JsfUtil.addSuccessMessage("AdditionalPerformers was successfully deleted.");
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

    public List<AdditionalPerformers> getAdditionalPerformersItems() {
        if (additionalPerformersItems == null) {
            getPagingInfo();
            additionalPerformersItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return additionalPerformersItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "additionalPerformers_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "additionalPerformers_list";
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
        additionalPerformers = null;
        additionalPerformersItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        AdditionalPerformers newAdditionalPerformers = new AdditionalPerformers();
        newAdditionalPerformers.setAdditionalPerformersPK(new AdditionalPerformersPK());
        String newAdditionalPerformersString = converter.getAsString(FacesContext.getCurrentInstance(), null, newAdditionalPerformers);
        String additionalPerformersString = converter.getAsString(FacesContext.getCurrentInstance(), null, additionalPerformers);
        if (!newAdditionalPerformersString.equals(additionalPerformersString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
