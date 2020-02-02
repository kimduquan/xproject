/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdq.open_up.jsf;

import com.kdq.open_up.beans.ArtifactFacade;
import com.kdq.open_up.entities.Artifact;
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
public class ArtifactController {

    public ArtifactController() {
        pagingInfo = new PagingInfo();
        converter = new ArtifactConverter();
    }
    private Artifact artifact = null;
    private List<Artifact> artifactItems = null;
    private ArtifactFacade jpaController = null;
    private ArtifactConverter converter = null;
    private PagingInfo pagingInfo = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(getJpaController().count());
        }
        return pagingInfo;
    }

    public ArtifactFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (ArtifactFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "artifactJpa");
        }
        return jpaController;
    }

    public SelectItem[] getArtifactItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getArtifactItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public Artifact getArtifact() {
        if (artifact == null) {
            artifact = (Artifact) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentArtifact", converter, null);
        }
        if (artifact == null) {
            artifact = new Artifact();
        }
        return artifact;
    }

    public String listSetup() {
        reset(true);
        return "artifact_list";
    }

    public String createSetup() {
        reset(false);
        artifact = new Artifact();
        return "artifact_create";
    }

    public String create() {
        try {
            //utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(artifact);
            try {
                //utx.commit();
            //} catch (javax.transaction.RollbackException ex) {
            //    transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Artifact was successfully created.");
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
        return scalarSetup("artifact_detail");
    }

    public String editSetup() {
        return scalarSetup("artifact_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        artifact = (Artifact) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentArtifact", converter, null);
        if (artifact == null) {
            String requestArtifactString = JsfUtil.getRequestParameter("jsfcrud.currentArtifact");
            JsfUtil.addErrorMessage("The artifact with id " + requestArtifactString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String artifactString = converter.getAsString(FacesContext.getCurrentInstance(), null, artifact);
        String currentArtifactString = JsfUtil.getRequestParameter("jsfcrud.currentArtifact");
        if (artifactString == null || artifactString.length() == 0 || !artifactString.equals(currentArtifactString)) {
            String outcome = editSetup();
            if ("artifact_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit artifact. Try again.");
            }
            return outcome;
        }
        try {
            //utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(artifact);
            try {
                //utx.commit();
            //} catch (javax.transaction.RollbackException ex) {
            //    transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Artifact was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentArtifact");
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
                JsfUtil.addSuccessMessage("Artifact was successfully deleted.");
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

    public List<Artifact> getArtifactItems() {
        if (artifactItems == null) {
            getPagingInfo();
            artifactItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return artifactItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "artifact_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "artifact_list";
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
        artifact = null;
        artifactItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Artifact newArtifact = new Artifact();
        String newArtifactString = converter.getAsString(FacesContext.getCurrentInstance(), null, newArtifact);
        String artifactString = converter.getAsString(FacesContext.getCurrentInstance(), null, artifact);
        if (!newArtifactString.equals(artifactString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
