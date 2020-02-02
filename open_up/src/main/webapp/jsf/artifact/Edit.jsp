<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing Artifact</title>
            <link rel="stylesheet" type="text/css" href="/open_up/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing Artifact</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Name:"/>
                    <h:outputText value="#{artifact.artifact.name}" title="Name" />
                    <h:outputText value="Responsible:"/>
                    <h:inputText id="responsible" value="#{artifact.artifact.responsible}" title="Responsible" required="true" requiredMessage="The responsible field is required." />
                    <h:outputText value="ModifiedBy:"/>
                    <h:inputText id="modifiedBy" value="#{artifact.artifact.modifiedBy}" title="ModifiedBy" required="true" requiredMessage="The modifiedBy field is required." />

                </h:panelGrid>
                <br />
                <h:commandLink action="#{artifact.edit}" value="Save">
                    <f:param name="jsfcrud.currentArtifact" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][artifact.artifact][artifact.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{artifact.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentArtifact" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][artifact.artifact][artifact.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{artifact.listSetup}" value="Show All Artifact Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
