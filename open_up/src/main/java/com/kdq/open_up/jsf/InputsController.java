/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdq.open_up.jsf;

import com.kdq.open_up.beans.InputsFacade;
import com.kdq.open_up.entities.Inputs;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.faces.FacesException;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import com.kdq.open_up.jsf.util.JsfUtil;
import com.kdq.open_up.entities.InputsPK;
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
public class InputsController {

    public InputsController() {
        pagingInfo = new PagingInfo();
        converter = new InputsConverter();
    }
    private Inputs inputs = null;
    private List<Inputs> inputsItems = null;
    private InputsFacade jpaController = null;
    private InputsConverter converter = null;
    private PagingInfo pagingInfo = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(getJpaController().count());
        }
        return pagingInfo;
    }

    public InputsFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (InputsFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "inputsJpa");
        }
        return jpaController;
    }

    public SelectItem[] getInputsItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getInputsItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public Inputs getInputs() {
        if (inputs == null) {
            inputs = (Inputs) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentInputs", converter, null);
        }
        if (inputs == null) {
            inputs = new Inputs();
        }
        return inputs;
    }

    public String listSetup() {
        reset(true);
        return "inputs_list";
    }

    public String createSetup() {
        reset(false);
        inputs = new Inputs();
        inputs.setInputsPK(new InputsPK());
        return "inputs_create";
    }

    public String create() {
        // TODO: no setter methods were found in your primary key class
        //    com.kdq.open_up.entities.InputsPK
        // and therefore initialization code need manual adjustments.
        try {
            //utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(inputs);
            try {
                //utx.commit();
            //} catch (javax.transaction.RollbackException ex) {
            //    transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Inputs was successfully created.");
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
        return scalarSetup("inputs_detail");
    }

    public String editSetup() {
        return scalarSetup("inputs_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        inputs = (Inputs) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentInputs", converter, null);
        if (inputs == null) {
            String requestInputsString = JsfUtil.getRequestParameter("jsfcrud.currentInputs");
            JsfUtil.addErrorMessage("The inputs with id " + requestInputsString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        // TODO: no setter methods were found in your primary key class
        //    com.kdq.open_up.entities.InputsPK
        // and therefore initialization code need manual adjustments.
        String inputsString = converter.getAsString(FacesContext.getCurrentInstance(), null, inputs);
        String currentInputsString = JsfUtil.getRequestParameter("jsfcrud.currentInputs");
        if (inputsString == null || inputsString.length() == 0 || !inputsString.equals(currentInputsString)) {
            String outcome = editSetup();
            if ("inputs_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit inputs. Try again.");
            }
            return outcome;
        }
        try {
            //utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(inputs);
            try {
                //utx.commit();
            //} catch (javax.transaction.RollbackException ex) {
            //    transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Inputs was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentInputs");
        InputsPK id = converter.getId(idAsString);
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
                JsfUtil.addSuccessMessage("Inputs was successfully deleted.");
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

    public List<Inputs> getInputsItems() {
        if (inputsItems == null) {
            getPagingInfo();
            inputsItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return inputsItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "inputs_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "inputs_list";
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
        inputs = null;
        inputsItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Inputs newInputs = new Inputs();
        newInputs.setInputsPK(new InputsPK());
        String newInputsString = converter.getAsString(FacesContext.getCurrentInstance(), null, newInputs);
        String inputsString = converter.getAsString(FacesContext.getCurrentInstance(), null, inputs);
        if (!newInputsString.equals(inputsString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
