<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Outputs Detail</title>
            <link rel="stylesheet" type="text/css" href="/open_up/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Outputs Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Artifact:"/>
                    <h:outputText value="#{outputs.outputs.outputsPK.artifact}" title="Artifact" />
                    <h:outputText value="Task:"/>
                    <h:outputText value="#{outputs.outputs.outputsPK.task}" title="Task" />


                </h:panelGrid>
                <br />
                <h:commandLink action="#{outputs.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentOutputs" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][outputs.outputs][outputs.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{outputs.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentOutputs" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][outputs.outputs][outputs.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{outputs.createSetup}" value="New Outputs" />
                <br />
                <h:commandLink action="#{outputs.listSetup}" value="Show All Outputs Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
