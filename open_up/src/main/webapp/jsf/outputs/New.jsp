<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New Outputs</title>
            <link rel="stylesheet" type="text/css" href="/open_up/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New Outputs</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{outputs.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="Artifact:"/>
                    <h:inputText id="artifact" value="#{outputs.outputs.outputsPK.artifact}" title="Artifact" required="true" requiredMessage="The artifact field is required." />
                    <h:outputText value="Task:"/>
                    <h:inputText id="task" value="#{outputs.outputs.outputsPK.task}" title="Task" required="true" requiredMessage="The task field is required." />

                </h:panelGrid>
                <br />
                <h:commandLink action="#{outputs.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{outputs.listSetup}" value="Show All Outputs Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
