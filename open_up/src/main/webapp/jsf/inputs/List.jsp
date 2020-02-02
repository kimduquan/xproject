<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Inputs Items</title>
            <link rel="stylesheet" type="text/css" href="/open_up/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Inputs Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Inputs Items Found)<br />" rendered="#{inputs.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{inputs.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{inputs.pagingInfo.firstItem + 1}..#{inputs.pagingInfo.lastItem} of #{inputs.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{inputs.prev}" value="Previous #{inputs.pagingInfo.batchSize}" rendered="#{inputs.pagingInfo.firstItem >= inputs.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{inputs.next}" value="Next #{inputs.pagingInfo.batchSize}" rendered="#{inputs.pagingInfo.lastItem + inputs.pagingInfo.batchSize <= inputs.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{inputs.next}" value="Remaining #{inputs.pagingInfo.itemCount - inputs.pagingInfo.lastItem}"
                                   rendered="#{inputs.pagingInfo.lastItem < inputs.pagingInfo.itemCount && inputs.pagingInfo.lastItem + inputs.pagingInfo.batchSize > inputs.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{inputs.inputsItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Artifact"/>
                            </f:facet>
                            <h:outputText value="#{item.inputsPK.artifact}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Task"/>
                            </f:facet>
                            <h:outputText value="#{item.inputsPK.task}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Mandatory"/>
                            </f:facet>
                            <h:outputText value="#{item.mandatory}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{inputs.detailSetup}">
                                <f:param name="jsfcrud.currentInputs" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][inputs.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{inputs.editSetup}">
                                <f:param name="jsfcrud.currentInputs" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][inputs.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{inputs.remove}">
                                <f:param name="jsfcrud.currentInputs" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][inputs.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{inputs.createSetup}" value="New Inputs"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
