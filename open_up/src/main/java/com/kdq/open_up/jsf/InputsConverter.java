/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdq.open_up.jsf;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import com.kdq.open_up.beans.InputsFacade;
import com.kdq.open_up.entities.Inputs;
import com.kdq.open_up.entities.InputsPK;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author FOXCONN
 */
public class InputsConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        InputsPK id = getId(string);
        InputsController controller = (InputsController) facesContext.getApplication().getVariableResolver().resolveVariable(facesContext, "inputs");
        return controller.getJpaController().find(id);
    }

    InputsPK getId(String string) {
        InputsPK id = new InputsPK();
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
        id.setTask(params[0]);
        id.setArtifact(params[1]);
        return id;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Inputs) {
            Inputs o = (Inputs) object;
            InputsPK id = o.getInputsPK();
            if (id == null) {
                return "";
            }
            String delim = "#";
            String escape = "~";
            String task = id.getTask();
            task = task == null ? "" : task.replace(escape, escape + escape);
            task = task.replace(delim, escape + delim);
            String artifact = id.getArtifact();
            artifact = artifact == null ? "" : artifact.replace(escape, escape + escape);
            artifact = artifact.replace(delim, escape + delim);
            return task + delim + artifact;
            // TODO: no setter methods were found in your primary key class
            //    com.kdq.open_up.entities.InputsPK
            // and therefore getAsString() method could not be pre-generated.
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: com.kdq.open_up.entities.Inputs");
        }
    }
    
}
