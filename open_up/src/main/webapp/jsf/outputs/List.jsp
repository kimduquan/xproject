<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Outputs Items</title>
            <link rel="stylesheet" type="text/css" href="/open_up/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Outputs Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Outputs Items Found)<br />" rendered="#{outputs.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{outputs.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{outputs.pagingInfo.firstItem + 1}..#{outputs.pagingInfo.lastItem} of #{outputs.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{outputs.prev}" value="Previous #{outputs.pagingInfo.batchSize}" rendered="#{outputs.pagingInfo.firstItem >= outputs.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{outputs.next}" value="Next #{outputs.pagingInfo.batchSize}" rendered="#{outputs.pagingInfo.lastItem + outputs.pagingInfo.batchSize <= outputs.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{outputs.next}" value="Remaining #{outputs.pagingInfo.itemCount - outputs.pagingInfo.lastItem}"
                                   rendered="#{outputs.pagingInfo.lastItem < outputs.pagingInfo.itemCount && outputs.pagingInfo.lastItem + outputs.pagingInfo.batchSize > outputs.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{outputs.outputsItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Artifact"/>
                            </f:facet>
                            <h:outputText value="#{item.outputsPK.artifact}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Task"/>
                            </f:facet>
                            <h:outputText value="#{item.outputsPK.task}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{outputs.detailSetup}">
                                <f:param name="jsfcrud.currentOutputs" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][outputs.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{outputs.editSetup}">
                                <f:param name="jsfcrud.currentOutputs" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][outputs.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{outputs.remove}">
                                <f:param name="jsfcrud.currentOutputs" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][outputs.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{outputs.createSetup}" value="New Outputs"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
