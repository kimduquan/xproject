/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdq.open_up.jsf;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import com.kdq.open_up.beans.AdditionalPerformersFacade;
import com.kdq.open_up.entities.AdditionalPerformers;
import com.kdq.open_up.entities.AdditionalPerformersPK;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author FOXCONN
 */
public class AdditionalPerformersConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        AdditionalPerformersPK id = getId(string);
        AdditionalPerformersController controller = (AdditionalPerformersController) facesContext.getApplication().getVariableResolver().resolveVariable(facesContext, "additionalPerformers");
        return controller.getJpaController().find(id);
    }

    AdditionalPerformersPK getId(String string) {
        AdditionalPerformersPK id = new AdditionalPerformersPK();
        String[] params = new String[2];
        int p = 0;
        int grabStart = 0;
        String delim = "#";
        String escape = "~";
        Pattern pattern = Pattern.compile(escape + "*" + delim);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            String found = matcher.group();
            if (found.length() % 2 == 1) {
                params[p] = string.substring(grabStart, matcher.start());
                p++;
                grabStart = matcher.end();
            }
        }
        if (p != params.length - 1) {
            throw new IllegalArgumentException("string " + string + " is not in expected format. expected 2 ids delimited by " + delim);
        }
        params[p] = string.substring(grabStart);
        for (int i = 0; i < params.length; i++) {
            params[i] = params[i].replace(escape + delim, delim);
            params[i] = params[i].replace(escape + escape, escape);
        }
        id.setRole(params[0]);
        id.setTask(params[1]);
        return id;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof AdditionalPerformers) {
            AdditionalPerformers o = (AdditionalPerformers) object;
            AdditionalPerformersPK id = o.getAdditionalPerformersPK();
            if (id == null) {
                return "";
            }
            String delim = "#";
            String escape = "~";
            String role = id.getRole();
            role = role == null ? "" : role.replace(escape, escape + escape);
            role = role.replace(delim, escape + delim);
            String task = id.getTask();
            task = task == null ? "" : task.replace(escape, escape + escape);
            task = task.replace(delim, escape + delim);
            return role + delim + task;
            // TODO: no setter methods were found in your primary key class
            //    com.kdq.open_up.entities.AdditionalPerformersPK
            // and therefore getAsString() method could not be pre-generated.
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: com.kdq.open_up.entities.AdditionalPerformers");
        }
    }
    
}
