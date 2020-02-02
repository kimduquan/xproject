/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdq.open_up.jsf;

import com.kdq.open_up.beans.TaskFacade;
import com.kdq.open_up.entities.Task;
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
public class TaskController {

    public TaskController() {
        pagingInfo = new PagingInfo();
        converter = new TaskConverter();
    }
    private Task task = null;
    private List<Task> taskItems = null;
    private TaskFacade jpaController = null;
    private TaskConverter converter = null;
    private PagingInfo pagingInfo = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(getJpaController().count());
        }
        return pagingInfo;
    }

    public TaskFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (TaskFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "taskJpa");
        }
        return jpaController;
    }

    public SelectItem[] getTaskItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getTaskItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public Task getTask() {
        if (task == null) {
            task = (Task) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTask", converter, null);
        }
        if (task == null) {
            task = new Task();
        }
        return task;
    }

    public String listSetup() {
        reset(true);
        return "task_list";
    }

    public String createSetup() {
        reset(false);
        task = new Task();
        return "task_create";
    }

    public String create() {
        try {
            //utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(task);
            try {
                //utx.commit();
            //} catch (javax.transaction.RollbackException ex) {
            //    transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Task was successfully created.");
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
        return scalarSetup("task_detail");
    }

    public String editSetup() {
        return scalarSetup("task_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        task = (Task) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTask", converter, null);
        if (task == null) {
            String requestTaskString = JsfUtil.getRequestParameter("jsfcrud.currentTask");
            JsfUtil.addErrorMessage("The task with id " + requestTaskString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String taskString = converter.getAsString(FacesContext.getCurrentInstance(), null, task);
        String currentTaskString = JsfUtil.getRequestParameter("jsfcrud.currentTask");
        if (taskString == null || taskString.length() == 0 || !taskString.equals(currentTaskString)) {
            String outcome = editSetup();
            if ("task_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit task. Try again.");
            }
            return outcome;
        }
        try {
            //utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(task);
            try {
                //utx.commit();
            //} catch (javax.transaction.RollbackException ex) {
            //    transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Task was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentTask");
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
                JsfUtil.addSuccessMessage("Task was successfully deleted.");
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

    public List<Task> getTaskItems() {
        if (taskItems == null) {
            getPagingInfo();
            taskItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return taskItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "task_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "task_list";
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
        task = null;
        taskItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Task newTask = new Task();
        String newTaskString = converter.getAsString(FacesContext.getCurrentInstance(), null, newTask);
        String taskString = converter.getAsString(FacesContext.getCurrentInstance(), null, task);
        if (!newTaskString.equals(taskString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
