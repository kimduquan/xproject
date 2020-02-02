<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New Role</title>
            <link rel="stylesheet" type="text/css" href="/open_up/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New Role</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{role.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="Name:"/>
                    <h:inputText id="name" value="#{role.role.name}" title="Name" required="true" requiredMessage="The name field is required." />
                    <h:outputText value="RoleSet:"/>
                    <h:inputText id="roleSet" value="#{role.role.roleSet}" title="RoleSet" required="true" requiredMessage="The roleSet field is required." />

                </h:panelGrid>
                <br />
                <h:commandLink action="#{role.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{role.listSetup}" value="Show All Role Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
