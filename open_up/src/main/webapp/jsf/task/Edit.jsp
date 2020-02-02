<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing Task</title>
            <link rel="stylesheet" type="text/css" href="/open_up/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing Task</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Name:"/>
                    <h:outputText value="#{task.task.name}" title="Name" />
                    <h:outputText value="PrimaryPerformer:"/>
                    <h:inputText id="primaryPerformer" value="#{task.task.primaryPerformer}" title="PrimaryPerformer" />

                </h:panelGrid>
                <br />
                <h:commandLink action="#{task.edit}" value="Save">
                    <f:param name="jsfcrud.currentTask" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][task.task][task.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{task.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentTask" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][task.task][task.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{task.listSetup}" value="Show All Task Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
