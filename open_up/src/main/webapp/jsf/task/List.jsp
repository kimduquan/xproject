<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Task Items</title>
            <link rel="stylesheet" type="text/css" href="/open_up/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Task Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Task Items Found)<br />" rendered="#{task.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{task.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{task.pagingInfo.firstItem + 1}..#{task.pagingInfo.lastItem} of #{task.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{task.prev}" value="Previous #{task.pagingInfo.batchSize}" rendered="#{task.pagingInfo.firstItem >= task.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{task.next}" value="Next #{task.pagingInfo.batchSize}" rendered="#{task.pagingInfo.lastItem + task.pagingInfo.batchSize <= task.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{task.next}" value="Remaining #{task.pagingInfo.itemCount - task.pagingInfo.lastItem}"
                                   rendered="#{task.pagingInfo.lastItem < task.pagingInfo.itemCount && task.pagingInfo.lastItem + task.pagingInfo.batchSize > task.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{task.taskItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Name"/>
                            </f:facet>
                            <h:outputText value="#{item.name}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="PrimaryPerformer"/>
                            </f:facet>
                            <h:outputText value="#{item.primaryPerformer}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{task.detailSetup}">
                                <f:param name="jsfcrud.currentTask" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][task.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{task.editSetup}">
                                <f:param name="jsfcrud.currentTask" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][task.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{task.remove}">
                                <f:param name="jsfcrud.currentTask" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][task.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{task.createSetup}" value="New Task"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
