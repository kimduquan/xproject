<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing AdditionalPerformers Items</title>
            <link rel="stylesheet" type="text/css" href="/open_up/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing AdditionalPerformers Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No AdditionalPerformers Items Found)<br />" rendered="#{additionalPerformers.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{additionalPerformers.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{additionalPerformers.pagingInfo.firstItem + 1}..#{additionalPerformers.pagingInfo.lastItem} of #{additionalPerformers.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{additionalPerformers.prev}" value="Previous #{additionalPerformers.pagingInfo.batchSize}" rendered="#{additionalPerformers.pagingInfo.firstItem >= additionalPerformers.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{additionalPerformers.next}" value="Next #{additionalPerformers.pagingInfo.batchSize}" rendered="#{additionalPerformers.pagingInfo.lastItem + additionalPerformers.pagingInfo.batchSize <= additionalPerformers.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{additionalPerformers.next}" value="Remaining #{additionalPerformers.pagingInfo.itemCount - additionalPerformers.pagingInfo.lastItem}"
                                   rendered="#{additionalPerformers.pagingInfo.lastItem < additionalPerformers.pagingInfo.itemCount && additionalPerformers.pagingInfo.lastItem + additionalPerformers.pagingInfo.batchSize > additionalPerformers.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{additionalPerformers.additionalPerformersItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Role"/>
                            </f:facet>
                            <h:outputText value="#{item.additionalPerformersPK.role}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Task"/>
                            </f:facet>
                            <h:outputText value="#{item.additionalPerformersPK.task}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{additionalPerformers.detailSetup}">
                                <f:param name="jsfcrud.currentAdditionalPerformers" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][additionalPerformers.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{additionalPerformers.editSetup}">
                                <f:param name="jsfcrud.currentAdditionalPerformers" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][additionalPerformers.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{additionalPerformers.remove}">
                                <f:param name="jsfcrud.currentAdditionalPerformers" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][additionalPerformers.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{additionalPerformers.createSetup}" value="New AdditionalPerformers"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
