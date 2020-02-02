<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>AdditionalPerformers Detail</title>
            <link rel="stylesheet" type="text/css" href="/open_up/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>AdditionalPerformers Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Role:"/>
                    <h:outputText value="#{additionalPerformers.additionalPerformers.additionalPerformersPK.role}" title="Role" />
                    <h:outputText value="Task:"/>
                    <h:outputText value="#{additionalPerformers.additionalPerformers.additionalPerformersPK.task}" title="Task" />


                </h:panelGrid>
                <br />
                <h:commandLink action="#{additionalPerformers.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentAdditionalPerformers" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][additionalPerformers.additionalPerformers][additionalPerformers.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{additionalPerformers.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentAdditionalPerformers" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][additionalPerformers.additionalPerformers][additionalPerformers.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{additionalPerformers.createSetup}" value="New AdditionalPerformers" />
                <br />
                <h:commandLink action="#{additionalPerformers.listSetup}" value="Show All AdditionalPerformers Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
