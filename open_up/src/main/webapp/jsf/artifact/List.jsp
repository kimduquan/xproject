<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Artifact Items</title>
            <link rel="stylesheet" type="text/css" href="/open_up/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Artifact Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Artifact Items Found)<br />" rendered="#{artifact.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{artifact.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{artifact.pagingInfo.firstItem + 1}..#{artifact.pagingInfo.lastItem} of #{artifact.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{artifact.prev}" value="Previous #{artifact.pagingInfo.batchSize}" rendered="#{artifact.pagingInfo.firstItem >= artifact.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{artifact.next}" value="Next #{artifact.pagingInfo.batchSize}" rendered="#{artifact.pagingInfo.lastItem + artifact.pagingInfo.batchSize <= artifact.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{artifact.next}" value="Remaining #{artifact.pagingInfo.itemCount - artifact.pagingInfo.lastItem}"
                                   rendered="#{artifact.pagingInfo.lastItem < artifact.pagingInfo.itemCount && artifact.pagingInfo.lastItem + artifact.pagingInfo.batchSize > artifact.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{artifact.artifactItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Name"/>
                            </f:facet>
                            <h:outputText value="#{item.name}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Responsible"/>
                            </f:facet>
                            <h:outputText value="#{item.responsible}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="ModifiedBy"/>
                            </f:facet>
                            <h:outputText value="#{item.modifiedBy}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{artifact.detailSetup}">
                                <f:param name="jsfcrud.currentArtifact" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][artifact.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{artifact.editSetup}">
                                <f:param name="jsfcrud.currentArtifact" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][artifact.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{artifact.remove}">
                                <f:param name="jsfcrud.currentArtifact" value="#{jsfcrud_class['com.kdq.open_up.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][artifact.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{artifact.createSetup}" value="New Artifact"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
