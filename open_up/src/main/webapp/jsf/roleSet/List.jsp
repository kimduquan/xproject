<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing RoleSet Items</title>
            <link rel="stylesheet" type="text/css" href="/open_up/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing RoleSet Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No RoleSet Items Found)<br />" rendered="#{roleSet.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{roleSet.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{roleSet.pagingInfo.firstItem + 1}..#{roleSet.pagingInfo.lastItem} of #{roleSet.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{roleSet.prev}" value="Previous #{roleSet.pagingInfo.batchSize}" rendered="#{roleSet.pagingInfo.firstItem >= roleSet.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{roleSet.next}" value="Next #{roleSet.pagingInfo.batchSize}" rendered="#{roleSet.pagingInfo.lastItem + roleSet.pagingInfo.batchSize <= roleSet.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{roleSet.next}" value="Remaining #{roleSet.pagingInfo.itemCount - roleSet.pagingInfo.lastItem}"
                                   rendered="#{roleSet.pagingInfo.lastItem < roleSet.pagingInfo.itemCount && roleSet.pagingInfo.lastItem + roleSet.pagingInfo.batchSize > roleSet.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{roleSet.roleSetItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Name"/>
                            </f:facet>
                            <h:outputText value="#{item.name}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{roleSet.detailSetup}">
                                <f:param name="jsfcrud.currentRoleSet" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][roleSet.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{roleSet.editSetup}">
                                <f:param name="jsfcrud.currentRoleSet" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][roleSet.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{roleSet.remove}">
                                <f:param name="jsfcrud.currentRoleSet" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][roleSet.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{roleSet.createSetup}" value="New RoleSet"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
