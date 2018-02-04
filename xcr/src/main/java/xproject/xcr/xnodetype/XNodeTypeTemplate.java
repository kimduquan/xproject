package xproject.xcr.xnodetype;

import java.util.List;

import xproject.xrmi.XRemote;

public interface XNodeTypeTemplate extends XNodeTypeDefinition, XRemote {
	List<XNodeDefinitionTemplate> xgetNodeDefinitionTemplates() throws Exception;
	List<XPropertyDefinitionTemplate> xgetPropertyDefinitionTemplates() throws Exception;
	void xsetAbstract(boolean abstractStatus) throws Exception;
	void xsetDeclaredSuperTypeNames(String[] names) throws Exception;
	void xsetMixin(boolean mixin) throws Exception;
	void xsetName(String name) throws Exception;
	void xsetOrderableChildNodes(boolean orderable) throws Exception;
	void xsetPrimaryItemName(String name) throws Exception;
	void xsetQueryable(boolean queryable) throws Exception;
}
