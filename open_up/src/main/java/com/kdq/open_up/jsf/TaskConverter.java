/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdq.open_up.jsf;

import com.kdq.open_up.entities.Task;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author FOXCONN
 */
public class TaskConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        String id = string;
        TaskController controller = (TaskController) facesContext.getApplication().getVariableResolver().resolveVariable(facesContext, "task");
        return controller.getJpaController().find(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Task) {
            Task o = (Task) object;
            return o.getName() == null ? "" : o.getName().toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: com.kdq.open_up.entities.Task");
        }
    }
    
}
