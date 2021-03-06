<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New AdditionalPerformers</title>
            <link rel="stylesheet" type="text/css" href="/open_up/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New AdditionalPerformers</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{additionalPerformers.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="Role:"/>
                    <h:inputText id="role" value="#{additionalPerformers.additionalPerformers.additionalPerformersPK.role}" title="Role" required="true" requiredMessage="The role field is required." />
                    <h:outputText value="Task:"/>
                    <h:inputText id="task" value="#{additionalPerformers.additionalPerformers.additionalPerformersPK.task}" title="Task" required="true" requiredMessage="The task field is required." />

                </h:panelGrid>
                <br />
                <h:commandLink action="#{additionalPerformers.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{additionalPerformers.listSetup}" value="Show All AdditionalPerformers Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
