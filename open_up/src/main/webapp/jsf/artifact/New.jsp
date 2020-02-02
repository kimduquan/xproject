<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New Artifact</title>
            <link rel="stylesheet" type="text/css" href="/open_up/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New Artifact</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{artifact.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="Name:"/>
                    <h:inputText id="name" value="#{artifact.artifact.name}" title="Name" required="true" requiredMessage="The name field is required." />
                    <h:outputText value="Responsible:"/>
                    <h:inputText id="responsible" value="#{artifact.artifact.responsible}" title="Responsible" required="true" requiredMessage="The responsible field is required." />
                    <h:outputText value="ModifiedBy:"/>
                    <h:inputText id="modifiedBy" value="#{artifact.artifact.modifiedBy}" title="ModifiedBy" required="true" requiredMessage="The modifiedBy field is required." />

                </h:panelGrid>
                <br />
                <h:commandLink action="#{artifact.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{artifact.listSetup}" value="Show All Artifact Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
