<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Role Items</title>
            <link rel="stylesheet" type="text/css" href="/open_up/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Role Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Role Items Found)<br />" rendered="#{role.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{role.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{role.pagingInfo.firstItem + 1}..#{role.pagingInfo.lastItem} of #{role.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{role.prev}" value="Previous #{role.pagingInfo.batchSize}" rendered="#{role.pagingInfo.firstItem >= role.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{role.next}" value="Next #{role.pagingInfo.batchSize}" rendered="#{role.pagingInfo.lastItem + role.pagingInfo.batchSize <= role.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{role.next}" value="Remaining #{role.pagingInfo.itemCount - role.pagingInfo.lastItem}"
                                   rendered="#{role.pagingInfo.lastItem < role.pagingInfo.itemCount && role.pagingInfo.lastItem + role.pagingInfo.batchSize > role.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{role.roleItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Name"/>
                            </f:facet>
                            <h:outputText value="#{item.name}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="RoleSet"/>
                            </f:facet>
                            <h:outputText value="#{item.roleSet}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{role.detailSetup}">
                                <f:param name="jsfcrud.currentRole" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][role.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{role.editSetup}">
                                <f:param name="jsfcrud.currentRole" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][role.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{role.remove}">
                                <f:param name="jsfcrud.currentRole" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][role.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{role.createSetup}" value="New Role"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
