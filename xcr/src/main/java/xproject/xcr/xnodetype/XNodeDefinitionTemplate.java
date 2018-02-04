package xproject.xcr.xnodetype;

import xproject.xrmi.XRemote;

public interface XNodeDefinitionTemplate extends XNodeDefinition, XRemote {
	void xsetAutoCreated(boolean autoCreated) throws Exception;
	void xsetDefaultPrimaryTypeName(String name) throws Exception;
	void xsetMandatory(boolean mandatory) throws Exception;
	void xsetName(java.lang.String name) throws Exception;
	void xsetOnParentVersion(int opv) throws Exception;
	void xsetProtected(boolean protectedStatus) throws Exception;
	void xsetRequiredPrimaryTypeNames(String[] names) throws Exception;
	void xsetSameNameSiblings(boolean allowSameNameSiblings) throws Exception;
}
