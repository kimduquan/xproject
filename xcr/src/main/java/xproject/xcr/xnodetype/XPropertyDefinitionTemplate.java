package xproject.xcr.xnodetype;

import xproject.xcr.XValue;
import xproject.xrmi.XRemote;

public interface XPropertyDefinitionTemplate extends XPropertyDefinition, XRemote {
	void xsetAutoCreated(boolean autoCreated) throws Exception;
	void xsetAvailableQueryOperators(String[] operators) throws Exception;
	void xsetDefaultValues(XValue[] defaultValues) throws Exception;
	void xsetFullTextSearchable(boolean fullTextSearchable) throws Exception;
	void xsetMandatory(boolean mandatory) throws Exception;
	void xsetMultiple(boolean multiple) throws Exception;
	void xsetName(String name) throws Exception;
	void xsetOnParentVersion(int opv) throws Exception;
	void xsetProtected(boolean protectedStatus) throws Exception;
	void xsetQueryOrderable(boolean queryOrderable) throws Exception;
	void xsetRequiredType(int type) throws Exception;
	void xsetValueConstraints(String[] constraints) throws Exception;
}
