/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdq.open_up.jsf;

import com.kdq.open_up.beans.OutputsFacade;
import com.kdq.open_up.entities.Outputs;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.faces.FacesException;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import com.kdq.open_up.jsf.util.JsfUtil;
import com.kdq.open_up.entities.OutputsPK;
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
public class OutputsController {

    public OutputsController() {
        pagingInfo = new PagingInfo();
        converter = new OutputsConverter();
    }
    private Outputs outputs = null;
    private List<Outputs> outputsItems = null;
    private OutputsFacade jpaController = null;
    private OutputsConverter converter = null;
    private PagingInfo pagingInfo = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(getJpaController().count());
        }
        return pagingInfo;
    }

    public OutputsFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (OutputsFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "outputsJpa");
        }
        return jpaController;
    }

    public SelectItem[] getOutputsItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getOutputsItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public Outputs getOutputs() {
        if (outputs == null) {
            outputs = (Outputs) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentOutputs", converter, null);
        }
        if (outputs == null) {
            outputs = new Outputs();
        }
        return outputs;
    }

    public String listSetup() {
        reset(true);
        return "outputs_list";
    }

    public String createSetup() {
        reset(false);
        outputs = new Outputs();
        outputs.setOutputsPK(new OutputsPK());
        return "outputs_create";
    }

    public String create() {
        // TODO: no setter methods were found in your primary key class
        //    com.kdq.open_up.entities.OutputsPK
        // and therefore initialization code need manual adjustments.
        try {
            //utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(outputs);
            try {
                //utx.commit();
            //} catch (javax.transaction.RollbackException ex) {
            //    transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Outputs was successfully created.");
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
        return scalarSetup("outputs_detail");
    }

    public String editSetup() {
        return scalarSetup("outputs_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        outputs = (Outputs) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentOutputs", converter, null);
        if (outputs == null) {
            String requestOutputsString = JsfUtil.getRequestParameter("jsfcrud.currentOutputs");
            JsfUtil.addErrorMessage("The outputs with id " + requestOutputsString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        // TODO: no setter methods were found in your primary key class
        //    com.kdq.open_up.entities.OutputsPK
        // and therefore initialization code need manual adjustments.
        String outputsString = converter.getAsString(FacesContext.getCurrentInstance(), null, outputs);
        String currentOutputsString = JsfUtil.getRequestParameter("jsfcrud.currentOutputs");
        if (outputsString == null || outputsString.length() == 0 || !outputsString.equals(currentOutputsString)) {
            String outcome = editSetup();
            if ("outputs_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit outputs. Try again.");
            }
            return outcome;
        }
        try {
            //utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(outputs);
            try {
                //utx.commit();
            //} catch (javax.transaction.RollbackException ex) {
            //    transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Outputs was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentOutputs");
        OutputsPK id = converter.getId(idAsString);
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
                JsfUtil.addSuccessMessage("Outputs was successfully deleted.");
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

    public List<Outputs> getOutputsItems() {
        if (outputsItems == null) {
            getPagingInfo();
            outputsItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return outputsItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "outputs_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "outputs_list";
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
        outputs = null;
        outputsItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Outputs newOutputs = new Outputs();
        newOutputs.setOutputsPK(new OutputsPK());
        String newOutputsString = converter.getAsString(FacesContext.getCurrentInstance(), null, newOutputs);
        String outputsString = converter.getAsString(FacesContext.getCurrentInstance(), null, outputs);
        if (!newOutputsString.equals(outputsString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
